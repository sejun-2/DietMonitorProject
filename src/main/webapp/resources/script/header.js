$(document).ready(function () {

    function generateMenuItems() {
        const items = [
            {
                text: '식품으로 찾아보기',
                href: '/foodSearch',
                subItems: []
            },
            {
                text: '하루섭취 식품 등록',
                href: '/diet/dailyDiet',
                subItems: []
            },
            {
                text: '내 정보',
                href: '/mypage/accountInfo',
                subItems: [
                    { text: '내 정보 수정', href: '/mypage/modifyAccount' },
                    { text: '나의 하루 섭취 식품', href: '/mypage/dietProgress' },
                    { text: '나의 영양성분 저장 기록', href: '/mypage/dietHistory' },
                    { text: '나의 영양성분 일일 권장량', href: '/diet/dailyDiet' },
                    { text: '나의 영양성분 비교분석', href: '/mypage/nutritionStandard' }
                ]
            }
        ];

        const ulWrap = $('<ul>').addClass('dap3 wrap');

        items.forEach(item => {
            const li = $('<li>');
            const ulInner = $('<ul>').addClass('dap4');
            const liInner = $('<li>').append($('<a>').attr('href', item.href).text(item.text));
            ulInner.append(liInner);

            item.subItems.forEach(subItem => {
                const subLi = $('<li>').append($('<a>').attr('href', subItem.href).text(subItem.text));
                ulInner.append(subLi);
            });

            li.append(ulInner);
            ulWrap.append(li);
        });


        $('.menu-placeholder').each(function () {
            $(this).append(ulWrap.clone());
        });
    }

    generateMenuItems();
    
    
    
    
    
    $("#header .profile").hide();
    $("#header .top_nav .gnb .lnb.main_profile").on('click', function(){
        $("#header .profile").toggle();
    }); 


    //header_menu_slider

    let subToggle = true;
    let subHeader = $("#header .header_inner.header_sub");
    let topNav = $("#header .top_nav");
    let haderInner = $("#header .header_inner");
    let nav = $("#header .nav");
    let navLnb = $("#header .nav .dap1 > .lnb");

    if (subHeader.length) {
        topNav.addClass('active');
        nav.css('background', 'white');
        nav.addClass('active');

        
    }else{
        nav.hover(
            function () {

            }, function(){
                topNav.removeClass('active');
                nav.css('background', 'none');
            });
    }



    navLnb.hover(function () {

            var i = navLnb.index(this);
            console.log(i);

            navLnb.find('ul.dap2').css('display', 'none');
            navLnb.children('a').css('color', '');

            topNav.addClass('active');
            nav.css('background', 'white');
            navLnb.eq(i).find('ul.dap2').css('display', 'block');
            navLnb.eq(i).children('a').css('color', '#0094E1');
        
        });

    nav.hover(
        function () {
            navLnb.eq(i).find('ul.dap2').css('display', 'block');
        }, function(){
            console.log('da2 out');
            //topNav.removeClass('active');
            //nav.css('background', 'none');
            navLnb.find('ul.dap2').css('display', 'none');
            navLnb.children('a').css('color', '');
        });

    navLnb.find('ul.dap2').hover(
        function () {},
        function () {
            console.log('da2 out');
            topNav.removeClass('active');
            nav.css('background', 'none');
            navLnb.find('ul.dap2').css('display', 'none');
        });


    // 탭메뉴
    $(".tab-menu ul li a").on('click', function() {
        let index = $(".tab-menu ul li a").index(this);
        
        //모든 div의 on 클래스 제거
        $('.tab-contents div').removeClass('on');
        //클릭된 index에 해당하는 div에 on 추가
        $('.tab-contents div:eq('+ index +')').addClass('on');
    });



    // 모바일 햄버거 메뉴
    $('#header .fa-bars').click(function () {
        $('#header .h_moblie').addClass('active');
        $('#header .fa-times').addClass('active');
        $('#header .fa-bars').addClass('active');
        $('#header .top_nav').show();
    });

    $('#header .fa-times').click(function () {
        $('#header .h_moblie').removeClass('active');
        $('#header .fa-times').removeClass('active');
        $('#header .fa-bars').removeClass('active');
        $('#header .top_nav').hide();
    });

    //모바일 메뉴 아코디언
    $('.main_menu > li > a').click(function () {
        $(this).next($('.snd_menu')).slideToggle('fast');
    })
    $('.snd_menu > li > a').click(function (e) {
        e.stopPropagation();
        $(this).next($('.trd_menu')).slideToggle('fast');
    })
    
    var activeText = $('.snb > li > a.on').text();
    $('.snb_tit h2').text(activeText);
    $('.snb > li > ul').hide();
    $('.snb > li > a.on').siblings('ul').show();

    $('.snb > li > a').click(function(event) {
        event.preventDefault();

        $('.snb > li > a').removeClass('on');

        $(this).addClass('on');
        $(this).siblings('ul').slideToggle(200);

        $('.snb > li > ul').not($(this).siblings('ul')).slideUp(200); 

        var clickedText = $(this).text();
        $('.snb_tit h2').text(clickedText);
    });
    

});