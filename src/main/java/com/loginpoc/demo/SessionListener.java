package com.loginpoc.demo;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@WebListener
public class SessionListener implements HttpSessionListener {
	
	private HttpSession session = null;

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		// no need to do anything here as connection may not have been established yet
        session  = event.getSession();
        System.out.println("Session created for id " + session.getId());
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		session  = event.getSession();
	    if(session.getId()==null){
	    	System.out.println("session destroyed");
	    }
		
	}

}
