package com.group2.wmproducts.service;

import java.util.HashMap;
import java.util.List;

import com.group2.wmproducts.model.ProductBean;
import com.group2.wmproducts.model.UserBean;

public interface UserService {
	public abstract String createUser(UserBean user);
	public abstract void assignCart(String userId);
	public abstract String verifyUser(UserBean user);
	public abstract String findUserIdbyEmail(String Email);
	public abstract String addToCart(String userId, String productId, String productQty);
	public abstract HashMap<String, Integer> getCartProducts(String userId);
	public abstract ProductBean getCartProduct(String productId);
}
