package com.fido.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class UserEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long Id;
	
	@Column(unique=true)
	private String userPhoneNo;
	
	private String password;
	
	
	private String name;
	
	@OneToMany (mappedBy = "userEntity", cascade = CascadeType.ALL)
	private Set<DeviceEntity> deviceEntities;


	/**
	 * @return the id
	 */
	public Long getId() {
		return Id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		Id = id;
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
	 * @return the deviceEntities
	 */
	public Set<DeviceEntity> getDeviceEntities() {
		return deviceEntities;
	}


	/**
	 * @param deviceEntities the deviceEntities to set
	 */
	public void setDeviceEntities(Set<DeviceEntity> deviceEntities) {
		this.deviceEntities = deviceEntities;
	}
	
	
}
