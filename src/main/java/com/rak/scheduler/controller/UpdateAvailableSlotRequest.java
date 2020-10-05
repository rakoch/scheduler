package com.rak.scheduler.controller;

import java.util.Date;

import com.rak.scheduler.model.User;

public class UpdateAvailableSlotRequest extends CreateAvailableSlotRequest {

	private long id;

	public UpdateAvailableSlotRequest(long id, User owner, Date start, Date end, double cost) {
		super(owner, start, end, cost);
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
