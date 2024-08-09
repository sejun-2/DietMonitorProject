<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>							
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>	
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">

    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
    <link rel="stylesheet" href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    <link href="./css/base.css" rel="stylesheet">
    <link href="./css/common.css" rel="stylesheet">
    <script type="text/javascript" src="./script/header.js"></script>

    <title>회원가입</title>
</head>
<body>
	<header id="header">
        <div class="header_inner header_sub">
            <jsp:include page="header.jsp" />
        </div>
    </header>


   <section class="signup">
        <div class="inner">
            <div class="sig_inner">
                <div class="sig_inputs">
                    <div class="sig_title">프로필 추가</div>
					<form action=""  method="post">
	                    <div class="sig_input wrap_s">
	                        <p>프로필 닉네임<span class="red">*</span></p>
	                        <input type="text"  name="nickname" placeholder="이름을 입력해주세요">
	                    </div>
	                    <div class="sig_input wrap_s">
	                        <p>생년월일<span class="red">*</span></p>
	                        <input type="text"  name="birth" placeholder="이름을 입력해주세요">
	                    </div>
	                    <div class="sig_input wrap_s">
	                        <p>성별<span class="red">*</span></p>
	                        <div class="wrap_s">
	                            <input type="radio" name="genderId" value="gender"><span class="mr20">여자</span>
	                            <input type="radio" name="genderId" value="man" checked="checked"><span>남자</span>
	                        </div>
	                   	 </div>
               		</div>
               		<button class="common_btn" type="submit">프로필 추가</button>
                </form>
            </div>


            <section class="signup sig_modify">
                <div class="inner">
                    <div class="sig_inner">
                        <div class="sig_inputs">
                            <div class="sig_title">프로필 관리</div>
        
                            <div class="sig_input active wrap_s">
                                <p>아이디</p>
                                <p class="information">rkdwldms9058</p>
                            </div>
                            <div class="sig_input wrap_s">
                                <p>이름</p>
                                <p class="information">강지은</p>
                            </div>
                            <div class="sig_input wrap_s">
                                <p>나이</p>
                                <p class="information">26</p>
                            </div>
                            <div class="sig_input wrap_s">
                                <p>성별</p>
                                <p class="information">여자</p>
                            </div>
                        </div>
            
                        <button class="common_btn" >프로필삭제</button>
                    </div>
                    
                    
                </div>
        
            </section>
            
            
        </div>

    </section>



    <jsp:include page="footer.jsp" />
</body>
</html>