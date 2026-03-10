package org.ncu.ecommerce_app.dao;

import java.util.List;

import org.ncu.ecommerce_app.model.Product;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDao {
	private final JdbcTemplate jdbcTemplate;
	
	public ProductDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	private final RowMapper<Product> rowMapper = (rs, rowNum) -> new Product(
            rs.getLong("id"),
            rs.getString("name"),
            rs.getDouble("price"),
            rs.getInt("quantity")
    );
	
	 public List<Product> findAll() {
	        String sql = "SELECT id, name, price, quantity FROM products";
	        return jdbcTemplate.query(sql, rowMapper);
	 }
	 
	 public Product findByProductId(long productId) {
		 String sqlString = "select id, name, price, quantity FROM products WHERE id = ?";
		 return jdbcTemplate.queryForObject(sqlString, rowMapper, productId);
	 }
	 
	 public void saveProduct(Product product) {
		 String sqlString = "insert into products VALUES (?, ?, ?, ?)";
		 int rowsUpdated = jdbcTemplate.update(sqlString, product.getProductId(), product.getProductName(), product.getProductPrice(), product.getProductQuantity());
		 if(rowsUpdated == 0)
			 throw new RuntimeException("Error saving product!!");
	 }
	 
	 public boolean update(long id, Product product) {
	        String sql = "UPDATE products SET name = ?, price = ?, quantity = ? WHERE id = ?";
	        int rows = jdbcTemplate.update(sql, product.getProductName(), product.getProductPrice(), product.getProductQuantity(), id);
	        return rows > 0;
	    }

	    public boolean delete(long id) {
	        String sql = "DELETE FROM products WHERE id = ?";
	        int rows = jdbcTemplate.update(sql, id);
	        return rows > 0;
	    }
	 
}
