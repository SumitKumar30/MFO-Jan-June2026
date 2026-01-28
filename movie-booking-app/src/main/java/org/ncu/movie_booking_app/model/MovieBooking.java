package org.ncu.movie_booking_app.model;

public class MovieBooking{
	int bookingId;
	String movieName;
	String customerName;
	int noOfTickets;
	public MovieBooking(int bookingId, String movieName, String customerName, int noOfTickets) {
		super();
		this.bookingId = bookingId;
		this.movieName = movieName;
		this.customerName = customerName;
		this.noOfTickets = noOfTickets;
	}
	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public int getNoOfTickets() {
		return noOfTickets;
	}
	public void setNoOfTickets(int noOfTickets) {
		this.noOfTickets = noOfTickets;
	}
	
	@Override
	public String toString() {
		return "MovieBooking [bookingId=" + bookingId + ", movieName=" + movieName + ", customerName=" + customerName
				+ ", noOfTickets=" + noOfTickets + "]";
	}
	
}
