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

import com.example.FoodDelivery.Dao.UserTableDao;
import com.example.FoodDelivery.Dto.UserTableDto;
import com.example.FoodDelivery.Service.UserTableService;
import com.example.FoodDelivery.model.UserTable;

	
	@ExtendWith(MockitoExtension.class)
	public class UserServiceTest {
	@InjectMocks
		UserTableService service;
		@Mock
		UserTableDao dao;
		UserTableDto dto;
		UserTable usr;

//		@BeforeEach
//		public void setup() {
//			dto = new UserDTO(34224, "jhg", "hgjh", "8765432", "gadfsg@jhgf.er", "jhjdfs");
//			usr = new UserTable(2, "deyy", "12345678", "8745423567", "something@g.com", "jsdhgt");
//		}

		// create user
		@Test
		public void createUser() {
			String actualRes = service.createduser(dto);// Calling actual method from control class
			assertEquals("UserTable Created Successfully", actualRes);
		}

		// get all user
		@Test
		public void getAllUsers() {
			when(dao.findAll()).thenReturn(new ArrayList<>());
			List<UserTable> list = service.getAllUserTable();
			assertNotNull(list);
		}

		// get user by id
		@Test
		public void getUserbyid() {
			int userid = 1;
			Optional<UserTable> expectedUser = Optional.of(usr);
			when(dao.findById(userid)).thenReturn(expectedUser);
			Optional<UserTable> actualUser = service.findUserTableid(userid);
			assertEquals(expectedUser, actualUser);
			verify(dao).findById(userid);
		}

		// delete user
		@Test
		public void testUserDelById() {
			int userid = 1;
			String result = service.Deleteuserid(userid);
			assertEquals("UserTable Deleted Successfully", result);
			verify(dao).deleteById(userid);
		}

		// update user by id
		@Test
		public void updateUserIf() {
			int userid = 0;
			when(dao.findById(userid)).thenReturn(Optional.of(usr));
			String list = service.updateuserid(userid, dto);
			assertNotNull(list);
		}

		@Test
		public void updateUserElse() {
			int userid = 1;
			String exp = "UserTable Updated Successfully";
			when(dao.findById(userid)).thenReturn(Optional.empty());
			String act = service.updateuserid(userid, dto);
			assertEquals(exp, act);
		}

	}

