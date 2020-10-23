package com.techelevator.model.domain;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RequestedReservation {
	private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
	private LocalDate startDate;
	private LocalDate endDate;
	private int people;

	
	
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(String date) {
		this.startDate = LocalDate.parse(date, formatter);
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(int days) {
		this.endDate = startDate.plusDays(days);
	}
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	
	public int getStartMonth() {
		return startDate.getMonthValue();
	}
	
	public int getEndMonth() {
		return endDate.getMonthValue();
	}
	
	

}
