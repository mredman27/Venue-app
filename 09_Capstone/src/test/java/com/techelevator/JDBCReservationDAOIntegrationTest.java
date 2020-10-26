package com.techelevator;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.Test;

import com.techelevator.model.dao.JDBCReservationDAO;
import com.techelevator.model.domain.Reservation;

public class JDBCReservationDAOIntegrationTest extends DAOIntegrationTest {

	@Test
	public void createReservation() {
		JDBCReservationDAO dao = new JDBCReservationDAO(getDataSource());
		Reservation reservation = new Reservation();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		reservation.setName("Test");
		reservation.setSpaceId(1);
		reservation.setPeople(1);
		reservation.setStartDate(LocalDate.parse("01/01/1999", formatter));
		reservation.setEndDate(LocalDate.parse("01/01/2000", formatter));
		assertEquals(dao.getCurrentId() + 1,dao.createReservation(reservation));
		
	}

}
