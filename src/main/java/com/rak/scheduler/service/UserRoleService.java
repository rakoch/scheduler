package com.rak.scheduler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rak.scheduler.model.UserRole;
import com.rak.scheduler.repository.UserRoleRepository;

@Component
public class UserRoleService {

	@Autowired
	UserRoleRepository repository;

	public void saveOrUpdates(UserRole userRole) {
		repository.save(userRole);
	}

	public void delete(long id) {
		repository.deleteById(id);
	}

	public List<UserRole> getUserRoles() {
		return (List<UserRole>) repository.findAll();
	}

	public Optional<UserRole> getUserRoleById(Long id) {
		return repository.findById(id);
	}

}
