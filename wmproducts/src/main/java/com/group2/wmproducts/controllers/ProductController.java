package com.group2.wmproducts.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.group2.wmproducts.model.ProductBean;
import com.group2.wmproducts.service.ProductService;

@Controller
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/newProduct")
	public String newProduct(Model model) {
		ProductBean product = new ProductBean();
        model.addAttribute("product", product);
		return "newProduct";
	}
	
	@PostMapping("/newProduct")
	public String submitForm(@ModelAttribute("product") ProductBean product, Model model) {
		System.out.println(product.getProductName());
		productService.newProduct(product);
	    return "newProduct";
	}

}
