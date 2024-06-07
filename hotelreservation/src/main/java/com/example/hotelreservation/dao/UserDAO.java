package com.example.hotelreservation.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.hotelreservation.pojo.User;
import com.example.hotelreservation.service.UserService;

@Repository
public class UserDAO {
	
	
	
    
    public void save(User user) {
    	Session session= DAO.getSessionFactory().openSession();
		Transaction tx=session.beginTransaction();
		session.persist(user);
		tx.commit();
        
    }

    
    public void update(User user) {
    	try(Session session= DAO.getSessionFactory().openSession()){
    		Transaction tx=session.beginTransaction();
    		session.merge(user);
    		tx.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    public void delete(User user) {
        if (user == null)
            return;
        try(Session session= DAO.getSessionFactory().openSession()){
    		Transaction tx=session.beginTransaction();
    		session.remove(user);
    		tx.commit();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

    
    public void deleteById(Long id) {
        try (Session session =DAO.getSessionFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            String queryString = "delete from User where id= :id";
            Query query = session.createQuery(queryString);
            query.setParameter("id", id);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    
    public void deleteByEmail(String email) {
        try (Session session = DAO.getSessionFactory().openSession()) {
            Transaction transaction = session.getTransaction();
            transaction.begin();
            String queryString = "delete from User where email= :email";
            Query query = session.createQuery(queryString);
            query.setParameter("email", email);
            query.executeUpdate();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
  

    
    public User getById(Long id) {
        try (Session session = DAO.getSessionFactory().openSession()) {
            String queryString = "FROM User where id=" + id;
            Query query = session.createQuery(queryString, User.class);
            List<User> users = query.list();
            return users.size() == 1 ? users.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getByEmail(String email) {
        try (Session session = DAO.getSessionFactory().openSession()) {
            String queryString = "FROM User u where u.email=\"" + email + "\"";
            Query query = session.createQuery(queryString, User.class);
            List<User> users = query.list();
            return users.size() == 1 ? users.get(0) : null;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    
    public List<User> getAllUsers() {
        String hql="FROM User";
        		Query q= DAO.getSessionFactory().openSession().createQuery(hql);
        		List<User> list= q.list();
        		return list;
        
    }
    
    
}


