package com.fido.model;

import java.util.Date;

public class Location {

	private Long id;

	/**
	 * Latitude
	 */
	private double latitude;

	/**
	 * Longitude
	 */
	private double longitude;

	/**
	 * IMEI of the device
	 */
	private String imei;

	/**
	 * Date and time
	 */
	private Date timestamp;
	
	/**
	 * Time in millis
	 */
	private long longTimeStamp;

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
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
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
	 * @return the timestamp
	 */
	public Date getTimestamp() {
		return timestamp;
	}

	/**
	 * @param timestamp the timestamp to set
	 */
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	/**
	 * @return the longTimeStamp
	 */
	public long getLongTimeStamp() {
		return longTimeStamp;
	}

	/**
	 * @param longTimeStamp the longTimeStamp to set
	 */
	public void setLongTimeStamp(long longTimeStamp) {
		this.longTimeStamp = longTimeStamp;
	}
	
	

}
