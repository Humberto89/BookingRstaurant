package com.BookingRestaurant.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.BookingRestaurant.controllers.RestaurantController;
import com.BookingRestaurant.exceptions.BookingException;
import com.BookingRestaurant.jsons.RestaurantRest;
import com.BookingRestaurant.jsons.TurnsRest;
import com.BookingRestaurant.responses.BookingResponse;
import com.BookingRestaurant.services.RestaurantService;

public class RestaurtantControllerTest {
	private static final String NAME = "Buger";
	private static final String DESCRIPTION = "Todo tipo de hamburgesas";
	private static final String ADDRESS = "Av. Galindo SS";
	private static final Long RESTAURANT_ID = 1L;
	private static final String IMAGE = "image.com";

	private static final String SUCCES_STATUS = "Succes";
	private static final String SUCCES_CODE = "200 OK";
	private static final String OK = "OK";

	public static final List<TurnsRest> TURN_LIST = new ArrayList<>();
	public static final RestaurantRest RESTAURANT_REST = new RestaurantRest();
	public final static List<RestaurantRest> RESTAURANT_REST_LIST = new ArrayList<>();

	@Mock
	RestaurantService restaurantService;
	@InjectMocks
	RestaurantController restaurantController;

	@Before
	public void init() throws BookingException {
		MockitoAnnotations.initMocks(this);

		RESTAURANT_REST.setImage(NAME);
		RESTAURANT_REST.setDescription(DESCRIPTION);
		RESTAURANT_REST.setAddress(ADDRESS);
		RESTAURANT_REST.setId(RESTAURANT_ID);
		RESTAURANT_REST.setImage(IMAGE);
		RESTAURANT_REST.setTurns(TURN_LIST);

		Mockito.when(restaurantService.getRestaurantById(RESTAURANT_ID)).thenReturn(RESTAURANT_REST);
	}

	@Test
	public void getRestaurantByIdTest() throws BookingException {
		final BookingResponse<RestaurantRest> response = restaurantController.getRestaurantById(RESTAURANT_ID);
		assertEquals(response.getStatus(), SUCCES_STATUS);
		assertEquals(response.getCode(), SUCCES_CODE);
		assertEquals(response.getMessage(), OK);
		assertEquals(response.getData(), RESTAURANT_REST);

	}

	@Test
	public void getRestauranTest() throws BookingException {
		final BookingResponse<List<RestaurantRest>> response = restaurantController.getRestaurant();
		assertEquals(response.getStatus(), SUCCES_STATUS);
		assertEquals(response.getCode(), SUCCES_CODE);
		assertEquals(response.getMessage(), OK);
		assertEquals(response.getData(), RESTAURANT_REST_LIST);
	}

}