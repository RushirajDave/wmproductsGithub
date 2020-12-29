package com.group2.wmproducts.controllers;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.group2.wmproducts.model.OrderBean;
import com.group2.wmproducts.model.ProductBean;
import com.group2.wmproducts.model.SessionData;
import com.group2.wmproducts.service.OrderService;

@Controller
public class OrderControllers {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/newOrder")
	public String newOrder(@SessionAttribute("sessiondata") SessionData sessiondata, Model model) {
		String userId = orderService.findUserIdbyEmail(sessiondata.userEmailId);
		HashMap<String, Integer> cartProducts = orderService.getCart(userId);
		List<String> orders= orderService.createOrder(userId, cartProducts);
		orderService.emptyCart(userId);
		System.out.println("all orders string" + orders);
	    return "redirect:/myOrders";
	}
	
	@GetMapping("/myOrders")
	public String myOrders(@SessionAttribute("sessiondata") SessionData sessiondata, Model model) {
		String userId = orderService.findUserIdbyEmail(sessiondata.userEmailId);
		List<OrderBean> orders = orderService.getMyOrders(userId);
		List<ProductBean> products = orderService.getProducts(orders);
		List<String> productImgList = new ArrayList<String>();
		System.out.println("all products" + products);
		System.out.println("all orders" + orders);
		model.addAttribute("orders", orders);
		model.addAttribute("products", products);
		for(int i=0; i<products.size(); i++) {
			productImgList.add(Base64.getEncoder().encodeToString(products.get(i).getProductImage().getData()));
		}
		model.addAttribute("productImg", productImgList );
		return "orderHistory";
	}
	
	@GetMapping("/adminOrders")
	public String adminOrders(Model model) {
		List<OrderBean> orders = orderService.getAllOrders();
		model.addAttribute("orders", orders);
		System.out.println("all orders" + orders);
		return "manageOrders";
	}
}
