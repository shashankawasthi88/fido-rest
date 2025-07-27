package com.fido.service.internal;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;


import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.fido.entity.DeviceEntity;
import com.fido.entity.UserEntity;
import com.fido.model.Device;
import com.fido.repository.DeviceRepository;
import com.fido.repository.UserRepository;

@Service
public class DeviceService {
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private DeviceRepository deviceRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	public Device createDevice(Device device)
	{
		
		DeviceEntity deviceEntity = this.modelMapper.map(device, DeviceEntity.class);
		// Handle user id
		if (device.getUserId()!=null)
		{
			UserEntity userEntity= this.userRepository.findById(device.getUserId()).orElse(null);
			if (userEntity == null)
			{
				throw new EntityNotFoundException("Corresponding user entity not found :"+device.getUserId());
			}
			deviceEntity.setUserEntity(userEntity);
		}
		deviceEntity = this.deviceRepository.save(deviceEntity);
		device = this.modelMapper.map(deviceEntity, Device.class);
		if (deviceEntity.getUserEntity()!=null)
		{
			device.setUserId(deviceEntity.getUserEntity().getId());
		}
		return device;
	}
	
	public Device getDevice(Long id)
	{
		DeviceEntity deviceEntity = this.deviceRepository.findById(id).orElse(null);
		if (deviceEntity == null)
		{
			throw new EntityNotFoundException(id.toString());
		}
		Device device = this.modelMapper.map(deviceEntity, Device.class);
		device.setUserId(deviceEntity.getUserEntity().getId());
		return device;
	}
	
	public Device updateDevice(Device device)
	{
		DeviceEntity deviceEntity = this.modelMapper.map(device, DeviceEntity.class);
		UserEntity userEntity = this.userRepository.findById(device.getUserId()).orElse(null);
		if (userEntity == null)
		{
			throw new EntityNotFoundException("Correspoding User not found :"+device.getUserId().toString());
		}
		deviceEntity.setUserEntity(userEntity);
		
		deviceEntity = this.deviceRepository.save(deviceEntity);
		
		device = this.modelMapper.map(deviceEntity, Device.class);
		device.setUserId(deviceEntity.getUserEntity().getId());
		return device;
	}
	
	/* @Transactional
	public Boolean deleteDevice (Long id)
	{
		
		System.out.println("Deleting device :" +id);
		System.out.println("Exists before delete? " + deviceRepository.existsById(id));

		this.deviceRepository.deleteById(id);
		return Boolean.TRUE;
	} */

	
	
	
	@Transactional
	public Boolean deleteDevice(Long id) {
	    Optional<DeviceEntity> deviceOpt = deviceRepository.findById(id);
	    if (deviceOpt.isPresent()) {
	        DeviceEntity device = deviceOpt.get();
	        UserEntity user = device.getUserEntity();
	        if (user != null) {
	            user.getDeviceEntities().remove(device);  // <-- remove from the collection
	        }
	        deviceRepository.delete(device);
	        return true;
	    }
	    return false;
	}
	
	
	/**
	 * Get all devices
	 * @return
	 */
	public List<Device> getDevices()
	{
		
		List<DeviceEntity> deviceEntities = this.deviceRepository.findAll();
		if (deviceEntities == null || deviceEntities.isEmpty())
		{
			return null;
		}
		List<Device> devices = new LinkedList<Device>();
		
		for (DeviceEntity deviceEntity : deviceEntities)
		{
			Device device = this.modelMapper.map(deviceEntity, Device.class);
			device.setUserId(deviceEntity.getUserEntity().getId());
			devices.add(device);
		}
		return devices;
	}
}
