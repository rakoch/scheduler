package com.rak.scheduler.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.rak.scheduler.model.AvailableSlot;
import com.rak.scheduler.model.Role;
import com.rak.scheduler.repository.UserRoleRepository;

@Component
public class UserRoleService {

	@Autowired
	UserRoleRepository repository;

	public void saveOrUpdates(Role userRole) {
		repository.save(userRole);
	}

	public Optional<Role> delete(long id) {
		Optional<Role> role = this.getRoleById(id);
		if(role.isPresent()) {
			repository.deleteById(id);
		}
		return role;
	}

	public List<Role> getUserRoles() {
		return (List<Role>) repository.findAll();
	}

	public Optional<Role> getRoleById(Long id) {
		return repository.findById(id);
	}

}
