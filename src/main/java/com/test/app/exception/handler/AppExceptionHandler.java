package com.test.app.exception.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.test.app.exception.response.ErrorResponse;
import com.test.app.service.impl.BookNotFoundException;

@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {
	
	@ExceptionHandler(value = {BookNotFoundException.class})
	public ResponseEntity<ErrorResponse> handleBookNotFoundException(BookNotFoundException e, WebRequest web) {
		ErrorResponse response = new ErrorResponse(e.getMessage(), new Date());
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = {Exception.class})
	public ResponseEntity<ErrorResponse> handleGenericException(Exception e, WebRequest web) {
		String message = e.getMessage() != null ? e.getMessage() : e.getLocalizedMessage();
		ErrorResponse response = new ErrorResponse(message, new Date());
		return new ResponseEntity<ErrorResponse>(response, HttpStatus.INTERNAL_SERVER_ERROR);
	}

}
