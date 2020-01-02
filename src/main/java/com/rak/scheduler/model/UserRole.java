package com.rak.scheduler.model;

public enum UserRole {

	ADMIN(0), PROVIDER(1), CLIENT(2);
	
	private long id;

	private UserRole(long id) {
		this.id = id;
	}

	public long getId() {
		return id;
	}
	
}
