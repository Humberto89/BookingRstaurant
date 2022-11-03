package com.BookingRestaurant.services;

import com.BookingRestaurant.exceptions.BookingException;

public interface CancelReservationService {

	public String deleteResetvation(String locator) throws BookingException;
	
	
}
