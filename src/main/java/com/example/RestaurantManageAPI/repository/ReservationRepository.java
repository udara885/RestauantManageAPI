package com.example.RestaurantManageAPI.repository;

import com.example.RestaurantManageAPI.entity.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository <Reservation,Integer> {
}
