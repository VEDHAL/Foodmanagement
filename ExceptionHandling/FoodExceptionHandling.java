package com.example.FoodDelivery.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice

public class FoodExceptionHandling {
	@ExceptionHandler(FoodOwnException.class)
		public ResponseEntity<String> handleOwnException(FoodOwnException e){
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body (e.getMessage());}
	
	@ExceptionHandler(FoodNulledException.class)
	public ResponseEntity<String> handleOwnException(FoodNulledException e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body (e.getMessage());}

	

	}

