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

import com.example.FoodDelivery.Dto.UserTableDto;
import com.example.FoodDelivery.ExceptionHandling.FoodNulledException;
import com.example.FoodDelivery.ExceptionHandling.FoodOwnException;
import com.example.FoodDelivery.Service.UserTableService;
import com.example.FoodDelivery.model.UserTable;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/user")
@Validated
public class UserTableController {

	@Autowired
	UserTableService userservice;
	@PostMapping("/createUserTable")
	
	public String createUserTable( @Valid @RequestBody UserTableDto dt)
	
	
	{
		return userservice.createduser(dt);
	}
	
	@GetMapping("/getUserTable")
	public List<UserTable> getUserTable(){
		return userservice.getAllUserTable();
	}
	
	@GetMapping("/findUserTable/{user_id}")
	public Optional<UserTable> findUserTable(@PathVariable int user_id)throws FoodOwnException{
		if (user_id==0){
			throw new FoodOwnException("invalid UserService ids");
		}
		
		return userservice.findUserTableid (user_id);
	}
	@GetMapping("/DelecteUserid")
	
	public String DeleteUserTableId(@RequestParam int user_id) {
		return userservice.Deleteuserid(user_id);
	}
	
	
	 @PutMapping("/updateUserid/{id}")
	    
	    public String updateUserTableById(@RequestBody UserTableDto e, @RequestParam int user_id)throws FoodNulledException {
		 if(user_id==0) {
	    		throw new FoodNulledException("update greater then zero");
	    	}
//	        
	        return userservice.updateuserid(user_id, e);
	}
	
}

