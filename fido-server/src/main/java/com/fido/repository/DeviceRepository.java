package com.fido.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fido.entity.DeviceEntity;



public interface DeviceRepository extends JpaRepository<DeviceEntity, Long> {
	
	List<DeviceEntity> findByImei(String imei);

}
