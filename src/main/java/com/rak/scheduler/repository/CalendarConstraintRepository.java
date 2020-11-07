package com.rak.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rak.scheduler.model.Appointment;
import com.rak.scheduler.model.AvailableSlot;

@Repository
public interface CalendarConstraintRepository extends JpaRepository<AvailableSlot, Long> {
	 
}

