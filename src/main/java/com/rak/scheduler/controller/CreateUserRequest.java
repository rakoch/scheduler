package com.rak.scheduler.controller;

import java.util.Set;

import com.rak.scheduler.model.Appointment;
import com.rak.scheduler.model.AvailableSlot;
import com.rak.scheduler.model.Role;

public class CreateUserRequest {

	private String email;
	private String firstName;
	private String lastName;
	private String phone;
	

	private Set<Role> roles;
	private Set<AvailableSlot> availableSlots;

	private Set<Appointment> appointments;


	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public Set<AvailableSlot> getAvailableSlots() {
		return availableSlots;
	}

	public void setAvailableSlots(Set<AvailableSlot> availableSlots) {
		this.availableSlots = availableSlots;
	}

	public Set<Appointment> getAppointments() {
		return appointments;
	}

	public void setAppointments(Set<Appointment> appointments) {
		this.appointments = appointments;
	}

	
}
