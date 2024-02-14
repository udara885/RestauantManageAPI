package com.example.RestaurantManageAPI.controller;

import com.example.RestaurantManageAPI.entity.Reservation;
import com.example.RestaurantManageAPI.repository.ReservationRepository;
import com.example.RestaurantManageAPI.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/reservation")

public class ReservationController {
    @Autowired
    private ReservationService reservationService;
    private ReservationRepository reservationRepository;
    @PostMapping("/addReservation")
    public Reservation addReservation(@RequestBody Reservation reservation){
        return reservationService.addReservationDB(reservation);
    }
    @PostMapping("/addReservations")
    public List<Reservation> addReservations(@RequestBody List<Reservation> reservation){
        return reservationService.addReservationsDB(reservation);
    }
    @GetMapping("/viewReservations")
    public List<Reservation> viewReservations(){
        return reservationService.viewReservations();
    }
    @GetMapping("/viewReservation/{id}")
    public Reservation viewReservation(@PathVariable int id){
        return reservationService.viewReservation(id);
    }
    @PutMapping("/updateReservation/{id}")
    public Reservation updateReservation(@RequestBody Reservation reservation, @PathVariable int id) {
        return reservationService.updateReservationDB(reservation, id);
    }
    @DeleteMapping("/deleteReservation/{id}")
    public String deleteReservation(@PathVariable int id ){
        return reservationService.deleteReservation(id);
    }
}
