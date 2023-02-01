package com.cg.onlinefoodorderingapplication.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurants")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurant_id")
	private Long restaurantId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "food_specialization")
	private String foodSpecialization;

	public Restaurant() {
		super();
	}

	public Restaurant(String firstName, String lastName, String email, String username, String password,
			String foodSpecialization) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.foodSpecialization = foodSpecialization;
	}
	
	
	public Restaurant(Long vendorId, String firstName, String lastName, String email, String username, String password,
			String foodSpecialization) {
		super();
		this.restaurantId = vendorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
		this.foodSpecialization = foodSpecialization;
	}

	public String getFoodSpecialization() {
		return foodSpecialization;
	}

	public void setFoodSpecialization(String foodSpecialization) {
		this.foodSpecialization = foodSpecialization;
	}

	public Long getVendorId() {
		return restaurantId;
	}

	public void setVendorId(Long vendorId) {
		this.restaurantId = vendorId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Restaurant [restaurantId=" + restaurantId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", username=" + username + ", password=" + password + ", foodSpecialization="
				+ foodSpecialization + "]";
	}

	
	
	
	

}

