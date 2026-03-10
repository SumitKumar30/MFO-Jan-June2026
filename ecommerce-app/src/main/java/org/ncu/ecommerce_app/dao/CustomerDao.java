package org.ncu.ecommerce_app.dao;

import java.util.List;

import org.ncu.ecommerce_app.model.Customer;
import org.ncu.ecommerce_app.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerDao {
private final JdbcTemplate jdbcTemplate;
	
	public CustomerDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private final RowMapper<Customer> rowMapper = (rs, rowNum) -> new Customer(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("email")
    );
	
	public void saveCustomer(Customer customer) {
		 String sqlString = "insert into customer VALUES (?, ?, ?)";
		 int rowsUpdated = jdbcTemplate.update(sqlString, customer.getCustomerId(), customer.getCustomerName(), customer.getCustomerEmail());
		 if(rowsUpdated == 0)
			 throw new RuntimeException("Error saving customer!!");
	 }
	
	 public List<Customer> findAll() {
	        String sql = "SELECT id, name, email FROM customer";
	        return jdbcTemplate.query(sql, rowMapper);
	 }
	 
	 public Customer findByCustomerId(int id) {
		 String sqlString = "select id, name, email FROM customer WHERE id = ?";
		 return jdbcTemplate.queryForObject(sqlString, rowMapper, id);
	 }
}
