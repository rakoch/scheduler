package com.rak.scheduler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rak.scheduler.model.CalendarConstraint;
import com.rak.scheduler.repository.CalendarConstraintRepository;

@Component
public class CalendarConstraintService {

	@Autowired
	CalendarConstraintRepository repository;

	public void saveOrUpdates(CalendarConstraint constraint) {
		repository.save(constraint);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}

	public List<CalendarConstraint> getCalendarConstraints() {
		return (List<CalendarConstraint>) repository.findAll();
	}

	public CalendarConstraint getCalendarConstraintById(long id) {
		Optional<CalendarConstraint> optionalCalendarConstraint = repository.findById(id);
		return optionalCalendarConstraint.orElseThrow(() -> new CalendarConstraintNotFoundException("Couldn't find a CalendarConstraint with id: " + id));
	}

}
