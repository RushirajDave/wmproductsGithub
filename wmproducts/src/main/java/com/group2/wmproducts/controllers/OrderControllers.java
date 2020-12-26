package com.group2.wmproducts.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.group2.wmproducts.model.OrderBean;
import com.group2.wmproducts.model.SessionData;
import com.group2.wmproducts.model.UserBean;
import com.group2.wmproducts.service.OrderService;
import com.group2.wmproducts.service.ProductService;

@Controller
public class OrderControllers {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/newOrder")
	public String newOrder(@SessionAttribute("sessiondata") SessionData sessiondata, Model model) {
		String userId = orderService.findUserIdbyEmail(sessiondata.userEmailId);
		HashMap<String, Integer> cartProducts = orderService.getCart(userId);
		orderService.createOrder(userId, cartProducts);
	    return "home";
	}
	@GetMapping("/myOrders")
	public String myOrders(@SessionAttribute("sessiondata") SessionData sessiondata, Model model) {
		String userId = orderService.findUserIdbyEmail(sessiondata.userEmailId);
		orderService.getMyOrders(userId);
		return "orderHistory";
	}
	@GetMapping("/adminOrders")
	public String adminOrders(@SessionAttribute("sessiondata") SessionData sessiondata, Model model) {
		List<OrderBean> ordersorder = orderService.getAllOrders();
		return "manageOrders";
	}
}
