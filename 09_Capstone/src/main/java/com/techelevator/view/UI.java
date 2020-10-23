package com.techelevator.view;

import java.time.Month;
import java.time.format.TextStyle;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import org.springframework.util.StringUtils;

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
	public String printOutSpaces(List<Space> spaceList) {
		for (Space s : spaceList) {
			System.out.printf("%-5s", "#" + s.getId());
			System.out.printf("%-20s ", s.getName());
			if (s.getOpenMonth() != 0) {
				System.out.printf("%-5s", (Month.of(s.getOpenMonth())
						.getDisplayName(TextStyle.SHORT,Locale.ENGLISH)) + ".");
			}
			System.out.println("");
		}
		return scan.nextLine();
	}
	public void errorMessage() {
		System.out.println("*** Please enter a valid option ***");
	}
	
	public void exitMessage() {
		System.out.println("Thank you for choosing Excelsior Venues, have a great day.");
	}
}
