package com.BookingRestaurant.controllers;

import java.util.List;

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
import com.BookingRestaurant.jsons.RestaurantRest;
import com.BookingRestaurant.responses.BookingResponse;
import com.BookingRestaurant.services.RestaurantService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(path = "/booking-restaurant" + "/v1")
public class RestaurantController {

	@Autowired
	RestaurantService restaurantService;

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "restaurant" + "/{" + "restaruantId"
			+ "}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse<RestaurantRest> getRestaurantById(@PathVariable Long restaurantId) throws BookingException {
		return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK",
				restaurantService.getRestaurantById(restaurantId));
	}

	@ResponseStatus(HttpStatus.OK)
	@RequestMapping(value = "restaurants", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public BookingResponse<List<RestaurantRest>> getRestaurant() throws BookingException {
		return new BookingResponse<>("Succes", String.valueOf(HttpStatus.OK), "OK", restaurantService.getRestaurants());
	}

}
