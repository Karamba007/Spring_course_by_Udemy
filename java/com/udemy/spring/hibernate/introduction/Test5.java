package com.udemy.spring.hibernate.introduction;

import java.util.List;

import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.spring.hibernate.introduction.entity.Employee;

public class Test5 {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			// Пример1: Получили работника и удаляем его
//			Employee emp = session.get(Employee.class, 11);
//			session.delete(emp);
			
			// Пример2: Удаление через HQL
//			session.createQuery("delete Employee"); // удалит все строки
			session.createQuery("delete Employee where name = 'Alex'").executeUpdate();

			session.getTransaction().commit();			

			System.out.println("Done");
		} finally {
			factory.close();
		}		

	}

}
