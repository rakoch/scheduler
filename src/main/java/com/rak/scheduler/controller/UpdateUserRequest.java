package com.rak.scheduler.controller;

public class UpdateUserRequest extends CreateUserRequest {

	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
