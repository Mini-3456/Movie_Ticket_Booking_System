package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="bookings")
public class Booking {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int bookingId;
	private String customerName;
	private int movieId;
	private int numberOfTickets;
	private double totalAmount;

	public Booking() {

	}

	public Booking(int bookingId, String customerName, int movieId, int numberOfTickets, double totalAmount) {
		super();
		this.bookingId = bookingId;
		this.customerName = customerName;
		this.movieId = movieId;
		this.numberOfTickets = numberOfTickets;
		this.totalAmount = totalAmount;
	}

	public Booking(String customerName, int movieId, int numberOfTickets, double totalAmount) {
		this.customerName = customerName;
		this.movieId = movieId;
		this.numberOfTickets = numberOfTickets;
		this.totalAmount = totalAmount;
	}

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public int getNumberOfTickets() {
		return numberOfTickets;
	}

	public void setNumberOfTickets(int numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}

	public double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", customerName=" + customerName + ", movieId=" + movieId
				+ ", numberOfTickets=" + numberOfTickets + ", totalAmount=" + totalAmount + "]";
	}}