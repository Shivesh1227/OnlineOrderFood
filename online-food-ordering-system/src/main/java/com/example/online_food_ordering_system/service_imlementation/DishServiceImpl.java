package com.example.online_food_ordering_system.service_imlementation;

import com.example.online_food_ordering_system.model.Dish;
import com.example.online_food_ordering_system.model.Dish.Cuisine;
import com.example.online_food_ordering_system.model.Review;
import com.example.online_food_ordering_system.repository.DishRepository;
import com.example.online_food_ordering_system.repository.ReviewRepository;
import com.example.online_food_ordering_system.service.DishService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class DishServiceImpl implements DishService {

    @Autowired
    private DishRepository dishRepository;
    
    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public List<Dish> getDishesByCuisine(Dish.Cuisine cuisine) {
        return dishRepository.findByCuisine(cuisine);
    }

    @Override
    public Dish getDishById(Long id) {
        return dishRepository.findById(id).orElse(null);
    }

//    @Override
//    public List<Dish> getDishesSortedByRating() {
//        return dishRepository.findAllByOrderByAvgRatingDesc();
//    }

    @Override
    public Dish addDish(Dish dish) {
        return dishRepository.save(dish);
    }

    @Override
    public List<Dish> getDishesByCuisineAndAvailability(Dish.Cuisine cuisine, boolean availability) {
        return dishRepository.findByCuisineAndAvailability(cuisine, availability);
    }

    @Override
    public Review addReview(Long dishId, Review review) {
        Dish dish = dishRepository.findById(dishId).orElseThrow(() -> new RuntimeException("Dish not found"));
        dish.addReview(review);
        dishRepository.save(dish);
        return reviewRepository.save(review);
    }

    @Override
    public List<Dish> getDishesSortedByRating() {
        return dishRepository.findAllByOrderByAvgRatingDesc();
    }

}
