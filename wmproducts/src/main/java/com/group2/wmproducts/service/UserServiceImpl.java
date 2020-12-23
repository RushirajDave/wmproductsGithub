package com.group2.wmproducts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.group2.wmproducts.model.UserBean;
import com.group2.wmproducts.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void createUser(UserBean user) {
		System.out.println("UserServiceImpl called");
		UserWM usermongo = new UserWM(user.getfName(), user.getlName(), user.getmNumber(), user.geteMail(), user.getuPassword());
		System.out.println("userRepository called");
		this.userRepository.save(usermongo);
		System.out.println("user saved in Mongodb");
		System.out.println("id " + usermongo.getId());
		System.out.println(usermongo.toString());
	}
	
	@Override
	public String verifyUser(UserBean user) {
		String userPass = user.getuPassword();
		UserWM usermongo = userRepository.findByUserEmail(user.geteMail());
		String dbPass = usermongo.getUserPassword();
		String dbUsername = usermongo.getFirstName();
		if(userPass.equalsIgnoreCase(dbPass))
			System.out.println("done");
		else
			System.out.println("not done");
		
		return dbUsername;
	}
}
