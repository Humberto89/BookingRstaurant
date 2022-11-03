package com.BookingRestaurant.exceptions;

import java.util.Arrays;

import org.springframework.http.HttpStatus;

import com.BookingRestaurant.dtos.ErrorDto;

public class InternalServerErrorException extends BookingException{

	private static final long serialVersionUID = 1L;

	public InternalServerErrorException(String code, String message) {
		super(code,HttpStatus.INTERNAL_SERVER_ERROR.value(), message);
		// TODO Auto-generated constructor stub
	}

	public InternalServerErrorException(String code, String message, ErrorDto data) {
		super(code, HttpStatus.INTERNAL_SERVER_ERROR.value(), message, Arrays.asList(data));
		// TODO Auto-generated constructor stub
	}
}
