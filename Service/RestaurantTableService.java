package com.example.FoodDelivery.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.FoodDelivery.Dao.RestaurantTableDao;
import com.example.FoodDelivery.Dto.RestaurantTableDto;
import com.example.FoodDelivery.model.RestaurantTable;

@Component

public class RestaurantTableService {
	




			@Autowired
		RestaurantTableDao dao;

			public String createRestaurant(RestaurantTableDto e) {

			RestaurantTable restaurant = new RestaurantTable();
				
			restaurant.setRestaurant_id(e.getRestaurant_id());
			restaurant.setEmail(e.getEmail());
				restaurant.setAddress(e.getAddress());
				restaurant.setName(e.getName());
				restaurant.setPhone(e.getPhone());
				dao.save(restaurant);
				return "restaurant created successfully";
			}

			// find all data
			public List<RestaurantTable> getAllRestaurant() {
				return dao.findAll();
			}

			// find by id
			public Optional<RestaurantTable> findRestaurantid(int id) {
				return dao.findById(id);
			}

			// delete by id
			public String DeleteRestaurant(int id) {

				dao.deleteById(id);
				return "restaurant delected successfully";
			}

			// update by id
			public String UpdateRestaurantTable(int id, RestaurantTableDto em) {
				Optional<RestaurantTable> optionalRestaurantTable = dao.findById(id);// convert to object empty in database that time we can
																		// handle full point exception that avoiding using
																		// option use to create obj
				if (optionalRestaurantTable.isPresent()) {
					RestaurantTable existingRestaurantTable = optionalRestaurantTable.get();

					existingRestaurantTable.setAddress(em.getAddress());
					existingRestaurantTable.setEmail(em.getEmail());
					existingRestaurantTable.setName(em.getName());
					existingRestaurantTable.setPhone(em.getPhone());

					dao.save(existingRestaurantTable);
					return "restauranttable updated successfully";
				}
				return "Restaurant Table not found";
			}
		}


