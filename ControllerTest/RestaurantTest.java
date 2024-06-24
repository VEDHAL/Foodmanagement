package com.example.FoodDelivery.ControllerTest;




	import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.junit.jupiter.api.Assertions.assertThrows;
	import static org.mockito.Mockito.verify;
	import static org.mockito.Mockito.when;

	import java.util.Arrays;
	import java.util.List;
	import java.util.Optional;

import javax.imageio.spi.RegisterableService;
import javax.naming.InvalidNameException;

import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.api.extension.ExtendWith;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.junit.jupiter.MockitoExtension;

import com.example.FoodDelivery.Controller.RestaurantTableController;
import com.example.FoodDelivery.Dto.RestaurantTableDto;
import com.example.FoodDelivery.ExceptionHandling.FoodNulledException;
import com.example.FoodDelivery.ExceptionHandling.FoodOwnException;
import com.example.FoodDelivery.Service.RestaurantTableService;
import com.example.FoodDelivery.model.RestaurantTable;
	

@ExtendWith(MockitoExtension.class)
	public class RestaurantTest {
		@InjectMocks
		RestaurantTableController control;
		@Mock
		RestaurantTableService service;
		RestaurantTableDto dto;
		RestaurantTable usr1, usr2;

//		@BeforeEach
//		public void setup() {
//			dto = new UserTableDto(34224, "jhg", "hgjh", "8765432", "gadfsg@jhgf.er", "jhjdfs");
//			usr1 = new UserTable(2, "deyy", "12345678", "8745423567", "something@gmail.com", "ckm");
//			usr2 = new UserTable(0, "Arun", "9876549864", "8745423567", "someone@gmail.com", "bangalore");
//
//		}

//		create user
		@Test
		public void createRestaurant() {
			String res = "UserTable Created Successfully";// expected result
			RestaurantTableDto dto = new RestaurantTableDto();// dto object to pass onto the testing method
			when(service.createRestaurant(dto)).thenReturn(res);// Testing method
			String actualRes = control.createRestauranatTable(dto);// Calling actual method from control class
			assertEquals(res, actualRes);
		}

//		get all user
		@Test
		public void getUser() {
			List<RestaurantTable> expectedUsers = Arrays.asList(usr1, usr2);
			when(service.getAllRestaurant()).thenReturn(expectedUsers);
			List<RestaurantTable> actualUsers = control.GetRestaurantTable();
			assertEquals(expectedUsers, actualUsers);
			verify(service).getAllRestaurant();
		}

//		get by id
		@Test
		public void testGetUserbyid_ValidId() throws FoodOwnException {
			int restaurantid = 1;
			Optional<RestaurantTable> expectedUser = Optional.of(usr1);
			when(service.findRestaurantid(restaurantid)).thenReturn(expectedUser);
			Optional<RestaurantTable> actualUser = control.findRestaurantTableid(restaurantid);
			assertEquals(expectedUser, actualUser);
			verify(service).findRestaurantid(restaurantid);
		}

		@Test
		public void testGetUserbyid_InvalidId() {

			// Given
			int restaurantid = 0;

			// When/Then
			FoodOwnException exception = assertThrows(FoodOwnException.class, () -> {
				control.findRestaurantTableid(restaurantid);
			});
			assertEquals("Must not be zero", exception.getMessage());
		}

	//delete user by id
		@Test
		public void userDelById() {
			int restaurantid = 0;
			String res = "restaurantTable Deleted Successfully";
			when(service.DeleteRestaurant(restaurantid)).thenReturn(res);
			String actRes = control.deleteRestaurantTable(restaurantid);
			assertEquals(res, actRes);
		}

//		Update user by id
		@Test
		public void testUpdatebyid_ValidId() throws FoodNulledException {
			// Given
			int userid = 1;
			RestaurantTableDto userDto = new RestaurantTableDto();
			String expectedResult = "restaurantTable Updated Successfully";
			when(service.UpdateRestaurantTable(userid, userDto)).thenReturn(expectedResult);
			String actualResult = control.updateRestaurantTableById(userDto, userid);
			assertEquals(expectedResult, actualResult);
			verify(service).UpdateRestaurantTable(userid, userDto);
		}

		@Test
		public void testUpdatebyid_InvalidId() {
			int userid = 0;
			RestaurantTableDto userDto = new RestaurantTableDto();
			assertThrows(FoodNulledException.class, () -> {
				control.updateRestaurantTableById(userDto, userid);
			});
		}

	}



