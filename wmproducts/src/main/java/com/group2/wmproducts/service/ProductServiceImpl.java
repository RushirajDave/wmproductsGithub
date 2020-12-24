package com.group2.wmproducts.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.group2.wmproducts.model.ProductBean;
import com.group2.wmproducts.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public void newProduct(ProductBean product) {
		ProductWM productmongo = new ProductWM(product.getProductId(), product.getProductName(), product.getProductCatagory(), product.getProductPrice(), product.getProductQty(), product.getProductSaller(), product.getProductDiscription(), 0);
		this.productRepository.save(productmongo);
		System.out.println("user saved in Mongodb");

	}

}
