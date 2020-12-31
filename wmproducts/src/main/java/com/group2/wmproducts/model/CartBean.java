package com.group2.wmproducts.model;

import java.util.HashMap;

public class CartBean {
	private String cartId;
	private String userId;
	private HashMap<String, Integer> cartProducts;
	
	public CartBean() {
		super();
	}
	public CartBean(String userId, HashMap<String, Integer> cartProducts) {
		super();
		this.userId = userId;
		this.cartProducts = cartProducts;
	}
	public String getCartId() {
		return cartId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public HashMap<String, Integer> getCartProducts() {
		return cartProducts;
	}
	public void setCartProducts(HashMap<String, Integer> cartProducts) {
		this.cartProducts = cartProducts;
	}
	
	
}
