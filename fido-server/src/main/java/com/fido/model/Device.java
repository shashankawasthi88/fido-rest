package com.fido.model;

public class Device {
	
	
	private Long id;
	
	
	private String devicePhoneNo;
	
	
	private String imei;
	
	
	private Long userId;


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
	

}
