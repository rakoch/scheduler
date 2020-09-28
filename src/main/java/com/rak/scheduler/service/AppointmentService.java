package com.rak.scheduler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rak.scheduler.model.Appointment;
import com.rak.scheduler.repository.AppointmentRepository;

@Component
public class AppointmentService {

	@Autowired
	AppointmentRepository repository;

	public void saveOrUpdates(Appointment appointment) {
		repository.save(appointment);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}

	public List<Appointment> getAppointments() {
		return (List<Appointment>) repository.findAll();
	}

	public Optional<Appointment> getAppointmentById(long id) {
		return repository.findById(id);
	}

}
