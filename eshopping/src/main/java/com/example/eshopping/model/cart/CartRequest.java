package com.example.eshopping.model.cart;

import com.example.eshopping.entity.Cart;

public class CartRequest {

	private String productId;
	private String userId;
	private String cartId;
	private int quantity;
	private boolean updateCart;
	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getCartId() {
		return cartId;
	}

	public void setCartId(String cartId) {
		this.cartId = cartId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public boolean isUpdateCart() {
		return updateCart;
	}

	public void setUpdateCart(boolean updateCart) {
		this.updateCart = updateCart;
	}
	
	
}
