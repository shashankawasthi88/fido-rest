package com.fido.service;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fido.entity.LocationEntity;
import com.fido.model.Location;
import com.fido.repository.LocationRepository;

@Service
public class LocationService {
	
	@Autowired
	private LocationRepository locationRepository;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public Location createLocation (Location location)
	{
		LocationEntity locationEntity = this.modelMapper.map(location, LocationEntity.class);
		locationEntity = this.locationRepository.save(locationEntity);
		return this.modelMapper.map(locationEntity, Location.class);
	}
	
	
	public Location getLocation(Long id)
	{
		LocationEntity locationEntity = this.locationRepository.findById(id).orElse(null);
		
		
		if (locationEntity == null)
		{
			throw new EntityNotFoundException(id.toString());
		}
		return this.modelMapper.map(locationEntity, Location.class);
	}
	
	public Location updateLocation(Location location)
	{
		LocationEntity locationEntity = this.modelMapper.map(location, LocationEntity.class);
		locationEntity = this.locationRepository.save(locationEntity);
		return this.modelMapper.map(locationEntity, Location.class);
	}
	
	public Boolean deleteLocation(Long id)
	{
		this.locationRepository.deleteById(id);
		return Boolean.TRUE;
	}
}
