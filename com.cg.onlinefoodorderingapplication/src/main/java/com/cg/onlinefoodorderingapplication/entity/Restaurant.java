package com.cg.onlinefoodorderingapplication.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "restaurant")
public class Restaurant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "restaurant_id")
	private Long restaurantId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "address")
	private String address;
	
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

	public Restaurant(String name, String address, String email, String username, String password,
			String foodSpecialization) {
		super();
		this.name = name;
		this.address = address;
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

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
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
		this.address = address;
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
		return "restuarant [restuarantId=" + restaurantId + ", name=" + name + ", address=" + address + ", email="
				+ email + ", username=" + username + ", password=" + password + ", foodSpecialization="
				+ foodSpecialization + "]";
	}

	
	
	
	

}
