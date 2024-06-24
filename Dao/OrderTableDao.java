package com.example.FoodDelivery.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.FoodDelivery.model.OrderTable;

public interface OrderTableDao extends JpaRepository<OrderTable, Integer>{

}
