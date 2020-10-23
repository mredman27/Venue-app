package com.techelevator.model.domain;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Space {
	// Instance variables
	private int id;
	private String name;
	private int openMonth;
	private int closeMonth;
	private int maximumOccupancy;
	private boolean wheelchairAccessible;
	private BigDecimal dailyRate;
	
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
	public int getOpenMonth() {
		return openMonth;
	}
	public void setOpenMonth(int openMonth) {
		this.openMonth = openMonth;
	}
	public int getCloseMonth() {
		return closeMonth;
	}
	public void setCloseMonth(int closeMonth) {
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
	public BigDecimal getDailyRate() {
		return dailyRate;
	}
	public void setDailyRate(BigDecimal dailyRate) {
		this.dailyRate = dailyRate;
	}
}
