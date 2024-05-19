package com.fido.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fido.entity.UserEntity;



public interface UserRepository extends JpaRepository<UserEntity, Long> {
	
	
	public List<UserEntity> findByEmail(String email);

}
