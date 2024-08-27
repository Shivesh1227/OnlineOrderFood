
package com.example.online_food_ordering_system.model;

import lombok.Data;
import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String address;

    @OneToMany(mappedBy = "customer")
    @JsonManagedReference
    private List<FoodOrder> orders;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<FoodOrder> getOrders() {
		return orders;
	}

	public void setOrders(List<FoodOrder> orders) {
		this.orders = orders;
	}

	public Customer(Long id, String name, String email, String address, List<FoodOrder> orders) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.address = address;
		this.orders = orders;
	}

	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", orders="
				+ orders + "]";
	}
    
    
}

