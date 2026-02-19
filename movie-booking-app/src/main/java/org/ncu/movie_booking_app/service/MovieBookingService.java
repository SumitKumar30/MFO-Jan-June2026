package org.ncu.movie_booking_app.service;



import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.ncu.movie_booking_app.model.MovieBooking;
import org.ncu.movie_booking_app.repository.MovieBookingRepository;
import org.ncu.movie_booking_app.repository.extractor.TotalTicketsExtractor;
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
	
	// calculate total tickets sold
	public int calculateTotalTicketsSold() {
		int total = movieBookingRepository.getTotalTicketsSold();
		if(total == 0) {
			throw new IllegalStateException("No tickets sold yet!");
		}
		
		return total;
	}
	
	// ticekts sold per movie ticket
	public int calculateTicketsSoldPerMovie(String movieName) {
		int ticketsPerMovie = 0;
		Map<String, Integer> movieTickets= movieBookingRepository.getMovieWiseTicketSales();
		for(Entry<String, Integer> entry : movieTickets.entrySet() ) {
			if(entry.getKey().equals(movieName))
				ticketsPerMovie = entry.getValue();
		}
		return ticketsPerMovie;
	}
}
