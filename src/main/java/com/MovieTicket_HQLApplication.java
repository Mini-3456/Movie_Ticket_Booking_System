package com;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.SelectionQuery;

import com.entity.Movie;
import com.utility.HibernateUtil;

public class MovieTicket_HQLApplication {

	public static void main(String[] args) {

		SessionFactory sessionFactory=HibernateUtil.getSessionFactory();

		Session session=sessionFactory.openSession();

		selectAllMovies(session);

		greaterthan(session);

		titles(session);

	    sortTicketPrice(session);

		maxAndAvgTicketPrice(session);

		update(session);

		delete(session);
	}

	private static void selectAllMovies(Session session) {
		SelectionQuery<Movie> query=session.createSelectionQuery("From Movie",Movie.class);
		List<Movie> movie=query.list();
		System.out.println(movie);
	}

	private static void greaterthan(Session session) {
		SelectionQuery<Movie> query=session.createSelectionQuery("From Movie where rating>?1",Movie.class);
		query.setParameter(1, 8);
		List<Movie> movie=query.list();
		System.out.println(movie);
	}

	private static void titles(Session session) {
		SelectionQuery<String> query = session.createSelectionQuery("Select m.title From Movie m", String.class);
		List<String> titles = query.getResultList();
	    System.out.println(titles);
	}

	private static void sortTicketPrice(Session session) {
		SelectionQuery<Movie> query=session.createSelectionQuery("From Movie order by ticketPrice desc",Movie.class);
		List<Movie> movie=query.getResultList();
		System.out.println(movie);
	}

	private static void maxAndAvgTicketPrice(Session session) {
		SelectionQuery<Double> query1=session.createSelectionQuery("Select max(ticketPrice) From Movie",Double.class);
		List<Double> movie=query1.getResultList();
		System.out.println(movie);
		SelectionQuery<Double> query2=session.createSelectionQuery("Select avg(ticketPrice) From Movie",Double.class);
		List<Double> movie1=query2.getResultList();
		System.out.println(movie1);
	}

	private static void update(Session session) {
		session.beginTransaction();
		MutationQuery mutationQuery=session.createMutationQuery("update Movie set ticketPrice=ticketPrice*1.10");
		mutationQuery.executeUpdate();
		session.getTransaction().commit();
	}
	private static void delete(Session session) {
		session.beginTransaction();
		MutationQuery mutationQuery=session.createMutationQuery("Delete From Movie where rating<?1");
		mutationQuery.setParameter(1, 7.0);
		mutationQuery.executeUpdate();
		session.getTransaction().commit();
	}

}
