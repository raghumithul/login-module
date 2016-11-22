package com.loginpoc.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.loginpoc.demo.model.Users;

public interface UserRepository extends MongoRepository<Users, String> {

}
