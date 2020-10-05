package com.rak.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rak.scheduler.model.Role;

@Repository
public interface UserRoleRepository extends JpaRepository<Role, Long> {
	 
}

