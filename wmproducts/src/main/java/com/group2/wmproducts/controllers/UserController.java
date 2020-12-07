package com.group2.wmproducts.controllers;

import java.util.Map;

import org.springframework.boot.autoconfigure.cassandra.CassandraProperties.Request;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.group2.wmproducts.model.User;

@Controller
public class UserController {
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	@GetMapping("/signup")
	public String sighup() {
		return "signup";
	}
	@RequestMapping(value = "registration",method = RequestMethod.GET)
	public String registration(@ModelAttribute("registrationForm") User user, Map<String, String> model) {
		System.out.println("registration called!");
		System.out.println("username: " + user.getfName()+" "+ user.getlName());
		return "login";
	}
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	
}
