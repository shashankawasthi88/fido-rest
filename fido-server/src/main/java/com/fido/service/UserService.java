package com.fido.service;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fido.entity.UserEntity;
import com.fido.model.User;
import com.fido.repository.UserRepository;


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
	
	/**
	 * Save user to DB
	 * @param user
	 * @return
	 */
	public User createUser(User user)
	{
		System.out.println(user.getName()+ " "+ user.getUserPhoneNo()+ " "+ user.getPassword());
		UserEntity userEntity = this.modelMapper.map(user, UserEntity.class);
		System.out.println(userEntity.getName()+ " "+ userEntity.getUserPhoneNo()+ " "+ userEntity.getPassword());
		userEntity = this.userRepository.save(userEntity);
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
		
		if (userEntity!= null)
		{
			return this.modelMapper.map(userEntity, User.class);
		}
		else
		{
			throw new EntityNotFoundException(id.toString());
		}
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
		userEntity = this.userRepository.save(userEntity);
		return this.modelMapper.map(userEntity, User.class);
		
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

}
