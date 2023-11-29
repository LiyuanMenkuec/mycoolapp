package com.theCode.demo.mycoolapp.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.theCode.demo.mycoolapp.errors.StudentErrorResponse;

@ControllerAdvice
public class StudentRestExceptionHandler {
	

	//Add an exception handler using @ExceptionHandler
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
		//create a StudentErrorResponse
		StudentErrorResponse error=new StudentErrorResponse();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessageString(exc.getMessage());//custom the message String
		error.setTimeStamp(System.currentTimeMillis());
		
		//return ResponseEntity
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.NOT_FOUND);
	}
	
	//Add an exception handler using @ExceptionHandler for all generic exception
	@ExceptionHandler
	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
		//create a StudentErrorResponse
		StudentErrorResponse error=new StudentErrorResponse();
		error.setStatus(HttpStatus.BAD_REQUEST.value());
		error.setMessageString(exc.getMessage());
		error.setTimeStamp(System.currentTimeMillis());
				
		//return ResponseEntity
		return new ResponseEntity<StudentErrorResponse>(error, HttpStatus.BAD_REQUEST);
	}

}
