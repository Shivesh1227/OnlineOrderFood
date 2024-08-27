package com.example.online_food_ordering_system.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.online_food_ordering_system.model.Customer;
import com.example.online_food_ordering_system.service.CustomerService;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

  

    
    @PostMapping("/login")
    public ResponseEntity<Customer> login(@RequestParam String email) {
        Customer customer = customerService.login(email);
        return ResponseEntity.ok(customer);
    }
   

    @GetMapping("/{id}")
    public ResponseEntity<Customer> getCustomerDetails(@PathVariable Long id) {
        Customer customer = customerService.getCustomerDetails(id);
        return ResponseEntity.ok(customer);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @RequestBody Customer customer) {
        customer.setId(id);
        Customer updatedCustomer = customerService.updateCustomer(customer);
        return ResponseEntity.ok(updatedCustomer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}
