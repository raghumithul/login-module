package com.loginpoc.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.loginpoc.demo.repositories.UserRepository;

@Controller
public class DemoController {
	
	
	@Autowired
	private UserRepository userRepository;

	@RequestMapping(value="/login", method=RequestMethod.GET)
	public ModelAndView hello(){
		ModelAndView mav = new ModelAndView();
		String output = "hello world !";
		mav.addObject("message", output);
		return mav;
	}
}
