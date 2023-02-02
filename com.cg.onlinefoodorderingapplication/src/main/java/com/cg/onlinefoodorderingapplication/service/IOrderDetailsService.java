package com.cg.onlinefoodorderingapplication.service;


import java.util.List;

import org.springframework.http.ResponseEntity;

import com.cg.onlinefoodorderingapplication.entity.OrderDetails;
import com.cg.onlinefoodorderingapplication.exception.ResourceNotFoundException;



public interface IOrderDetailsService {
	public OrderDetails orderDetails(Long orderId,OrderDetails orderDetails) throws ResourceNotFoundException;
	public List<OrderDetails> getAllOrderDetailsByOrderId(Long orderId);
    public ResponseEntity<?> deleteImage(Long orderId) throws ResourceNotFoundException;
	public List<OrderDetails> getOrderDetailsByRestaurantId(Long restaurantId);
	   public ResponseEntity<OrderDetails> updateRestaurant(Long orderDetailsId,
		         OrderDetails orderDetails) throws ResourceNotFoundException ;
}
