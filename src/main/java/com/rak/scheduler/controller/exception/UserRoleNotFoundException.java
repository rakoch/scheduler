package com.rak.scheduler.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)  
public class UserRoleNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -853440611476349081L;

	public UserRoleNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserRoleNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UserRoleNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UserRoleNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UserRoleNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
