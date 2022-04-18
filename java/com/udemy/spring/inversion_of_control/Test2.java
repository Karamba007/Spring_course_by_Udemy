package com.udemy.spring.inversion_of_control;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {
	public static void main(String[] args) {
		
		ClassPathXmlApplicationContext context = 
				new ClassPathXmlApplicationContext("applicationContext_IOC.xml");
		
		Pet pet = context.getBean("myPet", Pet.class);
		pet.say();
		context.close();
		

	}

}
