package com.example.FoodDelivery.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodDelivery.model.RestaurantTable;

public interface RestaurantTableDao extends JpaRepository<RestaurantTable, Integer> {

}
