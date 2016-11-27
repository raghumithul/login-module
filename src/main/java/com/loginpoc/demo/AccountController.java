package com.loginpoc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.loginpoc.demo.service.AccountService;

@Controller
public class AccountController {

	@Autowired
	AccountService accountService;
	
	@RequestMapping(path="/accounts", method=RequestMethod.GET)
	public ModelAndView getAccountDeatils(){
		return new ModelAndView("accounts", "account", accountService.getAllAccountDetails());
	}
}
