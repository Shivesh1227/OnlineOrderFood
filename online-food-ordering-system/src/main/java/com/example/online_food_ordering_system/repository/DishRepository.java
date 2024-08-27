package com.example.online_food_ordering_system.repository;


import com.example.online_food_ordering_system.model.Dish;
import com.example.online_food_ordering_system.model.Dish.Cuisine;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DishRepository extends JpaRepository<Dish, Long> {
    List<Dish> findByCuisine(Dish.Cuisine cuisine);
   
	List<Dish> findByCuisineAndAvailability(Cuisine cuisine, boolean availability);
	 @Query("SELECT d FROM Dish d ORDER BY d.avgRating DESC")
	    List<Dish> findAllByOrderByAvgRatingDesc();
}
