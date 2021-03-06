<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	background-color: black;
	color: white;
}

.wrap {
	width: 800px;
	margin: 200px auto;
}

.title {
	text-align: center;
	color: white;
}

table {
	width: 100%;
	border-collapse: collapse;
}

td {
	height: 30px;
	border-top: 1px solid gray;
	border-bottom: 1px solid gray;
	text-align: center;
}

td input{
	width: 190px; height: 30px;
}

tfoot input {
	width: 90px;
	height: 50px;
	background-color: gray;
	border: 0;
}

tfoot input:hover {
	cursor: pointer;
	background-color: white;
}
</style>
<script>
$(document).ready(function(){
	
	
});
</script>

</head>
<body>

<h1 class="title">조직원 추가</h1>
	<div class="wrap">
		<form action="/YM/familyinsert.do" method="post">
			<table border="1">
				<thead>
					<tr>
						<td>번호</td>
						<td>이름</td>
						<td>부서</td>
						<td>생년월일</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><input type="text" id="num" name="num" autofocus></td>
						<td><input type="text" name="name"></td>
						<td><input type="text" name="depart"></td>
						<td><input type="text" name="birthday"></td>
					</tr>
				</tbody>
				<tfoot>
					<tr>
						<td colspan="4">
							<input type="submit" id="insert_btn" value="등록"> 
							<input type="reset" value="입력 초기화">
							<input type="button" value="조직원 목록" onClick="location.href = '/YM/familyList.do'">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</body>
</html>