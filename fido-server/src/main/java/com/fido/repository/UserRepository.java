package com.fido.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fido.entity.UserEntity;



public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
