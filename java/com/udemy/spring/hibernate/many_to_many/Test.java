package com.udemy.spring.hibernate.many_to_many;

import javax.persistence.CascadeType;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.udemy.spring.hibernate.many_to_many.entity.Child;
import com.udemy.spring.hibernate.many_to_many.entity.Section;

public class Test {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Child.class)
				.addAnnotatedClass(Section.class)
				.buildSessionFactory();
		
		Session session = null;
		
		try {
			
//			// Создание 1ой секции и 3ех детей в эту секцию
			// добавление одной лишь секции в бд также добавит 
			// и всех связанных детей с ней
			session = factory.getCurrentSession();
			
			Section section1 = new Section("Football");
			Child child1 = new Child("Vitali", 5);
			Child child2 = new Child("Masha", 3);
			Child child3 = new Child("Vasya", 9);
			section1.addChildToSection(child1);
			section1.addChildToSection(child2);
			section1.addChildToSection(child3);
			
			session.beginTransaction();			
			session.save(section1);			
			session.getTransaction().commit();
			
			System.out.println("Done");
			
//********************************************************			
			
//			//Создание 1го ребенка и трех секций для него
//			// также добавим всё это через save() ребёнка
//			session = factory.getCurrentSession();
//			
//			Section section1 = new Section("Volleyball");
//			Section section2 = new Section("Chess");
//			Section section3 = new Section("Math");
//			Child child1 = new Child("Igor", 10);
//			
//			child1.addSectionToChild(section1);
//			child1.addSectionToChild(section2);
//			child1.addSectionToChild(section3);
//			
//			session.beginTransaction();			
//			session.save(child1);			
//			session.getTransaction().commit();
//			
//			System.out.println("Done");
			
//********************************************************
			
//			// Получение информации о секции и всех детях в ней
//			session = factory.getCurrentSession();				
//			session.beginTransaction();			
//
//			Section section1 = session.get(Section.class, 1);
//			System.out.println(section1);
//			System.out.println(section1.getChildren());
//			
//			session.getTransaction().commit();
//			
//			System.out.println("Done");
			
//********************************************************
			
//			// Получение информации о ребёнке и его секциях
//			session = factory.getCurrentSession();				
//			session.beginTransaction();			
//
//			Child child = session.get(Child.class, 4);
//			System.out.println(child);
//			System.out.println(child.getSections());
//			
//			session.getTransaction().commit();
//			
//			System.out.println("Done");
			
//********************************************************
			
			// Удаление секции/ребёнка
			// Чтобы при удалении секции не удалялись все дети,
			// которые её посещали, ставим соответствующий cascade
			// в обоих классах, например всё, кроме remove
			// cascade = {CascadeType.PERSIST, CascadeType.MERGE, 
			// CascadeType.REFRESH, CascadeType.DETACH}
			
			// Однако, если мы сделаем выше, убрав remove
			// мы больше не сможем воспользоваться каскадным сохранением объектов
			// и нужно по отдельности сохранять объекты			
			// либо использовать CascadeType.PERSIST не из javax.persistence 
			// а CascadeType.SAVE_UPFATE из org.hibernate.annotations 
			// А самое простое, это использовать для КАСКАДНОГО сохранения в такой
			// ситуации метод session.persist(), тогда произойдёт
			// правильное каскадное сохранение связанных объектов
//			session = factory.getCurrentSession();				
//			session.beginTransaction();			
//
//			Section section = session.get(Section.class, 1);
//			session.delete(section);			
//			session.getTransaction().commit();
//			
//			System.out.println("Done");
			
		} finally {
			session.close();
			factory.close();
		}

	}

}
