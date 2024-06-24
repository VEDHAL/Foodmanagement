package com.example.FoodDelivery.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.FoodDelivery.Dao.MenuTableDao;
import com.example.FoodDelivery.Dao.OrderTableDao
;
import com.example.FoodDelivery.Dto.MenuTableDto;
import com.example.FoodDelivery.Dto.OrderTableDto;
import com.example.FoodDelivery.model.MenuTable;
import com.example.FoodDelivery.model.OrderTable;

@Component

public class OrderTableService {


		@Autowired
	OrderTableDao dao;

		public String createOrder(OrderTableDto dto) {
			OrderTable order= new OrderTable() ;
			order.setOrderitemid(dto.getOrderitemid());
			order.setUser(dto.getUser());
			order.setOrder(dto.getOrder());
			order.setQuantity(dto.getQuantity());
		    dao.save(order);
				
				return "successfully order item created";
			}
		public List<OrderTable> getAllOrderTable() {
			return dao.findAll();
		}
		
		public Optional<OrderTable> findOrderTableid(int id) {
			return dao.findById(id);
		}

		public String DeleteOrderid(int id) {

			dao.deleteById(id);
			return "Order delected successfully";
		}

		public String updateOrderid(int id, OrderTableDto dto) {
			Optional<OrderTable> optionalorderTable = dao.findById(id);// convert to object empty in database that time we can
																	// handle full point exception that avoiding using
																	// option use to create obj
			if (optionalorderTable.isPresent()) {
				OrderTable obj = optionalorderTable.get();
				obj.setUser(dto.getUser());

				obj.setOrder(dto.getOrder());
				obj.setQuantity(dto.getQuantity());

				// No need to update empid as it's the primary key
				dao.save(obj);
				return "Ordertable updated successfully";
			}
			return "OrderTable not found";
		}

			
		}




