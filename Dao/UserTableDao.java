package com.example.FoodDelivery.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodDelivery.model.UserTable;

public interface UserTableDao  extends JpaRepository<UserTable, Integer> {

}
