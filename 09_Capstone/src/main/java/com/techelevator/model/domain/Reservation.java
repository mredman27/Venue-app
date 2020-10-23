package com.techelevator.model.domain;

import java.time.LocalDate;

public class Reservation {
	// Instance Variables
	private int id;
	private int spaceId;
	private LocalDate startDate;
	private LocalDate endDate;
	private String name;
	
	// Getters & Setters
	public String getName() {
		return name;
	}
	public void setName(String name) {	
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSpaceId() {
		return spaceId;
	}
	public void setSpaceId(int spaceId) {
		this.spaceId = spaceId;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

}
