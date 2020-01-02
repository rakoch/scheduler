package com.rak.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rak.scheduler.model.Appointment;

@Repository
public interface AppoinmentRepository extends JpaRepository<Appointment, Long> {
	 
}

