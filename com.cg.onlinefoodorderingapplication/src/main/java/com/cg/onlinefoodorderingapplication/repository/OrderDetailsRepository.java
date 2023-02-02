package com.cg.onlinefoodorderingapplication.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.onlinefoodorderingapplication.entity.OrderDetails;


@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails, Long>{
	
	List<OrderDetails> findByOrder_OrderId(Long orderId);
	List<OrderDetails> findByRestaurantId(Long restaurantId);
	Optional<OrderDetails> findByOrderDetailsIdAndOrder_OrderId(String orderDetailsId, Long orderId);

}
