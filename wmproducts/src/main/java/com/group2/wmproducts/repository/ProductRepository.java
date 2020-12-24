package com.group2.wmproducts.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.group2.wmproducts.service.ProductWM;
import com.group2.wmproducts.service.UserWM;

public interface ProductRepository extends MongoRepository<ProductWM, String> {
	public ProductWM findByProductName(String ProductName);
}
