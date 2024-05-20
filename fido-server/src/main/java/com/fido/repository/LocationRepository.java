package com.fido.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fido.entity.LocationEntity;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {
	
	
	List<LocationEntity> findByImei(String imei);

}
