package org.ncu.movie_booking_app.repository;


import java.util.ArrayList;
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
	
	// update a movie booking
	
	// find a movie booking by id
	
	// delete a movie booking by id
}
