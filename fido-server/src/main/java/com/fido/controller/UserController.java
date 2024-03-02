package com.fido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fido.model.User;
import com.fido.service.UserService;

@RestController
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public User createUser(@RequestBody User user)
	{
		return this.userService.createUser(user);
		
	}
	
	
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable Long id)
	{
		return this.userService.getUser(id);
	}
	
	
	@PutMapping("/user")
	public User updateUser(@RequestBody User user)
	{
		return this.userService.updateUser(user);
	}
	
	@DeleteMapping("/user/{id}")
	public Boolean deleteUser(@PathVariable Long id)
	{
		return this.userService.deleteUser(id);
	}
	
	
	

}
