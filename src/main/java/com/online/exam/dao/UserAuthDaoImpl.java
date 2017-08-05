package com.online.exam.dao;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.online.exam.model.UserAuth;

@Repository
public class UserAuthDaoImpl implements UserAuthDao {

	@Autowired
	private SessionFactory sessionFactory;
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public void save(UserAuth userAuth) {
		
		Session session =	sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try{
			session.save(userAuth);
			tx.commit();
		}
		catch(Exception exception){
			System.out.println("Exception in saving userAuth:"+exception);
			tx.rollback();
		}
	}

    public UserAuth getUserAuthDetails( String userID ) throws HibernateException 
    {
        Session session = sessionFactory.openSession();
        Transaction tx = null;
        try
        {
            tx = session.beginTransaction();
            String queryStr = "SELECT * FROM UserAuth WHERE users_id = :theUserID"; 
            Query query = session.createSQLQuery( queryStr ).addEntity( UserAuth.class );
            query.setParameter("theUserID", userID);

            UserAuth user = (UserAuth)query.uniqueResult();
            System.out.println("User Name:"+user.getUserID());
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
