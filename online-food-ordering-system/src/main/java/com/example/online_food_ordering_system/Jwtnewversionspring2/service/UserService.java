package com.example.online_food_ordering_system.Jwtnewversionspring2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.online_food_ordering_system.Jwtnewversionspring2.model.User;
import com.example.online_food_ordering_system.Jwtnewversionspring2.repo.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    public Optional<User> getUserByEmail(String emailId) {
        return userRepository.findByEmailId(emailId);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmailId(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found with email: " + username));

        // Ensure the user password is correctly retrieved and compared
        return new org.springframework.security.core.userdetails.User(user.getEmailId(), user.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole())));
    }


    public User saveUser(User user) {
        return userRepository.save(user);
    }
}
