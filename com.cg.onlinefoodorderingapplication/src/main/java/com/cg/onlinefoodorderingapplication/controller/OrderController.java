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

import com.cg.onlinefoodorderingapplication.entity.Order;
import com.cg.onlinefoodorderingapplication.exception.ResourceNotFoundException;
import com.cg.onlinefoodorderingapplication.service.IOrderService;



@RestController 
@RequestMapping("/api/o1")
public class OrderController {
	
	@Autowired
	private IOrderService orderService;
	
	//save an order
	@PostMapping("/orders")
	public Order saveOrder(@Valid @RequestBody Order order)
	{
		return orderService.saveOrder(order);
	}
	
	//get all orders
	@GetMapping("/orders")
	public List<Order> getAllOrders()
	{
		return orderService.getAllOrders();
	}
	
	//update orders
	@PutMapping("/orders/{id}")
	public ResponseEntity<Order> updateOrder(@PathVariable(value = "id") Long orderId,
	         @Valid @RequestBody Order orderDetails) throws ResourceNotFoundException {
		return orderService.updateOrder(orderId, orderDetails);
	    }	
	
	
	//delete order
	@DeleteMapping("/orders/{orderId}")
	public ResponseEntity<?> deleteOrder( 
			@PathVariable(value = "orderId") Long orderId)
	throws ResourceNotFoundException
	{
		return orderService.deleteOrder(orderId);
	}
	
	//get order by orderId
	@GetMapping("/orders/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable(value = "id") Long orderId)
        throws ResourceNotFoundException {
		return orderService.getOrderById(orderId);
    }

}
