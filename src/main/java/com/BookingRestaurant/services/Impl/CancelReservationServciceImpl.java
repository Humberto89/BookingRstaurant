package com.BookingRestaurant.services.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.BookingRestaurant.exceptions.BookingException;
import com.BookingRestaurant.exceptions.InternalServerErrorException;
import com.BookingRestaurant.exceptions.NotFountException;
import com.BookingRestaurant.repositories.ReservationRepository;
import com.BookingRestaurant.services.CancelReservationService;

public class CancelReservationServciceImpl implements CancelReservationService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CancelReservationServciceImpl.class);

	@Autowired
	
	private ReservationRepository reservationRepository;
	
	public String deleteResetvation(String locator) throws BookingException {
		
		reservationRepository.findByLocator(locator)
				.orElseThrow(() -> new NotFountException("LOCATOR_NOT_FOUND", "LOCATOR_NOT_FOUND"));
		
		try {
			reservationRepository.deleteByLocator(locator);
			
		} catch (Exception e) {
			
			LOGGER.error("INTERNAL_SERVER_ERROR", e);
			throw new InternalServerErrorException("INTERNAL_SERVER_ERROR", "INTERNAL_SERVER_ERROR");
			
		}
		
		return "LOCATOR_DELETED";
	}

}
