package com.example.FoodDelivery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Restaurant_Table")
public class RestaurantTable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

 private int  restaurant_id;
 private String name;
 private String email;
 private long phone;
 private String address;
 
public RestaurantTable() {
	super();
	// TODO Auto-generated constructor stub
}
public RestaurantTable(int restaurant_id, String name, String email, long phone, String address) {
	super();
	this.restaurant_id = restaurant_id;
	this.name = name;
	this.email = email;
	this.phone = phone;
	this.address = address;
}
public int getRestaurant_id() {
	return restaurant_id;
}
public void setRestaurant_id(int restaurant_id) {
	this.restaurant_id = restaurant_id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getPhone() {
	return phone;
}
public void setPhone(long phone) {
	this.phone = phone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Override
public String toString() {
	return "RestaurantTable [restaurant_id=" + restaurant_id + ", name=" + name + ", email=" + email + ", phone="
			+ phone + ", address=" + address + "]";
}
 






}
