<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<title>Insert title here</title>
<style>
	.wrap{
		width: 800px; height:200px;
		margin: 300px auto;
		text-align: center;
	}
	.wrap > form > .btn > input,a{
		margin: 10px;
	}
	label{
		width: 
	}
</style>
<script>
	$(document).ready(function() {
		$('.movelistpage').on('click', function() {
			location.href = '/ServerProgram/list.do';
		});
	});
</script>
</head>
<body>

	<div class="wrap">
		<form action="ServerProgram/join.do" method="post">
		<h3>회원 가입 폼</h3>
		<label for="id">
		아이디
		<input id="id" name="ID" type="text">		
		</label>
		<br>
		<label for="name">
		이름
		<input id="name" name="NAME" type="text">		
		</label>
		<input type="hidden" id="no" name="NO">
		<input type="hidden" id="grade" name="GRADE">
		<input type="hidden" id="point" name="POINT">
		<div class="btn">
		<input type="submit" value="회원가입">
		<input type="button" class="movelistpage" value="돌아가기">
		</div>
		</form>
		
	</div>

</body>
</html>