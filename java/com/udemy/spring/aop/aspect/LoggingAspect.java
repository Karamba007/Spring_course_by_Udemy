package com.udemy.spring.aop.aspect;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.udemy.spring.aop.Book;

@Component
@Aspect
@Order(1)
public class LoggingAspect {
	
	  @Before("com.udemy.spring.aop.aspect.MyPointcuts.allAddMethods()") 
	  public void beforeAddLoggingAdvice(JoinPoint joinPoint) {
		  
		  MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		  System.out.println("methodSignature = " + methodSignature);
		  System.out.println("methodSignature.getMethod() = " + methodSignature.getMethod());
		  System.out.println("methodSignature.getReturnType() = " + methodSignature.getReturnType());
		  System.out.println("methodSignature.getName() = " + methodSignature.getName());
		  
		  //Например добавляются в библиотеку и книги, и журналы
		  //но хотим вывести полную информацию о добавляемом материале
		  //только если добавляется книга
		  if (methodSignature.getName().equals("addBook")) {
			  Object[] arguments = joinPoint.getArgs();
			  for (Object obj : arguments) {
				  if (obj instanceof Book) {
					  Book myBook = (Book) obj;
					  System.out.println("Информация о книге: название книги - "
					  		+ myBook.getName() + " автор - " + myBook.getAuthor() +
					  		" год издания - " + myBook.getYearOfPublication());
				  } else if (obj instanceof String) {  //здесь обрабатываем второй параметр метода addBook()
					  System.out.println("Книгу добавляет - " + obj);
				  }
			  } 
		  } 
		  System.out.println("beforeGetLoggingAdvice: логирование попытки получить книгу/журнал");
		  System.out.println("---------------");
	  }

}
