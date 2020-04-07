package com.sapient.exception;

public class UserNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public UserNotFoundException() {
		super();
	}

	public UserNotFoundException(String message) {
		super(message);
	}
	
	public UserNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	
	 
}
