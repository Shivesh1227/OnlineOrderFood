package com.example.online_food_ordering_system.Jwtnewversionspring2.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.online_food_ordering_system.Jwtnewversionspring2.model.User;
import com.example.online_food_ordering_system.Jwtnewversionspring2.service.UserService;
import com.example.online_food_ordering_system.util.PasswordUtil;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.http.ResponseEntity;

import org.springframework.security.access.annotation.Secured;

@RestController
@RequestMapping("/home")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @GetMapping("/user")
    @Secured("ROLE_ADMIN")  // Only accessible by ADMIN
    public List<User> getUsers() {
        return userService.getUsers();
    }
    
    @GetMapping("/currentUser")
    public String currentUser(Principal principal) {
        return principal.getName();
    }

    @PostMapping("/createUser")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        user.setPassword(PasswordUtil.encodePassword(user.getPassword())); // Encode the password
        User createdUser = userService.saveUser(user);
        return ResponseEntity.ok(createdUser);
    }

}


