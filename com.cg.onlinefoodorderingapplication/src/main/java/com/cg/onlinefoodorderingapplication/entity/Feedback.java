package com.cg.onlinefoodorderingapplication.entity;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "feedbacks")
public class Feedback{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="feedback_id")
	private Long feedbackId;
	
	@Column(name = "custId")
	private Long customerId;
	
	@Column(name = "order_Id")
	private Long orderId;
	
	@Column(name = "order_rating")
	private Long orderRating;
	
	@Column(name = "order_feedback")
	private String orderFeedback;

	public Feedback() {
		super();
	}

	public Feedback(Long customerId, Long orderId, Long orderRating, String orderFeedback) {
		super();
		this.customerId = customerId;
		this.orderId = orderId;
		this.orderRating = orderRating;
		this.orderFeedback = orderFeedback;
	}


	public Long getFeedbackId() {
		return feedbackId;
	}

	public void setFeedbackId(Long feedbackId) {
		this.feedbackId = feedbackId;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getOrderRating() {
		return orderRating;
	}

	public void setOrderRating(Long orderRating) {
		this.orderRating = orderRating;
	}

	public String getOrderFeedback() {
		return orderFeedback;
	}

	public void setOrderFeedback(String orderFeedback) {
		this.orderFeedback = orderFeedback;
	}

	@Override
	public String toString() {
		return "Feedback [feedbackId=" + feedbackId + ", customerId=" + customerId + ", orderId=" + orderId
				+ ", orderDetails=" + orderRating + ", orderFeedback=" + orderFeedback + "]";
	}

	
}