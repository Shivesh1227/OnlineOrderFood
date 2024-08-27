package com.example.online_food_ordering_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import com.example.online_food_ordering_system.exception.InvalidInputException;
import com.example.online_food_ordering_system.exception.ResourceNotFoundException;
import com.example.online_food_ordering_system.model.FoodOrder;
import com.example.online_food_ordering_system.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping
   
    public FoodOrder placeOrder(@RequestBody FoodOrder order) {
        if (order == null || order.getCustomer() == null) {
            throw new InvalidInputException("Order or customer information is missing");
        }
        return orderService.placeOrder(order);
    }

    @GetMapping("/customer/{customerId}")
    
    public List<FoodOrder> getOrdersByCustomer(@PathVariable Long customerId) {
        List<FoodOrder> orders = orderService.getOrdersByCustomer(customerId);
        if (orders == null || orders.isEmpty()) {
            throw new ResourceNotFoundException("No orders found for customer with ID " + customerId);
        }
        return orders;
    }

    @GetMapping("/{id}")
   
    public FoodOrder getOrderById(@PathVariable Long id) {
        FoodOrder order = orderService.getOrderById(id);
        if (order == null) {
            throw new ResourceNotFoundException("Order with ID " + id + " not found");
        }
        return order;
    }

    @GetMapping("/bill/{orderId}")
    
    public String getBillOfOrder(@PathVariable Long orderId) {
        FoodOrder order = orderService.getOrderById(orderId);
        if (order == null) {
            throw new ResourceNotFoundException("Order with ID " + orderId + " not found");
        }
        return "Bill for Order ID " + orderId + " with Customer name: " + order.getCustomer().getName() + " is $" + order.getTotalPrice();
    }

    @GetMapping("/orderNumber/{orderNumber}")
   
    public FoodOrder getOrderByOrderNumber(@PathVariable String orderNumber) {
        FoodOrder order = orderService.getOrderByOrderNumber(orderNumber);
        if (order == null) {
            throw new ResourceNotFoundException("Order with Order Number " + orderNumber + " not found");
        }
        return order;
    }
}
