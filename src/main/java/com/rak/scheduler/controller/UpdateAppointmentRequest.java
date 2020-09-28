package com.rak.scheduler.controller;

import java.util.Date;
import java.util.Set;

import com.rak.scheduler.model.User;

public class UpdateAppointmentRequest extends CreateAppointmentRequest {

	private long id;
	
	public UpdateAppointmentRequest(long id, User owner, Date start, Date end, double cost, Set<User> participants, String description, String title) {
		super(owner, start, end, cost, participants, description, title);
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
