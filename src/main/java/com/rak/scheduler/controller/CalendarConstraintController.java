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
import com.rak.scheduler.model.CalendarConstraint;
import com.rak.scheduler.service.CalendarConstraintService;

@RestController
@RequestMapping("/contraints")
public class CalendarConstraintController {
	@Autowired CalendarConstraintService service;
	

    @GetMapping
    public List<CalendarConstraint> get() {
        return service.getCalendarConstraints();
    }

    @PostMapping
    public CalendarConstraint post(@RequestBody CreateCalendarConstraintRequest request) {
    	return service.saveOrUpdates(new CalendarConstraint(null, request.getOwner(), request.getStart(), request.getEnd(), request.getCost()));
    }
    
    @PutMapping
    public CalendarConstraint post(@RequestBody UpdateCalendarConstraintRequest request) {
    	return service.saveOrUpdates(new CalendarConstraint(request.getId(), request.getOwner(), request.getStart(), request.getEnd(), request.getCost()));
    }
    
    @GetMapping("/{id}")
    public CalendarConstraint getById(@PathVariable(required = true) long id) {
    	Optional<CalendarConstraint> optionalCalendarConstraint = service.getCalendarConstraintById(id);
		return optionalCalendarConstraint.orElseThrow(() -> new CalendarConstraintNotFoundException("Couldn't find a CalendarConstraint with id: " + id));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) long id) {
        service.delete(id);
    }
    
}
