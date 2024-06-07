package com.example.hotelreservation.dao;

import org.springframework.stereotype.Repository;

import com.example.hotelreservation.pojo.Hotel;
import com.example.hotelreservation.pojo.Reservation;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.query.Query;


@Repository
public class ReservationDAO {
	
	@PersistenceContext
    private EntityManager entityManager;
	
	public void saveReservation(Reservation reservation) {
            Session session = DAO.getSessionFactory().openSession();
            session.beginTransaction();
            session.persist(reservation);
            session.getTransaction().commit();
        }
	
	public List<Reservation> getReservationsByUserId(Long userId) {
        try (Session session = DAO.getSessionFactory().openSession()) {
        	String hql = "FROM Reservation r WHERE r.user.id = :userId";
        	List<Reservation> reservations = session.createQuery(hql, Reservation.class)
        	    .setParameter("userId", userId)
        	    .getResultList();
        	return reservations;        }
        
        

}

	public Reservation getReservationById(Long reservationId) {
        try (Session session = DAO.getSessionFactory().openSession()) {
            return session.find(Reservation.class, reservationId);
        }
    }

    public void cancelReservation(Reservation reservation) {
        try (Session session = DAO.getSessionFactory().openSession()) {
            session.beginTransaction();
            session.remove(reservation);
            session.getTransaction().commit();
        }
    }
}
