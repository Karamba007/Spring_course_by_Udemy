package com.udemy.spring.inversion_of_control;

public class Cat implements Pet{

	@Override
	public void say() {
		System.out.println("Meow-meow");		
	}

}
