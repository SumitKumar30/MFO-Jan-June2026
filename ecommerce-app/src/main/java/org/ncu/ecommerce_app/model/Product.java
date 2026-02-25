package org.ncu.ecommerce_app.model;

import java.util.Date;

public class Product {
	private long productId;
	private String productName;
	private double productPrice;
	private double productQuantity;
//	private String productDescription;
//	private Date productManufactureDate;
	
	public Product(long productId, String productName, double productPrice, double productQuantity) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productQuantity = productQuantity;
//		this.productDescription = productDescription;
//		this.productManufactureDate = productManufactureDate;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public double getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}
	public double getProductQuantity() {
		return productQuantity;
	}
	public void setProductQuantity(double productQuantity) {
		this.productQuantity = productQuantity;
	}

	/*
	 * public String getProductDescription() { return productDescription; } public
	 * void setProductDescription(String productDescription) {
	 * this.productDescription = productDescription; } public Date
	 * getProductManufactureDate() { return productManufactureDate; } public void
	 * setProductManufactureDate(Date productManufactureDate) {
	 * this.productManufactureDate = productManufactureDate; }
	 */
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productPrice=" + productPrice
				+ ", productQuantity=" + productQuantity + "]";
	}
	
}
