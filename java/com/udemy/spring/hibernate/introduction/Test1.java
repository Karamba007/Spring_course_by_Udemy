package com.udemy.spring.hibernate.introduction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.spring.hibernate.introduction.entity.Employee;

public class Test1 {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()   //фабрика сессий
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		try {
			Session session = factory.getCurrentSession();	//получение сессии	
			Employee emp = new Employee("Alex", "Ivanov", "IT", 900);
			session.beginTransaction();  //открытие сессии для транзакции
			session.save(emp);			//заполнение поля в таблице бд entity-объектом
			session.getTransaction().commit(); //закрытие сессии
			System.out.println(emp);
			
			System.out.println("Done");
		} finally {
			factory.close();  //фабрику всегда закрываем
		}		

	}

}
