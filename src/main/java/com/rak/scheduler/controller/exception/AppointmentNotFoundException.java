package com.rak.scheduler.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)  
public class AppointmentNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7438315384171387746L;

	public AppointmentNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AppointmentNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AppointmentNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AppointmentNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AppointmentNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
