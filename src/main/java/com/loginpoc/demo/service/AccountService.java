package com.loginpoc.demo.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.loginpoc.demo.model.Account;
import com.loginpoc.demo.repositories.AccountRepository;

@Component
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	public List<Account> getAllAccountDetails(){
		
		return accountRepository.findAll();
	}
	
	
	public Account getUserByUsername(String username){
		return accountRepository.findByUsername(username);
				
	}
}
