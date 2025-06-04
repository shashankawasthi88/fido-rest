package com.fido.service.orchestrator;

import java.io.IOException;
import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fido.entity.DeviceEntity;
import com.fido.exceptionhandler.ExternalCallException;
import com.fido.model.Device;
import com.fido.model.Location;
import com.fido.repository.DeviceRepository;
import com.fido.service.external.FidoExternalService;
import com.fido.service.internal.LocationService;

@Service
public class LocationOrchestratorService {
	
	
	@Autowired
	private DeviceRepository deviceRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private FidoExternalService externalService;
	
	
	@Autowired
	private LocationService locationService;
	
	
	public Location createLocation (Location location)
	{
		return this.locationService.createLocation(location);
	}
	
	
	public Location getLocation(Long id)
	{
		return this.locationService.getLocation(id);
	}
	
	
	public Location getLocation(String imei)
	{
		
		  List <DeviceEntity> deviceEntities =
		  this.deviceRepository.findByImei(imei);
		  
		  if (deviceEntities == null || deviceEntities.isEmpty()) { throw new
		  EntityNotFoundException("No location found for imei :" + imei);
		  
		  } DeviceEntity deviceEntity = deviceEntities.get(0);
		  
		  
		  
		  Device device =  this.modelMapper.map(deviceEntity, Device.class);
		 
		
		  try {
			return this.externalService.getLocation(device);
		} catch (IOException e) {
			throw new ExternalCallException("Could not fetch the location from the external servers");
		}
		
		
	}
	
	public Location updateLocation(Location location)
	{
		return this.locationService.updateLocation(location);
	}
	
	public Boolean deleteLocation(Long id)
	{
		this.locationService.deleteLocation(id);
		return Boolean.TRUE;
	}
}
