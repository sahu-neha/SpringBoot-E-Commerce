package com.ecommerce.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<MyExceptionHandler> exceptionHandler(IllegalArgumentException iae, WebRequest req) {
		System.out.println("===== Inside Exception Handler method =====");
		return new ResponseEntity<MyExceptionHandler>(
				new MyExceptionHandler(LocalDateTime.now(), iae.getMessage(), req.getDescription(false)),
				HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<MyExceptionHandler> exceptionHandler(CustomerException iae, WebRequest req) {
		System.out.println("===== Inside Exception Handler method =====");
		return new ResponseEntity<MyExceptionHandler>(
				new MyExceptionHandler(LocalDateTime.now(), iae.getMessage(), req.getDescription(false)),
				HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(CartException.class)
	public ResponseEntity<MyExceptionHandler> exceptionHandler(CartException iae, WebRequest req) {
		System.out.println("===== Inside Exception Handler method =====");
		return new ResponseEntity<MyExceptionHandler>(
				new MyExceptionHandler(LocalDateTime.now(), iae.getMessage(), req.getDescription(false)),
				HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(CategoryException.class)
	public ResponseEntity<MyExceptionHandler> exceptionHandler(CategoryException iae, WebRequest req) {
		System.out.println("===== Inside Exception Handler method =====");
		return new ResponseEntity<MyExceptionHandler>(
				new MyExceptionHandler(LocalDateTime.now(), iae.getMessage(), req.getDescription(false)),
				HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(OrdersException.class)
	public ResponseEntity<MyExceptionHandler> exceptionHandler(OrdersException iae, WebRequest req) {
		System.out.println("===== Inside Exception Handler method =====");
		return new ResponseEntity<MyExceptionHandler>(
				new MyExceptionHandler(LocalDateTime.now(), iae.getMessage(), req.getDescription(false)),
				HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(ProductException.class)
	public ResponseEntity<MyExceptionHandler> exceptionHandler(ProductException iae, WebRequest req) {
		System.out.println("===== Inside Exception Handler method =====");
		return new ResponseEntity<MyExceptionHandler>(
				new MyExceptionHandler(LocalDateTime.now(), iae.getMessage(), req.getDescription(false)),
				HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(ReviewException.class)
	public ResponseEntity<MyExceptionHandler> exceptionHandler(ReviewException iae, WebRequest req) {
		System.out.println("===== Inside Exception Handler method =====");
		return new ResponseEntity<MyExceptionHandler>(
				new MyExceptionHandler(LocalDateTime.now(), iae.getMessage(), req.getDescription(false)),
				HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(SubCategoryException.class)
	public ResponseEntity<MyExceptionHandler> exceptionHandler(SubCategoryException iae, WebRequest req) {
		System.out.println("===== Inside Exception Handler method =====");
		return new ResponseEntity<MyExceptionHandler>(
				new MyExceptionHandler(LocalDateTime.now(), iae.getMessage(), req.getDescription(false)),
				HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(WishlistException.class)
	public ResponseEntity<MyExceptionHandler> exceptionHandler(WishlistException iae, WebRequest req) {
		System.out.println("===== Inside Exception Handler method =====");
		return new ResponseEntity<MyExceptionHandler>(
				new MyExceptionHandler(LocalDateTime.now(), iae.getMessage(), req.getDescription(false)),
				HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyExceptionHandler> exceptionHandler(NoHandlerFoundException iae, WebRequest req) {
		System.out.println("===== Inside Exception Handler method =====");
		return new ResponseEntity<MyExceptionHandler>(
				new MyExceptionHandler(LocalDateTime.now(), iae.getMessage(), req.getDescription(false)),
				HttpStatus.BAD_REQUEST);

	}

}
