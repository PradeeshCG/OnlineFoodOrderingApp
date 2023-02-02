package com.cg.onlinefoodorderingapplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinefoodorderingapplication.entity.Item;


@Repository
public interface ItemRepository extends JpaRepository<Item, Long>{
	List<Item> findByRestaurant_RestaurantId(Long restaurantId);
	Optional<Item> findByItemIdAndRestaurant_RestaurantId(Long itemId, Long restaurantId);

}
