package com.BookingRestaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BookingRestaurant.exceptions.BookingException;
import com.BookingRestaurant.jsons.CreateReservationRest;
import com.BookingRestaurant.responses.BookingResponse;
import com.BookingRestaurant.services.ReservationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping(path = "/booking-reservation" + "")
public class ReservationController {

	@Autowired
	ReservationService reservationService;

	public BookingResponse<String> createReservation(@RequestBody CreateReservationRest createReservationRest)
			throws BookingException {
		return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				reservationService.createReservation(createReservationRest));
	}

}
