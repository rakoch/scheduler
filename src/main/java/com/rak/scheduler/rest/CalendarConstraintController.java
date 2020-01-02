package com.rak.scheduler.rest;

import java.util.List;

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
    public ResponseEntity post(@RequestBody CreateCalendarConstraintRequest request) {
    	service.saveOrUpdates(new CalendarConstraint(null, request.getOwner(), request.getStart(), request.getEnd(), request.getCost()));
        return ResponseEntity.ok().build();
    }
    
    @PutMapping
    public ResponseEntity post(@RequestBody UpdateCalendarConstraintRequest request) {
    	service.saveOrUpdates(new CalendarConstraint(request.getId(), request.getOwner(), request.getStart(), request.getEnd(), request.getCost()));
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/{id}")
    public CalendarConstraint getById(@PathVariable(required = true) long id) {
        return service.getCalendarConstraintById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(required = true) long id) {
        service.delete(id);
    }
    
}
