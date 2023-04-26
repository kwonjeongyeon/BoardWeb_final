package com.myspring.biz.common;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PointcutCommon { 
	//어노테이션 설정으로 변경하고부터는 어드바이스 클래스마다 포인트컷 설정이 포함되면서, 
	//비슷하거나 같은 포인트컷이 반복 선언되는 문제가 발생   => 포인트컷을 외부에 독립된 클래스에 따로 설정하도록 함.                                                                                                                                                                                                                                          

	@Pointcut("execution(* com.myspring.biz..*Impl.*(..))")
	public void allPointcut() {
	}
	
	@Pointcut("execution(* com.myspring.biz..*Impl.get*(..))")
	public void getPointcut() {
	}
}
