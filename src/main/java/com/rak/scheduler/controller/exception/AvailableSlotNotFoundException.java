package com.rak.scheduler.controller.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)  
public class AvailableSlotNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6888159064498965806L;

	public AvailableSlotNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AvailableSlotNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public AvailableSlotNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public AvailableSlotNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public AvailableSlotNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
