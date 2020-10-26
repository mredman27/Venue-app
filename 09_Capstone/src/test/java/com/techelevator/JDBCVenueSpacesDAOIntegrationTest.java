package com.techelevator;

import static org.junit.Assert.*;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.dao.JDBCVenueSpacesDAO;

public class JDBCVenueSpacesDAOIntegrationTest extends DAOIntegrationTest {

	@Test
	public void getVenueById() {
		JdbcTemplate jdbcTemplate = new JdbcTemplate(getDataSource());
		JDBCVenueSpacesDAO dao = new JDBCVenueSpacesDAO(getDataSource());
		int id = 0;
		String sql = "INSERT INTO venue(name, city_id, description) VALUES('Test', 1, 'Test') RETURNING id";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			id = results.getInt("id");
		}
		assertEquals(dao.getVenueById(id).getName(), "Test" );
		
	}
	
}
