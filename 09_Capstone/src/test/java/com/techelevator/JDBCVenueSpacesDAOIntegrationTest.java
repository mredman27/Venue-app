package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.dao.JDBCVenueSpacesDAO;

public class JDBCVenueSpacesDAOIntegrationTest extends DAOIntegrationTest {

	@Test
	public void getVenueById() {
		JDBCVenueSpacesDAO dao = new JDBCVenueSpacesDAO(getDataSource());
		int id = 0;
		id = dao.createNewVenue("Test", 1, "Test");
		assertEquals(dao.getVenueById(id).getName(), "Test" );
	}
	
}
