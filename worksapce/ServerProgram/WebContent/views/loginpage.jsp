<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.wrap{
		width: 200px; height:200px;
		margin: 300px auto;
		text-align: center;
	}
	.wrap > form > .btn > input,a{
		margin: 10px;
	}
</style>
</head>
<body>

	<div class="wrap">
		<form action="/ServerProgram/login.do" method="post">
		<h3>회원 관리 프로그램</h3>
		<input type="text" name="" placeholder="아이디">
		<br>
		<input type="text" name="" placeholder="이름">
		<div class="btn">
		<input type="submit" value="로그인">
		<a href="/ServerProgram/views/join.jsp">회원가입</a>
		</div>
		</form>
		
	</div>

</body>
</html>