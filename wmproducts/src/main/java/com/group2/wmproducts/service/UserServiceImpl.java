package com.group2.wmproducts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.group2.wmproducts.model.SessionData;
import com.group2.wmproducts.model.UserBean;
import com.group2.wmproducts.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void createUser(UserBean user) {
		UserWM usermongo = new UserWM(user.getfName(), user.getlName(), user.getmNumber(), user.geteMail(), user.getuPassword());
		this.userRepository.save(usermongo);
		System.out.println("user saved in Mongodb");
		System.out.println(usermongo.toString());
	}
	
	@Override
	public String verifyUser(UserBean user) {
		String userPass = user.getuPassword();
		UserWM usermongo = userRepository.findByUserEmail(user.geteMail());
		String dbUserId;
		String dbPass = usermongo.getUserPassword();
		if(userPass.equals(dbPass)) {
			System.out.println("Login done");
			dbUserId = usermongo.getId();
		} else {
			System.out.println("Login not done");
			dbUserId = "";
		}
		return dbUserId;
	}
}
