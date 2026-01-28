package org.ncu.movie_booking_app;


import java.util.*;
import org.ncu.movie_booking_app.model.MovieBooking;
import org.ncu.movie_booking_app.service.MovieBookingService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MovieBookingAppApplication implements CommandLineRunner{
	private MovieBookingService movieBookingService;
	
	public MovieBookingAppApplication(MovieBookingService movieBookingService) {
		this.movieBookingService = movieBookingService;
	}

	public static void main(String[] args) {
		SpringApplication.run(MovieBookingAppApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// user input logic
		
		System.out.println("Booking Movies.....");
		movieBookingService.acceptBooking(101, "Dhurandhar", "Rahul", 5);
		
		System.out.println("Movie Booked successfully!!");
		movieBookingService.acceptBooking(102, "Batman", "Abhishek", 3);
		System.out.println("Movie Booked successfully!!");
		
		movieBookingService.acceptBooking(103, "Tere Naam", "Kartik", 6);
		System.out.println("Movie Booked successfully!!");
		
		movieBookingService.acceptBooking(104, "Avengers", "Deepesh", 10);
		System.out.println("Movie Booked successfully!!");
		
		movieBookingService.acceptBooking(105, "Mission Impossible", "Ankush", 8);
		System.out.println("Movie Booked successfully!!");
		
		System.out.println("================ All Movie Bookings ============");
		
		/*
		 * List<MovieBooking> list= movieBookingService.fetchAllBookings();
		 * 
		 * for(MovieBooking mBooking : list) System.out.println(mBooking);
		 */
		
		movieBookingService.fetchAllBookings().forEach(movieBooking -> System.out.println(movieBooking));
	}

}
