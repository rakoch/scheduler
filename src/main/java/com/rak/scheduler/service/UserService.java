package com.rak.scheduler.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rak.scheduler.controller.exception.UserNotFoundException;
import com.rak.scheduler.model.User;
import com.rak.scheduler.repository.UserRepository;

@Component
public class UserService {

	@Autowired
	UserRepository repository;

	public void saveOrUpdates(User user) {
		repository.save(user);
	}

	public void delete(UUID id) {
		repository.deleteById(id);
	}

	public List<User> getAppointments() {
		return (List<User>) repository.findAll();
	}

	public Optional<User> getAppointmentById(UUID id) {
		return repository.findById(id);
	}

}
