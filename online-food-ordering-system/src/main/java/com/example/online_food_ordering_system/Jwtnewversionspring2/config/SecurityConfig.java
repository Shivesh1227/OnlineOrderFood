package com.example.online_food_ordering_system.Jwtnewversionspring2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.example.online_food_ordering_system.Jwtnewversionspring2.security.JwtAuthenticationEntryPoint;
import com.example.online_food_ordering_system.Jwtnewversionspring2.security.JwtAuthenticationFilter;

@Configuration
public class SecurityConfig {

    @Autowired
    private JwtAuthenticationEntryPoint point;

    @Autowired
    private JwtAuthenticationFilter filter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .cors(cors -> cors.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/home/**").hasRole("ADMIN") // Admin can access user creation
                .requestMatchers("/auth/login").permitAll()
//                .requestMatchers("/home/createUser").permitAll()// Public login endpoint
                
                .requestMatchers("/customers/**").hasRole("USER") 
                // Only admins can access admin endpoints
                .anyRequest().authenticated())
            .exceptionHandling(ex -> ex.authenticationEntryPoint(point))
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}

    

