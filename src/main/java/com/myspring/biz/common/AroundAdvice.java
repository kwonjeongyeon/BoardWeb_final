package com.myspring.biz.common;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

@Service
@Aspect
public class AroundAdvice {
	@Pointcut("execution(* com.myspring.biz..*Impl.*(..))")
	public void allPointcut() {
		
	}
	
	// AroundAdvice는 반드시 ProceedingJoinPoint 객체를 매개변수로 받아야 한다. (proceed() 메소드 가지고
	// 있으며 JoinPoint 상속)
	
	@Around("allPointcut()")
	public Object aroundLog(ProceedingJoinPoint pjp) throws Throwable {
//		System.out.println("[BEFORE] : 비즈니스 메소드 수행 전에 처리할 내용 ---");
//		Object returnobj = pjp.proceed();
//		//ProceedingJoinPoint 객체의 proceed() 메소드를 통해 비즈니스 메소드 호출 가능
//		System.out.println("[AFTER] : 비즈니스 메소드 수행 후에 처리할 내용 ---");
//		return returnobj;

		String method = pjp.getSignature().getName();

		StopWatch stopWatch = new StopWatch();
		stopWatch.start();

		Object obj = pjp.proceed();

		stopWatch.stop();
		System.out.println(method + "() 메소드 수행에 걸린 시간 : " + stopWatch.getTotalTimeMillis() + "(ms)초");
		return obj;
	}

}
