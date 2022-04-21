package com.udemy.spring.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAndSecurityAspect {
	
//	@Before("execution(public void getBook())") // срабатывает getBook() для всех классов имеющих такой метод
//	@Before("execution(public void com.udemy.spring.aop.UniLibrary.getBook())") // только для класса UniLibrary
//	@Before("execution(public void get*())") //  подходит для всех public void методов, имя которых начинается на get
//	@Before("execution(public void getBook(String))") // для метода с параметром String
//	@Before("execution(public void *(*))") // любой public void метод с любым одним параметром
//	@Before("execution(public void *(..))") // любой метод с любым кол-вом параметров
//	@Before("execution(public void getBook(com.udemy.spring.aop.Book))") //в параметрах передаётся объект класса, нужно прописывать полный путь класса
//	@Before("execution(public void getBook(com.udemy.spring.aop.Book, ..))") // первый параметр объект класса Book, а далее любое кол-во параметров
//	@Before("execution(* *(..))") // для абсолютно любого метода
	
	
//	  @Pointcut("execution(* get*())") 
//	  private void allGetMethods() {		  
//	  }	
//	  
//	  @Before("allGetMethods()") 
//	  public void beforeGetLoggingAdvice() { //
//		  System.out.println("beforeGetBookAdvice: попытка получить книгу");
//		  System.out.println("beforeGetLoggingAdvice: попытка получить книгу/журнал");
//	  }
//	  
//	  @Before("allGetMethods()") 
//	  public void beforeGetSecurityAdvice() {
//		  System.out.println("beforeGetSecurityAdvice: проверка прав на получение книги или журнала"); 
//	  }
//	  
//	  // @Before("execution(public * returnBook())") // подходит для всех public void методов, имя которых начинается на get
//	  @Before("execution(* returnBook())") //не учитывает модификатор доступа
//	  public void beforeReturnBookAdvice() {
//		  System.out.println("beforeGetBookAdvice: попытка вернуть книгу"); 
//	  }
	 
	
	
	//Комбинирование Pointcut для get и return методов класса UniLibrary
	
//	  @Pointcut("execution(* com.udemy.spring.aop.UniLibrary.get*())") // шаблон для get-методов 
//	  private void allGetMethodsFromUniLibrary() {		  
//	  }
//	  
//	  @Pointcut("execution(* com.udemy.spring.aop.UniLibrary.return*())") // шаблон для return-методов 
//	  private void allReturnMethodsFromUniLibrary() {		  
//	  }
//	  
//	  @Pointcut("allGetMethodsFromUniLibrary() || allReturnMethodsFromUniLibrary()") // шаблон для get и return методов 
//	  private void allGetAndReturnMethodsFromUniLibrary() {		  
//	  }
//	  
//	  @Before("allGetMethodsFromUniLibrary()") // срабатывает по шаблону на get-методы 
//	  public void beforeGetLoggingAdvice() {
//		  System.out.println("beforeGetLoggingAdvice: writing Log #1"); 
//	  }
//	  
//	  @Before("allReturnMethodsFromUniLibrary()") // срабатывает по шаблону на return-методы 
//	  public void beforeReturnLoggingAdvice() {
//		  System.out.println("beforeReturnLoggingAdvice: writing Log #2");
//	  }
//	  
//	  @Before("allGetAndReturnMethodsFromUniLibrary()") // срабатывает по шаблону на get и return методы
//	  public void beforeGetAndReturnLoggingAdvice() {
//		  System.out.println("beforeGetAndReturnLoggingAdvice: writing Log #3"); 
//	  }
	
	
	
	  //Комбинирование Pointcut для всех методов класса UniLibrary, кроме  returnMagazine
	  
//	  @Pointcut("execution(* com.udemy.spring.aop.UniLibrary.*(..))") 
//	  private void allMethodsFromUniLibrary() {
//	  }
//	  
//	  @Pointcut("execution(public void com.udemy.spring.aop.UniLibrary.returnMagazine())") 
//	  private void returnMagazineFromUnilibrary() {		  
//	  }
//	  
//	  @Pointcut("allMethodsFromUniLibrary() && !returnMagazineFromUnilibrary()")
//	  private void allMethodsExceptReturnMagazineFromUniLibrary() { 		  
//	  }
//	  
//	  // @Before("allMethodsFromUniLibrary() && !returnMagazineFromUnilibrary()")  // аналогично нижним Advice 
//	  // @Before("!returnMagazineFromUnilibrary()") // исключить только returnMagazine	  
//	  @Before("allMethodsExceptReturnMagazineFromUniLibrary()") 
//	  public void beforeAllMethodsExceptReturnMagazineAdvice() {
//		  System.out.println("beforeAllMethodsExceptReturnMagazineAdvice: Log #10"); 
//	  }
	
}
