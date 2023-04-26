package com.myspring.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.myspring.biz.board.BoardVO;
import com.myspring.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록 검색 처리");

		// 1. 사용자 입력 정보 추출 (검색 기능은 나중에 구현)
		// 2. DB 연동 처리
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);

// 3. 검색 결과와 화면 정보를 ModelAndView에 저장하여 리턴한다.
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList); // Model 정보 저장
//		mav.setViewName("getBoardList.jsp"); // View 정보 저장
		
		//InternalResourceViewResolver를 등록했을 때는 모든 View 이름에서 확장자 '.jsp'를 제거해야 함
		mav.setViewName("getBoardList");
		return mav;

	}

}
