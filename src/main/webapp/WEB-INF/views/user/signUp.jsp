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
    <link href="../css/base.css" rel="stylesheet">
    <link href="../css/common.css" rel="stylesheet">
    <script type="text/javascript" src="../script/header.js"></script>

    <title>회원가입</title>
</head>
<body>
	<header id="header">
        <div class="header_inner header_sub">
            <jsp:include page="../common/header.jsp" />
        </div>
    </header>


    <section class="signup">
        <div class="inner">
            <div class="sig_inner">
            	<form id="commentForm" action="/signup" method="post">
	                <div class="sig_inputs">
	                    <div class="sig_title">회원가입</div>
		                    <div class="sig_input">
			                    <div class="wrap_s">
			                        <p>이메일<span class="red">*</span></p>
			                        <input type="text" name="email" id="inputEmail" placeholder="이메일을 입력해 주세요" value="${user.email}">
			                        <button class="check_btn" type="button">중복확인</button>
									<span class="red" id="dupMsg"></span>
			                    </div>
		                        <c:if test="${ not empty userValidError.email}">
									<span class="check_info red">${userValidError.email}</span>
								</c:if>
							</div>
							
		                    <div class="sig_input wrap_s">
		                        <p>비밀번호<span class="red">*</span></p>
		                        <input type="password" name="pw" placeholder="비밀번호를 입력해 주세요" value="${user.pw}">
		                        <c:if test="${ not empty userValidError.pw }">
									<br/>
										<span class="red">${userValidError.pw}</span>
									<br/>
								</c:if>
		                    </div>
		                    <div class="sig_input wrap_s">
		                        <p>비밀번호 확인<span class="red">*</span></p>
		                        <input type="password" name="chkPw" placeholder="비밀번호를 한번 더 입력해 주세요" value="${user.chkPw}">
		                        <c:if test="${ not empty userValidError.chkPw }">
									<br/>
										<span class="red">${userValidError.chkPw}</span>
									<br/>
								</c:if>
		                    </div>
		                    <div class="sig_input wrap_s">
		                        <p>이름<span class="red">*</span></p>
		                        <input type="text" name="name" placeholder="이름을 입력해주세요" value="${user.name}">
		                        <c:if test="${ not empty userValidError.name }">
									<br/>
										<span class="red">${userValidError.name}</span>
									<br/>
								</c:if>
		                    </div>
		                    <div class="sig_input wrap_s">
		                        <p>프로필 닉네임<span class="red">*</span></p>
		                        <input type="text" name="nickname" placeholder="비밀번호를 입력해 주세요" value="${user.nickname}">
		                        <c:if test="">
									<br/>
										<span class="red"></span>
									<br/>
								</c:if>
		                    </div>
						
							<div class="sig_input wrap_s">
		                        <p>전화번호<span class="red">*</span></p>
		                        <input type="tel" name="tel" placeholder="전화번호를 입력해주세요" value="${user.tel}">
		                        <c:if test="${ not empty userValidError.tel }">
									<br/>
										<span class="red">${userValidError.tel}</span>
									<br/>
								</c:if>
		                    </div>
		                    <div class="sig_input wrap_s">
		                        <p>생년월일<span class="red">*</span></p>
		                        <input type="text" name="birth" placeholder="생년월일 6자리를 입력해주세요" value="${user.birth}">
		                        <c:if test="${ not empty userValidError.birth }">
									<br/>
										<span class="red">${userValidError.birth}</span>
									<br/>
								</c:if>
		                    </div>
		                    <div class="sig_input wrap_s">
		                        <p>성별<span class="red">*</span></p>
		                        <div class="wrap_s">
		                        	<span class="mr20">
		                        		<input type="radio" name="genderId"  value="3"  id="male" checked="checked">
		                        		<label for="male">남자</label>
		                        	</span>
		                            <span>
		                            	<input type="radio" name="genderId"  value="4" id="female">
		                            	<label for="female">여자</label>
		                            </span>
		                        </div>
		                    </div>
		                </div>
                		<button class="common_btn" type="submit">가입하기</button>
                </form>
            </div>
        </div>
    </section>
    
    <script>
    
		$(document).ready(function(){
			
			let emailDupChk;
			
			
			$('#inputEmail').change(function(){
				emailDupChk = false;
			});
			
			$('.common_btn').click(function(){
				if(emailDupChk == true){
					$('#commentForm').submit();
				} else {
					alert("중복 확인 해주세요");
					event.preventDefault();
					$('#inputEmail').focus();					
				}
			});
			
			$('.check_btn').click(function(){
				
				let inputEmail = $('#inputEmail').val();
				
				let requestJsonData = {
					'email':inputEmail,
				};
				
				let requestJsonDataString = JSON.stringify(requestJsonData);
				
				$.ajax({
					type: "POST",
					url: "http://localhost:8080/user/isDuplicatedEmail",
					headers:{
						"Content-type":"application/json;charset:UTF-8"
					},
					dataType: 'json',
					data:requestJsonDataString,
					success: function(result){
					
						if(result.header.resultCode == '200'){
							$('#dupMsg').text('사용 가능한 이메일입니다.');
							emailDupChk = true;
						} else if(result.header.resultCode == '10') {
							$('#dupMsg').text('올바르지 않은 이메일 형식입니다.');
							emailDupChk = false;
						} else {
							$('#dupMsg').text('이미 가입된 이메일입니다.');
							emailDupChk = false;
						}
					},
					error: function(error){
						console.log(error);
					}
				});
			});
			
		});
	</script>



    <jsp:include page="../common/footer.jsp" />
</body>
</html>