package com.myspring.view.board;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//import org.springframework.web.servlet.mvc.Controller;

import com.myspring.biz.board.BoardVO;
import com.myspring.biz.board.impl.BoardDAO;

@Controller
public class InsertBoardController{

//	@Override
//	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
	
	@RequestMapping(value = "/insertBoard.do")
	public void insertBoard(BoardVO vo) {
		
//	public void insertBoard(HttpServletRequest request) {
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

		BoardDAO boardDAO = new BoardDAO();
		boardDAO.insertBoard(vo);

//		// 3. 화면 네비게이션
//		ModelAndView mav = new ModelAndView();
////		mav.setViewName("getBoardList.do");
//		mav.setViewName("redirect:getBoardList.do");
//		return mav;
	}

}
