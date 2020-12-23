package com.group2.wmproducts.service;

import com.group2.wmproducts.model.UserBean;

public interface UserService {
	public abstract void createUser(UserBean user);
	public abstract String verifyUser(UserBean user);
}
