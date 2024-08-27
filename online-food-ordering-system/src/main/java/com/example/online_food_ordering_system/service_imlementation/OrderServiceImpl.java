package com.example.online_food_ordering_system.service_imlementation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.online_food_ordering_system.model.Customer;
import com.example.online_food_ordering_system.model.FoodOrder;
import com.example.online_food_ordering_system.repository.CustomerRepository;
import com.example.online_food_ordering_system.repository.OrderRepository;
import com.example.online_food_ordering_system.service.OrderService;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;
    
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public FoodOrder placeOrder(FoodOrder order) {
        if (order.getCustomer() == null || order.getCustomer().getId() == null) {
            throw new RuntimeException("Customer ID is missing");
        }

        Long customerId = order.getCustomer().getId();
        System.out.println("Looking up customer with ID: " + customerId);

        Customer customer = customerRepository.findById(customerId).orElse(null);
        if (customer == null) {
            throw new RuntimeException("Customer not found");
        }

        System.out.println("Found customer: " + customer.getName());

        order.setCustomer(customer);

        return orderRepository.save(order);
    }


    @Override
    public List<FoodOrder> getOrdersByCustomer(Long customerId) {
        return orderRepository.findByCustomerId(customerId);
    }

    @Override
    public FoodOrder getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }

    @Override
    public double calculateTotalPrice(FoodOrder order) {
        // Calculate total price logic
        return order.getTotalPrice();
    }


    @Override
    public FoodOrder getOrderByOrderNumber(String orderNumber) {
        return orderRepository.findByOrderNumber(orderNumber);
    }
}
