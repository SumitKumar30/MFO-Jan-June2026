package org.ncu.ecommerce_app.controller;

import java.util.Map;

import org.ncu.ecommerce_app.model.Product;
import org.ncu.ecommerce_app.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ecommerce_app")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	
	/*
	 * @GetMapping(value = "/hello") public String sayHello() { return
	 * "Hello Spring Web!!"; }
	 * 
	 * @GetMapping(value = "/msg") public Map<String,String> getMessageInJson(){ //
	 * give response in json format return Map.of("message","Hello Spring Web!"); }
	 */
	
	// saving product
	@PostMapping(value = "/save")
	public String saveProduct(@RequestBody Product product) {
		// productService.saveProduct(product)
		return "Product Saved Successfully!!!";
	}
	
	@DeleteMapping(value = "/delete/{id}")
	public String deleteProductById(@PathVariable int id) {
		// productService.deleteProduct(id)
		return "product deleted successsfully";
	}
	
	@PutMapping(value = "/update/{id}")
	public String updateProductById(@PathVariable int id, @RequestBody Product product) {
		// productService.updateProduct
		return "Product updated successfully";
	}
	
}
