package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;

import com.techelevator.model.dao.JDBCVenueSpacesDAO;

public class JDBCVenueSpacesDAOIntegrationTest extends DAOIntegrationTest {

	@Test
	public void getVenueById() {
		JDBCVenueSpacesDAO dao = new JDBCVenueSpacesDAO(getDataSource());
		
	}
	
//	private void insertDummyVenueIntoDatabase(String name, ) {
//		
//	}
}
