package com.cg.onlinefoodorderingapplication.service;

import java.util.List;



import org.springframework.http.ResponseEntity;

import com.cg.onlinefoodorderingapplication.entity.Feedback;
import com.cg.onlinefoodorderingapplication.exception.ResourceNotFoundException;

public interface IFeedbackService {
	
	public Feedback saveFeedback(Feedback feedback);
	public List<Feedback> getAllFeedbacks();
	public ResponseEntity<Feedback> updateFeedback(Long feedbackId,Feedback feedbackDetails) throws ResourceNotFoundException;
	public ResponseEntity<?> deleteFeedback(Long feedbackId) throws ResourceNotFoundException;
	public ResponseEntity<Feedback> getFeedbackById(Long feedbackId)throws ResourceNotFoundException;


}

