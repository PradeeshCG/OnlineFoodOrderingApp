package com.cg.onlinefoodorderingapplication.controller;

import java.util.List;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinefoodorderingapplication.entity.Restaurant;
import com.cg.onlinefoodorderingapplication.exception.ResourceNotFoundException;
import com.cg.onlinefoodorderingapplication.service.IRestaurantService;


@RestController 
@RequestMapping("/api/v1")
public class RestaurantController {
	
	@Autowired
	private IRestaurantService restaurantService;

	
	@PostMapping("/restaurants")
	public Restaurant createRestaurant(@Valid @RequestBody Restaurant restaurant)
	{
		return restaurantService.createRestaurant(restaurant);
	}
	
	@GetMapping("/restaurants")
	public List<Restaurant> getAllRestaurants()
	{
		return restaurantService.getAllRestaurants();
	}

	//Get Restaurant by id
	@GetMapping("/restaurants/{id}")
    public ResponseEntity<Restaurant> getRestaurantById(@PathVariable(value = "id") Long restaurantId)
        throws ResourceNotFoundException {
		return restaurantService.getRestaurantById(restaurantId);
	}
	
	//Get Restaurant by username and email
	@GetMapping("/restaurants/{username}/{email}")
	public ResponseEntity<Restaurant> getRestaurantByUsernameAndEmail(@PathVariable(value = "username") String username,
			@PathVariable(value = "email") String email) throws ResourceNotFoundException {
		return restaurantService.getRestaurantByUsernameAndEmail(username, email);
		}
	
	//update Restaurant
	@PutMapping("/restaurants/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(@PathVariable(value = "id") Long restaurantId,
         @Valid @RequestBody Restaurant restaurantDetails) throws ResourceNotFoundException {
		return restaurantService.updateRestaurant(restaurantId, restaurantDetails);
    }
	
}
