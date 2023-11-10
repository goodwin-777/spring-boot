package com.example.demo.exception;


public class MacbookNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public MacbookNotFoundException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public MacbookNotFoundException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public MacbookNotFoundException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	
}
