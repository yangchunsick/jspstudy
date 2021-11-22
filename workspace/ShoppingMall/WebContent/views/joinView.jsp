<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>회원가입</title>
	<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.css" integrity="sha512-4wfcoXlib1Aq0mUtsLLM74SZtmB73VHTafZAvxIp/Wk9u1PpIsrfmTvK0+yKetghCL8SHlZbMyEcV8Z21v42UQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
    <link rel="stylesheet" href="../css/join.css">
	<script src="../js/join.js"></script>
</head>
<body>

    <div class="container">
        
        <header>
            <h1>LOGO</h1>
        </header>
        
        <section>
			
            <form id="join_form" action="#" method="post">
               
                <div class="join_row">
                    <h3 class="join_title">
                        <label for="id">아이디</label>
                    </h3>
                    <div class="ps_box">
                        <input type="text" id="id" class="int" name="id" autofocus>
                    </div>
                    <p id="id_check"></p>
                </div>
                
                <div class="join_row">
                    <h3 class="join_title">
                        <label for="pwd">비밀번호</label>
                    </h3>
                    <div class="ps_box">
                        <input type="password" id="pwd" class="int" name="pwd">
                        <span id="pwd_icon" class="step_url pwd_icon"></span>
                    </div>
                    <p id="pwd_check"></p>
                </div>
                
                <div class="join_row">
                    <h3 class="join_title">
                        <label for="re_pwd">비밀번호 재확인</label>
                    </h3>
                    <div class="ps_box">
                        <input type="password" id="re_pwd" class="int" name="re_pwd">
                        <span id="re_pwd_icon" class="step_url re_pwd_icon"></span>
                    </div>
                    <p id="re_pwd_check"></p>
                </div>
                <br>
                
                <div class="join_row">
                    <h3 class="join_title">
                        <label for="name">이름</label>
                    </h3>
                    <div class="ps_box no_padding_ps_box">
                        <input type="text" id="name" class="int" name="name">
                    </div>
                    <p id="name_check" class="check_fail"></p>
                </div>
                
                <div class="btn_area">
                    <button id="btn_join" class="btn_type btn_primary">가입하기</button>
                </div>

            </form>
            
        </section>
    
    </div>
    
</body>
</html>