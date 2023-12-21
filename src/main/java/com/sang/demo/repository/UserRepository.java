package com.sang.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sang.demo.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long>{}