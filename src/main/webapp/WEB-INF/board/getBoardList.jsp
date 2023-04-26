<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>


<%-- <%
	//세션에 저장된 글 목록을 꺼낸다.
	//위와 달리 직접 DB연동을 처리하지 않고 자바코드는 controller인 DispatcherServlet 클래스로 이동, 단지 세션에 저장된 글 목록을 꺼내서 출력하는 기능만 제공한다.
	List<BoardVO> boardList = (List) session.getAttribute("boardList");	
%> --%>

<!DOCTYPE html PUBLIC "-//W3C/DTD HTML 4.01 Transitional//EN"
					  "http://www.w3.org/TR/html4.loose.dtd">

<html>
<head>
<meta charset="UTF-8" http-equiv="Content-Type" content="text/html">
<title>글 목록</title>
</head>
<body>
	<center>
		<h1>글 목록</h1>
		<h3>
			테스트님 환영합니다.<br>
			<%-- <a href="logout_proc.jsp">Log-out</a> --%>
			<a href="logout.do">Log-out</a>
		</h3>

		<%-- 검색 시작 --%>
		<form action="getBoardList.jsp" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="right"><select name="searchCondition">
							<option value="TITLE">제목</option>
							<option value="CONTENT">내용</option>
					</select> <input name="searchKeyword" type="text" /> <input type="submit"
						value="검색" /></td>
				</tr>
			</table>
		</form>
		<%-- 검색 종료 --%>

		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="#BBDEFB" width="100">번호</th>
				<th bgcolor="#BBDEFB" width="200">제목</th>
				<th bgcolor="#BBDEFB" width="150">작성자</th>
				<th bgcolor="#BBDEFB" width="150">등록일</th>
				<th bgcolor="#BBDEFB" width="100">조회수</th>
			</tr>

			<c:forEach items="${boardList}" var="board">
				<tr>
					<td>${board.seq}</td>
					<td align="left">
						<%-- <a href="getBoard.jsp?seq=<%=board.getSeq()%>"><%=board.getTitle()%></a> --%>
						<a href="getBoard.do?seq=${board.seq}">${board.title}</a>
					</td>
					<td>${board.writer}</td>
					<td>${board.regDate}</td>
					<td>${board.cnt}</td>
				</tr>
			</c:forEach>
		</table>
		<br> <a href="insertBoard.jsp">새글 등록</a>
	</center>
</body>
</html>
