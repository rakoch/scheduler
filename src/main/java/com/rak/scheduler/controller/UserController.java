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

import com.rak.scheduler.controller.exception.UserNotFoundException;
import com.rak.scheduler.model.User;
import com.rak.scheduler.service.UserService;

@RestController
@RequestMapping("/Users")
public class UserController {
	@Autowired
	UserService service;

	@GetMapping
	public List<User> getAll() {
		return service.getUsers();
	}

	// User(Long id, User owner, Date start, Date end, double cost, Set<User>
	// participants, String description, String title) {
	@PostMapping
	public ResponseEntity<User> post(@RequestBody CreateUserRequest request) {
		// TODO get current user to make owner
		User newUser = service.saveOrUpdates(new User(null, request.getEmail(), request.getFirstName(),
				request.getLastName(), request.getPhone(), request.getRoles(), null, null));
		if (newUser == null) {
			return ResponseEntity.notFound().build(); // TODO not sure I want or have to do this extra code
		} else {
			return ResponseEntity.ok(newUser);
		}
	}

	@PutMapping
	public ResponseEntity<User> put(@RequestBody UpdateUserRequest request) {
		User updatedUser = service.saveOrUpdates(
				new User(request.getId(), request.getEmail(), request.getFirstName(),
						request.getLastName(), request.getPhone(), request.getRoles(), null, null));
		if (updatedUser == null) {
			return ResponseEntity.notFound().build(); // TODO not sure I want or have to do this extra code
		} else {
			return ResponseEntity.ok(updatedUser);
		}
	}

	@GetMapping("/{id}")
	public User getById(@PathVariable(required = true) long id) {
		Optional<User> optionalUser = service.getUserById(id);
		return optionalUser.orElseThrow(() -> new UserNotFoundException("Couldn't find an User with id: " + id));

	}

	@DeleteMapping("/{id}")
	public User delete(@PathVariable(required = true) long id) {
		Optional<User> optionalUser = service.delete(id);
		return optionalUser
				.orElseThrow(() -> new UserNotFoundException("Couldn't find and delete an User with id: " + id));
	}

}
