package com.example.RestaurantManageAPI.controller;

import com.example.RestaurantManageAPI.entity.Order;
import com.example.RestaurantManageAPI.repository.OrderRepository;
import com.example.RestaurantManageAPI.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/order")

public class OrderController {
    @Autowired
    private OrderService orderService;
    private OrderRepository orderRepository;
    @PostMapping("/addOrder")
    public Order addOrder(@RequestBody Order order){
        return orderService.addOrderDB(order);
    }
    @PostMapping("/addOrders")
    public List<Order> addOrders(@RequestBody List<Order> order){
        return orderService.addOrdersDB(order);
    }
    @GetMapping("/viewOrders")
    public List<Order> viewOrders(){
        return orderService.viewOrders();
    }
    @GetMapping("/viewOrder/{id}")
    public Order viewOrder(@PathVariable int id){
        return orderService.viewOrder(id);
    }
    @PutMapping("/updateOrder/{id}")
    public Order updateOrder(@RequestBody Order order, @PathVariable int id) {
        return orderService.updateOrderDB(order, id);
    }
    @PutMapping("/payOrder/{id}")
    public Order payOrder(@PathVariable int id) {
        return orderService.paidOrderDB(id);
    }
    @DeleteMapping("/deleteOrder/{id}")
    public String deleteOrder(@PathVariable int id ){
        return orderService.deleteOrder(id);
    }
}
