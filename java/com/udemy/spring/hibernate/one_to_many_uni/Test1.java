package com.udemy.spring.hibernate.one_to_many_uni;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.spring.hibernate.one_to_many_uni.entity.Department;
import com.udemy.spring.hibernate.one_to_many_uni.entity.Employee;



public class Test1 {
	
public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()   
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Department.class)
				.buildSessionFactory();
		
		Session session = null;
		try {			
			
			//Добавление entity в БД
//			session = factory.getCurrentSession();
//			
//			Department dep = new Department("HR", 500, 1500);
//			Employee emp1 = new Employee("Oleg", "Ivanov", 800);
//			Employee emp2 = new Employee("Andrey", "Sidorov", 1000);
//			
//			dep.addEmployeeToDepartment(emp1);
//			dep.addEmployeeToDepartment(emp2);
//			
//			session.beginTransaction();
//			// Благодаря односторонней связи и cascade all при сохранении
//			// департамента сохранятся и работники
//			session.save(dep);
//
//			session.getTransaction().commit();
//			System.out.println("Done");
			
//***************************************************************************			
			
//			// Получение департамента и всех его работников
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			Department department = session.get(Department.class, 6);
//			System.out.println(department);
//			System.out.println(department.getEmps());
//			session.getTransaction().commit();	
//			
//			System.out.println("Done");
			
//***************************************************************************			
			
//			// Получение информации о работнике, но узнать информацию
//			// о его департаменте не можем, тк связь односторонняя
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			Employee employee = session.get(Employee.class, 8);
//			System.out.println(employee);
//			session.getTransaction().commit();	
//			
//			System.out.println("Done");
			
//***************************************************************************
			
			// Удаление работника не трогает департамент
			// Удаление департамента - удаляет всех его работников
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Employee employee = session.get(Employee.class, 11);
			Department department = session.get(Department.class, 7);
			
			session.delete(employee);
			session.delete(department);
			
			session.getTransaction().commit();	
			
			System.out.println("Done");
			
			
		} finally {
			session.close();
			factory.close();  
		}		

	}

}
