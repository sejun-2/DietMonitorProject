<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>							
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>	
<html>
<head>
<meta charset="UTF-8">
</head>
<body>
	<div class="header_inner">
            <div class="top_nav">
                <div class="inner">
                    <ul class="gnb wrap_s">
	                    <c:choose>
					        <c:when test="${ not empty accountNo and not empty memberNo }">
					            <li class="lnb white mr20">${user.nickname} 님 환영합니다!</li>
					            <li class="lnb main_profile">
	                                <img src="./images/header/chipmunk.jpg" alt="">
		                        </li>
					            <li class="lnb"><a href="/logout" class="logout">로그아웃</a></li>
					        </c:when>
					        <c:otherwise>
					            <li class="lnb"><a href="/login" class="login">로그인</a></li>
		                        <li class="lnb"><a href="/signup" class="signup">회원가입</a></li>
		                        <li class="lnb"><a href="" class="admin">관리자</a></li>
					        </c:otherwise>
					    </c:choose>
                    </ul>
                </div>
            </div>
            <div class="profile">
                <p class="title">프로필 전환</p>
                <ul class="box_wrap wrap">
                    <li class="box">
                        <a href="">
                            <img src="./images/header/ocean.jpg" alt="">
                            <p>누구누구</p>
                        </a>
                    </li>
                    <li class="box">
                        <a href="">
                            <img src="./images/header/ocean.jpg" alt="">
                            <p>누구누구</p>
                        </a>
                    </li>
                    <li class="box">
                        <a href="">
                            <img src="./images/header/ocean.jpg" alt="">
                            <p>누구누구</p>
                        </a>
                    </li>
                    <li class="box">
                        <a href="">
                            <img src="./images/header/ocean.jpg" alt="">
                            <p>누구누구</p>
                        </a>
                    </li>
                </ul>
            </div>
            <div class="nav">
                <div class="inner">
                    <div class="menu_inner wrap">
                        <h1 class="logo">
                            <a href="/">
                                <img src="./images/header/logo/header_logo.png" alt="로고이미지">
                            </a>
                        </h1>
    
                        <div class="menu">
                            <ul class="gnb dap1 wrap">
                                <li class="lnb"><a href="#">영양정보 찾아보기</a>
                                    <ul class="gnb dap2">
                                        <li class="lnb lnb_tit">
                                            <p>영양정보 찾아보기</p>
                                        </li>
                                        <li class="lnb lnb_cont menu-placeholder"></li>
                                    </ul>
                                </li>
                                <li class="lnb"><a href="#">섭취 식품 등록</a>
                                    <ul class="gnb dap2">
                                        <li class="lnb lnb_tit">
                                            <p>섭취 식품 등록</p>
                                        </li>
                                        <li class="lnb lnb_cont menu-placeholder"></li>
                                    </ul>
                                </li>
                                <li class="lnb"><a href="#">마이페이지</a>
                                    <ul class="gnb dap2">
                                        <li class="lnb lnb_tit">
                                            <p>마이페이지</p>
                                        </li>
                                        <li class="lnb lnb_cont menu-placeholder"></li>
                                    </ul>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
    
            </div>
        </div>
</body>
</html>