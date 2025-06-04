package com.fido;


import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.fido.constants.ErrorCode;
import com.fido.exceptionhandler.AuthenticationFailedException;
import com.fido.exceptionhandler.ExternalCallException;
import com.fido.model.ErrorDetails;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ResponseEntity<Object> handleEntityNotFoundException(EntityNotFoundException ex) {
		// You can customize the error message here
		ErrorDetails errorDetails = new ErrorDetails(ErrorCode.ENTITY_NOT_FOUND, ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(AuthenticationFailedException.class)
	public ResponseEntity<Object> handleAuthenticationFailedException(AuthenticationFailedException ex) {
		// You can customize the error message and status code here
		ErrorDetails errorDetails = new ErrorDetails(ErrorCode.UNAUTHOURIZED, ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
	}
	
	@ExceptionHandler(EntityExistsException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Object> handleEntityExistsException(EntityExistsException ex) {
		// You can customize the error message here
		ErrorDetails errorDetails = new ErrorDetails(ErrorCode.ENTITY_EXISTS, ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(ExternalCallException.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public ResponseEntity<Object> handleExternalCallException(ExternalCallException ex) {
		// You can customize the error message here
		ErrorDetails errorDetails = new ErrorDetails(ErrorCode.EXTERNAL_CALL_EXCEPTION, ex.getMessage());
		return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
