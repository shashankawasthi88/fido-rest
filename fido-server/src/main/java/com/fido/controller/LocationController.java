package com.fido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fido.model.Location;
import com.fido.service.LocationService;

@RestController
public class LocationController {
	
	
	@Autowired
	private LocationService locationService;
	
	@PostMapping("/location")
	public Location createLocation (@RequestBody Location location)
	{
		return this.locationService.createLocation(location);
	}
	
	
	@GetMapping("/location/{id}")
	public Location getLocation(@PathVariable Long id)
	{
		return this.locationService.getLocation(id);
	}
	
	@PutMapping("/location")
	public Location updateLocation(@RequestBody Location location)
	{
		
		return this.locationService.updateLocation(location);
	}
	
	@DeleteMapping("/location/{id}")
	public Boolean deleteLocation(@PathVariable Long id)
	{
		return this.locationService.deleteLocation(id);
	}

}
