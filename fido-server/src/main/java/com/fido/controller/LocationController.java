package com.fido.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fido.model.HistoricalLocation;
import com.fido.model.Location;
import com.fido.service.orchestrator.LocationOrchestratorService;

@RestController
public class LocationController {
	
	
	@Autowired
	private LocationOrchestratorService locationOrchestratorService;
	
	@PostMapping("/location")
	public Location createLocation (@RequestBody Location location)
	{
		return this.locationOrchestratorService.createLocation(location);
	}
	
	
	@GetMapping("/location/{id}")
	public Location getLocation(@PathVariable Long id)
	{
		return this.locationOrchestratorService.getLocation(id);
	}
	
	@PutMapping("/location")
	public Location updateLocation(@RequestBody Location location)
	{
		
		return this.locationOrchestratorService.updateLocation(location);
	}
	
	@DeleteMapping("/location/{id}")
	public Boolean deleteLocation(@PathVariable Long id)
	{
		return this.locationOrchestratorService.deleteLocation(id);
	}
	
	@GetMapping("/location")
	public Location getLocation(@RequestParam String imei)
	{
		return this.locationOrchestratorService.getLocation(imei);
	}
	
	@GetMapping("/location/{imei}/history")
	public HistoricalLocation getLocationHistory(
	    @PathVariable String imei,
	    @RequestParam(required = false) String date // fallback to String
	) 
	{
	    LocalDate parsedDate;

	    try {
	        if (date == null || date.isEmpty()) {
	            parsedDate = LocalDate.now();
	        } else {
	            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
	            parsedDate = LocalDate.parse(date, formatter);
	        }
	    } catch (DateTimeParseException ex) {
	        throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid date format. Use yyyy-MM-dd", ex);
	    }

	    return locationOrchestratorService.getLocationHistoryForDate(imei, parsedDate);
	}

}
