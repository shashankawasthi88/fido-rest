package com.fido.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.fido.entity.DeviceEntity;
import com.fido.entity.UserEntity;
import com.fido.model.Device;
import com.fido.model.Login;
import com.fido.model.User;
import com.fido.repository.UserRepository;
import com.fido.exceptionhandler.AuthenticationFailedException;


@Service
public class UserService {
	
	/**
	 * Model mapper
	 */
	@Autowired
    private ModelMapper modelMapper;
	
	/**
	 * Repository class
	 */
	@Autowired
	private UserRepository userRepository;
	
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	/**
	 * Save user to DB
	 * @param user
	 * @return
	 */
	public User createUser(User user)
	{
		
		
		System.out.println(user.getEmail());
		List<UserEntity> userEntities = this.userRepository.findByEmail(user.getEmail()); 
		if(!userEntities.isEmpty())
		{
			System.out.println(userEntities.get(0).getId());
			throw new EntityExistsException("Email ID already registered");
		}
		String encodedPassword = this.encodePassword(user.getPassword());
		
		user.setPassword(encodedPassword);
		
		UserEntity userEntity = this.modelMapper.map(user, UserEntity.class);
		System.out.println(userEntity.getName()+ " "+ userEntity.getUserPhoneNo()+ " "+ userEntity.getPassword());
		userEntity = this.userRepository.save(userEntity);
		// Device should not be added when the user is being created
		return this.modelMapper.map(userEntity, User.class);
		
	}
	
	
	/**
	 * Get user from DB
	 * @param id
	 * @return
	 */
	public User getUser( Long id)
	{
		UserEntity userEntity = this.userRepository.findById(id).orElse(null);
		
		if (userEntity == null)
		{
			throw new EntityNotFoundException(id.toString());
		}
		User user = this.modelMapper.map(userEntity, User.class);
		Set<Device> devices = new HashSet<Device>();
		user.setDevices(devices);
		// Handle devices if added to the user
		if (userEntity.getDeviceEntities()!= null && !userEntity.getDeviceEntities().isEmpty())
		{
			for( DeviceEntity deviceEntity: userEntity.getDeviceEntities())
			{
				Device device = this.modelMapper.map(deviceEntity, Device.class);
				devices.add(device);
			}
		}
		return user;
	}
	
	
	/**
	 * Update user
	 * @param user
	 * @return
	 */
	public User updateUser(User user)
	{
		UserEntity userEntity = this.userRepository.findById(user.getId()).orElse(null);
		if (userEntity == null)
		{
			throw new EntityNotFoundException(user.getId().toString());
		}
		userEntity = this.modelMapper.map(user, UserEntity.class);
		// Handle devices if added to the user
		if(user.getDevices()!= null && !user.getDevices().isEmpty())
		{
			Set<DeviceEntity> deviceEntities = new HashSet<DeviceEntity>();
			userEntity.setDeviceEntities(deviceEntities);
			for (Device device: user.getDevices())
			{
				DeviceEntity deviceEntity = this.modelMapper.map(device, DeviceEntity.class);
				deviceEntities.add(deviceEntity);
			}
		}
		userEntity = this.userRepository.save(userEntity);
		
		user = this.modelMapper.map(userEntity, User.class);
		
		// re add devices if added to the user
		if (userEntity.getDeviceEntities()!=null && !userEntity.getDeviceEntities().isEmpty())
		{
			Set<Device> devices = new HashSet<Device>();
			user.setDevices(devices);
			for (DeviceEntity deviceEntity: userEntity.getDeviceEntities())
			{
				Device device = this.modelMapper.map(deviceEntity, Device.class);
				devices.add(device);
			}
			
		}
		return user;
		
	}
	
	
	/**
	 * Delete user
	 * @param id
	 * @return
	 */
	public Boolean deleteUser(Long id)
	{
		UserEntity userEntity = this.userRepository.findById(id).orElse(null);
		if (userEntity == null)
		{
			throw new EntityNotFoundException(id.toString());
		}
		this.userRepository.delete(userEntity);	
		return Boolean.TRUE;
	}
	
	
	/**
	 * Login 
	 * @param login
	 * @return
	 */
	public User login (Login login)
	{
		List <UserEntity> userEntities = this.userRepository.findByEmail(login.getUsername());
		if (userEntities.isEmpty())
		{
			throw new EntityNotFoundException(login.getUsername());
		}
		if(passwordEncoder.matches(login.getPassword(), userEntities.get(0).getPassword()))
		{
			return this.modelMapper.map(userEntities.get(0), User.class);
		}
		
		throw new AuthenticationFailedException("Invalid username or password");
	}

	
	/**
	 * Encode password
	 * @param password
	 * @return
	 */
	private String encodePassword(String password)
	{
		return this.passwordEncoder.encode(password);
	}
}
