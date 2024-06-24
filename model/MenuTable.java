package com.example.FoodDelivery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="menu_table")

public class MenuTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

private int menu_id;
@ManyToOne
@JoinColumn(name="restaurant_id")
private RestaurantTable restaurant;
private String item_name;
private String description;
private int price;


public MenuTable() {
	super();
}


public MenuTable(int menu_id, RestaurantTable restaurant, String item_name, String description, int price) {
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
	return "MenuTable [menu_id=" + menu_id + ", restaurant=" + restaurant + ", item_name=" + item_name
			+ ", description=" + description + ", price=" + price + "]";
}







}

