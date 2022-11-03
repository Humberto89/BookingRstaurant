package com.BookingRestaurant.services;

import com.BookingRestaurant.exceptions.BookingException;
import com.BookingRestaurant.jsons.CreateReservationRest;
import com.BookingRestaurant.jsons.ReservationRest;

public interface ReservationService {
	
	ReservationRest getReservation(Long reservationId)throws BookingException;
	
	String createReservation(CreateReservationRest CreateReservationRest) throws BookingException;

}
