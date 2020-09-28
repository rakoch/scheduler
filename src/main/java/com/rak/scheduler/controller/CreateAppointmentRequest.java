package com.rak.scheduler.controller;

import java.util.Date;
import java.util.Set;

import com.rak.scheduler.model.User;

public class CreateAppointmentRequest {

	private User owner;
	private Date start;
	private Date end;
	private double cost;
	private Set<User> participants;
	private String description;
	private String title;
	
	public CreateAppointmentRequest(User owner, Date start, Date end, double cost, Set<User> participants, String description,
			String title) {
		super();
		this.owner = owner;
		this.start = start;
		this.end = end;
		this.cost = cost;
		this.participants = participants;
		this.description = description;
		this.title = title;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
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

	
}
