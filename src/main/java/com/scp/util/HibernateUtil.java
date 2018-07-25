package com.scp.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
//This is a util method used to create session factory object
public class HibernateUtil {
	private static  SessionFactory sessionfactory=null;
	
	public static SessionFactory getSessionFactory(){
		if (sessionfactory==null){
			sessionfactory=new Configuration().configure().buildSessionFactory();
		}
		return sessionfactory;
	}

	
	public static void flushNcommit(Session session ,Transaction tr){
		if(session!=null){
			session.flush();
		}
		if(tr!=null){
			tr.commit();
		}
	}
 public static void closeSession(Session session){
	 if (session!=null){
		 session.close();
	 }
 }	
	
	
	
}
