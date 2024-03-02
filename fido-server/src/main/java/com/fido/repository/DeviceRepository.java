package com.fido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fido.entity.DeviceEntity;



public interface DeviceRepository extends JpaRepository<DeviceEntity, Long> {

}
