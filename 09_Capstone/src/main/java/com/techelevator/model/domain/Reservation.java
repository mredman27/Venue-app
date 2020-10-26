package com.techelevator.model.domain;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Reservation {
	// Instance Variables
	private int id;
	private int spaceId;
	private LocalDate startDate;
	private LocalDate endDate;
	private String name;
	private int people;
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

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
	public void setPeople(int people) {
		this.people = people;
	}
	public int getPeople() {
		return people;
	}
	public String getFormattedStartDate() {
		return formatter.format(getStartDate());
	}
	public String getFormattedEndDate() {
		return formatter.format(getEndDate());
	}

	
}
