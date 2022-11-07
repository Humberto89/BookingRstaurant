package com.BookingRestaurant.services.Impl;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.BookingRestaurant.entities.Restaurant;
import com.BookingRestaurant.exceptions.BookingException;
import com.BookingRestaurant.exceptions.NotFountException;
import com.BookingRestaurant.jsons.RestaurantRest;
import com.BookingRestaurant.repositories.RestaurantRepository;
import com.BookingRestaurant.services.RestaurantService;

@Service
public class RestaurantServiceImpl implements RestaurantService {

	@Autowired
	RestaurantRepository restaurantRepository;

	public static final ModelMapper modelMapper = new ModelMapper();

	public RestaurantRest getRestaurantById(Long restaurantId) throws BookingException {
		return modelMapper.map(getRestaurantEntity(restaurantId), RestaurantRest.class);
	}

	public List<RestaurantRest> getRestaurants() throws BookingException {
		final List<Restaurant> restaurantsEntity = restaurantRepository.findAll();
		return restaurantsEntity.stream().map(service -> modelMapper.map(service, RestaurantRest.class))
				.collect(Collectors.toList());
	}

	private Restaurant getRestaurantEntity(long restaurantId) throws BookingException {
		return restaurantRepository.findById(restaurantId)
				.orElseThrow(() -> new NotFountException("SNOT-404-1", "RESTAURANT_NOT_FOUND"));
	}

}
