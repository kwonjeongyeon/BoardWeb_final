package com.myspring.view.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myspring.biz.board.BoardVO;
import com.myspring.biz.board.impl.BoardDAO;

@Controller
public class UpdateBoardController {

	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo, BoardDAO boardDAO) { 
		//수정에 필요한 데이터는 매개변수로 선언된 BoardVO 객체를 통해 받아냄
		System.out.println("글 수정 처리");

		boardDAO.updateBoard(vo);

		return "getBoardList.do";

	}

}
