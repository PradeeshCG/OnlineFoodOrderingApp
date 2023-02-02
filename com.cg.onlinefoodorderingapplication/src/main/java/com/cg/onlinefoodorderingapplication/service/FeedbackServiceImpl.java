package com.cg.onlinefoodorderingapplication.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cg.onlinefoodorderingapplication.entity.Feedback;
import com.cg.onlinefoodorderingapplication.exception.ResourceNotFoundException;
import com.cg.onlinefoodorderingapplication.repository.FeedbackRepository;

@Service
public class FeedbackServiceImpl implements IFeedbackService{
	
	@Autowired
	private FeedbackRepository feedbackRepository;

	@Override
	public Feedback saveFeedback(Feedback feedback) {
		return feedbackRepository.save(feedback);
	}

	@Override
	public List<Feedback> getAllFeedbacks() {
		return feedbackRepository.findAll();
	}

	@Override
	public ResponseEntity<Feedback> updateFeedback(Long feedbackId, Feedback feedbackDetails) throws ResourceNotFoundException {
		 Feedback feedback = feedbackRepository.findById(feedbackId)
			        .orElseThrow(() -> new ResourceNotFoundException("Order not found for this id :: " + feedbackId));

			        feedback.setCustomerId(feedbackDetails.getCustomerId());
			        feedback.setOrderId(feedbackDetails.getOrderId());
			        feedback.setOrderFeedback(feedbackDetails.getOrderFeedback());
			        feedback.setOrderRating(feedbackDetails.getOrderRating());
			      
			        
			        
			        final Feedback updatedFeedback = feedbackRepository.save(feedback);
			        return ResponseEntity.ok(updatedFeedback);
	}

	@Override
	public ResponseEntity<?> deleteFeedback(Long feedbackId) throws ResourceNotFoundException {
		return feedbackRepository.findById(feedbackId).map(feedback -> {
			feedbackRepository.delete(feedback);
		return ResponseEntity.ok().build();
		}).orElseThrow(()->new ResourceNotFoundException("feedback not found"));
	}

	@Override
	public ResponseEntity<Feedback> getFeedbackById(Long feedbackId) throws ResourceNotFoundException {
		 Feedback feedback = feedbackRepository.findById(feedbackId)
		          .orElseThrow(() -> new ResourceNotFoundException("Customer not found for this id :: " + feedbackId));
		        return ResponseEntity.ok().body(feedback);
	}

}
