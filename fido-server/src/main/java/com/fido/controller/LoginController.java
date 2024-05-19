package com.fido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fido.model.Login;
import com.fido.model.User;
import com.fido.service.UserService;

@RestController
public class LoginController {
	
	
	
	@Autowired
	private UserService userService;
	
	
	@PostMapping("/login")
	public User login(@RequestBody Login login)
	{
		return this.userService.login(login);
	}
	
	
	@PostMapping("/register")
	public User register (@RequestBody User user)
	{
		return this.userService.createUser(user);
	}
	

}
