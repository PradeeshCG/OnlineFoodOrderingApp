package com.cg.onlinefoodorderingapplication.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import com.cg.onlinefoodorderingapplication.entity.OrderDetails;
import com.cg.onlinefoodorderingapplication.exception.ResourceNotFoundException;
import com.cg.onlinefoodorderingapplication.repository.OrderDetailsRepository;
import com.cg.onlinefoodorderingapplication.repository.OrderRepository;

@Service
public class OrderDetailsServiceImpl implements IOrderDetailsService {
	
	@Autowired
	private OrderDetailsRepository orderDetailsRepository;
	
	@Autowired
	private OrderRepository orderRepository;

	@Override
	public OrderDetails orderDetails(Long orderId, OrderDetails orderDetails) throws ResourceNotFoundException {
		return orderRepository.findById(orderId).map(order -> {
			orderDetails.setOrder(order);
			return orderDetailsRepository.save(orderDetails);
		}).orElseThrow(() -> new ResourceNotFoundException("order not found"));
	}

	@Override
	public List<OrderDetails> getAllOrderDetailsByOrderId(Long orderId) {
		return orderDetailsRepository.findByOrder_OrderId(orderId);
	}

	@Override
	public ResponseEntity<?> deleteImage(Long orderId) throws ResourceNotFoundException {
		List<OrderDetails> orderDetails = orderDetailsRepository.findByOrder_OrderId(orderId);
		for (OrderDetails oD : orderDetails){
			orderDetailsRepository.delete(oD);
		}
		return ResponseEntity.ok().build();
	}

	@Override
	public List<OrderDetails> getOrderDetailsByRestaurantId(Long restaurantId) {
		return orderDetailsRepository.findByRestaurantId(restaurantId);
	}

	@Override
	public ResponseEntity<OrderDetails> updateRestaurant(Long orderDetailsId, OrderDetails orderDetails)
			throws ResourceNotFoundException {
		 OrderDetails newOrderDetails = orderDetailsRepository.findById(orderDetailsId)
			        .orElseThrow(() -> new ResourceNotFoundException("Restaurant not found for this id :: " + orderDetailsId));

			        newOrderDetails.setStatus(orderDetails.getStatus());
			        newOrderDetails.setComments(orderDetails.getComments());
			        newOrderDetails.setItemPrice(orderDetails.getItemPrice());
			        newOrderDetails.setTotalPrice(orderDetails.getTotalPrice());
			      
			        
			        final OrderDetails updatedOrerDetails = orderDetailsRepository.save(newOrderDetails);
			        return ResponseEntity.ok(updatedOrerDetails);
	}

}
