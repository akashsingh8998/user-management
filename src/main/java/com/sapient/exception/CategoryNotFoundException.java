package com.sapient.exception;

public class CategoryNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public CategoryNotFoundException() {
		super();
	}

	public CategoryNotFoundException(String message) {
		super(message);
	}
	
	public CategoryNotFoundException(String message,Throwable e) {
		super(message,e);
	}
	
	 
}
