package com.udemy.spring.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class NewLoggingAspect {
	
//	@Around("execution(public String returnBook())")
//	public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
//		
//		System.out.println("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть книгу");
//		long begin = System.currentTimeMillis();
//		//то, что выше Object targetMethodResult = proceedingJoinPoint.proceed()
//		//срабатывает до вызова основного метода из main
//		//Что бы Advice сработал после отработки основного метода, нужно принудительно запустить
//		//метод через proceedingJoinPoint.proceed() и return это значение, т.е. принудительно
//		//зупусить метод и вернуть значение, самостоятельно	
//		Object targetMethodResult = proceedingJoinPoint.proceed(); 
//		long end = System.currentTimeMillis();
//		
//		System.out.println("aroundReturnBookLoggingAdvice: в библиотеку успешно вернули книгу");
//		System.out.println("aroundReturnBookLoggingAdvice: метод returnBook() выполнил работу за "
//				+ (end - begin) + "ms");
//		
//		return targetMethodResult;
//	}
	
	
	//Пример работы при исключениях
	@Around("execution(public String returnBook())")
	public Object aroundReturnBookLoggingAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
		
		System.out.println("aroundReturnBookLoggingAdvice: в библиотеку пытаются вернуть книгу");
		Object targetMethodResult = null;
		
		try {
			targetMethodResult = proceedingJoinPoint.proceed(); 
		} catch (Exception e) {
			System.out.println("aroundReturnBookLoggingAdvice: было поймано исключение " + e);
			targetMethodResult = "Неизвестное название книги"; //либо изменить значение при исключении
			throw e; //либо словить и пробросить исключение дальше
		}
		
		System.out.println("aroundReturnBookLoggingAdvice: в библиотеку успешно вернули книгу");
		
		return targetMethodResult;
	}
	
}
