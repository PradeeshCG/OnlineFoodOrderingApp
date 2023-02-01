package com.cg.onlinefoodorderingapplication.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlinefoodorderingapplication.entity.Restaurant;
import com.cg.onlinefoodorderingapplication.exception.ResourceNotFoundException;
import com.cg.onlinefoodorderingapplication.repository.RestaurantRepository;

@Service
public class RestaurantService implements IRestaurantService{
	
	@Autowired
	RestaurantRepository restaurantRepository;

	@Override
	public Restaurant createRestaurant(Restaurant restaurant) {
		return restaurantRepository.save(restaurant);
	}

	@Override
	public List<Restaurant> getAllRestaurants() {
		return restaurantRepository.findAll();
	}

	@Override
	public ResponseEntity<Restaurant> getRestaurantById(Long restaurantId) throws ResourceNotFoundException {
		Restaurant restaurant = restaurantRepository.findById(restaurantId)
		          .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found for this id :: " + restaurantId));
		        return ResponseEntity.ok().body(restaurant);
	}

	@Override
	public ResponseEntity<Restaurant> getRestaurantByUsernameAndEmail(String username, String email)
			throws ResourceNotFoundException {
		Restaurant restaurant = restaurantRepository.findByUsernameAndEmail(username, email)
		          .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found " ));
		        return ResponseEntity.ok().body(restaurant);
	}

	@Override
	public ResponseEntity<Restaurant> updateRestaurant(Long restaurantId, Restaurant restaurantDetails) throws ResourceNotFoundException {
		Restaurant restaurant = restaurantRepository.findById(restaurantId)
			        .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found for this id :: " + restaurantId));

			        restaurant.setEmail(restaurantDetails.getEmail());
			        restaurant.setLastName(restaurantDetails.getLastName());
			        restaurant.setFirstName(restaurantDetails.getFirstName());
			        restaurant.setUsername(restaurantDetails.getUsername());
			        restaurant.setPassword(restaurantDetails.getPassword());
			        restaurant.setFoodSpecialization(restaurantDetails.getFoodSpecialization());
			        
			        final Restaurant updatedRestaurant = restaurantRepository.save(restaurant);
			        return ResponseEntity.ok(updatedRestaurant);
	}

}

