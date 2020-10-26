package com.techelevator.model.dao;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.model.domain.Reservation;

public class JDBCReservationDAO implements ReservationDAO {
	private JdbcTemplate jdbcTemplate;
	
	public JDBCReservationDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);	
		}

	@Override
	public int createReservation(Reservation reservation) {
		String sql = "INSERT INTO reservation(space_id, number_of_attendees, start_date, end_date, reserved_for) " +
					 "VALUES(?,?, TO_DATE(?, 'YYYY-MM-DD'), TO_DATE(?, 'YYYY-MM-DD'), ?) " +
					 "RETURNING reservation_id";
		int id = 0;
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql,reservation.getSpaceId(), reservation.getPeople(), 
				reservation.getFormattedStartDate(), reservation.getFormattedEndDate(), reservation.getName());
		while (results.next()) {
			id = results.getInt("reservation_id");
		}
		return id;
	}
	public int getCurrentId() {
		String sql = "SELECT last_value FROM reservation_reservation_id_seq";
		int id = 0;
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql);
		while (results.next()) {
			id = results.getInt("last_value");
		}
		return id;
	}

}
