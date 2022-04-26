package com.udemy.spring.aop;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class University {
	
	private List<Student> students = new ArrayList<Student>();
	
	public void addStudents() {
		Student st1 = new Student("Kosaty Vitali", 4, 7.5);
		Student st2 = new Student("Vikhail Ivanov", 2, 8.3);
		Student st3 = new Student("Elena Sidorova", 1, 9.1);
		students.add(st1);
		students.add(st2);
		students.add(st3);
	}
	
	public List<Student> getStudents(){
		System.out.println("Начало работы метода getStudents");
		//сгенерируем исключение, чтобы выполнить @AfterThrowing advice
		System.out.println(students.get(999));
		
		System.out.println("Information from method getStudents:");
		System.out.println(students);
		return students;
	}

}
