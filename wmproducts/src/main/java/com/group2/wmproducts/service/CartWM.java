package com.group2.wmproducts.service;

import java.util.HashMap;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "carts")
public class CartWM {
	@Id
	private String cartId;
	private String userId;
	private HashMap<String, Integer> cartProducts;
	public CartWM(String userId) {
		super();
		this.userId = userId;
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
