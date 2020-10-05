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

import com.rak.scheduler.controller.exception.CalendarConstraintNotFoundException;
import com.rak.scheduler.model.AvailableSlot;
import com.rak.scheduler.service.AvailableSlotService;

@RestController
@RequestMapping("/availableslots")
public class AvailableSlotController {
	@Autowired AvailableSlotService service;
	

    @GetMapping
    public List<AvailableSlot> get() {
        return service.getCalendarConstraints();
    }

    @PostMapping
    public AvailableSlot post(@RequestBody CreateAvailableSlotRequest request) {
    	return service.saveOrUpdates(new AvailableSlot(null, request.getOwner(), request.getStart(), request.getEnd(), request.getCost()));
    }
    
    @PutMapping
    public AvailableSlot post(@RequestBody UpdateAvailableSlotRequest request) {
    	return service.saveOrUpdates(new AvailableSlot(request.getId(), request.getOwner(), request.getStart(), request.getEnd(), request.getCost()));
    }
    
    @GetMapping("/{id}")
    public AvailableSlot getById(@PathVariable(required = true) long id) {
    	Optional<AvailableSlot> optionalCalendarConstraint = service.getCalendarConstraintById(id);
		return optionalCalendarConstraint.orElseThrow(() -> new CalendarConstraintNotFoundException("Couldn't find a AvailableSlot with id: " + id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) long id) {
        service.delete(id);
    }
    
}
