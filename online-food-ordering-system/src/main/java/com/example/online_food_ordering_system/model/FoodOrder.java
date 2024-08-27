package com.example.online_food_ordering_system.model;


import lombok.Data;
import jakarta.persistence.*;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Data
@Table(name = "food_order")  // Renamed table to avoid conflict
public class FoodOrder{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;
    private Date orderDate;
    private double totalPrice;
    private String deliveryAddress;
    private String deliveryStatus;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    @JsonBackReference
    private Customer customer;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getDeliveryAddress() {
		return deliveryAddress;
	}

	public void setDeliveryAddress(String deliveryAddress) {
		this.deliveryAddress = deliveryAddress;
	}

	public String getDeliveryStatus() {
		return deliveryStatus;
	}

	public void setDeliveryStatus(String deliveryStatus) {
		this.deliveryStatus = deliveryStatus;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public FoodOrder(Long id, String orderNumber, Date orderDate, double totalPrice, String deliveryAddress,
			String deliveryStatus, Customer customer) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.orderDate = orderDate;
		this.totalPrice = totalPrice;
		this.deliveryAddress = deliveryAddress;
		this.deliveryStatus = deliveryStatus;
		this.customer = customer;
	}

	public FoodOrder() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", orderNumber=" + orderNumber + ", orderDate=" + orderDate + ", totalPrice="
				+ totalPrice + ", deliveryAddress=" + deliveryAddress + ", deliveryStatus=" + deliveryStatus
				+ ", customer=" + customer + "]";
	}

	
}
