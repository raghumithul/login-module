package com.loginpoc.demo.repositories;

import java.util.Collection;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.loginpoc.demo.model.Account;

public interface AccountRepository extends MongoRepository<Account, String> {

	public Account findByUsername(String username);
	
	public 	Collection<Account> getAllAccounts();
}
