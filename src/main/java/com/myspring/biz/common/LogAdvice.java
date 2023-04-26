//package com.myspring.biz.common;
//
//import org.aspectj.lang.JoinPoint;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.aspectj.lang.annotation.Pointcut;
//import org.springframework.stereotype.Service;
//
//@Service
//@Aspect       //aspect = pointcut + advice
//public class LogAdvice {
////	public void printLog(JoinPoint jp) {
////		// JoinPoint 객체를 사용하려면 어드바이스 메소드 매개변수로 선언만 하면 된다.
////		// 클라이언트가 비즈니스 메소드를 호출할 때, 스프링 컨테이너가 JoinPoint 객체 생성해서 어드바이스 메소드 호출할 때 넘겨준다.
////		System.out.println("[공통 로그] 비즈니스 로직 수행 전 동작");
////	}
//
//	@Pointcut("execution(* com.myspring.biz..*Impl.*(..))")
//	public void allPointcut() { //포인트 컷
//	}
//
//	@Pointcut("execution(* com.myspring.biz..*Impl.get*(..))")
//	public void getPointcut() {
//	}
//
//	@Before("allPointcut()")
//	public void printLog() { //어드바이스
//		System.out.println("[공통 로그] 비즈니스 로직 수행 전 동작");
//		//allPointcut() 참조 메소드로 지정한 비즈니스 메소드가 호출될 때, 어드바이스 메소드인 printLog() 메소드가 Before 형태로 동작하도록 설정
//	}
//
//}
