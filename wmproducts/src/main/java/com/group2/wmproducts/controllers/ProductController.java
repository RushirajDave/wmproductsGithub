package com.group2.wmproducts.controllers;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.multipart.MultipartFile;

import com.group2.wmproducts.model.ProductBean;
import com.group2.wmproducts.model.SessionData;
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
	
	@GetMapping("/updateProduct")
	public String updateProduct(@ModelAttribute("productIdupdate") String productId, Model model) {
		ProductBean product = productService.findProduct(productId);
        model.addAttribute("product", product);
		return "updateProduct";
	}
	
	@PostMapping("/updateProduct")
	public String updateProductForm(@ModelAttribute("product") ProductBean product, @RequestParam(value = "productImg", required = false) MultipartFile productImg, Model model) {
		productService.updateProduct(product, productImg);
	    return "redirect:/allProducts";
	}
	
	@PostMapping("/newProduct")
	public String submitForm(@ModelAttribute("product") ProductBean product, @RequestParam(value = "productImg", required = false) MultipartFile productImg, Model model) {
		System.out.println(product.getProductName());
		productService.newProduct(product, productImg);
	    return "newProduct";
	}
	
	@GetMapping("/Product")
	public String Product(@SessionAttribute("sessiondata") SessionData sessiondata, @RequestParam(value = "productId", required = true) String productId, Model model) {
		ProductBean product = productService.findProduct(productId);
        model.addAttribute("product", product);
        model.addAttribute("productImg", Base64.getEncoder().encodeToString(product.getProductImage().getData()) );
        System.out.println(sessiondata.userEmailId);
		return "viewProduct";
	}
	
	@GetMapping("/WMProducts")
	public String searchProducts(Model model) {
		List<ProductBean> productBeanList = productService.getAllProducts();
		List<String> productImg = new ArrayList<String>();
		System.out.println(productBeanList.toString());
		for(int i=0; i<productBeanList.size(); i++) {
			productImg.add(Base64.getEncoder().encodeToString(productBeanList.get(i).getProductImage().getData()));
			model.addAttribute("productImg", productImg );
		}
        model.addAttribute("productList", productBeanList);
		return "index";
	}
	@GetMapping("/search")
	public String searchMyProducts(@RequestParam(value = "search", required = true) String search,Model model) {
		List<ProductBean> productBeanList = productService.getSearchProducts(search);
		List<String> productImg = new ArrayList<String>();
		System.out.println(productBeanList.toString());
		for(int i=0; i<productBeanList.size(); i++) {
			productImg.add(Base64.getEncoder().encodeToString(productBeanList.get(i).getProductImage().getData()));
			model.addAttribute("productImg", productImg );
		}
        model.addAttribute("productList", productBeanList);
		return "index";
	}
	
	@GetMapping("/allProducts")
	public String allProducts(Model model) {
		List<ProductBean> productBeanList = productService.getAllProducts();
		List<String> productImg = new ArrayList<String>();
		System.out.println(productBeanList.toString());
		for(int i=0; i<productBeanList.size(); i++) {
			productImg.add(Base64.getEncoder().encodeToString(productBeanList.get(i).getProductImage().getData()));
			model.addAttribute("productImg", productImg );
		}
        model.addAttribute("productList", productBeanList);
		return "manageProducts";
	}
	
	@GetMapping("/deleteProduct")
	public String deleteProduct(@RequestParam(value = "productId", required = true) String productId, Model model) {
		productService.deleteProduct(productId);
		return "redirect:/allProducts";
	}
}
