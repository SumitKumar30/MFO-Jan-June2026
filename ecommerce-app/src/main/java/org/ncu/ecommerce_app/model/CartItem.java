package org.ncu.ecommerce_app.model;

public class CartItem {
	private int cartItemId;
	private int customerId;
	private long productId;
	private double quantity;
	public CartItem(int cartItemId, int customerId, long productId, double quantity) {
		super();
		this.cartItemId = cartItemId;
		this.customerId = customerId;
		this.productId = productId;
		this.quantity = quantity;
	}
	public int getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(int cartItemId) {
		this.cartItemId = cartItemId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}
	public double getQuantity() {
		return quantity;
	}
	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "CartItem [cartItemId=" + cartItemId + ", customerId=" + customerId + ", productId=" + productId
				+ ", quantity=" + quantity + "]";
	}
	
}
