package com.BookingRestaurant.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BookingRestaurant.exceptions.BookingException;
import com.BookingRestaurant.jsons.RestaurantRest;
import com.BookingRestaurant.responses.BookingResponse;
import com.BookingRestaurant.services.RestaurantService;


@RestController
@RequestMapping(path = "/booking-restaurant" + "v1")
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;

	public BookingResponse<RestaurantRest> getRestaurantById(Long restaurantId) throws BookingException {
		return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				restaurantService.getRestaurantById(restaurantId));
	}
}
 