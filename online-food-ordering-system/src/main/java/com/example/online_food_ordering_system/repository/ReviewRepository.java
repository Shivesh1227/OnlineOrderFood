package com.example.online_food_ordering_system.repository;

import com.example.online_food_ordering_system.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}

