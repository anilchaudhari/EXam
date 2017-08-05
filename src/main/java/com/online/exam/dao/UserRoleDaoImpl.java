package com.online.exam.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.online.exam.model.Role;

@Repository
public class UserRoleDaoImpl implements UserRoleDao {

	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void save(Role role) {
			
		Session session =	sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			session.save(role);
			tx.commit();
		}
		catch(Exception exception){
			System.out.println("Exception in saving userRole:"+exception);
			tx.rollback();
		}
		
	}
	 public  Role getUserRoleDetails( String userID ) throws HibernateException 
     {
         Session session = sessionFactory.openSession();
         Transaction tx = null;
         try
         {
             tx = session.beginTransaction();
             String queryStr = "SELECT * FROM users_roles WHERE user_mail_id = :theUserID"; 
             Query query = session.createSQLQuery( queryStr ).addEntity(Role.class );
             query.setParameter("theUserID", userID);

            Role user = (Role)query.uniqueResult();

             tx.commit();

             return user;
         }
         catch (HibernateException ex) 
         {
             tx.rollback();
             ex.printStackTrace();
             throw ex;
         }
         finally {
             session.close();
         }
     }


}
