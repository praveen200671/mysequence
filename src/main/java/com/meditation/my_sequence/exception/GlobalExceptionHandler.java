package com.meditation.my_sequence.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> exceptionHandler(Exception exception) {

		return new ResponseEntity<>("Exception Occurred...."+exception.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(NoUserFoundException.class)
	public ResponseEntity<NoUserFoundException> noUserFoundExceptionHandler(NoUserFoundException e) {
//		NoUserFoundException exception=e.get
		return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
	}

}
