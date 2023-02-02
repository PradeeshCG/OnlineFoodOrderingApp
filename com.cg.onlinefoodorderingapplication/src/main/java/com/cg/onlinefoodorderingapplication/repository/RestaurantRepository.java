package com.cg.onlinefoodorderingapplication.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinefoodorderingapplication.entity.Restaurant;


@Repository
public interface RestaurantRepository extends JpaRepository<Restaurant, Long>{
	Optional<Restaurant> findByUsernameAndEmail(String username, String email);

}
