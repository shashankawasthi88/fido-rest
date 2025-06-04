package com.fido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fido.model.Login;
import com.fido.model.User;
import com.fido.service.orchestrator.UserOrchestratorService;

@RestController
public class LoginController {
	
	
	
	@Autowired
	private UserOrchestratorService userOrchestratorService;
	
	
	@PostMapping("/login")
	public User login(@RequestBody Login login)
	{
		return this.userOrchestratorService.login(login);
	}
	
	
	@PostMapping("/register")
	public User register (@RequestBody User user)
	{
		return this.userOrchestratorService.createUser(user);
	}
	

}
