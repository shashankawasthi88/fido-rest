package com.fido.model;

public class LocationCoordinate {
	
	/**
	 * Latitude
	 */
	private double latitude;

	/**
	 * Longitude
	 */
	private double longitude;
	
	
	/**
	 * Time in millis
	 */
	private long longTimeStamp;


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
