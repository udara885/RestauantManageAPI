package com.example.RestaurantManageAPI.controller;

import com.example.RestaurantManageAPI.entity.Payment;
import com.example.RestaurantManageAPI.repository.PaymentRepository;
import com.example.RestaurantManageAPI.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/payment")

public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    private PaymentRepository paymentRepository;
    @GetMapping("/viewPayments")
    public List<Payment> viewPayments(){
        return paymentService.viewPayments();
    }
    @GetMapping("/viewPayment/{id}")
    public Payment viewPayment(@PathVariable int id){
        return paymentService.viewPayment(id);
    }
}
