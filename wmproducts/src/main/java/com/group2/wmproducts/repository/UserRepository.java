package com.group2.wmproducts.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.group2.wmproducts.model.User;


public interface UserRepository extends MongoRepository<User, String> {
	public User findByFName(String fName);
}
