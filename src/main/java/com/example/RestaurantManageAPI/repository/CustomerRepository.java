package com.example.RestaurantManageAPI.repository;

import com.example.RestaurantManageAPI.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository <Customer,Integer> {
}
