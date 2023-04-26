package com.myspring.biz.common;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

import com.myspring.biz.user.UserVO;

@Service
@Aspect
public class AfterReturningAdvice {
	// 비즈니스 메소드가 수행되고 나서, 결과 데이터를 리턴할 때 동작하는 어드바이스
	// 어떤 메소드가 어떤 값을 리턴했는지를 알아야 사후 처리 기능을 다양하게 구현할 수 있음

	@Pointcut("execution(* com.myspring.biz..*Impl.get*(..))")
	public void getPointcut() {

	}

	//@AfterReturning(pointcut = "getPointcut()", returning = "returnobj")
	@AfterReturning(pointcut="PointcutCommon.getPointcut()", returning="returnobj")
	public void afterLog(JoinPoint jp, Object returnobj) {
		// Object : 바인드 변수 , 비즈니스 메소드가 리턴할 결괏값을 바인딩할 목적으로 사용, 어떤 값이 리턴될지 모르기 문에 Object 타입으로 선언
		String method = jp.getSignature().getName();

		if (returnobj instanceof UserVO) {
			UserVO user = (UserVO) returnobj;
			if (user.getRole().equals("Admin")) {
				System.out.println(user.getName() + " 로그인(Admin)");
			}
		}

//		System.out.println("[사후 처리] 비즈니스 로직 수행 후 동작");
		System.out.println("[사후 처리] " + method + "() 메소드 리턴값 : " + returnobj.toString());
	}

}
