package com.group2.wmproducts.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	
}
