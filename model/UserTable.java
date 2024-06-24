package com.example.FoodDelivery.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name="user_table")
public class UserTable {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

	private  int user_id;
	private String username;
	private String password;
	private long phone;
	private String address;
	public UserTable() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserTable(int user_id, String username, String password, long phone, String address) {
		super();
		this.user_id = user_id;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.address = address;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
		return "UserTable [user_id=" + user_id + ", username=" + username + ", password=" + password + ", phone="
				+ phone + ", address=" + address + "]";
	}
	
	

}
