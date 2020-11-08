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

import com.rak.scheduler.controller.exception.AvailableSlotNotFoundException;
import com.rak.scheduler.model.AvailableSlot;
import com.rak.scheduler.service.AvailableSlotService;

@RestController
@RequestMapping("/availableslots")
public class AvailableSlotController {
	@Autowired
	AvailableSlotService service;

	@GetMapping
	public List<AvailableSlot> getAll() {
		return service.getAvailableSlots();
	}

	// AvailableSlot(Long id, User owner, Date start, Date end, double cost,
	// Set<User> participants, String description, String title) {
	@PostMapping
	public ResponseEntity<AvailableSlot> post(@RequestBody CreateAvailableSlotRequest request) {
		// TODO get current user to make owner
		AvailableSlot newAvailableSlot = service.saveOrUpdates(
				new AvailableSlot(null, request.getOwner(), request.getStart(), request.getEnd(), request.getCost()));
		if (newAvailableSlot == null) {
			return ResponseEntity.notFound().build(); // TODO not sure I want or have to do this extra code
		} else {
			return ResponseEntity.ok(newAvailableSlot);
		}
	}

	@PutMapping
	public ResponseEntity<AvailableSlot> put(@RequestBody UpdateAvailableSlotRequest request) {
		AvailableSlot updatedAvailableSlot = service.saveOrUpdates(new AvailableSlot(request.getId(),
				request.getOwner(), request.getStart(), request.getEnd(), request.getCost()));
		if (updatedAvailableSlot == null) {
			return ResponseEntity.notFound().build(); // TODO not sure I want or have to do this extra code
		} else {
			return ResponseEntity.ok(updatedAvailableSlot);
		}
	}

	@GetMapping("/{id}")
	public AvailableSlot getById(@PathVariable(required = true) long id) {
		Optional<AvailableSlot> optionalAvailableSlot = service.getAvailableSlotById(id);
		return optionalAvailableSlot
				.orElseThrow(() -> new AvailableSlotNotFoundException("Couldn't find an AvailableSlot with id: " + id));

	}

	@DeleteMapping("/{id}")
	public AvailableSlot delete(@PathVariable(required = true) long id) {
		Optional<AvailableSlot> optionalAvailableSlot = service.delete(id);
		return optionalAvailableSlot.orElseThrow(
				() -> new AvailableSlotNotFoundException("Couldn't find and delete an AvailableSlot with id: " + id));
	}

}
