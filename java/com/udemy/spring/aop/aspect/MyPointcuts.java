package com.udemy.spring.aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class MyPointcuts {
	
//	  @Pointcut("execution(* add*())") 
//	  public void allGetMethods() {		  
//	  }
	
//	  @Pointcut("execution(* add*(..))") 
	  @Pointcut("execution(* abc*(..))") 
	  public void allAddMethods() {		  
	  }

}
