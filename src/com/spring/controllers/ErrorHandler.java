package com.spring.controllers;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

	
	@ExceptionHandler(NullPointerException.class)
	public String errorHandling(NullPointerException ex) {
		return "Error";
	}

}
