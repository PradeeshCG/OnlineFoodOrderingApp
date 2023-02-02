package com.cg.onlinefoodorderingapplication.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.cg.onlinefoodorderingapplication.entity.Item;
import com.cg.onlinefoodorderingapplication.exception.ResourceNotFoundException;
import com.cg.onlinefoodorderingapplication.repository.ItemRepository;
import com.cg.onlinefoodorderingapplication.repository.RestaurantRepository;

@Service
public class ItemServiceImpl implements IItemService{
	
	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;

	@Override
	public List<Item> getMenuByRestaurantId(Long restaurantId) {
		return itemRepository.findByRestaurant_RestaurantId(restaurantId);
	}

	@Override
	public List<Item> getMenu() {
		return itemRepository.findAll();
	}

	@Override
	public Item saveItemByRestaurantId(Long restaurantId, Item item) throws ResourceNotFoundException {
		return restaurantRepository.findById(restaurantId).map(restaurant ->{
			item.setRestaurant(restaurant);
			return itemRepository.save(item);
		}).orElseThrow(() -> new ResourceNotFoundException("Restaurant not found"));
	}

	@Override
	public Item createItem(Item item) {
		return itemRepository.save(item);
	}

	@Override
	public ResponseEntity<Item> getItemById(Long itemId) throws ResourceNotFoundException {
		 Item item = itemRepository.findById(itemId)
		          .orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + itemId));
		        return ResponseEntity.ok().body(item);
	}

	@Override
	public ResponseEntity<Item> updateItem(Long itemId, Item itemDetails) throws ResourceNotFoundException {
		Item item = itemRepository.findById(itemId)
		        .orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + itemId));

		        item.setItemName(itemDetails.getItemName());
		        item.setItemPrice(itemDetails.getItemPrice());
		        item.setDescription(itemDetails.getDescription());  
		        
		        final Item updatedItem = itemRepository.save(item);
		        return ResponseEntity.ok(updatedItem);
	}

	@Override
	public ResponseEntity<?> deleteItem(Long restaurantId, Long itemId) throws ResourceNotFoundException {
		return itemRepository.findByItemIdAndRestaurant_RestaurantId(itemId, restaurantId).map(item -> {
			itemRepository.delete(item);
		return ResponseEntity.ok().build();
		}).orElseThrow(()->new ResourceNotFoundException("item not found"));
	}

}
