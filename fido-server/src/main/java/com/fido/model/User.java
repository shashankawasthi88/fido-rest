package com.fido.model;

import java.util.Set;

public class User {
	
	/**
	 * Identifier
	 */
	private Long id;
	
	/**
	 * Phone number
	 */
	private String userPhoneNo;
	
	
	/**
	 * Password
	 */
	private String password;
	
	/**
	 * Name
	 */
	private String name;
	
	
	/**
	 * Email
	 */
	private String email;
	
	/**
	 * Image URL
	 */
	private String imageURL;
	
	
	private Set<Device> devices;
	
	/**
	 * ID from the external system
	 */
	private long userExternalId;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the userPhoneNo
	 */
	public String getUserPhoneNo() {
		return userPhoneNo;
	}

	/**
	 * @param userPhoneNo the userPhoneNo to set
	 */
	public void setUserPhoneNo(String userPhoneNo) {
		this.userPhoneNo = userPhoneNo;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the devices
	 */
	public Set<Device> getDevices() {
		return devices;
	}

	/**
	 * @param devices the devices to set
	 */
	public void setDevices(Set<Device> devices) {
		this.devices = devices;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the imageURL
	 */
	public String getImageURL() {
		return imageURL;
	}

	/**
	 * @param imageURL the imageURL to set
	 */
	public void setImageURL(String imageURL) {
		this.imageURL = imageURL;
	}

	/**
	 * @return the userExternalId
	 */
	public long getUserExternalId() {
		return userExternalId;
	}

	/**
	 * @param userExternalId the userExternalId to set
	 */
	public void setUserExternalId(long userExternalId) {
		this.userExternalId = userExternalId;
	}
	
	
	
}
