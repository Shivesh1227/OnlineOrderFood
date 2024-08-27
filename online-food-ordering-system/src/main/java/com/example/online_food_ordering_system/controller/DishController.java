package com.example.online_food_ordering_system.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.example.online_food_ordering_system.exception.InvalidInputException;
import com.example.online_food_ordering_system.exception.ResourceNotFoundException;
import com.example.online_food_ordering_system.exception.ResourceNotFoundException;
import com.example.online_food_ordering_system.model.Dish;
import com.example.online_food_ordering_system.model.Review;
import com.example.online_food_ordering_system.service.DishService;

import java.util.List;

@RestController
@RequestMapping("/dishes")
public class DishController {

    @Autowired
    private DishService dishService;

    @GetMapping("/cuisine")
  
    public ResponseEntity<List<Dish>> getDishesByCuisine(
            @RequestParam Dish.Cuisine cuisine,
            @RequestParam(defaultValue = "true") boolean availability) {
        if (cuisine == null) {
            throw new InvalidInputException("Cuisine type is required");
        }
        
        List<Dish> dishes = dishService.getDishesByCuisineAndAvailability(cuisine, availability);
        
        if (dishes.isEmpty()) {
            throw new ResourceNotFoundException("No dishes found for cuisine: " + cuisine);
        }
        
        return ResponseEntity.ok(dishes);
    }

    @GetMapping("/{id}")
    public Dish getDishById(@PathVariable Long id) {
        Dish dish = dishService.getDishById(id);
        if (dish == null) {
            throw new ResourceNotFoundException("Dish with ID " + id + " not found");
        }
        return dish;
    }

    @GetMapping("/sorted")
    public List<Dish> getDishesSortedByRating() {
        return dishService.getDishesSortedByRating();
    }

    @PostMapping
    public Dish addDish(@RequestBody Dish dish) {
        if (dish == null || dish.getName() == null || dish.getPrice() <= 0) {
            throw new InvalidInputException("Invalid dish data provided");
        }
        return dishService.addDish(dish);
    }

    @PostMapping("/{dishId}/reviews")
    public Review addReview(@PathVariable Long dishId, @RequestBody Review review) {
        Dish dish = dishService.getDishById(dishId);
        if (dish == null) {
            throw new ResourceNotFoundException("Dish with ID " + dishId + " not found");
        }
        return dishService.addReview(dishId, review);
    }
}
