package com.sa.paniwala.restdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class StudentRestExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleStudentException(StudentNotFoundException exec) {
		StudentErrorResponse ser = new StudentErrorResponse();
		ser.setStatus(HttpStatus.NOT_FOUND.value());
		ser.setMessage(exec.getMessage());
		ser.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<StudentErrorResponse>(ser, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleStudentException(Exception exec) {
		StudentErrorResponse ser = new StudentErrorResponse();
		ser.setStatus(HttpStatus.BAD_REQUEST.value());
		ser.setMessage(exec.getMessage());
		ser.setTimestamp(System.currentTimeMillis());
		
		return new ResponseEntity<StudentErrorResponse>(ser, HttpStatus.BAD_REQUEST);
	}
}
