package com.group2.wmproducts.controllers;

import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.group2.wmproducts.model.ProductBean;
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
		return "redirect:/WMProducts";
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
		String userId = userService.createUser(user);
		userService.assignCart(userId);
	    return "login";
	}
	@GetMapping("/home")
	public String home() {
		return "index";
	}
	@PostMapping("/addToCart")
	public String addToCart(@SessionAttribute("sessiondata") SessionData sessiondata, @RequestParam(value = "productId", required = true) String productId, @RequestParam(value = "productQty", required = true) String productQty) {
		String userId = userService.findUserIdbyEmail(sessiondata.userEmailId);
		userService.addToCart(userId, productId, productQty);
		return "home";
	}
	@GetMapping("/cart")
	public String cart(@SessionAttribute("sessiondata") SessionData sessiondata, Model model) {
		String userId = userService.findUserIdbyEmail(sessiondata.userEmailId);
		HashMap<String, Integer> cartProducts = userService.getCartProducts(userId);
		List<Integer> productQtyList = new ArrayList<Integer>();
		List<ProductBean> cartProductsList = new ArrayList<ProductBean>();
		List<String> productImgList = new ArrayList<String>();
		ProductBean product = new ProductBean();
		for (Map.Entry<String,Integer> entry : cartProducts.entrySet())  {
			product = userService.getCartProduct(entry.getKey());
			cartProductsList.add(product);
			productQtyList.add(entry.getValue());
		}
		for(int i=0; i<cartProductsList.size(); i++) {
			productImgList.add(Base64.getEncoder().encodeToString(cartProductsList.get(i).getProductImage().getData()));
			model.addAttribute("productImg", productImgList );
		}
		System.out.println(cartProducts);
		System.out.println(cartProductsList);
		System.out.println(productQtyList);
		model.addAttribute("mycartProduct", cartProductsList);
		model.addAttribute("mycartQty", productQtyList);
		return "cart";
	}
	
	@GetMapping("/logout")
	public String logout() {
		return "login";
	}
}
