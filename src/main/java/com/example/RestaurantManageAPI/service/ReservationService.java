package com.example.RestaurantManageAPI.service;

import com.example.RestaurantManageAPI.entity.Reservation;
import com.example.RestaurantManageAPI.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {
    @Autowired
    private ReservationRepository reservationRepository;
    public Reservation addReservationDB(Reservation reservation){
        return reservationRepository.save(reservation);
    }
    public List<Reservation> addReservationsDB(List<Reservation> reservation){
        return reservationRepository.saveAll(reservation);
    }
    public List<Reservation> viewReservations(){
        return reservationRepository.findAll();
    }
    public Reservation viewReservation(int id){
        return reservationRepository.findById(id).orElse(null);
    }
    public Reservation updateReservationDB(Reservation reservation, int id) {
        Reservation existingReservation = reservationRepository.findById(id).orElse(null);
        if (existingReservation == null) {
            return null;
        }
        existingReservation.setCid(reservation.getCid());
        existingReservation.setDateTime(reservation.getDateTime());
        existingReservation.setCount(reservation.getCount());
        return reservationRepository.save(existingReservation);
    }
    public String deleteReservation(int id){
        reservationRepository.deleteById(id);
        return "deleted";
    }
}
