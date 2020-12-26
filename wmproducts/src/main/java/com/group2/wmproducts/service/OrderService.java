package com.group2.wmproducts.service;

import java.util.HashMap;

public interface OrderService {
	public abstract	HashMap<String, Integer> getCart(String userId);
	public abstract String findUserIdbyEmail(String Email);
	public abstract	void createOrder(String userId, HashMap<String, Integer> cartProducts);
	public abstract String getMyOrders(String userId);
}
