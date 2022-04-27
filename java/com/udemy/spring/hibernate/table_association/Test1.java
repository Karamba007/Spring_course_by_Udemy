package com.udemy.spring.hibernate.table_association;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.spring.hibernate.introduction.entity.Employee;

public class Test1 {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()   
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		try {
			Session session = factory.getCurrentSession();		

			
			session.getTransaction().commit(); 
			
			
			System.out.println("Done");
		} finally {
			factory.close();  
		}		

	}

}

