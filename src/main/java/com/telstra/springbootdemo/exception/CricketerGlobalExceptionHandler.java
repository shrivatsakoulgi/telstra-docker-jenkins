package com.telstra.springbootdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CricketerGlobalExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<String> cricketerNotFoundExceptionHandler(CricketerNotFoundException ex) {
		return new ResponseEntity<String>("Cricketer not Found..",HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<String> duplicateCrickterExceptionHandler(DuplicateCricketerException ex) {
		return new ResponseEntity<String>("Duplicate Cricketer Inserted...",HttpStatus.BAD_REQUEST);
	}
	
	
}
