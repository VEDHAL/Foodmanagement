package com.example.FoodDelivery.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.FoodDelivery.Dao.MenuTableDao;
import com.example.FoodDelivery.Dao.UserTableDao;
import com.example.FoodDelivery.Dto.MenuTableDto;
import com.example.FoodDelivery.Dto.UserTableDto;
import com.example.FoodDelivery.model.MenuTable;
import com.example.FoodDelivery.model.UserTable;

@Component


public class MenuTableService {
	@Autowired
MenuTableDao dao;

	public String createMenu(MenuTableDto dto) {
		MenuTable obj= new MenuTable() ;
		obj.setMenu_id(dto.getMenu_id());
		obj.setRestaurant(dto.getRestaurant());
		obj.setItem_name(dto.getItem_name());
		obj.setDescription(dto.getDescription());
		obj.setPrice(dto.getPrice());
	    dao.save(obj);
			
			return "successfully created";
		}
	public List<MenuTable> getAllMenuTable() {
		return dao.findAll();
	}
	
	public Optional<MenuTable> findMenuTableid(int id) {
		return dao.findById(id);
	}

	public String DeleteMenuid(int id) {

		dao.deleteById(id);
		return "Menu delected successfully";
	}

	public String updatemenuid(int id, MenuTableDto dto) {
		Optional<MenuTable> optionalMenuTable = dao.findById(id);// convert to object empty in database that time we can
																// handle full point exception that avoiding using
																// option use to create obj
		if (optionalMenuTable.isPresent()) {
			MenuTable obj = optionalMenuTable.get();
         
			obj.setRestaurant(dto.getRestaurant());
			obj.setItem_name(dto.getItem_name());
			obj.setDescription(dto.getDescription());
			obj.setPrice(dto.getPrice());

			// No need to update empid as it's the primary key
			dao.save(obj);
			return "Usertable updated successfully";
		}
		return "UserTable not found";
	}

		
	}

