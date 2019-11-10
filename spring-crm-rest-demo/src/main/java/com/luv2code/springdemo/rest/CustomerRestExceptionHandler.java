package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomerRestExceptionHandler {

	//Add a handler for customer not found exception
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleExcetion(CustomerNotFoundException exc){
		
		//create CustomerErrorResponse object
		CustomerErrorResponse error = new CustomerErrorResponse(
				                       HttpStatus.NOT_FOUND.value(),
				                       exc.getMessage(),
				                       System.currentTimeMillis());
		
		//return responseEntity
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	//Add a handler to catch any exception
	@ExceptionHandler
	public ResponseEntity<CustomerErrorResponse> handleExcetion(Exception exc){
		
		//create CustomerErrorResponse object
		CustomerErrorResponse error = new CustomerErrorResponse(
				                       HttpStatus.BAD_REQUEST.value(),
				                       exc.getMessage(),
				                       System.currentTimeMillis());
		
		//return responseEntity
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
}
