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
	@Autowired AppointmentService service;
	

    @GetMapping
    public List<Appointment> get() {
        return service.getAppointments();
    }

    // Appointment(Long id, User owner, Date start, Date end, double cost, Set<User> participants, String description, String title) {
    @PostMapping
    public ResponseEntity post(@RequestBody CreateAppointmentRequest request) {
    	service.saveOrUpdates(new Appointment(null, request.getOwner(), request.getStart(), request.getEnd(), request.getCost(), request.getParticipants(), request.getDescription(), request.getTitle()));
        return ResponseEntity.ok().build();
    }
    
    @PutMapping
    public ResponseEntity post(@RequestBody UpdateAppointmentRequest request) {
    	service.saveOrUpdates(new Appointment(request.getId(), request.getOwner(), request.getStart(), request.getEnd(), request.getCost(), request.getParticipants(), request.getDescription(), request.getTitle()));
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/{id}")
    public Appointment getById(@PathVariable(required = true) long id) {
    	Optional<Appointment> optionalAppointment = service.getAppointmentById(id);
		return optionalAppointment.orElseThrow(() -> new AppointmentNotFoundException("Couldn't find a Appointment with id: " + id));

    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) long id) {
        service.delete(id);
    }
    
}
