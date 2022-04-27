package com.udemy.spring.hibernate.introduction;

import java.util.List;

import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.spring.hibernate.introduction.entity.Employee;

public class Test4 {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
//			// Изменение Java объектов в БД, например с id = 1
//			Employee emp = session.get(Employee.class, 1);
//			emp.setSalary(1500); 
//			//Т.е. получили объект класса Employee, через сеттеры изменили ему параметры
//			// закомитили далее и всё !!!
			
			
			// Изменение значения в БД у нескольких записей через запрос. 
			// Либо можно получить List<Employee> и через foreach и setter'ы изменить несколько записей
			session.createQuery("update Employee set salary = 1000 where name = 'Alex'")
					.executeUpdate();

			session.getTransaction().commit();			

			System.out.println("Done");
		} finally {
			factory.close();
		}		

	}

}
