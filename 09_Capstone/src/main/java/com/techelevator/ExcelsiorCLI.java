package com.techelevator;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.model.dao.JDBCVenueSpacesDAO;
import com.techelevator.view.UI;

public class ExcelsiorCLI {
	// These are our user interface and manager classes used for abstraction
	private UI ui;
	private VenueSpacesManager venueSpacesManager;
	private ReservationManager reservationManager;
	
	// We set up a data source and pass it to our constructor, which passes it to our managers, and then
	// we start the menu loop
	public static void main(String[] args) {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/excelsior-venues");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
	
		ExcelsiorCLI application = new ExcelsiorCLI(dataSource);
		application.run();
	}

	public ExcelsiorCLI(DataSource datasource) {
		this.venueSpacesManager = new VenueSpacesManager(datasource);
		this.reservationManager = new ReservationManager(datasource);
		this.ui = new UI();
	}
    /*
     * What would you like to do?
   	 *	1) List Venues
     *	Q) Quit
     * 
     *  This is what the below menu would look like.
     */
	public void run() {
		boolean isFinished = false;
		while (!isFinished) {
			String option = "";
			option = ui.printMainMenu();
			if (option.equals("1")) {
				/*
				 * Which venue would you like to view?
			     *	1) Hidden Owl Eatery
			     * 	2) Painted Squirrel Club
			     *	3) Rusty Farmer Spot
			     *	4) ...
			     *	R) Return to Previous Screen
			     *
			     * This is what the below menu would look like. It then takes the string input from 
			     * user and queries the venue with that string as it's id
				 */
				runVenueMenu(ui.printOutVenues(venueSpacesManager.getAllVenues()));
			}
			else if (option.equalsIgnoreCase("Q")) {
				ui.exitMessage();
				System.exit(1);
			}
			else ui.errorMessage();
		}
	}
	/*
	 *Runaway Time Emporium
	 *Location: Andoshire, PA
	 *Categories: Modern

	 *The perfect office space for those trying to get that next big project done. Plenty of office supplies available and a lightning fast wifi network.

	 *What would you like to do next?
     *	1) View Spaces
     *	2) Search for Reservation
     * 	R) Return to Previous Screen
     * 
     * This is what the below menu looks like
	 */
	public void runVenueMenu(String string) {
		boolean isFinished = false; 
		while (!isFinished) {
			String option = "";
			// This is getting the venues details from the earlier user input, displaying the details 
			// and then getting user input for the menu
			option = ui.printVenueDetails(venueSpacesManager.getVenueById(Integer.parseInt(string)));
			if (option.equals("1")) {
				venueSpacesManager.setVenue(venueSpacesManager.getVenueById(Integer.parseInt(string)));
				ui.printOutSpaces(venueSpacesManager.getAllSpacesFromVenue(venueSpacesManager.getVenue()));
				runSpaceMenu(string);
			}
			else if (option.equals("2")) {
				
			}
			else if (option.equalsIgnoreCase("R")) {
				isFinished = true;
			}
			else ui.errorMessage();
		}
	}
	/*
	 * Runaway Time Emporium Spaces

     	Name                Open   Close   Daily Rate   Max. Occupancy
   #1   Prepare             Apr.   Aug.    $2850.00     190
   #2   Work it Out         Jan.   Jun.    $4400.00     220
   #3   Brainstorm                         $3000.00     200
   #4   Get Work Done       Jul.   Dec.    $4800.00     160
   #5   Deliver Status                     $4400.00     220
   #6   Waste Time                         $6900.00     230
   #7   Creative Thinking                  $900.00      30

	What would you like to do next?
    	1) Reserve a Space
    	R) Return to Previous Screen
     * This is what the below menu will look like.
	 */
	public void runSpaceMenu(String string) {
		boolean isFinished = false;
		while (!isFinished) {
			String option = "";
			option = ui.printOutVenueMenu();
			if (option.equals("1")) {
				// This is where we store the inputed user data for the reservation for later
				venueSpacesManager.setRequestedReservation(ui.printOutReservationMenu());
				// And this is where we search the spaces by the user data(time frame and occupancy)
				ui.printOutSpaces(venueSpacesManager.getValidSpacesFromVenue(venueSpacesManager.getVenue(), venueSpacesManager.getRequestedReservation()));
				runReservationMenu();
				
			} 
			else if (option.equalsIgnoreCase("R")) {
				isFinished = true;
			}
			else ui.errorMessage();
		}
	}
	public void runReservationMenu() {
		boolean isFinished = false;
		while (!isFinished) {
			ui.printOutReservationConfirmationMenu();
			
		}
	}
}
