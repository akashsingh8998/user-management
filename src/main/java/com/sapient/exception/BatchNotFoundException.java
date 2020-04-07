package com.sapient.exception;

public class BatchNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public BatchNotFoundException() {
		super();
	}

	public BatchNotFoundException(String message) {
		super(message);
	}
	
	public BatchNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	
	 
}
