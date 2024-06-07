package com.fido.service.orchestrator;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fido.entity.UserEntity;
import com.fido.exceptionhandler.ExternalCallException;
import com.fido.model.Device;
import com.fido.model.User;
import com.fido.repository.UserRepository;
import com.fido.service.external.FidoExternalService;
import com.fido.service.internal.DeviceService;
import com.fido.service.internal.UserService;

@Service
public class DeviceIOrchestratorService {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private FidoExternalService externalService;

	@Autowired
	private UserService userService;

	@Autowired
	private DeviceService deviceService;

	public Device createDevice(Device device) {

		// check if one device for the user is already added or not

		if (device.getUserId() == null) {
			throw new EntityNotFoundException("Corresponding user entity not found :" + device.getUserId());
		}

		UserEntity userEntity = this.userRepository.findById(device.getUserId()).orElse(null);
		if (userEntity == null) {
			throw new EntityNotFoundException("Corresponding user entity not found :" + device.getUserId());
		}
		User user = this.modelMapper.map(userEntity, User.class);

		if (userEntity.getDeviceEntities() == null || userEntity.getDeviceEntities().isEmpty()) {
			// First device create - extenal service to create a new user
			Set<Device> devices = new HashSet<Device>();
			devices.add(device);
			user.setDevices(devices);
			try {
				user = this.externalService.createUserandDevice(user);
			} catch (IOException e) {

				e.printStackTrace();
				throw new ExternalCallException("Could not create new user on external server");
			}
			user = this.userService.updateUser(user);
			// return the device created
			return user.getDevices().iterator().next();
		} else {
			// one device is already added, we just need to create a new device in remote
			// and local
			try {
				device = this.externalService.addDevice(device);
			} catch (IOException e) {

				throw new ExternalCallException(e.getMessage());
			}
			return this.deviceService.createDevice(device);
		}
	}

	public Device getDevice(Long id) {
		return this.deviceService.getDevice(id);
	}

	public Device updateDevice(Device device) {
		return this.deviceService.updateDevice(device);
	}

	public Boolean deleteDevice(Long id) {
		
		Device device = this.deviceService.getDevice(id);

		User user = this.userService.getUser(device.getUserId());
		
		boolean isDeleted = false;
		try {
			isDeleted = this.externalService.deleteDevice(device.getDeviceExternalId(), user.getUserExternalId());
		} catch (IOException e) {
			throw new ExternalCallException(e.getMessage());
		}

		if (isDeleted)
		{
			// Delete from local
			return this.deviceService.deleteDevice(id);
		}
		else 
		{
			throw new ExternalCallException("Device could not be deleted from the server");
			
		}
		
	}

}
