package com.hibernate.util;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.chapter1.Employee;

public class HibernateUtil {

	private static SessionFactory sessionFactory = null;
	private static ServiceRegistry serviceRegistry;
	private static Configuration configuration;
	
	private static void buildSessionFactory(){
		configuration = new Configuration().configure("hibernate.cfg.xml");
        
		configuration.addAnnotatedClass(Employee.class);
		
		serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
		sessionFactory = configuration.buildSessionFactory(serviceRegistry);

	}
	
	public static synchronized SessionFactory getSessionFactory(){
		if(sessionFactory==null){
			buildSessionFactory();
		}
		return sessionFactory;
	}
	
	
	public static void shutDown(){
		if(sessionFactory!=null){			
			sessionFactory.close();
			sessionFactory=null;
		}
	}
}
