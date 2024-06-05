package com.fido.service.external;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fido.model.User;
import com.fido.service.internal.UserService;

@Service
public class UserExternalService {
	
	@Autowired
	private UserService userService;
	
	
	public User createUser(User user)
	{
		// do nothing, just create user in local DB as we can't create the external user yet
		return this.userService.createUser(user);
		
	}
	
	
	
	

}
