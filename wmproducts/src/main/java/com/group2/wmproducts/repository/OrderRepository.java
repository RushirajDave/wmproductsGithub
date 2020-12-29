package com.group2.wmproducts.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.group2.wmproducts.service.OrderWM;

public interface OrderRepository  extends MongoRepository<OrderWM, String> {
	public List<OrderWM> findByUserId(String userId);
}
