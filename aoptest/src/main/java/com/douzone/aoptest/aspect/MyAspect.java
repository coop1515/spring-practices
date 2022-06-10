package com.douzone.aoptest.aspect;

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
}
