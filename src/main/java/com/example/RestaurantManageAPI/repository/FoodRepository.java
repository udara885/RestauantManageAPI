package com.example.RestaurantManageAPI.repository;

import com.example.RestaurantManageAPI.entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FoodRepository extends JpaRepository <Food,Integer> {
}
