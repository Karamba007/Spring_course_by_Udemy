package com.udemy.spring.hibernate.introduction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.spring.hibernate.introduction.entity.Employee;

public class Test2 {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		try {
//			Session session = factory.getCurrentSession();			
//			Employee emp = new Employee("Elena", "Petrova", "Sales", 800);
//			session.beginTransaction();
//			session.save(emp);			
//			session.getTransaction().commit();			
//			
//			// после добавления поля в бд через save(), id объекту Employee сгенерировалось автоматически и
//			// его можно получить через объект, не обращаясь к БД
//			int myId = emp.getId(); 
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			Employee employee = session.get(Employee.class, myId);
//			session.getTransaction().commit();
//			
//			System.out.println(employee);
			
			//Также за одну сессию можно делать несколько транзакций
			Session session = factory.getCurrentSession();			
			Employee emp = new Employee("Oleg", "Sidorov", "HR", 700);
			session.beginTransaction();
			session.save(emp);	

			int myId = emp.getId(); 

			Employee employee = session.get(Employee.class, myId);
			session.getTransaction().commit();
			
			System.out.println(employee);			
			
			System.out.println("Done");
		} finally {
			factory.close();
		}		

	}

}
