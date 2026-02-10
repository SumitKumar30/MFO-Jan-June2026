package org.ncu.movie_booking_app.repository;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.ncu.movie_booking_app.model.MovieBooking;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MovieBookingRepository {
//	List<MovieBooking> movieBookings = new ArrayList<>();
	
	private JdbcTemplate jdbcTemplate;
	
	// injecting jdbcTemplate bean into MovieBookingRepository bean
	public MovieBookingRepository(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private RowMapper<MovieBooking> rowMapper = (rs, rowNum) -> new MovieBooking(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4));
	
	// save all the movie booking objects
	public void saveMovieBookings(MovieBooking movieBooking) {
		String sqlString = "insert into moviebooking values (?, ?, ?, ?)";
		jdbcTemplate.update(sqlString, movieBooking.getBookingId(), movieBooking.getMovieName(), movieBooking.getCustomerName(), movieBooking.getNoOfTickets());
//		movieBookings.add(movieBooking);
	}
	
	// retrieve all movie bookings
	public List<MovieBooking> retriveBookings(){
		String sqlString = "select bookingid, moviename, customername, tickets from moviebooking";
		return jdbcTemplate.query(sqlString, rowMapper);
		//return movieBookings;
	}
	
	// find a movie booking by id
	public MovieBooking retrieveBookingById(int bookingId) {
		/*
		 * boolean flag = false; for(MovieBooking mb : movieBookings) {
		 * if(mb.getBookingId() == bookingId) { flag = true; return mb; } }
		 * 
		 * if(!flag) throw new RuntimeException("Booking not found!!"); return null;
		 */
		String sqlString = "select bookingid, moviename, customername, tickets from moviebooking where bookingid = ?";
		return jdbcTemplate.queryForObject(sqlString, rowMapper, bookingId);
	}
	
	// update a movie booking
	
	public List<MovieBooking> updateBookingById(int bookingId, String movieName, String customerName, int tickets) {
//		MovieBooking booking = retrieveBookingById(bookingId);
//		booking.setCustomerName(customerName);
//		booking.setMovieName(movieName);
//		booking.setNoOfTickets(tickets);
		
		/*
		 * List<MovieBooking> bookings = retriveBookings(); int index = 0;
		 * for(MovieBooking b : bookings) { if(b.getBookingId() == bookingId){
		 * b.setCustomerName(customerName); b.setMovieName(movieName);
		 * b.setNoOfTickets(tickets); bookings.set(index, b); } index++; } return
		 * bookings;
		 */
		
		String sqlString = "update moviebooking set moviename = ?, customername = ?, tickets = ? where bookingid = ?";
		int rows = jdbcTemplate.update(sqlString, movieName, customerName, tickets, bookingId);
		if(rows > 0)
			return retriveBookings();
		else {
			throw new IllegalArgumentException("Invalid Booking Id");
		}
	}
	
	
	// delete a movie booking by id
	public List<MovieBooking> deleteBookingById(int bookingId){
		/*
		 * MovieBooking booking = retrieveBookingById(bookingId);
		 * movieBookings.remove(booking); return movieBookings;
		 */
		String sqlString = "delete from moviebooking where bookingid = ?";
		int rows = jdbcTemplate.update(sqlString, bookingId);
		if(rows > 0)
			return retriveBookings();
		else {
			throw new IllegalArgumentException("Record not found!!");
		}
	}
}
