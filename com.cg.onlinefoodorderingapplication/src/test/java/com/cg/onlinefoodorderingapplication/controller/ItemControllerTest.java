package com.cg.onlinefoodorderingapplication.controller;


import static org.hamcrest.CoreMatchers.any;
import static org.mockito.Mockito.when;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.cg.onlinefoodorderingapplication.entity.Item;

import com.cg.onlinefoodorderingapplication.service.IItemService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest
public class ItemControllerTest {
	private static final Object Item = null;

	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private IItemService itemService;
	
	@Autowired
	private ObjectMapper objectmapper;
	
	private Item item;
	
	@BeforeEach
	public void init () {
		item = new Item("Item", 0, null);
		
	}
	@Test
	public void testAddOnlineFoodOrdering () throws Exception{
		when(itemService.createItem((Item) any(Item.class))).thenReturn(item);
	}

}