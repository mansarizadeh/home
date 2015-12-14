package com.hibernate.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hibernate.chapter1.Employee;
import com.hibernate.util.HibernateUtil;

public class TestEmployee {

	public static void main(String[] args) {

		try {
			SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

			Session session = sessionFactory.openSession();

			Employee emp = new Employee();
			emp.setEmpID(1);
			emp.setEmpName("Mohammadali Ansarizadeh");
			
			session.beginTransaction();
			session.save(emp);
			session.getTransaction().commit();
			
			System.exit(0);
			
		} catch (Exception ex) {

			ex.printStackTrace(System.err);
		}
	}
}
