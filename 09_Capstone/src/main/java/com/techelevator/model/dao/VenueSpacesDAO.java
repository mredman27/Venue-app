package com.techelevator.model.dao;

import java.util.List;

import com.techelevator.model.domain.*;

public interface VenueSpacesDAO {
	public List<Venue> getAllVenues();
	
	public Venue getVenueById(int id);
	
	public List<Space> getAllSpacesFromVenue(Venue venue);
	
	public List<Space> getValidSpaces(Venue venue, RequestedReservation reservation);

	public int createNewVenue(String name, int cityId, String description);
}
