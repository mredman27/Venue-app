package com.techelevator.model.domain;

import java.util.List;

public class Venue {	
	// Instance variables
	private int id;
	private int venueId;
	private String name;
	private String city;
	private String description;
	private String state;
	private List<String> categories;
	
	// Getters & Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setVenueId(int id) {
		this.venueId = id;
	}
	public int getVenueId() {
		return venueId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public List<String> getCategories() {
		return categories;
	}
	public void setCategories(List<String> categories) {
		this.categories = categories;
	}

}
