package com.douzone.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MyAspect {
	
	@Before("execution(public com.douzone.aoptest.vo.ProductVo com.douzone.aoptest.service.ProductService.find(String))") //join point : when (Before) , point cut : where(괄호 안)
	public void beforeAdvice() { // advice (what)
		System.out.println("---Before Advice---");
	} //(where)Vo, find가 (Before)실행 될 때 (advice) sysout(---Before Advice---)부터 실행 해라.
	
	// *을 넣게되면 모든 리턴타입을 가져옴.( 리턴타입(public private ...)을 지정해주면 지정해주는 대로 가져옴.)
	// 시그너쳐(string)을 생략하려면 (..)
	@After("execution(* *..*.ProductService.find(..))")
	public void AfterAdvice() {
		System.out.println("---After Advice---");
	} 
	
	@AfterReturning("execution(* *..*.ProductService.*(..))") // 모든메소드를 부르는것은 일반적으로 사용하지않음.
	public void AfterReturningAdvice() {
		System.out.println("---AfterReturning Advice---");
	}
	
	@AfterThrowing(value="execution(* *..*.*.*(..))", throwing ="ex") // 모든 exception을 다 가져옴. global exception
	public void AfterThrowingAdvice(Throwable ex) {
		System.out.println("---AfterThrowing Advice: " + ex + "---");
	}
	
	@Around("execution(* *..*.ProductService.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable{
		// before
		System.out.println("---Around(Before) Advice---");
		
		// PointCut method 실행
		Object result = pjp.proceed();		
		
		// after
		System.out.println("---Around(After) Advice---");
		return result;
		
		
		
	}
}