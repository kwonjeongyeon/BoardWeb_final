package com.myspring.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myspring.biz.user.UserVO;
import com.myspring.biz.user.impl.UserDAO;

@Controller
public class LoginController {

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String loginView(UserVO vo) {
		//클라이언트가 GET 방식으로 입력 폼을 요청하면 입력 화면 보여준다.
		//loginView() 메소드는 로그인 화면으로 이동할 때 실행되는 메소드
		//사용자가 입력할 값이 없는 상태에서 매개변수로 USerVO객체를 받아들이도록 설정
		//매개변수로 받은 Command 객체에 적절한 데이터를 설정하면 리턴된 JSP 파일에서 이 데이터 사용 가능함. 
		// Command 객체에 저장된 데이터를 JSP에서 사용하려면 "${..}" 구문 이용 (여기서는 login.jsp) 
		System.out.println("로그인 화면으로 이동");
		vo.setId("test");
		vo.setPassword("test123");
		return "login.jsp";
	}

	@RequestMapping(value = "/login.do", method = RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		//입력 화면에서 submit 버튼을 클릭하여 POST 방식으로 요청하면 클라이언트의 요청 적절히 처리
		//실질적인 로그인 인증 작업 처리
		System.out.println("로그인 인증 처리--------");
		
		UserVO user = userDAO.getUser(vo);

		if (user != null) {
			session.setAttribute("userName", user.getName());
			return "getBoardList.do";
		} else {
			return "login.jsp";
		}
	}
	
	
	// 클라이언트가 직접 URL을 입력하거나 하이퍼링크를 클릭하여 요청하면 기본이 GET 방식
	//index.jsp 화면에서 로그인 링크를 클릭하면 서버에 "login.do" 요청 전달 (GET 방식 요청 전달 ) => loginView() 메소드 실행
	
	//로그인 화면으로 이동한 상태에서 로그인 버튼 클릭하면 "/login.do" 요청이 서버에 다시 한 번 전송
	// 이때는 POST 방식의 요청이므로 LoginController의 login() 메소드 실행
}
