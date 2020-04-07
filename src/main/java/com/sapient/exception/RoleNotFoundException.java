package com.sapient.exception;

public class RoleNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public RoleNotFoundException() {
		super();
	}

	public RoleNotFoundException(String message) {
		super(message);
	}
	
	public RoleNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	
	 
}
