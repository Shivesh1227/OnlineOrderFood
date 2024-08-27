package com.example.online_food_ordering_system.repository;



import com.example.online_food_ordering_system.model.FoodOrder;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<FoodOrder, Long> {
    List<FoodOrder> findByCustomerId(Long customerId);

	FoodOrder findByOrderNumber(String orderNumber);
}
