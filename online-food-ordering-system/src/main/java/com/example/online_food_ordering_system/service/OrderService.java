package com.example.online_food_ordering_system.service;


import java.util.List;

import com.example.online_food_ordering_system.model.FoodOrder;

public interface OrderService {
    FoodOrder placeOrder(FoodOrder order);
    List<FoodOrder> getOrdersByCustomer(Long customerId);
    FoodOrder getOrderById(Long id);
    double calculateTotalPrice(FoodOrder order);
	FoodOrder getOrderByOrderNumber(String orderNumber);
}
