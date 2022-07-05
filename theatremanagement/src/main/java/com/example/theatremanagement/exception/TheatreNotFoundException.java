package com.example.theatremanagement.exception;

public class TheatreNotFoundException extends Exception {
	
	public TheatreNotFoundException(Long theatreId) {
		
	}

	public TheatreNotFoundException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TheatreNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public TheatreNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public TheatreNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public TheatreNotFoundException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}