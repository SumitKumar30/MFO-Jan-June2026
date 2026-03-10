package org.ncu.ecommerce_app.dao;

import org.ncu.ecommerce_app.model.CartItem;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CartItemDao {
private final JdbcTemplate jdbcTemplate;
	
	public CartItemDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	public void saveCartItem(CartItem cartItem) {
		 String sqlString = "insert into cartitem VALUES (?, ?, ?, ?)";
		 int rowsUpdated = jdbcTemplate.update(sqlString, cartItem.getCartItemId(), cartItem.getCustomerId(), cartItem.getProductId(), cartItem.getQuantity());
		 if(rowsUpdated == 0)
			 throw new RuntimeException("Error saving cartItems!!");
	 }
}
