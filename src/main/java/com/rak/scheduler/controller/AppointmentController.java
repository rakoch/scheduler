package com.rak.scheduler.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rak.scheduler.controller.exception.AppointmentNotFoundException;
import com.rak.scheduler.model.Appointment;
import com.rak.scheduler.service.AppointmentService;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {
	@Autowired
	AppointmentService service;

	@GetMapping
	public List<Appointment> getAll() {
		return service.getAppointments();
	}

	// Appointment(Long id, User owner, Date start, Date end, double cost, Set<User>
	// participants, String description, String title) {
	@PostMapping
	public ResponseEntity<Appointment> post(@RequestBody CreateAppointmentRequest request) {
		// TODO get current user to make owner
		Appointment newAppointment = service.saveOrUpdates(new Appointment(request.getAvailableSlot(), null,
				request.getParticipants(), request.getTitle(), request.getDescription()));
		if (newAppointment == null) {
			return ResponseEntity.notFound().build(); // TODO not sure I want or have to do this extra code
		} else {
			return ResponseEntity.ok(newAppointment);
		}
	}

	@PutMapping
	public ResponseEntity<Appointment> put(@RequestBody UpdateAppointmentRequest request) {
		Appointment updatedAppointment = service.saveOrUpdates(
				new Appointment(request.getId(), request.getOwner(), request.getStart(), request.getEnd(),
						request.getCost(), request.getParticipants(), request.getDescription(), request.getTitle()));
		if (updatedAppointment == null) {
			return ResponseEntity.notFound().build(); // TODO not sure I want or have to do this extra code
		} else {
			return ResponseEntity.ok(updatedAppointment);
		}
	}

	@GetMapping("/{id}")
	public Appointment getById(@PathVariable(required = true) long id) {
		Optional<Appointment> optionalAppointment = service.getAppointmentById(id);
		return optionalAppointment
				.orElseThrow(() -> new AppointmentNotFoundException("Couldn't find an Appointment with id: " + id));

	}

	@DeleteMapping("/{id}")
	public Appointment delete(@PathVariable(required = true) long id) {
		Optional<Appointment> optionalAppointment = service.delete(id);
		return optionalAppointment.orElseThrow(
				() -> new AppointmentNotFoundException("Couldn't find and delete an Appointment with id: " + id));
	}

}
