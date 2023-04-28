<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>


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
<title><spring:message code="message.board.list.mainTitle" /></title>
</head>
<body>
	<center>
		<h1>
			<spring:message code="message.board.list.mainTitle" />
		</h1>
		<h3>
			${userName}
			<spring:message code="message.board.list.welcomeMsg" />
			<br>
			<%-- <a href="logout_proc.jsp">Log-out</a> --%>
			<a href="logout.do">Log-out</a>
		</h3>

		<%-- 검색 시작 --%>
		<form action="getBoardList.do" method="post">
			<table border="1" cellpadding="0" cellspacing="0" width="700">
				<tr>
					<td align="right"><select name="searchCondition">
							<%-- <option value="TITLE">제목</option>
							<option value="CONTENT">내용</option> --%>
							<c:forEach items="${conditionMap }" var="option">
								<option value="${option.value}">${option.key }</option>
							</c:forEach>
					</select> <input name="searchKeyword" type="text" /> <input type="submit"
						value="<spring:message code="message.board.list.search.condition.btn" />" /></td>
				</tr>
			</table>
		</form>
		<%-- 검색 종료 --%>

		<table border="1" cellpadding="0" cellspacing="0" width="700">
			<tr>
				<th bgcolor="#BBDEFB" width="100"><spring:message
						code="message.board.list.table.head.seq" /></th>
				<th bgcolor="#BBDEFB" width="200"><spring:message
						code="message.board.list.table.head.title" /></th>
				<th bgcolor="#BBDEFB" width="150"><spring:message
						code="message.board.list.table.head.writer" /></th>
				<th bgcolor="#BBDEFB" width="150"><spring:message
						code="message.board.list.table.head.regDate" /></th>
				<th bgcolor="#BBDEFB" width="100"><spring:message
						code="message.board.list.table.head.cnt" /></th>
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
		<br> <a href="insertBoard.jsp"><spring:message
				code="message.board.list.link.insertBoard" /></a>
	</center>
</body>
</html>
