package com.myspring.view.board;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.myspring.biz.board.BoardVO;
import com.myspring.biz.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {
	// 스프링 컨테이너가 BoardController 객체를 생성하고 클라이언트의 요청 패스에 따라 @RequestMapping 설정된 메소드 실행
	
	
	// 검색 조건 목록 설정
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap() { // View(JSP)에서 사용할 데이터를 설정하는 용도로 사용가능
		// @RequestMapping 어노테이션이 적용된 메소드보다 먼저 호출
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목", "TITLE");
		conditionMap.put("내용", "CONTENT");
		return conditionMap;
	}

	// 글 등록
	@RequestMapping("/insertBoard.do")
	public String insertBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 등록 처리");

		boardDAO.insertBoard(vo);
		return "getBoardList.do";
	}

	// 글 수정
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("board") BoardVO vo, BoardDAO boardDAO) {
		
		System.out.println("글 수정 처리");
		
		System.out.println("번호 : " + vo.getSeq());
		System.out.println("제목 : " + vo.getTitle());
		System.out.println("작성자 : " + vo.getWriter());
		System.out.println("내용 : " + vo.getContent());
		System.out.println("등록일 : " + vo.getRegDate());
		System.out.println("조회수 : " + vo.getCnt());

		boardDAO.updateBoard(vo);
		return "getBoardList.do";
	}

	// 글 삭제
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo, BoardDAO boardDAO) {
		System.out.println("글 삭제 처리");

		boardDAO.deleteBoard(vo);
		return "getBoardList.do";
	}

	// 글 상세 조회
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, BoardDAO boardDAO, Model model) {
		System.out.println("글 상세 조회 처리");

		model.addAttribute("board", boardDAO.getBoard(vo)); // Model 정보 저장
		return "getBoard.jsp"; // View 이름 리턴

//	public ModelAndView getBoard(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
//		System.out.println("글 상세 조회 처리");
//
//		mav.addObject("board", boardDAO.getBoard(vo)); // Model 정보 저장
//		mav.setViewName("getBoard.jsp"); // View 정보 저장
//		return mav;
	}

	// 글 목록 검색
	@RequestMapping("/getBoardList.do")
	public String getBoardList(BoardVO vo,BoardDAO boardDAO, Model model) {

//	public String getBoardList(
//			@RequestParam(value = "serchCondition", defaultValue = "TITLE", required = false) String condition,
//			@RequestParam(value = "serchKeyword", defaultValue = "", required = false) String keyword,
//			BoardDAO boardDAO, Model model) {

		System.out.println("글 목록 검색 처리");
//		System.out.println("검색 조건 : " + condition);
//		System.out.println("검색 단어 : " + keyword);

		model.addAttribute("boardList", boardDAO.getBoardList(vo)); // Model 정보 저장
		return "getBoardList.jsp"; // View 이름 리턴

//		public ModelAndView getBoardList(BoardVO vo, BoardDAO boardDAO, ModelAndView mav) {
//		// (1) 사용자 입력값을 받기 위한 BoardVO 클래스 (2) DB 연동 처리를 위한 BoardDAO 클래스
//		// (3) 검색 결과와 화면 정보를 저장하여 리턴하기 위한 ModelAndView
//		System.out.println("글 목록 검색 처리");
//
//		mav.addObject("boardList", boardDAO.getBoardList(vo)); // Model 정보 저장
//		mav.setViewName("getBoardList.jsp"); // View 정보 저장
//		return mav;
	}

}
