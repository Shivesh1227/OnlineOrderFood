package com.example.online_food_ordering_system.Jwtnewversionspring2.repo;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.online_food_ordering_system.Jwtnewversionspring2.model.User;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // Find a user by their email ID
    Optional<User> findByEmailId(String emailId);
    
    // Add other query methods as needed
}
