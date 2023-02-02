package com.cg.onlinefoodorderingapplication.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlinefoodorderingapplication.entity.Order;
import com.cg.onlinefoodorderingapplication.exception.ResourceNotFoundException;
import com.cg.onlinefoodorderingapplication.repository.OrderRepository;

@Service
public class OrderServiceImpl implements IOrderService{
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public Order saveOrder(Order order) {
		return orderRepository.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	@Override
	public ResponseEntity<Order> updateOrder(Long orderId, Order orderDetails) throws ResourceNotFoundException {
		 Order order = orderRepository.findById(orderId)
			        .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + orderId));

			        order.setAmount(orderDetails.getAmount());
			        order.setCustomerId(orderDetails.getCustomerId());
			        order.setStatus(orderDetails.getStatus());
			        order.setOrderDate(orderDetails.getOrderDate());
			        
			        final Order updatedOrder = orderRepository.save(order);
			        return ResponseEntity.ok(updatedOrder);
	}

	@Override
	public ResponseEntity<?> deleteOrder(Long orderId) throws ResourceNotFoundException {
		return orderRepository.findById(orderId).map(order -> {
			orderRepository.delete(order);
		return ResponseEntity.ok().build();
		}).orElseThrow(()->new ResourceNotFoundException("order not found"));
	}

	@Override
	public ResponseEntity<Order> getOrderById(Long orderId) throws ResourceNotFoundException {
		 Order order = orderRepository.findById(orderId)
		          .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + orderId));
		        return ResponseEntity.ok().body(order);
	}

}