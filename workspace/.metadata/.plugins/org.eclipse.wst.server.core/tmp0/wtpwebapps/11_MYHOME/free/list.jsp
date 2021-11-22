<%@page import="dto.Notice"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>My Home Page</title>
<script src="https://code.jquery.com/jquery-3.6.0.js"
	integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk="
	crossorigin="anonymous"></script>
<script>
	
</script>
</head>
<body>
	<h1>
		<a href="index.jsp">WEB PAGE</a>
	</h1>
	
	<hr>
	<!-- 작성 링크 -->
	<div>
		<!-- 로그인 한 유저가 not null일 때 로그인 한 경우에만  -->
		<c:if test="${loginUser.id != null}">
			<a href="insertForm.free">새글작성</a>
		</c:if>
	</div>
	<!-- 검색란 -->


	<!-- 목록 -->
	전체 게시글 : ${totalCount}개
	<table border="1">
		<thead>
			<tr>
				<td>번호</td>
				<td>작성자</td>
				<td style="text-align: center;">내용</td>
				<td>조회수</td>
				<td>최종 수정일</td>
			</tr>
		</thead>
		<tbody>
			<c:if test="${empty list}">
				<tr>
					<td colspan="5" style="text-align: center;">게시물이 존재하지 않습니다.</td>
				</tr>
			</c:if>
			<c:if test="${not empty list}">
				<c:forEach items="${list}" var="free">
					<tr>
						<td style="text-align: center;">${free.fNo}</td>
						<td>${free.writer}</td>
						<td>
							<c:if test="${free.content.length() < 20}">
								<a href="view.free?fNo=${free.fNo}">${free.content}</a>					
							</c:if>
							<c:if test="${free.content.length() >= 20}">
								<a href="view.free?fNo=${free.fNo}">${free.content.substring(0, 20)}</a>					
							</c:if>
						</td>
						<td style="text-align: center;">${free.hit}</td>
						<td>${free.lastModified}</td>
					</tr>
				</c:forEach>
			</c:if>
		</tbody>
		<tfoot>
			<tr>
				<td colspan="5" style="text-align: center;">페이징 처리할 곳</td>
			</tr>
		</tfoot>
	</table>

</body>
</html>