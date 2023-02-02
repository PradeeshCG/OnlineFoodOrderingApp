package com.cg.onlinefoodorderingapplication.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="customers")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "custId", nullable = false)
	private Long customerId;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name = "address", nullable = false)
	private String address;
	
	@Column(name = "email", nullable = false)
	@Pattern(regexp="(^$|[0-9]{10})")
	private String email;
	
	@Column(name = "username", nullable = false)
	private String username;
	
	@Column(name = "password", nullable = false)
	private String password;
	
	@Column(name = "wallet_balance", nullable = false)
	private double balance;
	
	@Column(name = "number_of_orders")
	private long numberOfOrders;

	public Customer() {
		super();
	}
	
	

	public Customer(String name, String address, String email, String username, String password) {
		super();
		this.name = name;
		this.address = address;
		this.email = email;
		this.username = username;
		this.password = password;
		this.balance = 0;
		this.numberOfOrders = 0;
	}



	public Customer(String name, String address, String email, String username, String password, double balance, long numberOfOrders) {
		super();
		this.name= name;
		this.address = address;
		this.email = email;
		this.username = username;
		this.password = password;
		this.balance = balance;
		this.numberOfOrders = numberOfOrders;
	}


	

	public long getNumberOfOrders() {
		return numberOfOrders;
	}

	public void setNumberOfOrders(long numberOfOrders) {
		this.numberOfOrders = numberOfOrders;
	}

	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address= address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Customer [customerId=" + customerId + ", Name=" + name + ", Address=" + address + ", email="
				+ email + ", username=" + username + ", password=" + password + ", balance=" + balance
				+ ", numberOfOrders=" + numberOfOrders + "]";
	}

	

	
	
	
}
