package com.example.FoodDelivery.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.FoodDelivery.Dao.UserTableDao;
import com.example.FoodDelivery.Dto.UserTableDto;
import com.example.FoodDelivery.model.UserTable;

@Component

public class UserTableService {



		@Autowired
	UserTableDao dao;

		public String createduser(UserTableDto e) {

			UserTable user = new UserTable();
			user.setUser_id(e.getUser_id());
			user.setPassword(e.getPassword());
			user.setAddress(e.getAddress());
			user.setPhone(e.getPhone());
			user.setUsername(e.getUsername());
			dao.save(user);
			return "student created successfully";
		}

		// find all data
		public List<UserTable> getAllUserTable() {
			return dao.findAll();
		}

		// find by id
		public Optional<UserTable> findUserTableid(int id) {
			return dao.findById(id);
		}

		// delete by id
		public String Deleteuserid(int id) {

			dao.deleteById(id);
			return "employee delected successfully";
		}

		// update by id
		public String updateuserid(int id, UserTableDto em) {
			Optional<UserTable> optionalUserTable = dao.findById(id);// convert to object empty in database that time we can
																	// handle full point exception that avoiding using
																	// option use to create obj
			if (optionalUserTable.isPresent()) {
				UserTable existingUserTable = optionalUserTable.get();

				existingUserTable.setPassword(em.getPassword());
				existingUserTable.setAddress(em.getAddress());
				existingUserTable.setPhone(em.getPhone());
				existingUserTable.setUsername(em.getUsername());

				// No need to update empid as it's the primary key
				dao.save(existingUserTable);
				return "Usertable updated successfully";
			}
			return "UserTable not found";
		}
	}

