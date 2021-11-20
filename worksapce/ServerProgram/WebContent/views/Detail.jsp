<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<title>Insert title here</title>
<script>
	$(document).ready(function(){
		
		$('#update_btn').on('click', function(){
			alert('수정할 수 없습니다.');
		});
		
		$('#delete_btn').on('click', function(){
			location.href = '/ServerProgram/delete.do';
		});
		
		
	});
</script>
</head>
<body>

<h3>회원 관리 시스템</h3>
<a herf="#">로그아웃</a>
<hr>
<table>
	<thead border="1">
		<tr>
			<td colspan="4">아이디</td>
			<td>이름</td>
			<td>등급</td>
			<td>포인트</td>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${members.ID}</td>
			<td><input type="text" name="name" value="${members.NAME}"></td>
			<td>${members.GRADE}</td>
			<td><input type="text" name="point" value="${members.point}"></td>
		</tr>
	</tbody>
	<tfoot>
		<tr>
			<td><input id="update_btn" type="button" value="수정하기"></td>			
			<td><input id="delete_btn" type="button" value="탈퇴하기"></td>
		</tr>
	</tfoot>
</table>

</body>
</html>