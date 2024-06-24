package com.example.FoodDelivery.ControllerTest;


	import static org.junit.jupiter.api.Assertions.assertEquals;
	import static org.junit.jupiter.api.Assertions.assertThrows;
	import static org.mockito.Mockito.verify;
	import static org.mockito.Mockito.when;

	import java.util.Arrays;
	import java.util.List;
	import java.util.Optional;

import javax.naming.InvalidNameException;

import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;
	import org.junit.jupiter.api.extension.ExtendWith;
	import org.mockito.InjectMocks;
	import org.mockito.Mock;
	import org.mockito.junit.jupiter.MockitoExtension;

	
import com.example.FoodDelivery.Controller.UserTableController;
import com.example.FoodDelivery.Dto.UserTableDto;
import com.example.FoodDelivery.ExceptionHandling.FoodNulledException;
import com.example.FoodDelivery.ExceptionHandling.FoodOwnException;
import com.example.FoodDelivery.Service.UserTableService;
import com.example.FoodDelivery.model.UserTable;
import com.fasterxml.jackson.databind.exc.InvalidNullException;

	@ExtendWith(MockitoExtension.class)
	public class UserControllerTest {
		@InjectMocks
		UserTableController control;
		@Mock
		UserTableService service;
		UserTableDto dto;
		UserTable usr1, usr2;

//		@BeforeEach
//		public void setup() {
//			dto = new UserTableDto(34224, "jhg", "hgjh", "8765432", "gadfsg@jhgf.er", "jhjdfs");
//			usr1 = new UserTable(2, "deyy", "12345678", "8745423567", "something@gmail.com", "ckm");
//			usr2 = new UserTable(0, "Arun", "9876549864", "8745423567", "someone@gmail.com", "bangalore");
//
//		}

//		create user
		@Test
		public void createUser() {
			String res = "UserTable Created Successfully";// expected result
			UserTableDto dto = new UserTableDto();// dto object to pass onto the testing method
			when(service.createduser(dto)).thenReturn(res);// Testing method
			String actualRes = control.createUserTable(dto);// Calling actual method from control class
			assertEquals(res, actualRes);
		}

//		get all user
		@Test
		public void getUser() {
			List<UserTable> expectedUsers = Arrays.asList(usr1, usr2);
			when(service.getAllUserTable()).thenReturn(expectedUsers);
			List<UserTable> actualUsers = control.getUserTable();
			assertEquals(expectedUsers, actualUsers);
			verify(service).getAllUserTable();
		}

//		get by id
		@Test
		public void testGetUserbyid_ValidId() throws FoodOwnException {
			int userid = 1;
			Optional<UserTable> expectedUser = Optional.of(usr1);
			when(service.findUserTableid(userid)).thenReturn(expectedUser);
			Optional<UserTable> actualUser = control.findUserTable(userid);
			assertEquals(expectedUser, actualUser);
			verify(service).findUserTableid(userid);
		}

		@Test
		public void testGetUserbyid_InvalidId() {

			// Given
			int userid = 0;

			// When/Then
			FoodOwnException exception = assertThrows(FoodOwnException.class, () -> {
				control.findUserTable(userid);
			});
			assertEquals("Must not be zero", exception.getMessage());
		}

	//delete user by id
		@Test
		public void userDelById() {
			int userid = 0;
			String res = "UserTable Deleted Successfully";
			when(service.Deleteuserid(userid)).thenReturn(res);
			String actRes = control.DeleteUserTableId(userid);
			assertEquals(res, actRes);
		}

//		Update user by id
		@Test
		public void testUpdatebyid_ValidId() throws FoodNulledException {
			// Given
			int userid = 1;
			UserTableDto userDto = new UserTableDto();
			String expectedResult = "UserTable Updated Successfully";
			when(service.updateuserid(userid, userDto)).thenReturn(expectedResult);
			String actualResult = control.updateUserTableById(userDto, userid);
			assertEquals(expectedResult, actualResult);
			verify(service).updateuserid(userid, userDto);
		}

		@Test
		public void testUpdatebyid_InvalidId() {
			int userid = 0;
			UserTableDto userDto = new UserTableDto();
			assertThrows(FoodNulledException.class, () -> {
				control.updateUserTableById(userDto, userid);
			});
		}

	}

