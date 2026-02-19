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
		movieBookingService.acceptBooking(106, "Border", "Amit", 10);
		
		System.out.println("Movie Booked successfully!!");
		movieBookingService.acceptBooking(107, "Inception", "Abhishek", 4);
		System.out.println("Movie Booked successfully!!");
		
		movieBookingService.acceptBooking(108, "Interstellar", "Kartik", 6);
		System.out.println("Movie Booked successfully!!");
		
		movieBookingService.acceptBooking(109, "Wanted", "Deepesh", 10);
		System.out.println("Movie Booked successfully!!");
		
		movieBookingService.acceptBooking(110, "Mission Impossible - VII", "Ankush", 8);
		System.out.println("Movie Booked successfully!!");
		
		movieBookingService.acceptBooking(111, "Interstellar", "Ankush", 8);
		System.out.println("Movie Booked successfully!!");
		
		System.out.println("================ All Movie Bookings ============");
		
		
		  List<MovieBooking> list= movieBookingService.fetchAllBookings();
		  
		  for(MovieBooking mBooking : list) System.out.println(mBooking);
		 
		
		  movieBookingService.fetchAllBookings().forEach(movieBooking ->
		  System.out.println(movieBooking));
		  
		  System.out.println("================ Find Movie Booking ============");
		  
		  System.out.println(movieBookingService.fetchMovieBookingById(109));
		  
		  System.out.println("================ Update Movie Booking ============");
		  
		  System.out.println(movieBookingService.updateBooking(109, "Batman Begins",
		  "Gaurav", 14));
		  
		  System.out.println("================ Remove Movie Booking ============");
		  
		  movieBookingService.deleteBooking(109).forEach(movieBooking -> System.out.println(movieBooking));
		  
		  System.out.println("==================== Total Tickets Sold ============================");
		  System.out.println(movieBookingService.calculateTotalTicketsSold());
		  
		  System.out.println("========================== Tickets Sold Per Movie =========================");
		  System.out.println("Tickets sold for give movie: "+movieBookingService.calculateTicketsSoldPerMovie("Interstellar"));
		 
	}

}
