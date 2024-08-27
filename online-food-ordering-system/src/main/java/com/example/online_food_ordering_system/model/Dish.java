package com.example.online_food_ordering_system.model;

import lombok.Data;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
public class Dish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double price;
    @Enumerated(EnumType.STRING)
    private Cuisine cuisine;
    private boolean availability;
    private double avgRating; // Persisted in the database

    @OneToMany(mappedBy = "dish", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    private List<Review> reviews = new ArrayList<>();
    
    public enum Cuisine {
        CHINESE, CONTINENTAL, NORTH_INDIAN, SOUTH_INDIAN
    }


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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Cuisine getCuisine() {
		return cuisine;
	}

	public void setCuisine(Cuisine cuisine) {
		this.cuisine = cuisine;
	}

	public boolean isAvailability() {
		return availability;
	}

	public void setAvailability(boolean availability) {
		this.availability = availability;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}

	public Dish(Long id, String name, String description, double price, Cuisine cuisine, boolean availability,
			List<Review> reviews, double avgRating) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.price = price;
		this.cuisine = cuisine;
		this.availability = availability;
		this.reviews = reviews;
		this.avgRating = avgRating;
	}

	public Dish() {
		super();
		// TODO Auto-generated constructor stub
	}
	 public void addReview(Review review) {
	        reviews.add(review);
	        review.setDish(this);
	        calculateAvgRating();
	    }

	    public void calculateAvgRating() {
	        if (reviews.isEmpty()) {
	            avgRating = 0;
	            return;
	        }
	        double total = reviews.stream().mapToDouble(Review::getRating).sum();
	        avgRating = total / reviews.size();
	    }

    

    // Other getters and setters
}
