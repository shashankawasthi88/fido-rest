package com.fido.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class DeviceEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String devicePhoneNo;
	
	private String imei;
	
	@ManyToOne
	@JoinColumn (name = "user_id")
	private UserEntity userEntity;
	
	
	/**
	 * The ID retrieved from remote servers
	 */
	private Long deviceExternalId;
	
	/**
	 * Device name
	 */
	private String deviceName;

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
	 * @return the devicePhoneNo
	 */
	public String getDevicePhoneNo() {
		return devicePhoneNo;
	}

	/**
	 * @param devicePhoneNo the devicePhoneNo to set
	 */
	public void setDevicePhoneNo(String devicePhoneNo) {
		this.devicePhoneNo = devicePhoneNo;
	}

	/**
	 * @return the imei
	 */
	public String getImei() {
		return imei;
	}

	/**
	 * @param imei the imei to set
	 */
	public void setImei(String imei) {
		this.imei = imei;
	}

	/**
	 * @return the userEntity
	 */
	public UserEntity getUserEntity() {
		return userEntity;
	}

	/**
	 * @param userEntity the userEntity to set
	 */
	public void setUserEntity(UserEntity userEntity) {
		this.userEntity = userEntity;
	}

	/**
	 * @return the deviceName
	 */
	public String getDeviceName() {
		return deviceName;
	}

	/**
	 * @param deviceName the deviceName to set
	 */
	public void setDeviceName(String deviceName) {
		this.deviceName = deviceName;
	}

	/**
	 * @return the deviceExternalId
	 */
	public Long getDeviceExternalId() {
		return deviceExternalId;
	}

	/**
	 * @param deviceExternalId the deviceExternalId to set
	 */
	public void setDeviceExternalId(Long deviceExternalId) {
		this.deviceExternalId = deviceExternalId;
	}
}
