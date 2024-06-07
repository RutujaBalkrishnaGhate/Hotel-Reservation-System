package com.example.hotelreservation.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotelreservation.dao.ReservationDAO;
import com.example.hotelreservation.pojo.Reservation;

@Service
public class ReservationServiceImpl implements ReservationService{

	@Autowired
	ReservationDAO reservationDAO;
	

    @Override
    public void saveReservation(Reservation reservation) {
        reservationDAO.saveReservation(reservation);
    }

    @Override
    public List<Reservation> getReservationsByUserId(Long userId) {
        return reservationDAO.getReservationsByUserId(userId);
    }
    
    @Override
    public void cancelReservation(Long reservationId) {
        Reservation reservation = reservationDAO.getReservationById(reservationId);
        if (reservation != null) {
            reservationDAO.cancelReservation(reservation);
        }
    }

}
