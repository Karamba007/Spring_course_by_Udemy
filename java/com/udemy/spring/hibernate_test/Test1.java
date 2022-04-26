package com.udemy.spring.hibernate_test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.spring.hibernate_test.entity.Employee;

public class Test1 {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		try {
			Session session = factory.getCurrentSession();			
			Employee emp = new Employee("Vitali", "Kasaty", "IT", 5000);
			session.beginTransaction();
			session.save(emp);			
			session.getTransaction().commit();
		} finally {
			factory.close();
		}		

	}

}
