package com.rak.scheduler.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import com.rak.scheduler.model.User;

public class UpdateAppointmentRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -467066344873498554L;
	
	private long id;
	private User owner;
	private Date start;
	private Date end;
	private Double cost;
	private Set<User> participants;
	private String title;
	private String description;
	
	public UpdateAppointmentRequest(long id, User owner, Date start, Date end, Double cost, Set<User> participants, String description, String title) {
		this.id = id;
		this.owner = owner;
		this.start = start;
		this.end = end;
		this.cost = cost;
		this.participants = participants;
		this.title = title;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Set<User> getParticipants() {
		return participants;
	}

	public void setParticipants(Set<User> participants) {
		this.participants = participants;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
