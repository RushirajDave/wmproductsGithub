package com.group2.wmproducts.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.group2.wmproducts.service.CartWM;

public interface CartRepository extends MongoRepository<CartWM, String> {
	public CartWM findByUserId(String userId);
}
