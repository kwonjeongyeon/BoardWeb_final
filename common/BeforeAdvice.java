package com.myspring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

@Service
@Aspect
public class BeforeAdvice { // BeforeAdvice는 비즈니스 메소드가 실행되기 전에 공통으로 처리할 작업을 위해 사용

	@Pointcut("execution(* com.myspring.biz..*Impl.*(..))")
	public void allPointcut() {
	}
	
//	@Pointcut("execution(* *(..))")
//	public void allPointcut() {
//	}

	
	//@Before("allPointcut()")
	@Before("PointcutCommon.allPointcut()")
	public void beforeLog(JoinPoint jp) {
		String method = jp.getSignature().getName();
		// getSignature() 메소드를 이용하면 클라이언트가 호출한 메소드 이름을 출력할 수 있음
		Object[] args = jp.getArgs();
		// getArgs() 메소드를 통해 인자 목록을 Object 배열로 얻어낼 수 있어서 메소드 호출에 어떤 값들을 사용했는지도 알 수 있음.

//		System.out.println("[사전 처리] 비즈니스 로직 수행 전 동작");
		System.out.println("[사전 처리] " + method + "() 메소드 ARGS 정보 : " + args[0].toString());
	}

}
