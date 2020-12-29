package com.group2.wmproducts.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.group2.wmproducts.service.ProductWM;

public interface ProductRepository extends MongoRepository<ProductWM, String> {
	public ProductWM findByProductId(String productId);
	public ProductWM findByProductName(String productName);
	public List<ProductWM> findByProductNameLike(String search);
}
