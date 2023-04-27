package com.myspring.view.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LogoutController { //로그아웃 처리를 위해 세션 객체 필요
								//HttpSession을 매개변수로 선언하면 스프링 컨테이너가 로그아웃을 요청한 브라우저와 매핑된 세션 객체를 찾아서 넘겨준다.
								//따라서 매개변수로 받은 세션 객체를 강제 종료하면 된다. 

	@RequestMapping("/logout.do")
	public String logout(HttpSession session) {
		System.out.println("로그아웃 처리");

		session.invalidate();
		//Invalidates this session then unbinds any objects bound to it. 무효화

		return "login.jsp";
	}

}
