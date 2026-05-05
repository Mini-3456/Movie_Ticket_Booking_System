package com;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.MutationQuery;
import org.hibernate.query.NativeQuery;

import com.entity.Booking;
import com.utility.HibernateUtil;
public class Movie_Application_Native {
public static void main(String[] args) {

	SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
	Session session =sessionFactory.openSession();
	
	allBookings(session);
	customerBookings(session);
	joinQuery(session);
	update(session);
	delete(session);
	
}
private static void allBookings(Session session) {
	NativeQuery<Booking> nativeQuery=session.createNativeQuery("select * from bookings",Booking.class);
	List<Booking> list=nativeQuery.list();
	System.out.println(list);
}

private static void customerBookings(Session session) {
	NativeQuery<Booking> nativeQuery=session.createNativeQuery("select * from bookings where customerName='Ravi'",Booking.class);
	List<Booking> list=nativeQuery.list();
	System.out.println(list);
}

private static void joinQuery(Session session) {
	NativeQuery<Object[]> nativeQuery=session.createNativeQuery("select b.customerName, m.title, b.numberOfTickets"
                                                                +" from bookings b join movies m on b.movieId=m.movieId",Object[].class);
	List<Object[]> list=nativeQuery.list();
	for (Object[] row : list) {
        System.out.println("Customer: " + row[0] + ", Movie: " + row[1] + ", Tickets: " + row[2]);
    }
}
private static void update(Session session) {
	session.beginTransaction();
	MutationQuery mutationQuery=session.createNativeMutationQuery("Update bookings set totalAmount=?1 where bookingId=?2");
	mutationQuery.setParameter(1, 968);
	mutationQuery.setParameter(2,1);
	mutationQuery.executeUpdate();
	session.getTransaction().commit();
}
private static void delete(Session session) {
    session.beginTransaction();
    MutationQuery mutationQuery = session.createNativeMutationQuery("Delete from bookings where numberOfTickets < ?1");
    mutationQuery.setParameter(1, 1);
    int deletedRows = mutationQuery.executeUpdate();
    session.getTransaction().commit();
}
}