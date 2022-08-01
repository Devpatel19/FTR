package com.vehicle.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.vehicle.error.ErrorMessage;

@RestControllerAdvice
public class GlobalException 
{
	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler(InvalidFormatException e)
	{
		ErrorMessage err=new ErrorMessage();
		err.setCodeStatus(HttpStatus.BAD_REQUEST.value());
		err.setMessage("Vehicle Maximum Lifting capacity should be a Integer");
		ResponseEntity<ErrorMessage> entity=new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		return entity;
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> ExceptionHandler(Exception e)
	{
		ErrorMessage err=new ErrorMessage();
		err.setCodeStatus(HttpStatus.BAD_REQUEST.value());
		err.setMessage(e.getMessage());
		ResponseEntity<ErrorMessage> entity=new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		return entity;
	}
	
	@ExceptionHandler(VehicleNotFoundException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler(VehicleNotFoundException e)
	{
		ErrorMessage err=new ErrorMessage();
		err.setCodeStatus(HttpStatus.BAD_REQUEST.value());
		err.setMessage(e.getMessage());
		ResponseEntity<ErrorMessage> entity=new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		return entity;
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler(MethodArgumentNotValidException e)
	{
		ErrorMessage err=new ErrorMessage();
		err.setCodeStatus(HttpStatus.BAD_REQUEST.value());
		err.setMessage(e.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage).collect(Collectors.joining(",")));
		ResponseEntity<ErrorMessage> entity=new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		return entity;
	}
	
		
	@ExceptionHandler(VehicleStatusExistException.class)
	public ResponseEntity<ErrorMessage> exceptionHandler(VehicleStatusExistException e)
	{
		ErrorMessage err=new ErrorMessage();
		err.setCodeStatus(HttpStatus.BAD_REQUEST.value());
		err.setMessage(e.getMessage());
		ResponseEntity<ErrorMessage> entity=new ResponseEntity<>(err,HttpStatus.BAD_REQUEST);
		return entity;
	}
}