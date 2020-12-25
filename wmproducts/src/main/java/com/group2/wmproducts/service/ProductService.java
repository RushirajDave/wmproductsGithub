package com.group2.wmproducts.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.group2.wmproducts.model.ProductBean;

public interface ProductService {
	public abstract void newProduct(ProductBean product, MultipartFile productImg);
	public abstract ProductBean findProduct(String productId);
	public abstract List<ProductBean> getAllProducts();
}
