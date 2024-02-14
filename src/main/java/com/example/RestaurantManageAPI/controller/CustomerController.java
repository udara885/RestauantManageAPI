package com.example.RestaurantManageAPI.controller;

import com.example.RestaurantManageAPI.entity.Customer;
import com.example.RestaurantManageAPI.repository.CustomerRepository;
import com.example.RestaurantManageAPI.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/customer")

public class CustomerController {
    @Autowired
    private CustomerService customerService;
    private CustomerRepository customerRepository;
    @PostMapping("/addCustomer")
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomerDB(customer);
    }
    @PostMapping("/addCustomers")
    public List<Customer> addCustomers(@RequestBody List<Customer> customer){
        return customerService.addCustomersDB(customer);
    }
    @GetMapping("/viewCustomers")
    public List<Customer> viewCustomers(){
        return customerService.viewCustomers();
    }
    @GetMapping("/viewCustomer/{id}")
    public Customer viewCustomer(@PathVariable int id){
        return customerService.viewCustomer(id);
    }
    @PutMapping("/updateCustomer/{id}")
    public Customer updateCustomer(@RequestBody Customer customer, @PathVariable int id) {
        return customerService.updateCustomerDB(customer, id);
    }
    @DeleteMapping("/deleteCustomer/{id}")
    public String deleteCustomer(@PathVariable int id ){
        return customerService.deleteCustomer(id);
    }
}
