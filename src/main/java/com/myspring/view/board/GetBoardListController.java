package com.myspring.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.biz.board.BoardVO;
import com.myspring.biz.board.impl.BoardDAO;

@Controller
public class GetBoardListController {

	@RequestMapping("/getBoardList.do")
	public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		// 세 개의 매개 변수 선언
		// (1) 사용자 입력값을 받기 위한 BoardVO 클래스 (2) DB 연동 처리를 위한 BoardDAO 클래스 (3) 검색 결과와 화면 정보를 저장하여 리턴하기 위한 ModelAndView
		
		System.out.println("글 목록 검색 처리");

		mav.addObject("boardList", boardDAO.getBoardList(vo)); // Model 정보 저장
		mav.setViewName("getBoardList.jsp"); // View 정보 저장

		return mav;

	}

}
