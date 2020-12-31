package com.group2.wmproducts.service;

import java.util.HashMap;
import java.util.List;

import com.group2.wmproducts.model.OrderBean;
import com.group2.wmproducts.model.ProductBean;

public interface OrderService {
	public abstract	HashMap<String, Integer> getCart(String userId);
	public abstract String findUserIdbyEmail(String Email);
	public abstract	List<String> createOrder(String userId, HashMap<String, Integer> cartProducts);
	public abstract List<OrderBean> getMyOrders(String userId);
	public abstract List<OrderBean> getAllOrders();
	public abstract List<ProductBean> getProducts(List<OrderBean> orders);
	public abstract String emptyCart(String userId);
}
