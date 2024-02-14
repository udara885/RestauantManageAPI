package com.example.RestaurantManageAPI.service;

import com.example.RestaurantManageAPI.entity.Payment;
import com.example.RestaurantManageAPI.repository.OrderRepository;
import com.example.RestaurantManageAPI.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private OrderRepository orderRepository;
    public List<Payment> viewPayments(){
        return paymentRepository.findAll();
    }
    public Payment viewPayment(int id){
        return paymentRepository.findById(id).orElse(null);
    }
}
