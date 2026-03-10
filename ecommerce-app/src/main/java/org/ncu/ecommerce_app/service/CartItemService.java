package org.ncu.ecommerce_app.service;

import org.ncu.ecommerce_app.dao.CartItemDao;
import org.ncu.ecommerce_app.dao.CustomerDao;
import org.ncu.ecommerce_app.dao.ProductDao;
import org.ncu.ecommerce_app.model.CartItem;
import org.ncu.ecommerce_app.model.Customer;
import org.ncu.ecommerce_app.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartItemService {
	@Autowired
	private CartItemDao cartItemDao;
	@Autowired
	private CustomerDao customerDao;
	@Autowired
	private ProductDao productDao;
	
	public String saveCartItems(int cartItemId, int customerId, long productId, double quantity) {
		Customer customer = customerDao.findByCustomerId(customerId);
		
		if(customer == null)
			throw new RuntimeException("Customer Not Found!!");
		
		Product product = productDao.findByProductId(productId);
		
		if(product == null)
			throw new RuntimeException("Product Not Found!!");
		
		if(product.getProductQuantity() < 1)
			throw new IllegalArgumentException("Product Quantity must not be 0!");
		
		CartItem cartItem = new CartItem(
					cartItemId,
					customer.getCustomerId(),
					product.getProductId(),
					product.getProductQuantity()
				);
		
		
		cartItemDao.saveCartItem(cartItem);
		return "cart item save successfully!";
	}
}
