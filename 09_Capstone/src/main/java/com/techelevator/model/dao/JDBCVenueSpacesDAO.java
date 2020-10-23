package com.techelevator.model.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.domain.RequestedReservation;
import com.techelevator.model.domain.Space;
import com.techelevator.model.domain.Venue;

public class JDBCVenueSpacesDAO implements VenueSpacesDAO {
	private JdbcTemplate jdbcTemplate;
	
	public JDBCVenueSpacesDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override 
	public List<Venue> getAllVenues() {
		List<Venue> venueList = new ArrayList<>();
		String sql = "SELECT venue.name, venue.id, city.name as city_name, city.state_abbreviation as state_abbreviation, venue.description " + 
				"FROM venue " + 
				"JOIN city ON city.id = venue.city_id " +
				"ORDER BY venue.id";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			Venue venue; 
			venue = mapRowToVenue(results);
			String getCategoriesSql = "SELECT category.name " + 
					"FROM category " + 
					"WHERE category.id IN (SELECT category_id FROM category_venue WHERE venue_id = ?)";
			SqlRowSet categoryResults = jdbcTemplate.queryForRowSet(getCategoriesSql, venue.getId());
			List<String> categoryList = new ArrayList<String>();
			while (categoryResults.next()) {
				categoryList.add(categoryResults.getString("name"));
			}
			venue.setCategories(categoryList);
			venueList.add(venue);
		}
		return venueList;
	}
	@Override
	public Venue getVenueById(int id) {
		Venue venue = new Venue();
		String sql = "SELECT venue.name, venue.id, city.name as city_name, city.state_abbreviation as state_abbreviation, venue.description " + 
				"FROM venue " + 
				"JOIN city ON city.id = venue.city_id " +
				"WHERE venue.id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);
		while (results.next()) {
			venue = mapRowToVenue(results);
			String getCategoriesSql = "SELECT category.name " + 
					"FROM category " + 
					"WHERE category.id IN (SELECT category_id FROM category_venue WHERE venue_id = ?)";
			SqlRowSet categoryResults = jdbcTemplate.queryForRowSet(getCategoriesSql, venue.getId());
			List<String> categoryList = new ArrayList<String>();
			while (categoryResults.next()) {
				categoryList.add(categoryResults.getString("name"));
			}
			venue.setCategories(categoryList);
		}
		return venue;
	}

	@Override
	public List<Space> getAllSpacesFromVenue(Venue venue) {
		List<Space> spaceList = new ArrayList<>();
		String sql = "SELECT id,venue_id, name, is_accessible, open_from, open_to, max_occupancy, CAST(daily_rate as decimal) AS daily_rate_dec FROM space WHERE venue_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, venue.getId());
		while (results.next()) {
			spaceList.add(mapRowToSpace(results));
		}
		return spaceList;
	}

	@Override
	public List<Space> getValidSpaces(Venue venue, RequestedReservation reservation) {
		List<Space> validSpaces = new ArrayList<>();
		String sql = "SELECT name, id, is_accessible, open_from, open_to, max_occupancy, CAST(daily_rate AS decimal) AS daily_rate_dec FROM space WHERE venue_id = ? AND max_occupancy > ? "
				+ "AND (open_from IS NULL OR (open_from <= ? AND open_to >= ?))";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, venue.getId(), reservation.getPeople(), reservation.getStartMonth(), reservation.getEndMonth());
		while (results.next()) {
			validSpaces.add(mapRowToSpace(results));
		}
		return validSpaces;
	}
	
	private Venue mapRowToVenue(SqlRowSet results) {
		Venue venue = new Venue();
		venue.setName(results.getString("name"));
		venue.setId(results.getInt("id"));
		venue.setCity(results.getString("city_name"));
		venue.setState(results.getString("state_abbreviation"));
		venue.setDescription(results.getString("description"));
		return venue;
	}
	
	private Space mapRowToSpace(SqlRowSet results) {
		Space space = new Space();
		space.setName(results.getString("name"));
		space.setId(results.getInt("id"));
		space.setWheelchairAccessible(results.getBoolean("is_accessible"));
		space.setDailyRate(BigDecimal.valueOf(results.getDouble("daily_rate_dec")));
		space.setMaximumOccupancy(results.getInt("max_occupancy"));
		if (results.getInt("open_from") != 0) {
			space.setOpenMonth(results.getInt("open_from"));
		}
		if (results.getInt("open_to") != 0) {
			space.setCloseMonth(results.getInt("open_to"));
		}
		return space;
	}
}
