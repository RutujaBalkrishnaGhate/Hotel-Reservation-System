package com.example.hotelreservation.service;

import java.util.List;

import com.example.hotelreservation.pojo.Reservation;

public interface ReservationService {

	void saveReservation(Reservation reservation);

	List<Reservation> getReservationsByUserId(Long userId);

	void cancelReservation(Long reservationId);

}
