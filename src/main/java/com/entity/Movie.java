package com.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="movies")
public class Movie {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int movieId;
	private String title;
	private String genre;
	private double rating;
	private double ticketPrice;

	public Movie() {

	}

	public Movie(int movieId, String title, String genre, double rating, double ticketPrice) {
		super();
		this.movieId = movieId;
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.ticketPrice = ticketPrice;
	}

	public Movie(String title, String genre, double rating, double ticketPrice) {
		this.title = title;
		this.genre = genre;
		this.rating = rating;
		this.ticketPrice = ticketPrice;
	}

	public int getMovieId() {
		return movieId;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public double getTicketPrice() {
		return ticketPrice;
	}

	public void setTicketPrice(double ticketPrice) {
		this.ticketPrice = ticketPrice;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", title=" + title + ", genre=" + genre + ", rating=" + rating
				+ ", ticketPrice=" + ticketPrice + "]";
	} }
