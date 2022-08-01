package com.example.demo.aspect;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.demo.exception.UserNotFoundException;
import com.example.demo.util.ErrorMessage;

@RestControllerAdvice
public class ExceptionAspect {
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorMessage> userNotFoundExceptionHandler(UserNotFoundException e){
		ErrorMessage msg = new ErrorMessage();
		msg.setMessage(e.getMessage());
		msg.setStatusCode(HttpStatus.BAD_REQUEST.value());
		msg.setUrl("/ftr");
		
		ResponseEntity<ErrorMessage> entity = new ResponseEntity<>(msg,HttpStatus.OK);
		return entity;
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> ExceptionHandler(Exception e){
		ResponseEntity<String> entity = new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
		return entity;
	}
}
