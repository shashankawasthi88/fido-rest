package com.fido.model;

public class Device {
	
	
	private Long id;
	
	
	private String devicePhoneNo;
	
	
	private String imei;
	
	
	private Long userId;
	
	/**
	 * The ID retrieved from remote servers
	 */
	private Long deviceExternalId;
	
	/**
	 * Device name
	 */
	private String deviceName;
	
	
	/**
	 * Daily distance moved by the pet
	 */
	private int dailyDistanceMovement = 0;
	
	
	/**
	 * Daily active time
	 */
	private int dailyActivityTime = 0;


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
	 * @return the userId
	 */
	public Long getUserId() {
		return userId;
	}


	/**
	 * @param userId the userId to set
	 */
	public void setUserId(Long userId) {
		this.userId = userId;
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


	/**
	 * @return the dailyDistanceMovement
	 */
	public int getDailyDistanceMovement() {
		return dailyDistanceMovement;
	}


	/**
	 * @param dailyDistanceMovement the dailyDistanceMovement to set
	 */
	public void setDailyDistanceMovement(int dailyDistanceMovement) {
		this.dailyDistanceMovement = dailyDistanceMovement;
	}


	/**
	 * @return the dailyActivityTime
	 */
	public int getDailyActivityTime() {
		return dailyActivityTime;
	}


	/**
	 * @param dailyActivityTime the dailyActivityTime to set
	 */
	public void setDailyActivityTime(int dailyActivityTime) {
		this.dailyActivityTime = dailyActivityTime;
	}	
	
}
