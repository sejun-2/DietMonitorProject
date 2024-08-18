<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <link href="../css/board.css" rel="stylesheet">
    <script type="text/javascript" src="../script/header.js"></script>
    <script type="text/javascript" src="../script/common.js"></script>

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
                    <a href="../index.html"><img class="home center" src="../images/sub/icon/material-home.svg"
                            alt="홈 아이콘"></a>
                    <div class="route_info wrap">
                        <a href="./foodSearchList.html"><span class="dap1">영양정보 찾아보기</span></a>
                        <a href="./foodSearchList.html"><span class="dap2">식품으로 찾아보기</span></a>
                    </div>
                </div>
            </div>

        </div>

    </section>



    <section class="table_menu">
        <div class="inner">
            <div class="wrap">
                <p class="reference">
                    ※ 아래 표를 클릭하시면 해당 식품의 영양정보가 나와요
                </p>

                <button class="board_btn wrap">
                    <img src="./images/sub/icon/material-install-desktop.svg" alt="">
                    <p class="ml10">나의 영양성분 기록 저장</p>
                </button>

            </div>


            <table class="new_tbl_board tbl_boards tb01 mt20 mb20">
                <colgroup>
                    <col style="width: 10%;">
                    <col style="width: 30%;">
                    <col style="width: 15%;">
                    <col style="width: 15%;">
                    <col style="width: 10%;">
                    <col style="width: 10%;">
                </colgroup>
                <thead>
                    <tr>
                        <th scope="col">번호</th>
                        <th scope="col">식품명</th>
                        <th scope="col">식품대분류</th>
                        <th scope="col">식품중분류</th>
                        <th scope="col">에너지(Kcal)</th>
                        <th scope="col">하루 섭취<br>식품 등록</th>
                    </tr>
                </thead>
                <tbody>
                    <tr onclick="">
                        <td>1</td>
                        <td>햄버거</td>
                        <td>빵 및 과자류</td>
                        <td>해당없음</td>
                        <td>225</td>
                        <td>
                            <button class="board_td_btn wrap" type="button">
                                <img src="./images/sub/icon/feather-x-box.svg" alt="">
                                <p>등록취소</p>
                            </button>
                        </td>

                    </tr>

                    <tr class="tr_event">
                        <td class="more_information" colspan="6">
                            <div class="wrap">
                                <img  class="slider-left" data-target=".nutrient1" src="./images/sub/icon/slider/slider-left.svg" alt="">
                                <div class="more_nutrient">
                                    <ul class="nutrient nutrient1 wrap">

                                        <li class="more_item wrap">
                                            <p class="title">중량</p>
                                            <p class="info">100g</p>
                                        </li>
                                        <li class="more_item wrap">
                                            <p class="title">에너지(kcal)</p>
                                            <p class="info">63.0</p>
                                        </li>
                                        <li class="more_item wrap">
                                            <p class="title">탄수화물(g)</p>
                                            <p class="info">8.5</p>
                                        </li>
                                        <li class="more_item wrap">
                                            <p class="title">당류(g)</p>
                                            <p class="info">0.2</p>
                                        </li>
                                        <li class="more_item wrap">
                                            <p class="title">단백질(g)</p>
                                            <p class="info">0.2</p>
                                        </li>
                                        <li class="more_item wrap">
                                            <p class="title">지방(g)</p>
                                            <p class="info">0.2</p>
                                        </li>
                                        <li class="more_item wrap">
                                            <p class="title">포화지방(g)</p>
                                            <p class="info">0.2</p>
                                        </li>
                                        <li class="more_item wrap">
                                            <p class="title">나트륨(mg)</p>
                                            <p class="info">0.2</p>
                                        </li>
                                        <li class="more_item wrap">
                                            <p class="title">비타민 A(μg RA)</p>
                                            <p class="info">0.2</p>
                                        </li>
                                        <li class="more_item wrap">
                                            <p class="title">레티놀(μg)</p>
                                            <p class="info">0.2</p>
                                        </li>
                                        <li class="more_item wrap">
                                            <p class="title">레티놀(μg)</p>
                                            <p class="info">0.2</p>
                                        </li>
                                        <li class="more_item wrap">
                                            <p class="title">레티놀(μg)</p>
                                            <p class="info">0.2</p>
                                        </li>
                                        <li class="more_item wrap">
                                            <p class="title">레티놀(μg)</p>
                                            <p class="info">0.2</p>
                                        </li>
                                    </ul>
                                </div>


                                <img  class="slider-right" data-target=".nutrient1" src="./images/sub/icon/slider/slider-right.svg" alt="">
                            </div>
                        </td>
                    </tr>

                    <tr onclick="">
                        <td>2</td>
                        <td>싸이버거</td>
                        <td>즉석식품류</td>
                        <td>해당없음</td>
                        <td>225</td>
                        <td>
                            <button class="board_td_btn wrap" type="button">
                                <img src="./images/sub/icon/feather-x-box.svg" alt="">
                                <p>등록취소</p>
                            </button>
                        </td>
                    </tr>

                    <tr class="tr_event">
                        <td class="more_information" colspan="6">
                            <div class="wrap">
                                <img  class="slider-left" data-target=".nutrient2" src="./images/sub/icon/slider/slider-left.svg" alt="">
                                <div class="more_nutrient">
                                    <ul class="nutrient nutrient2 wrap">

                                        <li class="more_item wrap">
                                            <p class="title">중량</p>
                                            <p class="info">100g</p>
                                        </li>
                                        <li class="more_item wrap">
                                            <p class="title">에너지(kcal)</p>
                                            <p class="info">63.0</p>
                                        </li>
                                        <li class="more_item wrap">
                                            <p class="title">탄수화물(g)</p>
                                            <p class="info">8.5</p>
                                        </li>
                                        <li class="more_item wrap">
                                            <p class="title">당류(g)</p>
                                            <p class="info">0.2</p>
                                        </li>
                                        <li class="more_item wrap">
                                            <p class="title">단백질(g)</p>
                                            <p class="info">0.2</p>
                                        </li>
                                        <li class="more_item wrap">
                                            <p class="title">지방(g)</p>
                                            <p class="info">0.2</p>
                                        </li>
                                        <li class="more_item wrap">
                                            <p class="title">포화지방(g)</p>
                                            <p class="info">0.2</p>
                                        </li>
                                        <li class="more_item wrap">
                                            <p class="title">나트륨(mg)</p>
                                            <p class="info">0.2</p>
                                        </li>
                                        <li class="more_item wrap">
                                            <p class="title">비타민 A(μg RA)</p>
                                            <p class="info">0.2</p>
                                        </li>
                                        <li class="more_item wrap">
                                            <p class="title">레티놀(μg)</p>
                                            <p class="info">0.2</p>
                                        </li>
                                        <li class="more_item wrap">
                                            <p class="title">레티놀(μg)</p>
                                            <p class="info">0.2</p>
                                        </li>
                                        <li class="more_item wrap">
                                            <p class="title">레티놀(μg)</p>
                                            <p class="info">0.2</p>
                                        </li>
                                        <li class="more_item wrap">
                                            <p class="title">레티놀(μg)</p>
                                            <p class="info">0.2</p>
                                        </li>
                                    </ul>
                                </div>


                                <img class="slider-right" data-target=".nutrient2" src="./images/sub/icon/slider/slider-right.svg" alt="">
                            </div>
                        </td>
                    </tr>

                </tbody>
            </table>
            <button class="common_btn mb80" type="submit">전체등록 취소</button>

    </section>


    <section class="table_menu" id="section1">
        <div class="inner">
            <div class="wrap">
                <p class="table_menu_sub">등록 식품 영양성분 함량 합계</p>

                <div class="pagenation_btn wrap">
                    <div class="slider_prev">
                        <img src="./images/sub/icon/slider/slider-left.svg" alt="">
                    </div>
                    <div class="slider_next">
                        <img src="./images/sub/icon/slider/slider-right.svg" alt="">
                    </div>
                </div>

            </div>

            <div class="table_inner">
                <div class="linear_box">

                </div>
                <table class="new_tbl_board tbl_boards tb01 mt20 mb60">
                    <colgroup>
                        <col style="width: 10%;">
                        <col style="width: 15%;">
                        <col style="width: 10%;">
                        <col style="width: 10%;">
                        <col style="width: 7%;">
                    </colgroup>
                    <thead>
                        <tr>
                            <th scope="col">중량</th>
                            <th scope="col">에너지(kcal)</th>
                            <th scope="col">탄수화물(g)</th>
                            <th scope="col">당류(g)</th>
                            <th scope="col">단백질(g)</th>
                            <th scope="col">지방(g)</th>
                            <th scope="col">단백질(g)</th>
                            <th scope="col">포화지방(g)</th>
                            <th scope="col">나트륨(mg)</th>
                            <th scope="col">비타민 A(μg RA)</th>
                            <th scope="col">레티놀(μg)</th>
                            <th scope="col">레티놀(μg)</th>
                            <th scope="col">레티놀(μg)</th>
                            <th scope="col">레티놀(μg)</th>
                        </tr>
                    </thead>
                    
                    <tbody>
                        <tr onclick="">
                            <td>100</td>
                            <td>0.2</td>
                            <td>0.2</td>
                            <td>0.2</td>
                            <td>0.2</td>
                            <td>0.2</td>
                            <td>0.2</td>
                            <td>0.2</td>
                            <td>0.2</td>
                            <td>0.2</td>
                            <td>0.2</td>
                            <td>0.2</td>
                            <td>0.2</td>
                            <td>0.2</td>
                        </tr>
                    </tbody>
                </table>
            </div>
    </section>

    <section class="table_menu" id="section2">
        <div class="inner">
            <div class="wrap">
                <p class="table_menu_sub">일일 권장량 대비 비교</p>

                <div class="pagenation_btn wrap">
                    <div class="slider_prev">
                        <img src="./images/sub/icon/slider/slider-left.svg" alt="">
                    </div>
                    <div class="slider_next">
                        <img src="./images/sub/icon/slider/slider-right.svg" alt="">
                    </div>
                </div>

            </div>

            <div class="table_inner">
                <div class="linear_box">

                </div>
                <table class="new_tbl_board tb01 mt20 mb60">
                    <colgroup>
                        <col style="width: 10%;">
                        <col style="width: 15%;">
                        <col style="width: 10%;">
                        <col style="width: 10%;">
                        <col style="width: 7%;">
                    </colgroup>
                    <thead>
                        <tr>
                            <th scope="col">중량</th>
                            <th scope="col">에너지(kcal)</th>
                            <th scope="col">탄수화물(g)</th>
                            <th scope="col">당류(g)</th>
                            <th scope="col">단백질(g)</th>
                            <th scope="col">지방(g)</th>
                            <th scope="col">단백질(g)</th>
                            <th scope="col">포화지방(g)</th>
                            <th scope="col">나트륨(mg)</th>
                            <th scope="col">비타민 A(μg RA)</th>
                            <th scope="col">레티놀(μg)</th>
                            <th scope="col">레티놀(μg)</th>
                            <th scope="col">레티놀(μg)</th>
                            <th scope="col">레티놀(μg)</th>
                        </tr>
                    </thead>
                    
                    <tbody>
                        <tr onclick="">
                            <td>100</td>
                            <td>0.2</td>
                            <td>0.2</td>
                            <td>0.2</td>
                            <td>0.2</td>
                            <td>0.2</td>
                            <td>0.2</td>
                            <td>0.2</td>
                            <td>0.2</td>
                            <td>0.2</td>
                            <td>0.2</td>
                            <td>0.2</td>
                            <td>0.2</td>
                            <td>0.2</td>
                        </tr>
                    </tbody>
                </table>
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
						<img src="../images/sub/icon/slider/akar-chevron-left-small.svg"
							alt="">
					</div>
					<div class="slide_stop">
						<img src="../images/sub/icon/slider/akar-two-line-vertical.svg"
							alt="">
					</div>
					<div class="slide_next">
						<img src="../images/sub/icon/slider/akar-chevron-right-small.svg"
							alt="">
					</div>
				</div>
			</div>

			<div class="slide_cont_box swiper-container">
                <div class="swiper-wrapper">
                    <div class="slide_box wrap">
                        <div class="box swiper-slide">
						<div class="title_food">에너지(kcal)</div>
						<div class="info">
							<div class="info_title">칼로리 섭취가 부족할 경우</div>
							<div class="info_detail">허기가 지고 신진대사가 늦어짐. 지방대신 근육을 태움
								근육이 제대로 회복되질 못함 몸이 무겁고 피곤함이 계속됨...</div>
						</div>
						<div class="more">상세보기</div>
					</div>
				</div>

				<div class="slide_box wrap">
					<div class="box swiper-slide">
						<div class="title_food">탄수화물(g)</div>
						<div class="info">
							<div class="info_title">탄수화물 섭취가 부족할 경우</div>
							<div class="info_detail">탄수화물 섭취가 부족하면 저혈당 증상이 나타나고, 피로감, 무기력감, 활력 저하, 정신 기능 지체, 수면 부족 등의 증상이 나타날 수 있습니다. 
								또한 탄수화물이 부족하면 지방뿐만 아니라 근육을 에너지원으로 활용하여 근손실이 일어나고, 심각할 경우 일상생활에서 어려움을 겪을 수 있습니다...</div>
						</div>
						<div class="more">상세보기</div>
					</div>
				</div>

				<div class="slide_box wrap">
					<div class="box swiper-slide">
						<div class="title_food">당류(g)</div>
						<div class="info">
							<div class="info_title">당 섭취가 부족할 경우</div>
							<div class="info_detail">당류 부족으로 인해 저혈당증이 발생할 수 있습니다. 저혈당증은 혈액 속 포도당 농도가 필요량보다 부족한 상태를 말하며, 
								혈당이 70mg/dL 이하로 떨어지면 에너지가 부족하다는 신호로 증상이 나타납니다....</div>
						</div>
						<div class="more">상세보기</div>
					</div>
				</div>
			</div>

		</div>
		</div>
	</section>

	<div class="popup">
		<div class="box">
			<div class="close">
				<img src="../images/sub/icon/close-x.svg" alt="">
			</div>
			<div class="title">칼로리 섭취가 부족할 경우 나타나는 현상</div>
			<div class="info">신체가 기능하려면 단백질이 필요하며 근육은 이 단백질의 주요 공급원입니다. 근육 이화작용이 발생하여 신체가 근육 단백질을 동원하여 칼로리로 전환하게 됩니다. 
								결과적으로 근육이 작아집니다. 칼로리가 부족한 식단과 규칙적인 운동을 하면 지방이 많이 줄어들더라도 근육량도 감소하게 됩니다. 그로인해
								허기가 지고 신진대사가 늦어지며, 지방대신 근육을 태우기 시작합니다. 근육이 제대로 회복되질 못하며 몸이 무겁고 피곤함이 계속됩니다. 
								면역력이 강해지지 않고 아프거나 부상을 입을 확률이 높아집니다. 비타민B군, 비타민D 결핍이 발생할 수 있습니다.</div>

			<div class="wrap_s mt40 mb30">
				<img src="../images/sub/icon/Icon fa-solid-star.svg" alt="">
				<p class="popup_title">일일 권장량 대비 부족 영양소 별 추천 검색</p>
			</div>
			<ul class="tag_inner wrap_s">
				<li class="tag">#건강한 식단</li>
				<li class="tag">#풍부한 채소</li>
				<li class="tag">#단백질</li>
				<li class="tag">#불포화 지방산</li>
			</ul>
		</div>
	</div>
	
	<div class="popup">
		<div class="box">
			<div class="close">
				<img src="../images/sub/icon/close-x.svg" alt="">
			</div>
			<div class="title">탄수화물 섭취가 부족할 경우 나타나는 현상</div>
			<div class="info">탄수화물 섭취가 부족하면 저혈당 증상이 나타나고, 피로감, 무기력감, 활력 저하, 정신 기능 지체, 수면 부족 등의 증상이 나타날 수 있습니다. 
				또한 탄수화물이 부족하면 지방뿐만 아니라 근육을 에너지원으로 활용하여 근손실이 일어나고, 심각할 경우 일상생활에서 어려움을 겪을 수 있습니다. 
				탄수화물은 근육을 움직이는 연료로, 근육을 움직여야 근육이 만들어집니다. 탄수화물이 부족하면 우리 몸은 당을 만들기 위해 근육을 분해하여 근육이 줄어들 수 있습니다. 
				또한 탄수화물 섭취가 부족하면 몸에서는 포도당을 대신할 다른 에너지원을 만들어내기 위해 지방을 분해하여 케톤체가 합성되기도 합니다.</div>

			<div class="wrap_s mt40 mb30">
				<img src="../images/sub/icon/Icon fa-solid-star.svg" alt="">
				<p class="popup_title">일일 권장량 대비 부족 영양소 별 추천 검색</p>
			</div>
			<ul class="tag_inner wrap_s">
				<li class="tag">#현미</li>
				<li class="tag">#보리</li>
				<li class="tag">#귀리</li>
				<li class="tag">#통곡물</li>
				<li class="tag">#과일</li>
			</ul>
		</div>
	</div>

	<!-- ---------------------그래프-------------------------- -->

	<div class="graph">
		<div class="inner">
			<div class="wrap">
				<c:forEach var="i" begin="1" end="23">
					<div class="graphBox" style="width: 48%; height: 400px;">
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