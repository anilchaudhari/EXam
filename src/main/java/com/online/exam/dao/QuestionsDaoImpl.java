package com.online.exam.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.exam.form.QuestionCriteria;
import com.online.exam.model.QCategory;
import com.online.exam.model.Questions;

@Repository
public class QuestionsDaoImpl implements QuestionsDao {

	@Autowired
	private SessionFactory sessionFactory;
	public Long saveQuestions(Questions questions) {
		Session session = null;
		Transaction tx=null;
		Long id = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			id = (Long) session.save(questions);
			tx.commit();
		}
		catch(Exception exception){
			System.out.println("Exception in saving questions:"+exception);
			tx.rollback();
		}
		finally{
			session.close();
		}
		return id;
	}

	public Questions findById(Long qId) {
		Session session = null;
		Transaction tx=null;
		Questions questions = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			questions = (Questions) session.get(Questions.class, qId);
			tx.commit();
		}
		catch(Exception exception){
			System.out.println("Exception in fetching questions:"+exception);
			tx.rollback();
		}
		finally{
			session.close();
		}
		return questions;
	}


	public void deleteQuestionsByCategory(QCategory category) {
		Session session = null;
		Transaction tx=null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Query query = session.createQuery("delete Questions where category_id = :ID");
			query.setParameter("ID", new Long(category.getCid()));
			//session.delete("Questions",category);
			query.executeUpdate();
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

	public void deleteById(Long id) {
		Session session = null;
		Transaction tx=null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Serializable idx = new Long(id.toString());
			Object persistentInstance = session.load(Questions.class, idx);
			if (persistentInstance != null) {
			    session.delete(persistentInstance);
			}
			tx.commit();
		}
		catch(Exception exception){
			System.out.println("Exception in deleting questions by id:"+exception);
			tx.rollback();
		}
		finally{
			session.close();
		}
		
	}

	@SuppressWarnings("unchecked")
	public Questions findByCategory(Long cId) {
		
		Session session = null;
		Transaction tx=null;
		List<Questions> questions = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Questions.class);
			criteria.add(Restrictions.eq("qCategory.cid",cId));
			questions = criteria.list();
			tx.commit();
		}
		catch(Exception exception){
			System.out.println("Exception in deleting Questions:"+exception);
			tx.rollback();
		}
		finally{
			session.close();
		}
		
		return questions.size()>0? questions.get(0):null;
	}
	
	@SuppressWarnings("unchecked")
	public List<Questions> findAllQuestion() {
		Session session = null;
		Transaction tx=null;
		List<Questions> questions = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			questions =  session.createCriteria(Questions.class).list();
			tx.commit();
		}
		catch(Exception exception){
			System.out.println("Exception in fetching Question:"+exception);
			tx.rollback();
		}
		finally{
			session.close();
		}
		return questions;
	}

	@SuppressWarnings("unchecked")
	public List<Questions> findRandomQuestion(QuestionCriteria questionCriteria) {
		Session session = null;
		Transaction tx=null;
		List<Questions> questionList=null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			Criteria criteria = session.createCriteria(Questions.class);
			criteria.add(Restrictions.eq("qCategory.cid", questionCriteria.getCategoryId()));
			criteria.add(Restrictions.sqlRestriction("1=1 order by rand()"));
			criteria.setMaxResults(questionCriteria.getNumberOfQuestion().intValue());
			/*Query query = session.createQuery("FROM Questions ORDER BY rand() where category_id=?").setMaxResults(questionCriteria.getNumberOfQuestion().intValue());			//session.delete("Questions",category);
			query.setParameter("category_id", questionCriteria.getCategoryId());
			questionList=query.list();*/
			questionList = criteria.list();
			tx.commit();
		}
		catch(Exception exception){
			System.out.println("Exception in Random Questions:"+exception);
			tx.rollback();
		}
		finally{
			session.close();
		}
		return questionList;
	}
	
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}


	

}
