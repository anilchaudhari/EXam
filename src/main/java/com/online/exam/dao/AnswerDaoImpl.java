package com.online.exam.dao;

import java.io.Serializable;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.exam.model.Answer;
import com.online.exam.model.Questions;

@Repository
public class AnswerDaoImpl implements AnswerDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	public Long saveAnswer(Answer answer) {
		Session session = null;
		Transaction tx=null;
		Long id = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			id = (Long) session.save(answer);
			tx.commit();
		}
		catch(Exception exception){
			System.out.println("Exception in saving answer:"+exception);
			tx.rollback();
		}
		finally{
			session.close();
		}
		return id;
	}

	public void deleteByQuestions(Questions questions) {
		Session session = null;
		Transaction tx=null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Serializable id = new Long(17);
			Object persistentInstance = session.load(Answer.class, id);
			if (persistentInstance != null) {
			    session.delete(persistentInstance);
			}
			tx.commit();
		}
		catch(Exception exception){
			System.out.println("Exception in deleting Questions:"+exception);
			tx.rollback();
		}
		finally{
			session.close();
		}
		
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
