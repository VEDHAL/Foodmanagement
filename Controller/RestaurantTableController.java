package com.example.FoodDelivery.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.FoodDelivery.Dto.RestaurantTableDto;
import com.example.FoodDelivery.Dto.UserTableDto;
import com.example.FoodDelivery.ExceptionHandling.FoodNulledException;
import com.example.FoodDelivery.ExceptionHandling.FoodOwnException;
import com.example.FoodDelivery.Service.RestaurantTableService;
import com.example.FoodDelivery.model.RestaurantTable;

@RestController
@RequestMapping("/Restaurant")
public class RestaurantTableController {
	
@Autowired
RestaurantTableService RestaurantService;
@PostMapping("/createRestaurantTable")
public String createRestauranatTable(@RequestBody RestaurantTableDto rt)
{
	return RestaurantService.createRestaurant(rt);

}
@GetMapping("/getRestaurantTable")
public List<RestaurantTable>GetRestaurantTable(){
	return RestaurantService.getAllRestaurant();
}
@GetMapping("/findRestaurantid/{restaurant_id}")
public Optional<RestaurantTable>findRestaurantTableid(@PathVariable int restaurant_id) throws FoodOwnException{
	if (restaurant_id==0){
		throw new FoodOwnException("invalid restaarant table ids");
	}
	
	return RestaurantService.findRestaurantid(restaurant_id);
}
@GetMapping("/deleteRestaurantid")
public String deleteRestaurantTable(@RequestParam int restaurant_id) {
	return RestaurantService.DeleteRestaurant(restaurant_id);
}
@PutMapping("/updateRestaurantTableid/{id}")


public String updateRestaurantTableById(@RequestBody RestaurantTableDto e, @RequestParam int restaurant_id) throws FoodNulledException {
	 if(restaurant_id==0) {
 		throw new FoodNulledException("update reataurant table greater then zero");
 	}
// 
	
	
	return RestaurantService.UpdateRestaurantTable(restaurant_id, e);
}


}



