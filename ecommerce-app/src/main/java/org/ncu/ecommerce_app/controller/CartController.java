package org.ncu.ecommerce_app.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ecommerce_app")
public class CartController {
	
	@PostMapping(value = "/api/cart/add/{cartItemId}/{customerId}/{productId}/{quantity}")
	public String addProductToCart(@PathVariable int cartItemId, @PathVariable int customerId, @PathVariable int productId, @PathVariable double quantity) {
		return null;
	}
}
