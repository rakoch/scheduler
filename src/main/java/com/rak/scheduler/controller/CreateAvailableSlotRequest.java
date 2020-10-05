package com.rak.scheduler.controller;

import java.util.Date;

import com.rak.scheduler.model.User;

public class CreateAvailableSlotRequest {
	private User owner;
	private Date start;
	private Date end;
	private double cost;
		
	public CreateAvailableSlotRequest(User owner, Date start, Date end, double cost) {
		super();
		this.owner = owner;
		this.start = start;
		this.end = end;
		this.cost = cost;
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
	
	
}
