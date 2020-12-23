package com.group2.wmproducts.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.group2.wmproducts.service.UserWM;


public interface UserRepository extends MongoRepository<UserWM, String> {
	public UserWM findByFirstName(String firstName);
	public UserWM findByUserEmail(String userEmail);
}
