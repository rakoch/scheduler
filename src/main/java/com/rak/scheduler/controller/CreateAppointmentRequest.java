package com.rak.scheduler.controller;

import java.util.Set;

import com.rak.scheduler.model.AvailableSlot;
import com.rak.scheduler.model.User;

public class CreateAppointmentRequest {

	private AvailableSlot availableSlot;
	private Set<User> participants;
	private String description;
	private String title;
	private Double cost;
	
	public CreateAppointmentRequest(AvailableSlot availableSlot, Set<User> participants, String description,
			String title, Double cost) {
		super();

		this.availableSlot = availableSlot;
		this.participants = participants;
		this.description = description;
		this.title = title;
		this.cost = cost;
	}


	public AvailableSlot getAvailableSlot() {
		return availableSlot;
	}


	public void setAvailableSlot(AvailableSlot availableSlot) {
		this.availableSlot = availableSlot;
	}


	public Set<User> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<User> participants) {
		this.participants = participants;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	public Double getCost() {
		return cost;
	}


	public void setCost(Double cost) {
		this.cost = cost;
	}

	
}
