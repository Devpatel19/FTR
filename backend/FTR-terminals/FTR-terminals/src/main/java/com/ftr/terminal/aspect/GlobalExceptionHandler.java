package com.ftr.terminal.aspect;

import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ftr.terminal.exception.CapacityExceededException;
import com.ftr.terminal.exception.ItemTypeNotFoundException;
import com.ftr.terminal.exception.TerminalEmptyException;
import com.ftr.terminal.exception.TerminalNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(CapacityExceededException.class)
	public ResponseEntity<ErrorMessage> CapacityExceededExceptionHandler(CapacityExceededException ex)
	{
		ErrorMessage error = new ErrorMessage();
		error.setMessage("Given capacity is more or equal to the given capacity");
		return ResponseEntity.badRequest().body(error);
	}
	
	@ExceptionHandler(ItemTypeNotFoundException.class)
	public ResponseEntity<ErrorMessage> ItemTypeNotFoundExceptionHandler(ItemTypeNotFoundException ex)
	{
		ErrorMessage error = new ErrorMessage();
		error.setMessage("No such Item type exists.");
		return ResponseEntity.badRequest().body(error);
	}
	
	@ExceptionHandler(TerminalEmptyException.class)
	public ResponseEntity<ErrorMessage> TerminalEmptyExceptionHandler(TerminalEmptyException ex)
	{
		ErrorMessage error = new ErrorMessage();
		error.setMessage("No terminals exists, please add.");
		return ResponseEntity.badRequest().body(error);
	}
	
	
	@ExceptionHandler(TerminalNotFoundException.class)
	public ResponseEntity<ErrorMessage> TerminalNotFoundExceptionHandler(TerminalNotFoundException ex)
	{
		ErrorMessage error = new ErrorMessage();
		error.setMessage("Terminal details not found for ID :" + ex.getMessage());
		return ResponseEntity.badRequest().body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorMessage> methodArgumentExceptionHandler(MethodArgumentNotValidException ex) 
	{
		ErrorMessage error = new ErrorMessage();
		error.setMessage(ex.getBindingResult().getAllErrors().stream().map(ObjectError::getDefaultMessage)
			        		                                  .collect(Collectors.joining(", ")));

		return ResponseEntity.badRequest().body(error);
	}
			
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ErrorMessage> constraintViolationExceptionHandler(ConstraintViolationException ex) 
	{
		ErrorMessage error = new ErrorMessage();
		error.setMessage(ex.getConstraintViolations().stream().map(ConstraintViolation::getMessage)
			        		                          .collect(Collectors.joining(", ")));
		return ResponseEntity.badRequest().body(error);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorMessage> generalExceptionHandler(ExceptionHandler ex)
	{
		ErrorMessage error = new ErrorMessage();
		error.setMessage("Oops ! something went wrong.");
		return ResponseEntity.badRequest().body(error);
	}
	

	
}
