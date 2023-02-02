package com.studentApi.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
@RestControllerAdvice
public class AppHandler {
	
	@ExceptionHandler(NoRecordFoundExp.class)
	public ResponseEntity<?> NoRecordFoundExp(Exception msg) {
		return new ResponseEntity<>(msg.getMessage(), HttpStatus.NOT_FOUND);
	}

}
