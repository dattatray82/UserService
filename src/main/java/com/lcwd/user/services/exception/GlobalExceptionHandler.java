package com.lcwd.user.services.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.lcwd.user.services.payload.ApiResponse;



@RestControllerAdvice
public class GlobalExceptionHandler {

	// @ExceptionHandler annotation are used to handle this type of exception(Defined type) occurs in 
	// any where in the project that will handle by this method.
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handlerResourceNotFoundException(ResourceNotFoundException ex){
		
		String message = ex.getMessage();
		/* without using setter method to set value into object.
		 * Instead of this you can use @Builder annotation to build any type of object in single line. 
		 */
		
		ApiResponse response = new ApiResponse();
		response.setMessage(message);
		response.setStatus(HttpStatus.NOT_FOUND);
		response.setSuccess(true);
		
		return new ResponseEntity<ApiResponse>(response, HttpStatus.NOT_FOUND);
	}
}
