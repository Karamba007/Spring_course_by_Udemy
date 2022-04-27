package com.udemy.spring.hibernate.introduction;

import java.util.List;

import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.spring.hibernate.introduction.entity.Employee;

public class Test3 {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.buildSessionFactory();
		
		try {
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			// !!! Указывается не имя таблицы в ("from Employee"), а имя класса,
			// тк в классе есть указание с какой таблицей связан класс @Table(name="employees")
//			List<Employee> emps = session.createQuery("from Employee") //получение всех записей из бд
//					.getResultList();
			
//			List<Employee> emps = session.createQuery("from Employee where name = 'Alex'") // получение Employee с именем Alex
//					.getResultList();                  //здесь также, name название поля в Employee, а не поле в таблице БД 
			
			List<Employee> emps = session.createQuery("from Employee where name = 'Alex' AND salary > 800") 
			.getResultList();                   
			for (Employee e : emps) {
				System.out.println(e);
			}	

			session.getTransaction().commit();			

			System.out.println("Done");
		} finally {
			factory.close();
		}		

	}

}
