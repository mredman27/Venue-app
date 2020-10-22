package com.techelevator.model.dao;

import java.util.List;

import com.techelevator.model.domain.RequestedReservation;
import com.techelevator.model.domain.Space;
import com.techelevator.model.domain.Venue;

public class JDBCVenueSpacesDAO implements VenueSpacesDAO {

	public JDBCVenueSpacesDAO() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public List<Venue> getAllVenues() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Venue getVenueById() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Space> getAllSpacesFromVenue(Venue venue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Space> getValidSpaces(Venue venue, RequestedReservation reservation) {
		// TODO Auto-generated method stub
		return null;
	}

}
