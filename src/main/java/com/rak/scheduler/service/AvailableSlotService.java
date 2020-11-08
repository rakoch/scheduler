package com.rak.scheduler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rak.scheduler.model.Appointment;
import com.rak.scheduler.model.AvailableSlot;
import com.rak.scheduler.repository.AvailableSlotRepository;

@Component
public class AvailableSlotService {

	@Autowired
	AvailableSlotRepository repository;

	public AvailableSlot saveOrUpdates(AvailableSlot availableSlot) {
		return repository.save(availableSlot);
	}

	public Optional<AvailableSlot> delete(long id) {
		Optional<AvailableSlot> availableSlot = this.getAvailableSlotById(id);
		if(availableSlot.isPresent()) {
			repository.deleteById(id);
		}
		return availableSlot;
	}

	public List<AvailableSlot> getAvailableSlots() {
		return (List<AvailableSlot>) repository.findAll();
	}

	public Optional<AvailableSlot> getAvailableSlotById(long id) {
		 return repository.findById(id);
	}

}
