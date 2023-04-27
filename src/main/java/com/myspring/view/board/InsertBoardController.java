package com.myspring.view.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//import org.springframework.web.servlet.mvc.Controller;

import com.myspring.biz.board.BoardVO;
import com.myspring.biz.board.impl.BoardDAO;

@Controller
public class InsertBoardController {

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {

	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
														//사용자 입력값을 Command 객체로 받기 위해 BoardVO 클래스를 매개변수로 선언
														// DB 연동 처리를 위해 BoardDAO도 매개변수로 선언
														// Command 객체는 Controller 메소드 매개변수로 받은 VO(Value Object) 객체라고 보면된다.
														// InsertBoardController클래스의 insertBoard() 메소드를 Command 객체를 이용하여 구현
																	

//		public void insertBoard(BoardVO vo) {

//		public void insertBoard(HttpServletRequest request) {
		System.out.println("글 등록 처리");

//		// 1. 사용자 입력 정보 추출
//		// request.setCharacterEncoding("UTF-8");
//		String title = request.getParameter("title");
//		String writer = request.getParameter("writer");
//		String content = request.getParameter("content");
//
//		// 2. DB 연동 처리
//		BoardVO vo = new BoardVO();
//		vo.setTitle(title);
//		vo.setWriter(writer);
//		vo.setContent(content);

//		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);
//		return "getBoardList.do";
		return "redirect:getBoardList.do";

//		// 3. 화면 네비게이션
//		ModelAndView mav = new ModelAndView();
////		mav.setViewName("getBoardList.do");
//		mav.setViewName("redirect:getBoardList.do");
//		return mav;
	}

}
