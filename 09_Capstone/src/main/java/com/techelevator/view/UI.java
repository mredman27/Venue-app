package com.techelevator.view;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.springframework.util.StringUtils;

import com.techelevator.model.domain.RequestedReservation;
import com.techelevator.model.domain.Reservation;
import com.techelevator.model.domain.Space;
import com.techelevator.model.domain.Venue;

public class UI {
	Scanner scan = new Scanner(System.in);
	public String printMainMenu() {
		System.out.println("What would you like to do?");
		System.out.println("\t1) List Venues");
		System.out.println("\tQ) Quit");
		return scan.nextLine();
	}
	
	public String printOutVenues(List<Venue> list) {
		System.out.println("Which venue would you like to view?");
		for (Venue v : list) {
			System.out.println("\t" + v.getId() + ") " + v.getName());
		}
		return scan.nextLine();
	}
	public String printVenueDetails(Venue venue) {
		System.out.println(venue.getName());
		System.out.println("Location: " + venue.getCity() + ", " + venue.getState());
		System.out.println("Categories: " + venue.getCategories());
		System.out.println("\n" + venue.getDescription());
		System.out.println("What would you like to do next?");
		System.out.println("\t 1) View Spaces");
		System.out.println("\t 2) Search for Reservation");
		System.out.println("\t R) Return to previous menu");
		return scan.nextLine();
	}
	public void printOutSpaces(List<Space> spaceList) {
		if (spaceList.size() == 0) {
			System.out.println("No results found!");
			return;
		}
		System.out.printf("%-5s", "ID");
		System.out.printf("%-27s", "Name");
		System.out.printf("%-6s", "Open");
		System.out.printf("%-6s", "Close");
		System.out.printf("%-12s", "Daily Rate");
		System.out.printf("%-12s %n", "Max Occupancy");
		for (Space s : spaceList) {
			
			System.out.printf("%-5s", "#" + s.getId());
			System.out.printf("%-26s ", s.getName());
			if (s.getOpenMonth() != 0) {
				System.out.printf("%-6s", (Month.of(s.getOpenMonth())
						.getDisplayName(TextStyle.SHORT,Locale.ENGLISH)) + ".");
			}
			else System.out.printf("%6s", "");
			if (s.getCloseMonth() != 0) {
				System.out.printf("%-6s", (Month.of(s.getCloseMonth())
						.getDisplayName(TextStyle.SHORT,Locale.ENGLISH)) + ".");
			}
			else System.out.printf("%6s", "");
			System.out.printf("%-12s", "$" + s.getDailyRate());
			System.out.printf("%-12s %n", s.getMaximumOccupancy());
			
		}
	
	}
	public String printOutVenueMenu() {
		System.out.println("");
		System.out.println("What would you like to do?");
		System.out.println("\t 1) Reserve a space");
		System.out.println("\t R) Return to previous screen");
		return scan.nextLine();
	}
	public RequestedReservation printOutReservationMenu()  {
		RequestedReservation requestedReservation = new RequestedReservation();
		System.out.println("When do you need the space? ('MM/DD/YYYY' Format)");
		requestedReservation.setStartDate(scan.nextLine());
		System.out.println("How many days will you need the space?");
		requestedReservation.setEndDate(scan.nextInt());
		scan.nextLine();
		System.out.println("How many people will be in attendance");
		requestedReservation.setPeople(scan.nextInt());
		return requestedReservation;
	}
	
	public Reservation printOutReservationConfirmationMenu() throws Exception {
		Reservation reservation = new Reservation();
		System.out.println("Which space would you like to reserve? (Enter 0 to cancel)");
		int i = 0;
		i = scan.nextInt();
		if (i == 0) {
			scan.nextLine();
			throw new Exception();
		}
		reservation.setSpaceId(i);
		scan.nextLine();
		System.out.println("And what name will this be under?");
		reservation.setName(scan.nextLine());
		return reservation;
		
	}
	public void printOutReservationDetails(Reservation reservation) {
		System.out.println("Thank you for submitting your reservation, your details as followed:");
		System.out.println("Confirmation #: " + reservation.getId());
		System.out.println("Reserved for: " + reservation.getName());
		System.out.println("Attendees: " + reservation.getPeople());
		System.out.println("Arrival Date: " + reservation.getStartDate());
		System.out.println("Departure Date: " + reservation.getEndDate());
		
	}
	public void errorMessage() {
		System.out.println("*** Please enter a valid option ***");
	}
	
	public void exitMessage() {
		System.out.println("Thank you for choosing Excelsior Venues, have a great day.");
	}
}
