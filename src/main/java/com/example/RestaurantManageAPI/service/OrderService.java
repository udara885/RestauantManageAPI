package com.example.RestaurantManageAPI.service;

import com.example.RestaurantManageAPI.entity.Customer;
import com.example.RestaurantManageAPI.entity.Food;
import com.example.RestaurantManageAPI.entity.Order;
import com.example.RestaurantManageAPI.entity.Payment;
import com.example.RestaurantManageAPI.repository.CustomerRepository;
import com.example.RestaurantManageAPI.repository.FoodRepository;
import com.example.RestaurantManageAPI.repository.OrderRepository;
import com.example.RestaurantManageAPI.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private CustomerRepository customerRepository;
    public Order addOrderDB(Order order){
        Food food = foodRepository.findById(order.getFid()).orElse(null);
        if (food == null) {
            throw new IllegalArgumentException("Food item not found.");
        }
        order.setAmount(food.getPrice() * order.getQty());
        order.setDateTime(LocalDateTime.now());
        order.setStatus("not paid");
        return orderRepository.save(order);
    }
    public List<Order> addOrdersDB(List<Order> orders) {
        for (Order order : orders) {
            order.setDateTime(LocalDateTime.now());
        }
        return orderRepository.saveAll(orders);
    }
    public List<Order> viewOrders(){
        return orderRepository.findAll();
    }
    public Order viewOrder(int id){
        return orderRepository.findById(id).orElse(null);
    }
    public Order updateOrderDB(Order order, int id) {
        Order existingOrder = orderRepository.findById(id).orElse(null);
        if (existingOrder == null) {
            return null;
        }
        Food food = foodRepository.findById(existingOrder.getFid()).orElse(null);
        if (food == null) {
            throw new IllegalArgumentException("Food item not found.");
        }
        existingOrder.setCid(order.getCid());
        existingOrder.setFid(order.getFid());
        existingOrder.setQty(order.getQty());
        float newAmount = food.getPrice() * order.getQty();
        existingOrder.setAmount(newAmount);
        return orderRepository.save(existingOrder);
    }
    public String deleteOrder(int id){
        orderRepository.deleteById(id);
        return "deleted";
    }
    public Order paidOrderDB(int id) {
        Order order = orderRepository.findById(id).orElse(null);
        if (order != null) {
            Payment payment = new Payment();
            payment.setCid(order.getCid());
            payment.setAmount(order.getAmount());
            payment.setDateTime(LocalDateTime.now());
            paymentRepository.save(payment);
            Customer customer = customerRepository.findById(order.getCid()).orElse(null);
            if (customer != null) {
                customer.setSpent(customer.getSpent() + order.getAmount());
                customerRepository.save(customer);
            }
            order.setStatus("paid");
            orderRepository.save(order);
        }
        return order;
    }
}
