package com.online.exam.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.exam.model.QCategory;

@Repository
public class CategoryDaoImpl implements CategoryDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	public Long saveCategory(QCategory category) {
		
		Session session = null;
		Transaction tx=null;
		Long id = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			id = (Long) session.save(category);
			tx.commit();
		}
		catch(Exception exception){
			System.out.println("Exception in saving Category:"+exception);
			tx.rollback();
		}
		finally{
			session.close();
		}
		return id;
	}
	
	@SuppressWarnings("unchecked")
	public List<QCategory> getAllCategory() {
		Session session = null;
		Transaction tx=null;
		List<QCategory> list = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			list = session.createCriteria(QCategory.class).list();
			tx.commit();
		}
		catch(Exception exception){
			System.out.println("Exception in fetching Category:"+exception);
			tx.rollback();
		}
		finally{
			session.close();
		}
		return list;
	}

	public QCategory findById(Long cId) {
		Session session = null;
		Transaction tx=null;
		QCategory category = null;
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			category = (QCategory) session.get(QCategory.class, cId);
			tx.commit();
		}
		catch(Exception exception){
			System.out.println("Exception in fetching Category:"+exception);
			tx.rollback();
		}
		finally{
			session.close();
		}
		return category;
	}

	public void deleteCategory(QCategory category) {

		Session session = null;
		Transaction tx=null;
		Serializable id = new Long(category.getCid());
		Object persistentInstance = null;
		
		try{
			session = sessionFactory.openSession();
			tx = session.beginTransaction();
			persistentInstance = session.load(QCategory.class, id);
			if (persistentInstance != null) {
			    session.delete(persistentInstance);
			}
			tx.commit();
		}
		catch(Exception exception){
			System.out.println("Exception in deleting Category:"+exception);
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
