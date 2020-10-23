package com.techelevator;

import java.util.List;

import javax.sql.DataSource;
import com.techelevator.model.domain.*;
import com.techelevator.model.dao.JDBCVenueSpacesDAO;

public class VenueSpacesManager {

	private JDBCVenueSpacesDAO venueSpacesDAO;
	private Reservation reservation;
	private RequestedReservation requestedReservation;
	private Venue venue;
	
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


	public Reservation getReservation() {
		return reservation;
	}


	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}


	public RequestedReservation getRequestedReservation() {
		return requestedReservation;
	}


	public void setRequestedReservation(RequestedReservation requestedReservation) {
		this.requestedReservation = requestedReservation;
	}


	public Venue getVenue() {
		return venue;
	}


	public void setVenue(Venue venue) {
		this.venue = venue;
	}
}
