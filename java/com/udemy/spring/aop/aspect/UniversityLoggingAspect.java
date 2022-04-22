package com.udemy.spring.aop.aspect;

import java.util.List;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import com.udemy.spring.aop.Student;

@Component
@Aspect
public class UniversityLoggingAspect {
	
//	@Before("execution(* getStudents())")
//	public void beforeGetStudentsLoggingAdvice() {
//		System.out.println("beforeGetStudentsLoggingAdvice: логируем получение "
//				+ "списка студентов перед методом getStudents");
//	}
	
	
//	@AfterReturning("execution(* getStudents())") // обычный Advice, срабатывает после отработки метода	
//	public void afterReturningGetStudentsLoggingAdvice() {		
//		
//		System.out.println("afterReturningGetStudentsLoggingAdvice: логируем получение "
//				+ "списка студентов после работы метода getStudents");
//	}
	

	@AfterReturning(pointcut = "execution(* getStudents())", returning = "students")
	//Advice @AfterReturning срабатывает после норма окончания метода с основной логикой,
	//но до присвоения результата этого метода какой-либо переменной.
	//Т.е. перехватываем возвращаемоме значение метода getStudent и делаем в возвращаемом объекте изменения
	//и только после этого getStudent вернёт скорректированое значение
	//имя параметра returning должно совпадать с именем параметра метода
	public void afterReturningGetStudentsLoggingAdvice(List<Student> students) { 
		
		Student firstStudent = students.get(0);
		String nameSurname = firstStudent.getName();
		nameSurname = "Mr. " + nameSurname;
		firstStudent.setName(nameSurname);
		
		double avgGrade = firstStudent.getAvgGrade();
		avgGrade = avgGrade + 1;
		firstStudent.setAvgGrade(avgGrade);
		
		System.out.println("afterReturningGetStudentsLoggingAdvice: логируем получение "
				+ "списка студентов после работы метода getStudents");
	}
	
	//Advice срабатывает, если было выброшено исключение
	//в advice можно произвести некие действия
	//далее исключение произойдёт в точке вызова метода в главной программе
//	@AfterThrowing("execution(* getStudents())")
//	public void afterThrowingGetStudentsLoggingAdvice() {
//		System.out.println("afterThrowingGetStudentsLoggingAdvice: логируем выброс исключения");
//	}
	
	//Advice так же может получить информацию о исключении
	//и например залогировать его
//	@AfterThrowing(pointcut = "execution(* getStudents())", throwing = "exception")
//	public void afterThrowingGetStudentsLoggingAdvice(Throwable exception) {
//		System.out.println("afterThrowingGetStudentsLoggingAdvice: логируем выброс исключения " + exception);
//	}
	
	
	//выполняется после метода с основной логикой
	//независимо от того, нормально он завершился или было выброшено исключения
	//@After не может получить доступ к возвращаемому значению и исключению
	@After("execution(* getStudents())")
	public void afterGetStudentsLoggingAdvice() {
		System.out.println("afterGetStudentsLoggingAdvice: логируем нормальное окончание работы "
				+ "метода или выброс исключения");
	}
	

}
