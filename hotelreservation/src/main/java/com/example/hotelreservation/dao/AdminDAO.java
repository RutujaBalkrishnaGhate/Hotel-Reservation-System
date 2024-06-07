package com.example.hotelreservation.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.hotelreservation.pojo.Admin;

@Repository
public class AdminDAO {
	
	

	
	

	public void saveAdmin(Admin a) {
		
		Session session= DAO.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.persist(a);
		tx.commit();
		
	}
	
	
	public Admin getById(Long aid) {
	    try (Session session = DAO.getSessionFactory().openSession()) {
	        return session.get(Admin.class, aid);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}


	public Admin getByEmail(String email) {
	    try (Session session = DAO.getSessionFactory().openSession()) {
	        String queryString = "FROM Admin a where a.email = :email";
	        Query<Admin> query = session.createQuery(queryString, Admin.class);
	        query.setParameter("email", email);

	        return query.uniqueResult();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return null;
	}


	
	
	

}
