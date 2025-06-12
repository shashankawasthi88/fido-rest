package com.fido.model;

import java.time.LocalDate;
import java.util.List;

public class HistoricalLocation {
	
	private LocalDate date;
	
	private String distance;
	
	private List <LocationCoordinate> cordinates;

	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}

	/**
	 * @return the distance
	 */
	public String getDistance() {
		return distance;
	}

	/**
	 * @param distance the distance to set
	 */
	public void setDistance(String distance) {
		this.distance = distance;
	}

	/**
	 * @return the cordinates
	 */
	public List<LocationCoordinate> getCordinates() {
		return cordinates;
	}

	/**
	 * @param cordinates the cordinates to set
	 */
	public void setCordinates(List<LocationCoordinate> cordinates) {
		this.cordinates = cordinates;
	}

}
