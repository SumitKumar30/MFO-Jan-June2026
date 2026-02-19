package org.ncu.movie_booking_app.repository.extractor;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.ncu.movie_booking_app.model.MovieBooking;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;

public class TotalTicketsExtractor implements ResultSetExtractor<Integer> {

	@Override
	public Integer extractData(ResultSet rs) throws SQLException, DataAccessException {
		 int total = 0;

	        while (rs.next()) {
	            int tickets = rs.getInt("tickets");
	            total = total + tickets;
	        }

	        return total;

	}

}
