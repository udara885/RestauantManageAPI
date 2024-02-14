package com.example.RestaurantManageAPI.repository;

import com.example.RestaurantManageAPI.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository <Payment,Integer> {
}
