package com.myspring.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.biz.board.BoardVO;
import com.myspring.biz.board.impl.BoardDAO;

public class GetBoardController {

	@RequestMapping("/getBoard.do")
	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
		System.out.println("글 상세 조회 처리");

		mav.addObject("board", boardDAO.getBoard(vo)); // Model 정보 저장
		mav.setViewName("getBoard.jsp"); // View 정보 저장

		return mav;
	}

}
