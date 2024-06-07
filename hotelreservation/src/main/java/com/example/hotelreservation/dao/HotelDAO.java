package com.example.hotelreservation.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.example.hotelreservation.pojo.Hotel;
import com.example.hotelreservation.pojo.User;


@Repository
public class HotelDAO {
	
	public void saveHotel(Hotel h) {
		
		Session session= DAO.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.persist(h);
		tx.commit();
		
	}
	
	public List<Hotel> getAllHotels(){
		
		String hql="FROM Hotel";
		Query q= DAO.getSessionFactory().openSession().createQuery(hql);
		List<Hotel> list= q.list();
		return list;
		
	}
	
	public void updateHotel(Hotel h) {
		
		Session session= DAO.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.merge(h);
		tx.commit();
		
	}
	
	public void deleteHotel(Hotel h) {
		
		Session session= DAO.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.remove(h);
		tx.commit();
		
	}
	
	 
    public Hotel getById(int i) {
        try (Session session = DAO.getSessionFactory().openSession()) {
            String queryString = "FROM Hotel where hotelid=" + i;
            Query query = session.createQuery(queryString, Hotel.class);
            List<Hotel> hotels = query.list();
            return hotels.size() == 1 ? hotels.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
   public void delete(Hotel hotel) {
        if (hotel == null)
            return;
        try(Session session= DAO.getSessionFactory().openSession()){
    		Transaction tx=session.beginTransaction();
    		session.remove(hotel);
    		tx.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    
    public void deleteById(int id) {
        try (Session session =DAO.getSessionFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            String queryString = "delete from Hotel where id= :id";
            Query query = session.createQuery(queryString);
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	

     
	

}