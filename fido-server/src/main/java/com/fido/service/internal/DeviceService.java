package com.fido.service.internal;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	
	public Boolean deleteDevice (Long id)
	{
		this.deviceRepository.deleteById(id);
		return Boolean.TRUE;
	}

}
