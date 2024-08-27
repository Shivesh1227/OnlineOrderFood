package com.example.online_food_ordering_system.service_imlementation;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.online_food_ordering_system.exception.ResourceNotFoundException;
import com.example.online_food_ordering_system.exception.InvalidInputException;
import com.example.online_food_ordering_system.model.Customer;
import com.example.online_food_ordering_system.repository.CustomerRepository;
import com.example.online_food_ordering_system.service.CustomerService;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer login(String email) {
        // Assuming login should verify credentials; since only email is provided, we'll throw an exception
        // if the customer is not found. Ideally, this should include password verification.
        Optional<Customer> customerOpt = customerRepository.findByEmail(email);
        return customerOpt.orElseThrow(() -> new ResourceNotFoundException("Customer not found with email: " + email));
    }

    @Override
    public Customer getCustomerDetails(Long id) {
        return customerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + id));
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        if (customer.getId() == null) {
            throw new InvalidInputException("Customer ID cannot be null for update.");
        }

        if (!customerRepository.existsById(customer.getId())) {
            throw new ResourceNotFoundException("Customer not found with id: " + customer.getId());
        }

        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new ResourceNotFoundException("Customer not found with id: " + id);
        }
        customerRepository.deleteById(id);
    }
}
