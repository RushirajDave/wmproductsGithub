package com.group2.wmproducts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.group2.wmproducts.model.SessionData;
import com.group2.wmproducts.model.UserBean;
import com.group2.wmproducts.service.UserService;

@Controller
@SessionAttributes({"sessiondata"})
public class UserController {
	
	@ModelAttribute("sessiondata")
	public SessionData sessiondata() {
		return new SessionData();
	}
	
	@Autowired
	UserService userService;
	
	@GetMapping("/login")
	public String login(Model model) {
		UserBean user = new UserBean();
        model.addAttribute("user", user);
		return "login";
	}
	@PostMapping("/login")
	public String verifyLogin(@ModelAttribute("user") UserBean user, Model model) {
		SessionData sessionEmailID = new SessionData(userService.verifyUser(user));
		model.addAttribute("sessiondata", sessionEmailID);
	    return "home";
	}
	@GetMapping("/signup")
	public String sighup(Model model) {
		UserBean user = new UserBean();
        model.addAttribute("user", user);
        return "signup";
	}
	@PostMapping("/signup")
	public String submitForm(@ModelAttribute("user") UserBean user) {
		System.out.println("Controller called");
		System.out.println("UserService called");
		userService.createUser(user);
	    return "login";
	}
	@GetMapping("/home")
	public String home() {
		return "home";
	}
}
