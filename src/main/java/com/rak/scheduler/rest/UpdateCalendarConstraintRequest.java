package com.rak.scheduler.rest;

import java.util.Date;

import com.rak.scheduler.model.User;

public class UpdateCalendarConstraintRequest extends CreateCalendarConstraintRequest {

	private long id;

	public UpdateCalendarConstraintRequest(long id, User owner, Date start, Date end, double cost) {
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
