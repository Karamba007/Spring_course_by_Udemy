package com.udemy.spring.inversion_of_control;

public class Dog implements Pet{
	
	@Override
	public void say() {
		System.out.println("Bow-Wow");
	}

}
