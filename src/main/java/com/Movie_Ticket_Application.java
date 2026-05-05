package com;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Booking;
import com.entity.Movie;
import com.utility.HibernateUtil;

public class Movie_Ticket_Application {
public static void main(String[] args) {

SessionFactory sessionFactory=HibernateUtil.getSessionFactory();

Session session= sessionFactory.openSession();

deleteData(session);

	}

private static void InsertData(Session session) {
	session.beginTransaction();
	//Insert Movies
	Movie movie1 =new Movie("Leo", "Action", 8.5, 200.0);
	Movie movie2 = new Movie("Jailer", "Drama", 8.0, 180.0);
    Movie movie3 = new Movie("F3", "Comedy", 7.0, 150.0);

	session.persist(movie1);
	session.persist(movie2);
	session.persist(movie3);

	//Insert Booking
	Booking booking1 = new Booking("Ravi", movie1.getMovieId(), 2, movie1.getTicketPrice() * 2);
    Booking booking2 = new Booking("Sita", movie3.getMovieId(), 3, movie3.getTicketPrice() * 3);

    session.persist(booking1);
    session.persist(booking2);
    session.getTransaction().commit();
}
private static void displayAllMovies(Session session) {
	//Read Data (Movies)
    List<Movie> movies=session.createQuery("from Movie", Movie.class).list();
    for(Movie movie:movies) {
    	System.out.println("MovieID:"+movie.getMovieId()+" "
                          +"Title:"+movie.getTitle()+" "
    			          +"Genre:"+movie.getGenre()+" "
    			          +"Rating:"+movie.getRating()+" "
    			          +"TotalPrice:"+movie.getTicketPrice());
    }
}
	private static void displayAllBookings(Session session) {
		//Read Data (Booking)
		    List<Booking> bookings=session.createQuery("from Booking",Booking.class).list();
		    for(Booking booking:bookings) {
		    	String movieTitle = session.find(Movie.class, booking.getMovieId()).getTitle();
		    	System.out.println("BookingID:"+booking.getBookingId()+" "
		    			+"CustomerName:"+booking.getCustomerName()+" "
		    			+"Movie:"+movieTitle+" "
		    			+"NumberOfTickets:"+booking.getNumberOfTickets()+" "
		    			+"TotalAmount:"+booking.getTotalAmount());
		    }
		    	session.close();
	}

	private static void updateData(Session session) {
        session.beginTransaction();

        // Update Movie Price
        Movie movie = session.get(Movie.class, 1);
        if (movie != null) {
            movie.setTicketPrice(220.0);
            session.merge(movie); // merge is the modern replacement for update
        }

        // Update Booking tickets and recalculate total
        Booking booking = session.get(Booking.class, 1);
        if (booking != null && movie != null) {
            booking.setNumberOfTickets(4);
            booking.setTotalAmount(movie.getTicketPrice() * 4);
            session.merge(booking);
            System.out.println("Updated Ravi's booking to 4 tickets.");
        }

        session.getTransaction().commit();
    }
	private static void deleteData(Session session) {
        session.beginTransaction();

        // Delete Booking (ID 2)
        Booking bookingToDelete = session.get(Booking.class, 2);
        if (bookingToDelete != null) {
            session.remove(bookingToDelete); // remove is the modern replacement for delete
            System.out.println("Deleted Booking ID 2");
        }

        // Delete Movie (ID 2)
        Movie movieToDelete = session.get(Movie.class, 2);
        if (movieToDelete != null) {
            session.remove(movieToDelete);
            System.out.println("Deleted Movie ID 2");
        }

        session.getTransaction().commit();
    }
	}


