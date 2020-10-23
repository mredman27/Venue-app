package com.techelevator;

import java.util.List;

import javax.sql.DataSource;
import com.techelevator.model.domain.*;
import com.techelevator.model.dao.JDBCVenueSpacesDAO;

public class VenueSpacesManager {

	private JDBCVenueSpacesDAO venueSpacesDAO;

	public VenueSpacesManager(DataSource dataSource) {
		venueSpacesDAO = new JDBCVenueSpacesDAO(dataSource);
	}
	

	public List<Venue> getAllVenues() { 
		return venueSpacesDAO.getAllVenues();
	}
	public Venue getVenueById(int id) {
		return venueSpacesDAO.getVenueById(id);
	}
	public List<Space> getAllSpacesFromVenue(Venue venue) {
		return venueSpacesDAO.getAllSpacesFromVenue(venue);
	}
	public List<Space> getValidSpacesFromVenue(Venue venue, RequestedReservation reservation) {
		return venueSpacesDAO.getValidSpaces(venue, reservation);
	}
}
