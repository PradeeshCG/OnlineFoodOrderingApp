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

import com.cg.onlinefoodorderingapplication.entity.Feedback;
import com.cg.onlinefoodorderingapplication.exception.ResourceNotFoundException;
import com.cg.onlinefoodorderingapplication.service.IFeedbackService;



@RestController 
@RequestMapping("/api/f1")
public class FeedbackController {
	
	@Autowired
	private IFeedbackService feedbackService;
	
	//save an order
	@PostMapping("/feedbacks")
	public Feedback feedbackOrder(@Valid @RequestBody Feedback feedback)
	{
		return feedbackService.saveFeedback(feedback);
	}
	
	//get all orders
	@GetMapping("/feedbacks")
	public List<Feedback> getAllFeedbacks()
	{
		return feedbackService.getAllFeedbacks();
	}
	
	//update orders
	@PutMapping("/feedbacks/{id}")
	public ResponseEntity<Feedback> updateFeedback(@PathVariable(value = "id") Long feedbackId,
	         @Valid @RequestBody Feedback feedbackDetails) throws ResourceNotFoundException {
		return feedbackService.updateFeedback(feedbackId, feedbackDetails);
	    }	
	
	
	//delete order
	@DeleteMapping("/feedbacks/{feedbackId}")
	public ResponseEntity<?> deleteFeedback( 
			@PathVariable(value = "feedbackId") Long feedbackId)
	throws ResourceNotFoundException
	{
		return feedbackService.deleteFeedback(feedbackId);
	}
	
	//get order by orderId
	@GetMapping("/feedbacks/{id}")
    public ResponseEntity<Feedback> getFeedbackById(@PathVariable(value = "id") Long feedbackId)
        throws ResourceNotFoundException {
		return feedbackService.getFeedbackById(feedbackId);
    }

}

