package com.rak.scheduler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rak.scheduler.model.Role;
import com.rak.scheduler.model.User;
import com.rak.scheduler.repository.UserRepository;

@Component
public class UserService {

	@Autowired
	UserRepository repository;

	public User saveOrUpdates(User user) {
		return repository.save(user);
	}

	public Optional<User> delete(long id) {
		Optional<User> user = this.getUserById(id);
		if(user.isPresent()) {
			repository.deleteById(id);
		}
		return user;
	}

	public List<User> getUsers() {
		return (List<User>) repository.findAll();
	}

	public Optional<User> getUserById(Long id) {
		return repository.findById(id);
	}

}
