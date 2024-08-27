package com.example.online_food_ordering_system.service;

import com.example.online_food_ordering_system.model.Dish;
import com.example.online_food_ordering_system.model.Review;
import com.example.online_food_ordering_system.model.Dish.Cuisine;

import java.util.List;

public interface DishService {
    List<Dish> getDishesByCuisine(Dish.Cuisine cuisine);
    Dish getDishById(Long id);
    List<Dish> getDishesSortedByRating();
    Dish addDish(Dish dish);
    List<Dish> getDishesByCuisineAndAvailability(Cuisine cuisine, boolean availability);
    Review addReview(Long dishId, Review review);
}
