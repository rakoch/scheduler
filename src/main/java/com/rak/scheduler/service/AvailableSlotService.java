package com.rak.scheduler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rak.scheduler.model.AvailableSlot;
import com.rak.scheduler.repository.CalendarConstraintRepository;

@Component
public class AvailableSlotService {

	@Autowired
	CalendarConstraintRepository repository;

	public AvailableSlot saveOrUpdates(AvailableSlot availableSlot) {
		return repository.save(availableSlot);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}

	public List<AvailableSlot> getCalendarConstraints() {
		return (List<AvailableSlot>) repository.findAll();
	}

	public Optional<AvailableSlot> getCalendarConstraintById(long id) {
		 return repository.findById(id);
	}

}
