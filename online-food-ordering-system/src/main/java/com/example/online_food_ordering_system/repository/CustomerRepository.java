package com.example.online_food_ordering_system.repository;

import com.example.online_food_ordering_system.model.Customer;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    
    Optional<Customer> findByEmail(String email);
}


