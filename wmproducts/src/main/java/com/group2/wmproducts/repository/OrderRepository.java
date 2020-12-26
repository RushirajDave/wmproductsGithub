package com.group2.wmproducts.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.group2.wmproducts.service.OrderWM;

public interface OrderRepository  extends MongoRepository<OrderWM, String> {
	
}
