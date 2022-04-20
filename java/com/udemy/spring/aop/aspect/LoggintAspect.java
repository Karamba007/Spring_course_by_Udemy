package com.udemy.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggintAspect {
	
//	@Before("execution(public void getBook())") - срабатывает getBook() для всех классов имеющих такой метод
//	@Before("execution(public void com.udemy.spring.aop.UniLibrary.getBook())") // только для класса UniLibrary
	@Before("execution(public void get*())") // подходит для всех public void методов, имя которых начинается на get
	public void beforeGetBookAdvice() {
		System.out.println("beforeGetBookAdvice: попытка получить книгу");
	}
	
//	@Before("execution(public * returnBook())") // подходит для всех public void методов, имя которых начинается на get
	@Before("execution(* returnBook())") //не учитывает модификатор доступа
	public void beforeReturnBookAdvice() {
		System.out.println("beforeGetBookAdvice: попытка вернуть книгу");
	}

}
