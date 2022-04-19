package com.udemy.spring.spring_introduction;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test4 {
	
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext2.xml");
		
		Dog myDog = context.getBean("myPet", Dog.class);
//		myDog.setName("Fedor");
		Dog yourDog = context.getBean("myPet", Dog.class);
//		yourDog.setName("Ball");
		
//		System.out.println(myDog.getName());
//		System.out.println(yourDog.getName());
		
//		Синглтон scope предоставляет один бин для всех
		
//		Dog myDog = context.getBean("myPet", Dog.class);
//		Dog yourDog = context.getBean("myPet", Dog.class);
//		
//		System.out.println("Переменные ссылкаются на один и тот же объект? " +
//				(myDog == yourDog));
//		System.out.println(myDog);
//		System.out.println(yourDog);
		
		context.close();

	}

}
