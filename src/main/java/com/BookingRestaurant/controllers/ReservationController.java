package com.BookingRestaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.BookingRestaurant.exceptions.BookingException;
import com.BookingRestaurant.jsons.CreateReservationRest;
import com.BookingRestaurant.jsons.ReservationRest;
import com.BookingRestaurant.responses.BookingResponse;
import com.BookingRestaurant.services.ReservationService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/booking-reservation" + "/v1")
public class ReservationController {

	@Autowired
	ReservationService reservationService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "reservation" + "/{" + "reservationId"
			+ "}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse<ReservationRest> getRestaurantById(@PathVariable Long reservationId)
			throws BookingException {
		return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				reservationService.getReservation(reservationId));
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "reservation", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse<String> createReservation(@RequestBody CreateReservationRest createReservationRest)
			throws BookingException {
		return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				reservationService.createReservation(createReservationRest));
	}

}
