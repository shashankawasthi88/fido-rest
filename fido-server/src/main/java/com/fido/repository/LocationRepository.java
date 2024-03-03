package com.fido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fido.entity.LocationEntity;

public interface LocationRepository extends JpaRepository<LocationEntity, Long> {

}
