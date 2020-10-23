package com.techelevator;

import javax.sql.DataSource;

import com.techelevator.model.dao.JDBCReservationDAO;
import com.techelevator.model.domain.Reservation;

public class ReservationManager {
	private JDBCReservationDAO reservationDAO;
	public ReservationManager(DataSource datasource) {
		reservationDAO = new JDBCReservationDAO(datasource);
	}
	
	public void saveReservation(Reservation reservation) {
		reservation.setId(reservationDAO.createReservation(reservation));
		
	}

}
