package com.online.exam.utility;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

public class Utilities {
	
	@Autowired
	private SessionFactory sessionfactory;
	
	public  Session getSession(){
		
		return sessionfactory.openSession();
	}
	
	public  Transaction getTransaction(Session session){
		
		return session.beginTransaction();
	}
	public SessionFactory getSessionfactory() {
		return sessionfactory;
	}
	public void setSessionfactory(SessionFactory sessionfactory) {
		this.sessionfactory = sessionfactory;
	}
	

}
