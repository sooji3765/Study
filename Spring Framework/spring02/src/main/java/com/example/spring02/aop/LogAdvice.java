package com.example.spring02.aop;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component // 스프링에서 공통으로 등록
@Aspect
public class LogAdvice {
	private static final Logger logger
		= LoggerFactory.getLogger(LogAdvice.class);
	
	/*
	@Around("execution(* com.example.spring02.controller..*Controller.*(..))"
			+ " or execution(* com.example.spring02.service..*Impl.*(..))"
			+ " or execution(* com.example.spring02.model..dao.*Impl.*(..))")*/
	public Object logPrint(ProceedingJoinPoint joinPoint) 
			throws Throwable{
		//실행 1
		long start = System.currentTimeMillis();
		
		// 메인 메서드 실행 2
		
		// 메인 후 실행 3
		Object result = joinPoint.proceed();
		
		String type =
				joinPoint.getSignature().getDeclaringTypeName();
		String name = "";
		if(type.indexOf("Controller") > -1) {
			name ="Controller \t:";
		}else if (type.indexOf("Service") > -1) {
			name ="ServiceImpl \t:";
		}else if (type.indexOf("DAO") >-1) {
			name ="DaoImple \t:";
		}
		
		//호출한 클래스, method 정보
		logger.info(name+type+"."+joinPoint.getSignature()
				.getName()+"()");
		
		//method에 전달되는 매개변수들
		logger.info(Arrays.toString(joinPoint.getArgs()));
		// 로그 수집 끝난 시간
		long end=System.currentTimeMillis();
		long time=end-start;
		logger.info("실행시간:"+time);
		return result;
	}
	
}
