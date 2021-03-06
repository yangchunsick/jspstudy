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
<style>
	label{
		display: block;
		margin-top: 10px;
	}
	textarea {
		width: 178px; height: 90px;
	}
</style>
<script>
	$(document).ready(function (){
		fnInsertBoard();
		fnFileCheck();
	});
	
	function fnInsertBoard() {
		$('#insert_btn').on('click', function(){
			if($('#title').val() == ''){
				alert('제목은 필수 입니다.');
				$('#title').focus();
				return;
			}else if($('#fileName').val() == ''){
				alert('이미지 첨부는 필수 입니다.');
				return;
			}
			$('#f').attr('action', 'insert.board');		// action을 주는 속성은 attr
			$('#f').submit();
		}); // #insert_btn
	}// end fnemptyCheck
	
	function fnFileCheck(){
		$('#fileName').on('change', function(event){
			/*
				이벤트 대상
				event.target
				this
				#fileName
			*/
			
			/* 첨부 파일의 확장자 제한하기 */
			/*
				파일명.확장자
				마지막 . 인덱스 : 3  (lastIndexOf())
				3 + 1 인덱스부터 끝까지 추출  (substring())
			*/
			let fullname = $(this).val();
			let extension = fullname.substring(fullname.lastIndexOf('.') + 1).toUpperCase();	//toUpperCase(); 대문자로 변환해서 받아 옴
			let extList = ['JPG', 'JPEG', 'PNG', 'GIF'];
			if ($.inArray(extension, extList) == -1) {  // 배열에 찾는 요소가 없으면 -1을 반환
				alert('확장자가 jpg, jpeg, png, gif인 파일만 업로드 할 수 있습니다.');
				$(this).val('');  // 첨부된 파일명을 빈 문자열로 바꿈 => 첨부가 없어짐.
				return false;
			}
			
			/* 첨부 파일의 용량 제한하기 */
			let maxSize = 10 * 1024 * 1024;  // 10메가 * 1024킬로바이트 * 1024바이트
			let fileSize = $(this)[0].files[0].size;
			if (maxSize < fileSize) {
				alert('10MB 이하의 파일만 업로드 할 수 있습니다.');
				$(this).val('');
				return false;
			}
		});
	} // end fnFileCheck
</script>
</head>
<body>

	<div>
			<!-- 파일 첨부 폼 
					1. method="post"
					2. enctype="multipart/form-data"
			 -->
			 
		<form id="f" method="post" enctype="multipart/form-data">
			
			<label for="writer">작성자</label>
			<input type="text" id="writer" name="writer" value="${loginUser.id}" readonly>
			
			<label for="title">제목</label>
			<input type="text" id="title" name="title" autofocus>
			
			<label for="fileName">이미지</label>
			<input type="file" id="fileName" name="fileName">
			
			<label for="content">내용</label>
			<textarea id="content" name="content"></textarea>
			
			<br><br>
			
			<div class="btn_area">
				<input type="button" id="insert_btn" value="입력 완료">
				<input type="reset">
				<input type="button" value="목록" onclick="location.href='list.board'">
			</div>
			
		</form>

	</div>












</body>
</html>