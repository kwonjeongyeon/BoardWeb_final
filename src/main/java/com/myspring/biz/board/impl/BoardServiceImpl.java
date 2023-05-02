package com.myspring.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspring.biz.board.BoardService;
import com.myspring.biz.board.BoardVO;
//import com.myspring.biz.common.Log4jAdvice;
//import com.myspring.biz.common.LogAdvice;

@Service("boardService")
public class BoardServiceImpl implements BoardService {

	@Autowired
	private BoardDAOMybatis boardDAO;
	
//	private BoardDAO boardDAO;       
//	private BoardDAOSpring boardDAO;
	// 데이터베이스 연동이 포함된 비즈니스 로직 처리를 위해 BoardDAO 타입 객체를 멤버변수로 가지고 있음.
	// private LogAdvice log;
	// private Log4jAdvice log;

//	public BoardServiceImpl() {
//		// log = new LogAdvice();
//		log = new Log4jAdvice();
//	}

	public void insertBoard(BoardVO vo) {
		// log.printLog();
		// log.printLogging();

//		if (vo.getSeq() == 0) {
//			throw new IllegalArgumentException("0번 글은 등록할 수 없습니다.");
//			//seq 변숫값이 0이면, IllegalArgumentException을 강제로 발생시켜 예외 처리 어드바이스의 동작 여부 확인 
//			// 글 등록 작업은 subquery를 사용하여 seq 컬럼값을 자동으로 증가시키기 때문에 매개변수 BoardVO 객체의 seq 변숫값은 중요하지 않음.
//		}
		boardDAO.insertBoard(vo);
		//boardDAO.insertBoard(vo);
	}

	public void updateBoard(BoardVO vo) {
		// log.printLog();
		// log.printLogging();
		boardDAO.updateBoard(vo);
	}

	public void deleteBoard(BoardVO vo) {
		// log.printLog();
		// log.printLogging();
		boardDAO.deleteBoard(vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		// log.printLog();
		// log.printLogging();
		return boardDAO.getBoard(vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		// log.printLog();
		// log.printLogging();
		return boardDAO.getBoardList(vo);
	}
}
