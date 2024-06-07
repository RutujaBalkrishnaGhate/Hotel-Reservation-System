package com.example.hotelreservation.dao;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.example.hotelreservation.pojo.Admin;
import com.example.hotelreservation.pojo.Hotel;
import com.example.hotelreservation.pojo.Reservation;
import com.example.hotelreservation.pojo.User;


public class DAO {

	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if(sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				
				Properties settings = new Properties();
				settings.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver");
				settings.put(Environment.URL, "jdbc:mysql://localhost:3306/hotelreservationdb");
				settings.put(Environment.USER, "root");
				settings.put(Environment.PASS, "Rutu1234");
				settings.put(Environment.DIALECT, "org.hibernate.dialect.MySQLDialect");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO, "update");
				
				configuration.setProperties(settings);
				configuration.addAnnotatedClass(Hotel.class);
				configuration.addAnnotatedClass(User.class);
				configuration.addAnnotatedClass(Reservation.class);
				configuration.addAnnotatedClass(Admin.class);

				
				ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder().applySettings(settings).build();
				
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
	
}

