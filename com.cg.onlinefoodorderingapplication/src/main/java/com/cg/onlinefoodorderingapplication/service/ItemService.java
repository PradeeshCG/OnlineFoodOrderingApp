package com.cg.onlinefoodorderingapplication.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlinefoodorderingapplication.entity.Item;
import com.cg.onlinefoodorderingapplication.exception.ResourceNotFoundException;

public interface IItemService {
	public List<Item> getMenuByRestaurantId(Long restaurantId);

	public List<Item> getMenu();

	public Item saveItemByRestaurantId(Long restaurantId, Item item) throws ResourceNotFoundException;

	public Item createItem(Item item);

	public ResponseEntity<Item> getItemById(Long itemId) throws ResourceNotFoundException;

	public ResponseEntity<Item> updateItem(Long itemId, Item itemDetails) throws ResourceNotFoundException;

	public ResponseEntity<?> deleteItem(Long restaurantId, Long itemId) throws ResourceNotFoundException;
}
