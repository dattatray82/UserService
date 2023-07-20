package com.lcwd.user.services.payload;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {

	private String message;
	private boolean success;
	private HttpStatus status;
	public String getMessage() {
		return message;
	}
	public boolean isSuccess() {
		return success;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	
}
