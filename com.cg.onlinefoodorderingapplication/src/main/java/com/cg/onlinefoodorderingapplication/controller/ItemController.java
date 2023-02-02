package com.cg.onlinefoodorderingapplication.controller;

import java.util.List;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.onlinefoodorderingapplication.entity.Item;
import com.cg.onlinefoodorderingapplication.exception.ResourceNotFoundException;
import com.cg.onlinefoodorderingapplication.service.IItemService;




@RestController 
@RequestMapping("/api/i1")
public class ItemController {
	
	@Autowired
	private IItemService itemService;
	
	//get menu for corresponding vendor
	@GetMapping("/restaurant/{restaurantId}/menu")
	public List<Item> getMenuByRestaurantId(@PathVariable(value = "restaurantId") Long restaurantId)
	{
		return itemService.getMenuByRestaurantId(restaurantId);
		
	}
	
	//Get all items to create a menu
	@GetMapping("/menu")
	public List<Item> getMenu()
	{
		return itemService.getMenu();
	}
	
	//Add a new item for corresponding vendor
	@PostMapping("/restaurant/{restaurantId}/menu")
	public Item saveItemByRestaurantId(@PathVariable(value = "restaurantId") Long restaurantId,
			@Valid @RequestBody Item item) throws ResourceNotFoundException
	{
		return itemService.saveItemByRestaurantId(restaurantId, item);
	}
	
	//Add a new item in menu
	@PostMapping("/menu")
	public Item createItem(@Valid @RequestBody Item item)
	{
		return itemService.createItem(item);
		
	}
	
	
	@GetMapping("/menu/{itemId}")
    public ResponseEntity<Item> getItemById(@PathVariable(value = "itemId") Long itemId)
        throws ResourceNotFoundException {
		return itemService.getItemById(itemId);
    }
	
	
	@PutMapping("/menu/{itemId}")
    public ResponseEntity<Item> updateItem(@PathVariable(value = "itemId") Long itemId,
         @Valid @RequestBody Item itemDetails) throws ResourceNotFoundException
	{
		return itemService.updateItem(itemId, itemDetails);
    }
	
	//Delete an item according to itemId and vendorId
	@DeleteMapping("/restaurants/{restaurantId}/menu/{itemId}")
	public ResponseEntity<?> deleteItem(@PathVariable(value = "restaurantId") Long restaurantId, 
			@PathVariable(value = "itemId") Long itemId)
	throws ResourceNotFoundException
	{
		return itemService.deleteItem(restaurantId, itemId);
	}

	
}
