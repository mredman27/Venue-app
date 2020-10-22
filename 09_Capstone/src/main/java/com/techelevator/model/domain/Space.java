package com.techelevator.model.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Space {
	// Instance variables
	private int id;
	private String name;
	private LocalDate openMonth;
	private LocalDate closeMonth;
	private int maximumOccupancy;
	private boolean wheelchairAccessible;
	private BigDecimal monthlyRate;
	
	// Getters & Setters
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public LocalDate getOpenMonth() {
		return openMonth;
	}
	public void setOpenMonth(LocalDate openMonth) {
		this.openMonth = openMonth;
	}
	public LocalDate getCloseMonth() {
		return closeMonth;
	}
	public void setCloseMonth(LocalDate closeMonth) {
		this.closeMonth = closeMonth;
	}
	public int getMaximumOccupancy() {
		return maximumOccupancy;
	}
	public void setMaximumOccupancy(int maximumOccupancy) {
		this.maximumOccupancy = maximumOccupancy;
	}
	public boolean isWheelchairAccessible() {
		return wheelchairAccessible;
	}
	public void setWheelchairAccessible(boolean wheelchairAccessible) {
		this.wheelchairAccessible = wheelchairAccessible;
	}
	public BigDecimal getMonthlyRate() {
		return monthlyRate;
	}
	public void setMonthlyRate(BigDecimal monthlyRate) {
		this.monthlyRate = monthlyRate;
	}
}
