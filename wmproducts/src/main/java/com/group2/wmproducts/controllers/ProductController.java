package com.group2.wmproducts.controllers;

import java.util.Base64;
import java.util.List;

import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.group2.wmproducts.model.ProductBean;
import com.group2.wmproducts.service.ProductService;
import com.group2.wmproducts.service.ProductWM;

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
	public String submitForm(@ModelAttribute("product") ProductBean product, @RequestParam(value = "productImg", required = false) MultipartFile productImg, Model model) {
		System.out.println(product.getProductName());
		productService.newProduct(product, productImg);
	    return "newProduct";
	}
	
	@GetMapping("/Product")
	public String Product(@RequestParam(value = "productId", required = true) String productId, Model model) {
		ProductBean product = productService.findProduct(productId);
        model.addAttribute("product", product);
        model.addAttribute("productImg", Base64.getEncoder().encodeToString(product.getProductImage().getData()) );
		return "viewProduct";
	}
	
	@GetMapping("/WMProducts")
	public String searchProducts(Model model) {
		List<ProductBean> productBeanList = productService.searchProducts();
		System.out.println(productBeanList.toString());
        model.addAttribute("productList", productBeanList);
		return "index";
	}
}
