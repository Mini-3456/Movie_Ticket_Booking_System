package com.utility;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Booking;
import com.entity.Movie;

public class HibernateUtil {

	public static SessionFactory sessionFactory = null;

	public static  SessionFactory getSessionFactory() {

		if(sessionFactory==null) {
		Configuration cfg=new Configuration();
		cfg.configure();
		cfg.addAnnotatedClass(Movie.class);
		cfg.addAnnotatedClass(Booking.class);

		sessionFactory=cfg.buildSessionFactory();
		return sessionFactory;
	}else {
		return sessionFactory;
	}

	}
}
