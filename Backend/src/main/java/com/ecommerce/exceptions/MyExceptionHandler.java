package com.ecommerce.exceptions;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class MyExceptionHandler {

	private LocalDateTime timestamp;
	private String message;
	private String details;

	public MyExceptionHandler(LocalDateTime timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}

}