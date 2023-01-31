package com.cg.onlinefoodorderingapplication.service;

import java.util.List;



import org.springframework.http.ResponseEntity;


import com.cg.onlinefoodorderingapplication.entity.Restaurant;
import com.cg.onlinefoodorderingapplication.exception.ResourceNotFoundException;


public interface IRestaurantService {
	
	public Restaurant createRestaurant(Restaurant restaurant);
	public List<Restaurant> getAllRestaurants();
    public ResponseEntity<Restaurant> getRestaurantById(Long restaurantId)
            throws ResourceNotFoundException;
	public ResponseEntity<Restaurant> getRestaurantByUsernameAndEmail(String username,
			String email) throws ResourceNotFoundException;
    public ResponseEntity<Restaurant> updateRestaurant(Long restaurantId,Restaurant restaurantDetails) throws ResourceNotFoundException;
    
}