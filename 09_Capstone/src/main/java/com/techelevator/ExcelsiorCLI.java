package com.techelevator;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.techelevator.model.dao.JDBCVenueSpacesDAO;
import com.techelevator.view.UI;

public class ExcelsiorCLI {
	private UI ui;
	private VenueSpacesManager venueSpacesManager;
	
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
		this.ui = new UI();
	}

	public void run() {
		boolean isFinished = false;
		while (!isFinished) {
			String option = "";
			option = ui.printMainMenu();
			if (option.equals("1")) {
				runVenueMenu(ui.printOutVenues(venueSpacesManager.getAllVenues()));
			}
			else if (option.equalsIgnoreCase("Q")) {
				ui.exitMessage();
				System.exit(1);
			}
			else ui.errorMessage();
		}

	}
	public void runVenueMenu(String string) {
		boolean isFinished = false; 
		while (!isFinished) {
			String option = "";
			option = ui.printVenueDetails(venueSpacesManager.getVenueById(Integer.parseInt(string)));
			if (option.equals("1")) {
				ui.printOutSpaces(venueSpacesManager.getAllSpacesFromVenue(venueSpacesManager.getVenueById(Integer.parseInt(string))));
			}
			else if (option.equals("2")) {
				
			}
			else if (option.equalsIgnoreCase("R")) {
				isFinished = true;
			}
			else ui.errorMessage();
		}
	}
}
