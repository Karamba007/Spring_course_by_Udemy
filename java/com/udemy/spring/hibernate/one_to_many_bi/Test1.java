package com.udemy.spring.hibernate.one_to_many_bi;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.spring.hibernate.one_to_many_bi.entity.Department;
import com.udemy.spring.hibernate.one_to_many_bi.entity.Employee;

public class Test1 {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()   
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Department.class)
				.buildSessionFactory();
		
		Session session = null;
		try {	
			
//			// Создание работников и департамент
//			// помещаем в List<Employee> у Department созданных работников
//			// save() на Department
//			// Hibernate автоматически создаст поля в обеих таблицах
//			// на основе прописанных связей
//			session = factory.getCurrentSession();
//			Department dep = new Department("IT", 300, 12000);
//			Employee emp1 = new Employee("Vitali", "Kasaty", 5000);
//			Employee emp2 = new Employee("Elena", "Smirnova", 1000);
//			
//			dep.addEmployeeToDepartment(emp1);
//			dep.addEmployeeToDepartment(emp2);
//			
//			session.beginTransaction();
//			session.save(dep);			
//			session.getTransaction().commit();	
//			
//			System.out.println("Done");
			
			
			
//			// Получение департамента и всех его работников
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			Department department = session.get(Department.class, 1);
//			System.out.println(department);
//			System.out.println(department.getEmps());
//			session.getTransaction().commit();	
//			
//			System.out.println("Done");
			
			
			
//			// Получение работника и информация о его департаменте
//			session = factory.getCurrentSession();
//			session.beginTransaction();
//			
//			Employee employee = session.get(Employee.class, 1);
//			System.out.println(employee);
//			System.out.println(employee.getDepartment());
//			session.getTransaction().commit();	
//			
//			System.out.println("Done");
			
			
			
			// Удаление работника, а так как cascade = type.ALL
			// то удалится и весь department работника
			// поэтому нужно ставит cascade в зависимости от предметной области
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			Employee employee = session.get(Employee.class, 9);
			session.delete(employee);
			session.getTransaction().commit();	
			
			System.out.println("Done");
			
			
		} finally {
			session.close();
			factory.close();  
		}		

	}

}
