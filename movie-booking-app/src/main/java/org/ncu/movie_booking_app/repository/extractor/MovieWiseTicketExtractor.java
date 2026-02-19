package org.ncu.movie_booking_app.repository.extractor;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;



public class MovieWiseTicketExtractor implements ResultSetExtractor<Map<String, Integer>> {

	@Override
	public Map<String, Integer> extractData(ResultSet rs) throws SQLException, DataAccessException {
		Map<String, Integer> movieTicketsMap = new HashMap<>();
		while(rs.next()) {
			String movieName = rs.getString("moviename");
			int tickets = rs.getInt("tickets");
			
			if(movieTicketsMap.containsKey(movieName)) {
				int totalTickets = movieTicketsMap.get(movieName);
				movieTicketsMap.put(movieName, totalTickets+tickets);
			}else {
				movieTicketsMap.put(movieName, tickets);
			}
		}
		return movieTicketsMap;
	}

}
