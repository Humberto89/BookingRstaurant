package com.BookingRestaurant.services;

import java.util.List;

import com.BookingRestaurant.exceptions.BookingException;
import com.BookingRestaurant.jsons.RestaurantRest;

public interface RestaurantService {

	RestaurantRest getRestaurantById(Long restaurantId) throws BookingException;
	
	public List<RestaurantRest> getRestaurants() throws BookingException;
}
