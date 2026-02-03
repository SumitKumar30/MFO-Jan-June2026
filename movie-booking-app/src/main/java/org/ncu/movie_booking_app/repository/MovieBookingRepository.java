package org.ncu.movie_booking_app.repository;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.ncu.movie_booking_app.model.MovieBooking;
import org.springframework.stereotype.Repository;

@Repository
public class MovieBookingRepository {
	List<MovieBooking> movieBookings = new ArrayList<>();
	
	// save all the movie booking objects
	public void saveMovieBookings(MovieBooking movieBooking) {
		movieBookings.add(movieBooking);
	}
	
	// retrieve all movie bookings
	public List<MovieBooking> retriveBookings(){
		return movieBookings;
	}
	
	// find a movie booking by id
	public MovieBooking retrieveBookingById(int bookingId) {
		boolean flag = false;
		for(MovieBooking mb : movieBookings) {
			if(mb.getBookingId() == bookingId) {
				flag = true;
				return mb;
			}
		}
		
		if(!flag) 
			throw new RuntimeException("Booking not found!!");
		return null;
	}
	
	// update a movie booking
	
	public List<MovieBooking> updateBookingById(int bookingId, String movieName, String customerName, int tickets) {
//		MovieBooking booking = retrieveBookingById(bookingId);
//		booking.setCustomerName(customerName);
//		booking.setMovieName(movieName);
//		booking.setNoOfTickets(tickets);
		
		List<MovieBooking> bookings = retriveBookings();
		int index = 0;
		for(MovieBooking b : bookings) {
			if(b.getBookingId() == bookingId){
				b.setCustomerName(customerName);
				b.setMovieName(movieName);
				b.setNoOfTickets(tickets);				
				bookings.set(index, b);
			}
			index++;
		}
		return bookings;
	}
	
	
	// delete a movie booking by id
	public List<MovieBooking> deleteBookingById(int bookingId){
		MovieBooking booking =  retrieveBookingById(bookingId);
		movieBookings.remove(booking);
		return movieBookings;
	}
}
