package com.fido.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fido.model.Device;
import com.fido.service.DeviceService;

@RestController
public class DeviceController {
	
	@Autowired
	private DeviceService deviceService;
	
	
	@PostMapping("/device")
	public Device createDevice(@RequestBody Device device)
	{
		return this.deviceService.createDevice(device);
	}
	
	@GetMapping("/device/{id}")
	public Device getDevice(@PathVariable Long id)
	{
		return this.deviceService.getDevice(id);
	}
	
	@PutMapping("/device")
	public Device updateDevice(@RequestBody Device device)
	{
		return this.deviceService.updateDevice(device);
	}
	
	@DeleteMapping("/device/{id}")
	public Boolean deleteDevice (@PathVariable Long id)
	{
		return this.deviceService.deleteDevice(id);
	}

}
