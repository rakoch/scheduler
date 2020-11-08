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

	public Appointment saveOrUpdates(Appointment appointment) {
		return repository.save(appointment);
	}

	public Optional<Appointment> delete(long id) {
		Optional<Appointment> appt = this.getAppointmentById(id);
		if(appt.isPresent()) {
			repository.deleteById(id);
		}
		return appt;
	}

	public List<Appointment> getAppointments() {
		return (List<Appointment>) repository.findAll();
	}

	public Optional<Appointment> getAppointmentById(long id) {
		return repository.findById(id);
	}

}
