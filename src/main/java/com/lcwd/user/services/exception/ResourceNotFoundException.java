package com.lcwd.user.services.exception;

public class ResourceNotFoundException extends RuntimeException{

	// extra properties that you want manage. 
	
	private String message;
	
		public ResourceNotFoundException() {
			super("Resource Not Found On Server !!");
		}
		
		public ResourceNotFoundException(String message) {
			super(message);
		}
}
