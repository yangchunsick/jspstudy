<%@page import="java.util.ArrayList"%>
<%@page import="dto.Board"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%-- 1, 2, 3, 4, 5 --%>

	<c:forEach var="i" begin="1" end="5" step="1">
		<h1> ${(1 + 5) - i}&nbsp; </h1>
	</c:forEach>
	<hr>
	
	<%-- 1950년 ~ 2021년 
	
	<select name="year">
		<c:forEach var="y" begin="2021" end="1950" step="1">
			<option value="${(2021 - 1950) - y}">${y}년</option>
		</c:forEach>
	</select>
	--%>
	
	
	<%-- 1월 ~ 12월 --%>
	<select name="month">
		<c:forEach var="m" begin="1" end="12" step="1">
			<option value="${m}">${m}월</option>
		</c:forEach>
	</select>
	<hr>
	<%-- 배열 --%>
	
	<% String[] menu = {"김밥", "떡볶이", "순대"};
		pageContext.setAttribute("menu", menu);
	%>	
	<c:forEach var="food" items="${menu}" varStatus="v">
		인덱스 : ${v.index}, 요소 번호: ${v.count}, 요소: ${food}<br>
	</c:forEach>
	<hr>
	
	<%-- List --%>
	<%
		List<String> hobbies = Arrays.asList("여행", "독서", "요가");
		pageContext.setAttribute("hobbies", hobbies);
	%>
	<c:forEach var="hobby" items="${hobbies}" varStatus="k">
		인덱스 : ${k.index}, 요소 : ${hobby} <br>	
	</c:forEach>
	
	<%-- List<Board> --%>
	<%
	List<Board> list = new ArrayList<>();
	list.add(new Board("공지사항", "관리자", 1589));
	list.add(new Board("필독", "카페지기", 3547));;
	list.add(new Board("출석!", "서교동멋쟁이", 3237));;
	pageContext.setAttribute("list", list);
	%>
	<table border="1">
		<thead>
			<tr>
				<td>글번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>조회수</td>
			</tr>		
		</thead>
		<tbody>
			<c:forEach var="board" items="${list}" varStatus="v">
				<tr>
					<td>${v.count}</td>
					<td><a href="#?no=${v.count}">${board.title}</a></td>
					<td>${board.writer}</td>
					<td>${board.view}</td>
				</tr>
			</c:forEach>
		</tbody>
	
	</table>
	

</body>
</html>