package com.example.RestaurantManageAPI.service;

import com.example.RestaurantManageAPI.entity.Customer;
import com.example.RestaurantManageAPI.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    public  Customer addCustomerDB(Customer customer){
        return customerRepository.save(customer);
    }
    public List<Customer> addCustomersDB(List<Customer> customer){
        return customerRepository.saveAll(customer);
    }
    public List<Customer> viewCustomers(){
        return customerRepository.findAll();
    }
    public Customer viewCustomer(int id){
        return customerRepository.findById(id).orElse(null);
    }
    public Customer updateCustomerDB(Customer customer, int id) {
        Customer existingCustomer = customerRepository.findById(id).orElse(null);
        if (existingCustomer == null) {
            return null;
        }
        existingCustomer.setCname(customer.getCname());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setMobile(customer.getMobile());
        return customerRepository.save(existingCustomer);
    }
    public String deleteCustomer(int id){
        customerRepository.deleteById(id);
        return "deleted";
    }
}
