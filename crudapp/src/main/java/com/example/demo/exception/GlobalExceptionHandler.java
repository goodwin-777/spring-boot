package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<MacbookErrorResponse> exceptionHandler(MacbookNotFoundException e){
		MacbookErrorResponse response = new MacbookErrorResponse();
		response.setMessage(e.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setTime(System.currentTimeMillis());
		return new ResponseEntity<MacbookErrorResponse>(response, HttpStatus.NOT_FOUND);		
	}
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> exceptionHandler(EmployeeNotFoundException e){
		EmployeeErrorResponse response = new EmployeeErrorResponse();
		response.setMessage(e.getMessage());
		response.setStatus(HttpStatus.NOT_FOUND.value());
		response.setTime(System.currentTimeMillis());
		return new ResponseEntity<EmployeeErrorResponse>(response, HttpStatus.NOT_FOUND);		
	}
	@ExceptionHandler
	public ResponseEntity<MacbookErrorResponse> exceptionHandler(Exception e){
		MacbookErrorResponse response = new MacbookErrorResponse();
		response.setMessage(e.getMessage());
		response.setStatus(HttpStatus.BAD_REQUEST.value());
		response.setTime(System.currentTimeMillis());
		return new ResponseEntity<MacbookErrorResponse>(response, HttpStatus.BAD_REQUEST);		
	}
//	@ExceptionHandler
//	public ResponseEntity<EmployeeErrorResponse> exceptionHandler(Exception e){
//		EmployeeErrorResponse response = new EmployeeErrorResponse();
//		response.setMessage(e.getMessage());
//		response.setStatus(HttpStatus.BAD_REQUEST.value());
//		response.setTime(System.currentTimeMillis());
//		return new ResponseEntity<EmployeeErrorResponse>(response, HttpStatus.BAD_REQUEST);		
//	}
}
