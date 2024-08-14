<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css">
<link rel="stylesheet"
	href="https://unpkg.com/swiper@7/swiper-bundle.min.css" />
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<link href="../css/base.css" rel="stylesheet">
<link href="../css/board.css" rel="stylesheet">
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
				<div class="sig_inputs">
					<div class="sig_title">프로필 추가</div>
					<form action="/addProfile" method="POST">
						<div class="sig_input wrap_s">
							<p>
								프로필 닉네임<span class="red">*</span>
							</p>
							<input type="text" name="nickname" placeholder="이름을 입력해주세요">
						</div>
						
						<div class="sig_input wrap_s">
							<p>프로필 선택<span class="red">*</span></p>
							<div class="cc-selector">
								<c:forEach var="i" begin="1" end="5" step="1">
									<input style="display: none;" id="profile${i}" type="radio" name="iconId" value="${i}" /> 
									<label class="drinkcard-cc profiles" for="profile${i}">
										<img src="../images/header/profile/profile_${i}.png">
									</label>
								</c:forEach>
							</div>
						</div>						
						
						<div class="sig_input wrap_s">
							<p>
								생년월일<span class="red">*</span>
							</p>
							<input type="text" name="birth" placeholder="이름을 입력해주세요">
						</div>
						<div class="sig_input wrap_s">
							<p>
								성별<span class="red">*</span>
							</p>
							<div class="wrap_s">
								<span class="mr20"> <input type="radio" name="genderId"
									value="3" id="male" checked="checked"> <label
									for="male">남자</label>
								</span> <span> <input type="radio" name="genderId" value="4"
									id="female"> <label for="female">여자</label>
								</span>
							</div>
						</div>
					</div>
					<button class="common_btn" type="submit">프로필 추가</button>
				</form>
			</div>


			<section class="table_menu">
				<div class="inner">
					<table id="find_business_table"
						class="new_tbl_board tb01 mt20 mb60">
						<colgroup>
							<col style="width: 2%;">
							<col style="width: 50%;">
							<col style="width: 15%;">
							<col style="width: 15%;">
							<col style="width: auto;">
						</colgroup>
						<thead>
							<tr>
								<th scope="col">번호</th>
								<th scope="col">닉네임</th>
								<th scope="col">나이</th>
								<th scope="col">성별</th>
								<th scope="col">프로필삭제</th>
							</tr>
						</thead>
						<tbody id="memberList">
							<c:forEach var="profile" items="${profiles}" varStatus="status">
								<tr onclick="">
									<td>${status.count}</td>
									<td>${profile.nickname}</td>
									<td>${profile.age}</td>
									<td>${profile.genderName}</td>
									<td>
										<c:if test="${status.count ne 1}">
											<form action="/removeProfile" method="post" onsubmit="return confirm('정말로 삭제하시겠습니까?');">
				                                <input type="hidden" name="accountNo" value="${profile.accountNo}">
				                                <input type="hidden" name="memberNo" value="${profile.memberNo}">
				                                <button class="board_td_btn" type="submit">프로필삭제</button>
				                            </form>
										</c:if>
										
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</section>


		</div>

	</section>



	<jsp:include page="../common/footer.jsp" />
	
	<!-- <script>
	$(document).ready(function(){
		memberListShow();
		
	});
	
		function memberListShow(){
			let requestJsonData = {
				
			}
			let requestJsonDataString = JSON.stringify(requestJsonData);
			
			$.ajax({
				type: "POST",
				url: "http://localhost:8080/findMemberList",
				headers:{
				"Content-type":"application/json;charset:UTF-8"
			},		
			dataType: 'json', 
			data: requestJsonDataString, 
			success: function(userList){
				
			let data = "";
			
			console.log(userList);
				
						/* for(item in userList){
							
							data += "	<tr onclick="">";
							data += "	<td>1</td>";
							data += "	<td>" + profiles[item].nickname + "</td>";
							data += "	<td>" + profiles[item].age + "</td>";
							data += "	<td>" + profiles[item].genderName + "</td>";
							data += "	<td>";
							data += "		<form action=\"/removeProfile\" method=\"post\" onsubmit=\"return confirm('정말로 삭제하시겠습니까?');\">";
							data += "         <input type=\"hidden\" name=\"accountNo\" value=" + userList.accountNo + ">";
							data += "	            <input type=\"hidden\" name=\"memberNo\" value=" + userList.memberNo + ">";
							data += "	            <button class=\"board_td_btn\" type=\"submit\">프로필삭제</button>";
							data += "	        </form>";
							data += "		</td>";
							data += "	</tr>";
					
						} */
							$('#memberList').html(data);
			
						},
						error: function(error){
							console.log('통신에러');
						}
					});
				});
		}	
		

	
	 	
	 	
	 	
	
	

	
	</script> -->
	
	
</body>
</html>