package com.loginpoc.demo.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.loginpoc.demo.model.Token;

public interface TokenRepository extends MongoRepository<Token, String> {
    Token findBySeries(String series);
    Token findByUsername(String username);
}
