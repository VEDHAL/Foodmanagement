package com.example.FoodDelivery.Dto;

import com.example.FoodDelivery.model.RestaurantTable;

public class MenuTableDto {

	private int menu_id;
	
	private RestaurantTable restaurant;
	
	private String item_name;
	private String description;
	private int price;
	public MenuTableDto() {
		super();
	}
	public MenuTableDto(int menu_id, RestaurantTable restaurant, String item_name, String description, int price) {
		super();
		this.menu_id = menu_id;
		this.restaurant = restaurant;
		this.item_name = item_name;
		this.description = description;
		this.price = price;
	}
	public int getMenu_id() {
		return menu_id;
	}
	public void setMenu_id(int menu_id) {
		this.menu_id = menu_id;
	}
	public RestaurantTable getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(RestaurantTable restaurant) {
		this.restaurant = restaurant;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "MenuTableDto [menu_id=" + menu_id + ", restaurant=" + restaurant + ", item_name=" + item_name
				+ ", description=" + description + ", price=" + price + "]";
	}

}