package com.techelevator;

import javax.sql.DataSource;

import com.techelevator.model.dao.JDBCReservationDAO;
import com.techelevator.model.domain.RequestedReservation;
import com.techelevator.model.domain.Reservation;

public class ReservationManager {
	private JDBCReservationDAO reservationDAO;
	private Reservation reservation;
	public ReservationManager(DataSource datasource) {
		reservationDAO = new JDBCReservationDAO(datasource);
	}
	
	public void saveReservation(Reservation reservation, RequestedReservation requestedReservation) {
		reservation.setPeople(requestedReservation.getPeople());
		reservation.setStartDate(requestedReservation.getStartDate());
		reservation.setEndDate(requestedReservation.getEndDate());
		reservation.setId(reservationDAO.createReservation(reservation));
		this.reservation = reservation;
	}
	
	public Reservation getReservation() {
		return this.reservation;
	}
}
