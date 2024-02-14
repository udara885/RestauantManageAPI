package com.example.RestaurantManageAPI.repository;

import com.example.RestaurantManageAPI.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository <Order,Integer> {
}
