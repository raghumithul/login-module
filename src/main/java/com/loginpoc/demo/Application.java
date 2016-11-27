package com.loginpoc.demo;

import javax.servlet.http.HttpSessionListener;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.web.session.HttpSessionEventPublisher;

@SpringBootApplication
public class Application {	

	
	 public static void main(String[] args) throws Throwable {
	        SpringApplication.run(Application.class, args);
	    }
	 
	 @Bean
	 public HttpSessionListener httpSessionListener(){
		 return new SessionListener();
	 }
	 
	 @Bean
	 public HttpSessionEventPublisher httpSessionEventPublisher() {
	     return new HttpSessionEventPublisher();
	 }
}
