package com.online.exam.dao;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.exam.model.Users;
@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	public Long save(Users users) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			Long savedUsersId = (Long) session.save(users);
			tx.commit();
			
			return savedUsersId;
		}
		catch(Exception exception){
			System.out.println("Exception in save users:"+exception);
			tx.rollback();
			return null;
		}	
		finally{
			session.close();
		}
	}

	public Users findById(Long userId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			Users users = (Users) session.get(Users.class, userId);
			tx.commit();
			return users;
		}
		catch(Exception exception){
			System.out.println("Exception in fetching users:"+exception);
			tx.rollback();
			return null;
		}
		finally{
			session.close();	
		}
	}

}
