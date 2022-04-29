package com.udemy.spring.hibernate.one_to_one;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.spring.hibernate.one_to_one.entity.Detail;
import com.udemy.spring.hibernate.one_to_one.entity.Employee;

//One-to-one uni-directional
public class Test1 {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()   
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Detail.class)
				.buildSessionFactory();
		
		Session session = null;
		try {
			
//			// Добавление в бд отношения One-to-one по uni-directional
//			Session session = factory.getCurrentSession();		
//			Employee employee = new Employee("Vitali", "Kosaty", "IT", 5000);
//			Detail detail = new Detail("Minsk", "123456789", "vitalik007007@gmail.com");
//			employee.setEmpDetail(detail);
//			
//			session.beginTransaction();
//			session.save(employee);
//			session.getTransaction().commit();
//			
//			System.out.println("Done");
			
//***************************************************************************
			
//			//Получаем работника из бд
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			Employee emp = session.get(Employee.class, 10);
//			// Получить объект класса Detail этого работника можно просто через геттер
//			// создавать new Detail() при этом не обязательно
//			// Однако если бы мы хотели получить работника по id, которого не существует,
//			// то при вызове геттера на null будет исключение и хоть фабрика в finaly закроется
//			// но сессия не будет закрыта, поэтому нужно обрабатывать исключение и закрывать сессию 
//			// либо в try-catch, либо так же в finally
//			System.out.println(emp.getEmpDetail());
//			session.getTransaction().commit();
//			
//			System.out.println("Done");
			
//***************************************************************************
			
			// Удаление работника, благодаря cascade автоматически удалится так же и связанная с ним
			// запись в details
			session = factory.getCurrentSession();
			session.beginTransaction();
			Employee emp = session.get(Employee.class, 2);
			session.delete(emp);
			
			session.getTransaction().commit();			
			System.out.println("Done");
			
		} finally {
			session.close();
			factory.close();  
		}		

	}

}

