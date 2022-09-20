package com.telstra.springbootdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CricketerGlobalException {
	
	@ExceptionHandler
	public ResponseEntity<String> cricketerNotFoundException(CricketerNotFoundException ex){
		return new ResponseEntity<String>("Cricketer not found..", HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<String> duplicateCricketerException(DuplicateCricketerException ex){
		return new ResponseEntity<String>("Duplicate Cricketer Inserted..", HttpStatus.BAD_REQUEST);
	}
	

}
