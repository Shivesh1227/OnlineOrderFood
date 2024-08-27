package com.example.online_food_ordering_system.service;

import com.example.online_food_ordering_system.model.Customer;

public interface CustomerService {
    Customer login(String email);
    Customer getCustomerDetails(Long id);
    Customer updateCustomer(Customer customer);
    void deleteCustomer(Long id);
}

