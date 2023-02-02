package com.cg.onlinefoodorderingapplication.controller;




import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import org.springframework.test.web.servlet.result.*;
import com.cg.onlinefoodorderingapplication.entity.Customer;
import com.cg.onlinefoodorderingapplication.exception.ResourceNotFoundException;
import com.cg.onlinefoodorderingapplication.service.ICustomerService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class CustomerControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ICustomerService customerService;
	
	@Autowired
	private ObjectMapper objectMapper;
	private ResponseEntity<Customer> customer2;
	private Customer customer;
	private Customer customer1;
	
	@BeforeEach
	public void init() {
		customer = new Customer("pradeesh","chennai","pradeesh@gmail.com","pradeesh","vijay");
		customer1 = new Customer("pradeeshvijay","Pune","pradeeshvijay@gmail.com","pradeeshvijay","pv");
	}
	
	@Test
	public void testAddCustomer() throws Exception{
		when(customerService.createCustomer((Customer) any(Customer.class))).thenReturn(customer);
	}
	@Test
	public void testlistAllCustomers() {
		List<Customer> customerList = new ArrayList<Customer>();
		customerList.add(customer);
		customerList.add(customer1);
		when(customerService.getCustomerList()).thenReturn(customerList);
	}
	
	@Test
	public void testgetCustomerById() throws ResourceNotFoundException {	
		when(customerService.getCustomerById(anyLong())).thenReturn(customer2);
	}

}

