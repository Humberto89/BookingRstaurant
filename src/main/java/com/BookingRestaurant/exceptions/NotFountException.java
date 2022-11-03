package com.BookingRestaurant.exceptions;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import com.BookingRestaurant.dtos.ErrorDto;

public class NotFountException extends BookingException {

	private static final long serialVersionUID = 1L;

	public NotFountException(String code, String message) {
		super(code, HttpStatus.NOT_FOUND.value(), message);
		// TODO Auto-generated constructor stub
	}

	public NotFountException(String code, String message, ErrorDto data) {
		super(code, HttpStatus.NOT_FOUND.value(), message, Arrays.asList(data));
		// TODO Auto-generated constructor stub
	}

	
}
