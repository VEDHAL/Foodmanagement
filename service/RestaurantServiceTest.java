package com.example.FoodDelivery.service;



	import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.junit.jupiter.api.Assertions.assertNotNull;
	import static org.mockito.Mockito.verify;
	import static org.mockito.Mockito.when;

	import java.util.ArrayList;
	import java.util.List;
	import java.util.Optional;

	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.api.extension.ExtendWith;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.junit.jupiter.MockitoExtension;

import com.example.FoodDelivery.Dao.RestaurantTableDao;
import com.example.FoodDelivery.Dto.RestaurantTableDto;
import com.example.FoodDelivery.Service.RestaurantTableService;
import com.example.FoodDelivery.model.RestaurantTable;

	
	@ExtendWith(MockitoExtension.class)
	public class RestaurantServiceTest {
	@InjectMocks
		RestaurantTableService service;
		@Mock
		RestaurantTableDao dao;
		RestaurantTableDto dto;
		RestaurantTable usr;

//		@BeforeEach
//		public void setup() {
//			dto = new UserDTO(34224, "jhg", "hgjh", "8765432", "gadfsg@jhgf.er", "jhjdfs");
//			usr = new UserTable(2, "deyy", "12345678", "8745423567", "something@g.com", "jsdhgt");
//		}

		// create user
		@Test
		public void createRestaurant() {
			String actualRes = service.createRestaurant(dto);// Calling actual method from control class
			assertEquals("UserTable Created Successfully", actualRes);
		}

		// get all user
		@Test
		public void getAllRestaurant() {
			when(dao.findAll()).thenReturn(new ArrayList<>());
			List<RestaurantTable> list = service.getAllRestaurant();
			assertNotNull(list);
		}

		// get user by id
		@Test
		public void getRestaurantbyid() {
			int restaurantid = 1;
			Optional<RestaurantTable> expectedUser = Optional.of(usr);
			when(dao.findById(restaurantid)).thenReturn(expectedUser);
			Optional<RestaurantTable> actualUser = service.findRestaurantid(restaurantid);
			assertEquals(expectedUser, actualUser);
			verify(dao).findById(restaurantid);
		}

		// delete user
		@Test
		public void testUserDelById() {
			int restaurantid = 1;
			String result = service.DeleteRestaurant(restaurantid);
			assertEquals("UserTable Deleted Successfully", result);
			verify(dao).deleteById(restaurantid);
		}

		// update user by id
		@Test
		public void updateUserIf() {
			int restaurantid = 0;
			when(dao.findById(restaurantid)).thenReturn(Optional.of(usr));
			String list = service.UpdateRestaurantTable(restaurantid, dto);
			assertNotNull(list);
		}

		@Test
		public void updateUserElse() {
			int restaurantid = 1;
			String exp = "restaurantTable Updated Successfully";
			when(dao.findById(restaurantid)).thenReturn(Optional.empty());
			String act = service.UpdateRestaurantTable(restaurantid, dto);
			assertEquals(exp, act);
		}

	}



