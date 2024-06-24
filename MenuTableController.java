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

import com.example.FoodDelivery.Dto.MenuTableDto;
import com.example.FoodDelivery.Dto.UserTableDto;
import com.example.FoodDelivery.ExceptionHandling.FoodNulledException;
import com.example.FoodDelivery.ExceptionHandling.FoodOwnException;
import com.example.FoodDelivery.Service.MenuTableService;
import com.example.FoodDelivery.Service.UserTableService;
import com.example.FoodDelivery.model.MenuTable;
import com.example.FoodDelivery.model.UserTable;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/menu")
@Validated

public class MenuTableController {



	@Autowired
	MenuTableService service;
	@PostMapping("/createMenuTable")
	
	public String createUserTable( @Valid @RequestBody MenuTableDto dt)
	
	
	{
		return service.createMenu(dt);
	}
	
	@GetMapping("/getMenuTable")
	public List<MenuTable> getMenuTable(){
		return service.getAllMenuTable();
	}
	
	@GetMapping("/findMenuTable/{menu_id}")
	public Optional<MenuTable> findMenuTable(@PathVariable int menu_id)throws FoodOwnException{
		if (menu_id==0){
			throw new FoodOwnException("invalid UserService ids");
		}
		
		return service.findMenuTableid(menu_id);
	}
	@GetMapping("/DelecteMenuid")
	
	public String DeleteMenuTableId(@RequestParam int menu_id) {
		return service.DeleteMenuid(menu_id);
	}
	
	
	 @PutMapping("/updateMenuid/{id}")
	    
	    public String updateMenuTableById(@RequestBody MenuTableDto e, @RequestParam int menu_id)throws FoodNulledException {
		 if(menu_id==0) {
	    		throw new FoodNulledException("update greater then zero");
	    	}
//	        
	        return service.updatemenuid(menu_id, e);
	}}
	
