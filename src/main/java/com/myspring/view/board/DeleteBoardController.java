package com.myspring.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.biz.board.BoardVO;
import com.myspring.biz.board.impl.BoardDAO;

@Controller
public class DeleteBoardController {

	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 삭제 처리");

		boardDAO.deleteBoard(vo);

		return "getBoardList.do";
	}
}
