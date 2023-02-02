package com.cg.onlinefoodorderingapplication.service;


import java.util.List;



import org.springframework.http.ResponseEntity;

import com.cg.onlinefoodorderingapplication.entity.Order;
import com.cg.onlinefoodorderingapplication.exception.ResourceNotFoundException;


public interface IOrderService {
	public Order saveOrder(Order order);
	public List<Order> getAllOrders();
	public ResponseEntity<Order> updateOrder(Long orderId,Order orderDetails) throws ResourceNotFoundException;
	public ResponseEntity<?> deleteOrder(Long orderId) throws ResourceNotFoundException;
	public ResponseEntity<Order> getOrderById(Long orderId)throws ResourceNotFoundException;

}
