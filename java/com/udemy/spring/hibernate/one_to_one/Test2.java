package com.udemy.spring.hibernate.one_to_one;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.spring.hibernate.one_to_one.entity.Detail;
import com.udemy.spring.hibernate.one_to_one.entity.Employee;

//One-to-one bi-directional
public class Test2 {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()   
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Detail.class)
				.buildSessionFactory();
		
		Session session = null;
		try {
			
			session = factory.getCurrentSession();
			
			// Добавление в базу при One-to-One bi-directional
//			Employee employee = new Employee("Nikolay", "Ivanov", "HR", 500);
//			Detail detail = new Detail("London", "34", "nika@gmail.com");
//			
//			employee.setEmpDetail(detail);
//			detail.setEmployee(employee);
//			session.beginTransaction();
//			
//			session.save(employee);
//			session.getTransaction().commit();
			
			
//			// Получение из базы информации о работнике по его id_detail из таблицы detail
//			session.beginTransaction();
//			Detail detail = session.get(Detail.class, 4);
//			System.out.println(detail.getEmployee());
//			
//			session.getTransaction().commit();			
//			
//			System.out.println("Done");
			
			
//			// Удаление записи из таблицы details и связанной с ней записью в employees
//			session.beginTransaction();
//			Detail detail = session.get(Detail.class, 4);
//			session.delete(detail);
//			
//			session.getTransaction().commit();			
//			
//			System.out.println("Done");
			
			
			// Для удаления при One-to-One bi-directional только записи detail
			// и не трогать связанную запись employee
			// изменяем cascede в классе Detail
			// например на @OneToOne(mappedBy = "empDetail", cascade = {CascadeType.PERSIST, CascadeType.REFRESH})
			// и перед тем как удалить detail нужно разрушить связь у объекта employee
			// т.е присвоить null на empDetail
			session.beginTransaction();
			Detail detail = session.get(Detail.class, 1);
			detail.getEmployee().setEmpDetail(null);
			session.delete(detail);
			
			session.getTransaction().commit();			
			
			System.out.println("Done");
			
		} finally {
			session.close();
			factory.close();  
		}		

	}

}

