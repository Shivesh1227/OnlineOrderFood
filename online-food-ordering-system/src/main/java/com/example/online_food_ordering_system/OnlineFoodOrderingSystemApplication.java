package com.example.online_food_ordering_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.online_food_ordering_system.util.PasswordUtil;

@SpringBootApplication
public class OnlineFoodOrderingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(OnlineFoodOrderingSystemApplication.class, args);
		
	}

}
