package org.ncu.movie_booking_app.service;



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
		return movieBookingRepository.retriveBookings();
		
		// sort movie bookings by no. of tickets booked
	}
	
	// update a movie booking 
	
	// find a movie booking by id
	
	// delete a movie booking by id
}
