<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <link href="../css/board.css" rel="stylesheet">
    <link href="../css/import.css" rel="stylesheet">
    <script type="text/javascript" src="../script/header.js"></script>
    <script type="text/javascript" src="../script/common.js"></script>

    <title>foodIngredients</title>
</head>
<body>
	<header id="header">
        <div class="header_inner header_sub">
            <jsp:include page="./header.jsp" />
        </div>
    </header>

   <div class="sub_content"></div>

    <section class="sub_title">
        <div class="inner">
            <div class="wrap">
                <h1 class="title">식품으로 찾아보기</h1>
                <div class="route wrap">
                    <a href="./index.html"><img class="home center" src="../images/sub/icon/material-home.svg"
                            alt="홈 아이콘"></a>
                    <div class="route_info wrap">
                        <a href="./foodSearchList.html"><span class="dap1">영양정보 찾아보기</span></a>
                        <a href="./foodSearchList.html"><span class="dap2">식품으로 찾아보기</span></a>
                    </div>
                </div>
            </div>

        </div>

    </section>


    <div id="content">
        <div class="inner">
            <div style="position:relative;">
                <p class="box_tip">선택한 식품에 대한 1회 제공량에 대한 에너지를 나타내고, 1일 영양성분 대비 기준치는 성인을 기준으로 계산했어요.</p>
    
            </div>
    
            <div class="bbsTitle box type02">
                <em>식품 및 음식명</em>
                <h3>${food.foodName}</h3>
                <!-- 제조사 -->
                <span class="sub ref">식품의약품안전처</span>
    
            </div>
            
            <div data-skin-food="table">
                <dl>
                    <dt>데이터구분</dt>
                    <dd>${food.dataSortName}</dd>
                    <dt>식품기원</dt>
                    <dd>${food.foodSortName}</dd>
                    <dt>대표식품명</dt>
                    <dd>${food.repFoodName}</dd>
                    <dt style="width:7%;">식품분류</dt>
                    <dd style="width:22%;">
                        <div class="class-group">
                        	<span class="class-depth01">${food.mainCategoryName}</span>
                        	<span class="class-depth02">${food.midCategoryName}</span>
                        	<span class="class-depth03">${food.subCategoryName}</span></div>
                    </dd>
                </dl>
                
                <dl>
                    <dt>총 내용량</dt>
                    	<dd>${food.foodWeight}</dd>
                    <dt>영양성분 함량 기준량</dt>
                    	<dd>${food.nutStandardAmount}</dd>
                    <dt>1회 섭취참고량</dt>
                    	<dd>${food.refAmountOnce}</dd>
                    <dt>데이터생성방법명</dt>
                    	<dd>${food.dataGenerationMethodName}</dd>
                    <dt>데이터생성일자</dt>
                    	<dd>${food.dataCreationDate}</dd>
                    <dt>데이터기준일자</dt>
                    	<dd>${food.dataBaseDate}</dd>
                </dl>
            </div>
    
            <div class="box_flex mt10">
    
                <div class="btn">
                    <a href="javascript:;" id="excelButton" onclick="history.back();"
                        class="button white docs-creator"><span>이전 화면으로</span></a>
                </div>
            </div>
    
            <div data-skin-food="simple" class="mt20">
                <ul data-skin-food="head">
                    <li>분류</li>
                    <li style="width:30%">영양성분</li>
                    <li style="width:18%">100g 당 함량</li>
                    <li style="width:20%" data-skin-food="input">
                        <div id="defaultServingSizeForm">
                            <input type="number" name="foodAmount" id="servingSize" value="100" size="5" title="영양성분입력항목">
                            <a href="javascript:;" class="button sm black docs-creator"
                                onclick="javascript:fnObj.fnSearch(1);"><span>적용</span></a>
                        </div>
                    </li>
                    <li style="width:15%">1일영양섭취기준(%)</li>
                </ul>
                
                <div data-skin-food="list">
                    <div data-skin-food="row">
    					<c:forEach var="item" items="${nutrientList}" varStatus="status">
    						<c:if test="${status.count == 1}">
    							<em>일반성분</em>
    						</c:if>                        	
                        	<c:if test="${status.count == 7}">
    							<em>기타</em>
    						</c:if>
    						<c:if test="${status.count == 8}">
    							<em>무기질</em>
    						</c:if>
    						<c:if test="${status.count == 13}">
    							<em>비타민</em>
    						</c:if>
    						<c:if test="${status.count == 21}">
    							<em>지방산</em>
    						</c:if>
                        	<div data-skin-food="cell">
	                        	<span></span>
	                            <span style="width:30%">${item.nutrientName}(${item.nutrientUnit})</span>
	                            <span style="width:18%" class="nutrient-content"></span>
	                            <span style="width:20%" class="nutrient-result" data-skin-food="size"></span>
	                            <span style="width:15%" class="tac">13.20%</span>
                            </div>
                    	</c:forEach>
                    </div>
                </div>
    
                <div class="area_btn">
                    <a href="javascript:;" onclick="history.back();"
                        class="button lg black docs-creator"><span>이전화면으로</span></a>
                </div>
            </div>
        </div>

        

    </div>

    <jsp:include page="./footer.jsp" />
    
    
    
    <script>
    	
    $(document).ready(function(){
    	
    	nutrientShow();
    	
    	$('input[name=foodAmount]').change(function(){
    		nutrientShow();
    	});
    	
    });
    
    function nutrientShow(){
    	
    	let foodAmountPer = parseFloat($('input[name=foodAmount]').val() / 100);
    	
    	$('.nutrient-content').eq(0).text('${food.kcal}');
    	let nutrientContent = '${food.kcal}' * foodAmountPer;
    	$('.nutrient-result').eq(0).text(nutrientContent.toFixed(2));
    	$('.nutrient-content').eq(1).text('${food.water}');
    	nutrientContent = '${food.water}' * foodAmountPer;
    	$('.nutrient-result').eq(1).text(nutrientContent.toFixed(2));
    	$('.nutrient-content').eq(2).text('${food.protein}');
    	nutrientContent = '${food.protein}' * foodAmountPer;
    	$('.nutrient-result').eq(2).text(nutrientContent.toFixed(2));
    	$('.nutrient-content').eq(3).text('${food.fat}');
    	nutrientContent = '${food.fat}' * foodAmountPer;
    	$('.nutrient-result').eq(3).text(nutrientContent.toFixed(2));
    	$('.nutrient-content').eq(4).text('${food.carbohydrate}');
    	nutrientContent = '${food.carbohydrate}' * foodAmountPer;
    	$('.nutrient-result').eq(4).text(nutrientContent.toFixed(2));
    	$('.nutrient-content').eq(5).text('${food.sugars}');
    	nutrientContent = '${food.sugars}' * foodAmountPer;
    	$('.nutrient-result').eq(5).text(nutrientContent.toFixed(2));
    	$('.nutrient-content').eq(6).text('${food.dietary_fiber}');
    	nutrientContent = '${food.dietary_fiber}' * foodAmountPer;
    	$('.nutrient-result').eq(6).text(nutrientContent.toFixed(2));
    	$('.nutrient-content').eq(7).text('${food.calcium}');
    	nutrientContent = '${food.calcium}' * foodAmountPer;
    	$('.nutrient-result').eq(7).text(nutrientContent.toFixed(2));
    	$('.nutrient-content').eq(8).text('${food.ironContent}');
    	nutrientContent = '${food.ironContent}' * foodAmountPer;
    	$('.nutrient-result').eq(8).text(nutrientContent.toFixed(2));
    	$('.nutrient-content').eq(9).text('${food.ironContent}');
    	nutrientContent = '${food.ironContent}' * foodAmountPer;
    	$('.nutrient-result').eq(9).text(nutrientContent.toFixed(2));
    	$('.nutrient-content').eq(10).text('${food.potassium}');
    	nutrientContent = '${food.potassium}' * foodAmountPer;
    	$('.nutrient-result').eq(10).text(nutrientContent.toFixed(2));
    	$('.nutrient-content').eq(11).text('${food.sodium}');
    	nutrientContent = '${food.sodium}' * foodAmountPer;
    	$('.nutrient-result').eq(11).text(nutrientContent.toFixed(2));
    	$('.nutrient-content').eq(12).text('${food.vitaminA}');
    	nutrientContent = '${food.vitaminA}' * foodAmountPer;
    	$('.nutrient-result').eq(12).text(nutrientContent.toFixed(2));
    	$('.nutrient-content').eq(13).text('${food.retinol}');
    	nutrientContent = '${food.retinol}' * foodAmountPer;
    	$('.nutrient-result').eq(13).text(nutrientContent.toFixed(2));
    	$('.nutrient-content').eq(14).text('${food.betaCarotene}');
    	nutrientContent = '${food.betaCarotene}' * foodAmountPer;
    	$('.nutrient-result').eq(14).text(nutrientContent.toFixed(2));
    	$('.nutrient-content').eq(15).text('${food.thiamine}');
    	nutrientContent = '${food.thiamine}' * foodAmountPer;
    	$('.nutrient-result').eq(15).text(nutrientContent.toFixed(3));
    	$('.nutrient-content').eq(16).text('${food.riboflavin}');
    	nutrientContent = '${food.riboflavin}' * foodAmountPer;
    	$('.nutrient-result').eq(16).text(nutrientContent.toFixed(3));
    	$('.nutrient-content').eq(17).text('${food.niacin}');
    	nutrientContent = '${food.niacin}' * foodAmountPer;
    	$('.nutrient-result').eq(17).text(nutrientContent.toFixed(2));
    	$('.nutrient-content').eq(18).text('${food.vitaminC}');
    	nutrientContent = '${food.vitaminC}' * foodAmountPer;
    	$('.nutrient-result').eq(18).text(nutrientContent.toFixed(2));
    	$('.nutrient-content').eq(19).text('${food.vitaminD}');
    	nutrientContent = '${food.vitaminD}' * foodAmountPer;
    	$('.nutrient-result').eq(19).text(nutrientContent.toFixed(2));
    	$('.nutrient-content').eq(20).text('${food.cholesterol}');
    	nutrientContent = '${food.cholesterol}' * foodAmountPer;
    	$('.nutrient-result').eq(20).text(nutrientContent.toFixed(2));
    	$('.nutrient-content').eq(21).text('${food.saturatedFat}');
    	nutrientContent = '${food.saturatedFat}' * foodAmountPer;
    	$('.nutrient-result').eq(21).text(nutrientContent.toFixed(2));
    	$('.nutrient-content').eq(22).text('${food.transFat}');
    	nutrientContent = '${food.transFat}' * foodAmountPer;
    	$('.nutrient-result').eq(22).text(nutrientContent.toFixed(2));
    	
    }
    
    </script>
</body>
</html>