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
<!-- 

	   $('#pwck').on('blur', function(){
			if($('#pw').val() == $('#pwck').val()){
				alert('비밀번호가 일치 합니다.');
			}else if($('pw').val() != $('#pwck').val()){
				alert('비밀번호를 다시 확인 해주세요.');
				event.prevetDefualt();
			}
		});	

 -->


<script>
	$(document).ready(function(){
		
		/* 아이디 중복 체크 */
		$('#id').on('keyup', function(){
			$.ajax({
				url: 'idCheck.member',		
				type: 'post',
				data: 'id=' + $('#id').val(),
				dataType: 'json',
				success: function(resData){
					if(resData.result == true){
						$('#id_check').text('사용 가능한 아이디 입니다.');
					}else{
						$('#id_check').text('이미 사용중인 아이디 입니다.');
					}
				},
				error: function(xhr){
					alert(xlr.responseText);
				},
			});
		});
			
		/* 비밀번호 재확인 */
		$('#f').on('submit', function(event){
			if($('#pw').val() != $('#pwck').val()){
				alert('비밀번호를 다시 확인 해주세요.');
				event.preventDefault();
				return false;
			}
				return true;
		});
		
	});
</script>
</head>
<body>

	<div>
		<form id="f" action="join.member" method="post">
			<input type="text" name="id" id="id" placeholder="ID">
			<span id="id_check"></span><br>
			<input type="password" name="pw" id="pw" placeholder="PW"> <br>
			<input type="password" name="pwck" id="pwck" placeholder="PW Check"> <br>
			<input type="text" name="name" id="name" placeholder="NAME"> <br>
			<input type="text" name="email" id="email" placeholder="Email"> <br>
			<button>Join</button>
			<input type="reset" value="Reset">
			<input type="button" value="Do Not Join" onclick="location.href='index.jsp'">
		</form>
	</div>

</body>
</html>