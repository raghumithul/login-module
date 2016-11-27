package com.loginpoc.demo.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.loginpoc.demo.model.Account;
import com.loginpoc.demo.repositories.AccountRepository;

@Component
public class AccountService {

	@Autowired
	AccountRepository accountRepository;
	
	public Collection<Account> getAllAccountDetails(){
		
		return accountRepository.getAllAccounts();
	}
	
	
	public Account getUserByUsername(String username){
		return accountRepository.findByUsername(username);
				
	}
}
