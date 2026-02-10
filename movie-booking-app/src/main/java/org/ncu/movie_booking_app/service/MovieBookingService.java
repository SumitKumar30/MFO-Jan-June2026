package org.ncu.movie_booking_app.service;



import java.util.Collections;
import java.util.List;

import org.ncu.movie_booking_app.model.MovieBooking;
import org.ncu.movie_booking_app.repository.MovieBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieBookingService {
	@Autowired
	private MovieBookingRepository movieBookingRepository;
	
	// method to accept a movie booking and some validation criteria
	public void acceptBooking(int id, String movieName, String customerName, int tickets) {
		
		if(tickets < 0) {
			throw new RuntimeException("Invalid tickets");
		}else if(movieName.equals(null)) {
			throw new RuntimeException("Empty Name!!!");
		}
		
		movieBookingRepository.saveMovieBookings(new MovieBooking(id, movieName, customerName, tickets));
		System.out.println("Movie Bookings saved successfully!!!");
	}
	
	// method to fetch all movie bookings
	public List<MovieBooking> fetchAllBookings(){
		List<MovieBooking> bookings = movieBookingRepository.retriveBookings();
		
		// sort movie bookings by no. of tickets booked
		Collections.sort(bookings);
		
		return bookings;
	}
	
	// find a movie booking by id
	public String fetchMovieBookingById(int bookingId) {
		// validation check
		if(movieBookingRepository.retrieveBookingById(bookingId) != null) {
			
			return "Booking Found ==>> "+movieBookingRepository.retrieveBookingById(bookingId);
		}
		else
			return "No Booking Found!!";
	}
	
	
	// update a movie booking 
	public List<MovieBooking> updateBooking(int id, String mname, String cname, int tickets){
		return movieBookingRepository.updateBookingById(id, mname, cname, tickets);
	}
	
	
	// delete a movie booking by id
	public List<MovieBooking> deleteBooking(int id){
		return movieBookingRepository.deleteBookingById(id);
	}
}
