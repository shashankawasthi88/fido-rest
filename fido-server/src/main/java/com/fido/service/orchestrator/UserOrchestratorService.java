package com.fido.service.orchestrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fido.model.Login;
import com.fido.model.User;
import com.fido.service.internal.UserService;

@Service
public class UserOrchestratorService {

	@Autowired
	private UserService userService;

	/**
	 * Save user to DB
	 * 
	 * @param user
	 * @return
	 */
	public User createUser(User user) {
		// Do nothing but create user in the local database
		return this.userService.createUser(user);

	}

	/**
	 * Get user from DB
	 * 
	 * @param id
	 * @return
	 */
	public User getUser(Long id) {

		return this.userService.getUser(id);
	}

	/**
	 * Update user
	 * 
	 * @param user
	 * @return
	 */
	public User updateUser(User user) {

		return this.userService.updateUser(user);

	}

	/**
	 * Delete user
	 * 
	 * @param id
	 * @return
	 */
	public Boolean deleteUser(Long id) {
		return this.userService.deleteUser(id);
	}

	/**
	 * Login
	 * 
	 * @param login
	 * @return
	 */
	public User login(Login login) {
		// Check username and password from the local database
		return this.userService.login(login);
	}
}
