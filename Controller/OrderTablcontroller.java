package com.example.FoodDelivery.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.FoodDelivery.Dto.OrderTableDto;
import com.example.FoodDelivery.ExceptionHandling.FoodNulledException;
import com.example.FoodDelivery.ExceptionHandling.FoodOwnException;
import com.example.FoodDelivery.Service.OrderTableService;
import com.example.FoodDelivery.model.OrderTable;

import jakarta.validation.Valid;

@RestController
	@RequestMapping("/menu")
	@Validated

	public class OrderTablcontroller {



		@Autowired
		OrderTableService service;
		@PostMapping("/createOrderTable")
		
		public String createUserTable( @Valid @RequestBody OrderTableDto dt)
		
		
		{
			return service.createOrder(dt);
		}
		
		@GetMapping("/getOrderTable")
		public List<OrderTable> getOrderTable(){
			return service.getAllOrderTable();
		}
		
		@GetMapping("/findOrderTable/{Orderitemid}")
		public Optional<OrderTable> findOrderTable(@PathVariable int Orderitemid)throws FoodOwnException{
			if (Orderitemid==0){
				throw new FoodOwnException("invalid UserService ids");
			}
			
			return service.findOrderTableid(Orderitemid);
		}
		@GetMapping("/DelecteOrderid")
		
		public String DeleteOrderTableId(@RequestParam  int Orderitemid) {
			return service.DeleteOrderid(Orderitemid);
		}
		
		
		 @PutMapping("/updateOrderid/{id}")
		    
		    public String updateOrderTableById(@RequestBody OrderTableDto e, @RequestParam int Orderitemid)throws FoodNulledException {
			 if(Orderitemid==0) {
		    		throw new FoodNulledException("update greater then zero");
		    	}
	        
		        return service.updateOrderid(Orderitemid, e);
		}}
		


