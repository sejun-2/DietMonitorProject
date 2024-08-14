<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<link href="../css/common.css" rel="stylesheet">
<link href="../css/board.css" rel="stylesheet">
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/4.4.1/chart.umd.js"
	integrity="sha512-ZwR1/gSZM3ai6vCdI+LVF1zSq/5HznD3ZSTk7kajkaj4D292NLuduDCO1c/NT8Id+jE58KYLKT7hXnbtryGmMg=="
	crossorigin="anonymous" referrerpolicy="no-referrer"></script>
<script type="text/javascript" src="../script/header.js"></script>
<script type="text/javascript" src="../script/common.js"></script>
<script type="text/javascript" src="../script/graph.js"></script>

<title>foodIngredients</title>
</head>
<body>
	<header id="header">
		<div class="header_inner header_sub">
			<jsp:include page="../common/header.jsp" />
		</div>
	</header>



	<div class="sub_content"></div>

	<section class="sub_title">
		<div class="inner">
			<div class="wrap">
				<h1 class="title">식품으로 찾아보기</h1>
				<div class="route wrap">
					<a href="../index.html"><img class="home center"
						src="../images/sub/icon/material-home.svg" alt="홈 아이콘"></a>
					<div class="route_info wrap">
						<a href="./foodSearchList.html"><span class="dap1">영양정보
								찾아보기</span></a> <a href="./foodSearchList.html"><span class="dap2">식품으로
								찾아보기</span></a>
					</div>
				</div>
			</div>

		</div>

	</section>




	<section class="decibal_title mb80">
		<div class="inner">
			<div class="info">
				<span class="blue_style">에너지(kcal),</span> <span class="blue_style">탄수화물(g),</span>
				<span class="blue_style">지방(g)</span> <span class="text">섭취가
					너무 적어요.</span>
			</div>
			<div class="wrap mb50">
				<p class="text">부족한 영양성분의 상세 설명과 추천 식품이 궁금하시다면 해당 영양성분의 상세보기를
					눌러주세요.</p>
				<div class="page_nation wrap">
					<div class="slide_prev">
						<img src="./images/sub/icon/slider/akar-chevron-left-small.svg"
							alt="">
					</div>
					<div class="slide_stop">
						<img src="./images/sub/icon/slider/akar-two-line-vertical.svg"
							alt="">
					</div>
					<div class="slide_next">
						<img src="./images/sub/icon/slider/akar-chevron-right-small.svg"
							alt="">
					</div>
				</div>
			</div>

			<div class="slide_cont_box wrap">
				<div class="linear_box"></div>
				<div class="slide_box wrap">
					<div class="box">
						<div class="title_food">에너지(kcal)</div>
						<div class="info">
							<div class="info_title">에너지가 부족할 경우</div>
							<div class="info_detail">하루종일 힘이없다. 칼로리는 우리 몸이 움직이고 활동하는데
								필요한 에너지이다. 하루 섭취 칼로리 가 너무 적다는 것은 기름 없는 자동차나 마찬가...</div>
						</div>
						<div class="more">상세보기</div>
					</div>
				</div>

				<div class="slide_box wrap">
					<div class="box">
						<div class="title_food">에너지(kcal)</div>
						<div class="info">
							<div class="info_title">에너지가 부족할 경우</div>
							<div class="info_detail">하루종일 힘이없다. 칼로리는 우리 몸이 움직이고 활동하는데
								필요한 에너지이다. 하루 섭취 칼로리 가 너무 적다는 것은 기름 없는 자동차나 마찬가...</div>
						</div>
						<div class="more">상세보기</div>
					</div>
				</div>

				<div class="slide_box wrap">
					<div class="box">
						<div class="title_food">에너지(kcal)</div>
						<div class="info">
							<div class="info_title">에너지가 부족할 경우</div>
							<div class="info_detail">하루종일 힘이없다. 칼로리는 우리 몸이 움직이고 활동하는데
								필요한 에너지이다. 하루 섭취 칼로리 가 너무 적다는 것은 기름 없는 자동차나 마찬가...</div>
						</div>
						<div class="more">상세보기</div>
					</div>
				</div>
			</div>

		</div>
	</section>

	<div class="popup">
		<div class="box">
			<div class="close">
				<img src="./images/sub/icon/close-x.svg" alt="">
			</div>
			<div class="title">에너지가 부족할 경우 나타나는 현상</div>
			<div class="info">하루종일 힘이없다. 칼로리는 우리 몸이 움직이고 활동하는데 필요한 에너지이다.
				하루 섭취 칼로리가 너무 적다는 것은 기름 없는 자동차나 마찬가지 하루종일 힘이없다. 칼로리는 우리 몸이 움직이고
				활동하는데 필요한 에너지이다. 하루 섭취 칼로리가 너무 적다는 것은 기름 없는 자동차나 마찬가지 하루종일 힘이없다.
				칼로리는 우리 몸이 움직이고 활동하는데 필요한 에너지이다. 하루 섭취 칼로리가 너무 적 다는 것은 기름 없는 자동차나
				마찬가지 하루종일 힘이없다. 칼로리는 우리 몸이 움직이고 활동하는데 필요한 에너지이다. 칼로리는 우리 몸이 움직이고
				활동하는데 필요한 에너지이다. 하루 섭취 칼로리가 너무 적다는 것은 기름 없는 자동차나 마찬가지 하루종일 힘이없다.
				칼로리는 우리 몸이 움직이고 활동하는데 필요한 에너지이다. 다다다다다다다다</div>

			<div class="wrap_s mt40 mb30">
				<img src="./images/sub/icon/Icon fa-solid-star.svg" alt="">
				<p class="popup_title">일일 권장량 대비 부족 영양소 별 추천 검색</p>
			</div>
			<ul class="tag_inner wrap_s">
				<li class="tag">#햄버거</li>
				<li class="tag">#아이스크림</li>
				<li class="tag">#햄버거</li>
				<li class="tag">#아이스크림</li>
				<li class="tag">#아이스크림</li>
				<li class="tag">#햄버거</li>
			</ul>
		</div>
	</div>

	<!-- ---------------------그래프-------------------------- -->

	<div class="graph">
		<div class="inner">
			<div class="wrap_s">
				<c:forEach var="i" begin="1" end="23">
					<div class="graphBox" style="width: 600px; height: 400px;">
						<canvas class="lineCanvas"></canvas>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>

	<!-- ---------------------DB그래프-------------------------- -->

	<script type="text/javascript">
		//JSP에서 값을 JavaScript 변수로 전달

		var grapeData = [];

		var nutrienStandard = [];		
		<c:forEach var="Standard" items="${findTotalDietByStandard}">
			<c:if test="${Standard.foodIntake == 9999}">
				nutrienStandard.push(0);
			</c:if>
			<c:if test="${Standard.foodIntake != 9999}">
				nutrienStandard.push('${Standard.foodIntake}');
			</c:if>
		</c:forEach>
		
		grapeData.push(nutrienStandard);
		
		nutrientIntakePrograss = [];
		
		<c:forEach var="item" items="${totalDietListMonthSum}">
			var nutrientIntakeItem = {
				saveDate : '${item.saveDate}',
				kcal : '${item.kcal}',
				water : '${item.water}',
				protein : '${item.protein}',
				fat : '${item.fat}',
				batch : '${item.batch}',
				carbohydrate : '${item.carbohydrate}',
				sugars : '${item.sugars}',
				dietaryFiber : '${item.dietaryFiber}',
				calcium : '${item.calcium}',
				ironContent : '${item.ironContent}',
				phosphorus : '${item.phosphorus}',
				potassium : '${item.potassium}',
				sodium : '${item.sodium}',
				vitaminA : '${item.vitaminA}',
				retinol : '${item.retinol}',
				betaCarotene : '${item.betaCarotene}',
				thiamine : '${item.thiamine}',
				riboflavin : '${item.riboflavin}',
				niacin : '${item.niacin}',
				vitaminC : '${item.vitaminC}',
				vitaminD : '${item.vitaminD}',
				cholesterol : '${item.cholesterol}',
				saturatedFat : '${item.saturatedFat}',
				transFat : '${item.transFat}'
			};	
			nutrientIntakePrograss.push(nutrientIntakeItem);
		</c:forEach>
		
		grapeData.push(nutrientIntakePrograss);		
		
		document.addEventListener('DOMContentLoaded', function() {			
			lineChart(grapeData); //한달
		});
	</script>


	<jsp:include page="../common/footer.jsp" />
</body>
</html>