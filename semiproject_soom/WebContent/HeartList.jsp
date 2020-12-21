<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String ctxPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Heart</title>
   <style>
        @import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap');
        </style>
    <style>
        body {
            font-family: 'Nanum Gothic', sans-serif;
            width: 100%;
            height: 100%;
            background-color: rgb(22, 25, 41);
        }

        a {
            text-decoration: none;
            color: white;
        }
    </style>
    <!-- fix_nav -->
    <style>
        #fix_side {
            width: 259px;
            height: 100%;
            background-color: rgb(20, 23, 38);
            display: block;
            position: fixed;
        }

        #fix_logo {
            width: 259px;
            height: 60px;
            top: 0px;
            margin-bottom: 30px;
        }

        #fix_user {
            width: 259px;
            height: 60px;
            text-align: left;
        }
        
        #fix_user>a {
            margin-right: 30px;
            line-height: 60px;
            left: 0px;
            font-size: 16px;
            margin-left: 10px;
            font-weight:bold
        }

        #fix_prof {
            width: 30px;
            height: 60px;
            float: left;
            margin-left: 32px;
        }

        #fix_side_menu {
            overflow: hidden;
            margin-top: 11px;
            margin-left: 25px;
            width: 209px;
        }

        input[type="radio"] {
            display: none;
        }

        .fix_each {
            box-sizing: border-box;
            border: 1px solid rgb(20, 23, 38);
            width: 209px;
            height: 35px;
            padding-left: 10px;
            margin-bottom: 10px;
        }

        .fix_menu_icon {
            width: 20px;
            height: 35px;
        }

        .fix_each:hover {
            box-sizing: border-box;
            border: 1px solid rgb(74, 254, 0);
            border-radius: 6px;
        }

        .fix_each_menu {
            width: 164px;
            color: rgb(244, 244, 244);
            float: right;
            line-height: 35px;
        }

        .fix_each_menu:hover {
            color: rgb(168, 168, 169);
        }

        .fix_each:hover>.fix_each_menu {
            width: 164px;
        }


        #fix_side_menu>div>ul {
            display: none;
            width: 209px;
            margin-top: -10px;
            margin-bottom: 7px;
        }

        #fix_side_menu>div>ul>li {
            height: 30px;
        }

        #fix_side_menu>div>ul>li>a {
            line-height: 32px;
            margin-left: 45px;
            font-size: 15px;
        }

        #fix_side_menu>div>ul>li>a:hover {
            color: rgb(168, 168, 169);
        }

        nav>#fix_side_menu>div>input:nth-of-type(1):checked~.fix_each:nth-of-type(1) {
            box-sizing: border-box;
            border: 1px solid rgb(74, 254, 0);
            border-radius: 6px;
        }

        nav>#fix_side_menu>div>input:nth-of-type(2):checked~.fix_each:nth-of-type(2) {
            box-sizing: border-box;
            border: 1px solid rgb(74, 254, 0);
            border-radius: 6px;
        }

        nav>#fix_side_menu>div>input:nth-of-type(5):checked~.fix_each:nth-of-type(5) {
            box-sizing: border-box;
            border: 1px solid rgb(74, 254, 0);
            border-radius: 6px;
        }

        nav>#fix_side_menu>div>input:nth-of-type(1):checked~.fix_each:nth-of-type(1)+ul {
            display: block;
        }


        nav>#fix_side_menu>div>input:nth-of-type(2):checked~.fix_each:nth-of-type(2)+ul {
            display: block;
        }

        nav>#fix_side_menu>div>input:nth-of-type(5):checked~.fix_each:nth-of-type(5)+ul {
            display: block;
        }

        .fix_btn {
            width: 209px;
            height: 40px;
            bottom: 30px;
            margin-left: 25px;
            position: absolute;
        }

        .fix_player_btn {
            width: 209px;
            height: 40px;
            border: none;
            background-color: rgb(74, 254, 0);
            font-weight: bold;
            border-radius: 40px;
            cursor: pointer;
            text-shadow: 0 0 10px rgb(74, 254, 0);
            box-shadow: 0 0 25px 0 rgb(74, 254, 0), 0 20px 25px 0 rgba(0, 0, 0, 0.2);

        }

        .fix_player_btn:hover {
            box-sizing: border-box;
            border: 2px solid rgb(74, 254, 0);
            background-color: rgb(20, 23, 38);
            color: rgb(244, 244, 244);
            text-shadow: 0 0 10px rgb(74, 254, 0);
            box-shadow: 0 0 25px 0 rgb(74, 254, 0), 0 20px 25px 0 rgba(0, 0, 0, 0.2);
        }
    </style>

    <!-- fix_header -->
    <style>
        .fix_header {
            height: 90px;
            width: calc(100% - 259px);
            box-shadow: 0px 8px 2px rgba(0, 0, 0, 0.2), 0 6px 20px rgba(0, 0, 0, 0.19);
            background-color: rgb(23, 26, 40);
            position: relative;
            float: right;
        }


        .fix_search {
            position: absolute;
            top: 20px;
            right: 40px;
            width: 45px;
            height: 45px;
            border-radius: 50%;
            transition: all 1s;
            z-index: 4;
            box-shadow: 0 0 25px 0 rgba(0, 0, 0, 0.4);
        }

        .fix_search:hover {
            cursor: pointer;
        }

        .fix_search::before {
            content: "";
            position: absolute;
            margin: auto;
            top: 22px;
            right: 0;
            bottom: 0;
            left: 22px;
            width: 12px;
            height: 2px;
            background: white;
            transform: rotate(45deg);
            transition: all .5s;
        }

        .fix_search::after {
            content: "";
            position: absolute;
            margin: auto;
            top: -5px;
            right: 0;
            bottom: 0;
            left: -5px;
            width: 25px;
            height: 25px;
            border-radius: 50%;
            border: 4px solid white;
            transition: all .5s;
        }


        .fix_searchbx {
            position: absolute;
            top: 30px;
            right: 40px;
            width: 25px;
            height: 25px;
            outline: none;
            border: none;
            background: rgb(74, 254, 0);
            color: black;
            text-shadow: 0 0 10px rgb(74, 254, 0);
            padding: 0 80px 0 20px;
            border-radius: 30px;
            box-shadow: 0 0 25px 0 rgb(74, 254, 0), 0 20px 25px 0 rgba(0, 0, 0, 0.2);
            transition: all 1s;
            opacity: 0;
            z-index: 5;
            font-weight: bolder;
            letter-spacing: 0.1em;
        }

        .fix_searchbx:hover {
            cursor: pointer;
        }

        .fix_searchbx:focus {
            width: 300px;
            opacity: 1;
            cursor: text;
        }

        .fix_searchbx:focus~.fix_search {
            background: #151515;
            z-index: 6;
        }

        .fix_searchbx:focus~.fix_search::before {
            top: 0;
            left: 0;
            width: 25px;
        }

        .fix_searchbx:focus~.fix_search::after {
            top: 0;
            left: 0;
            width: 25px;
            height: 2px;
            border: none;
            background: white;
            border-radius: 0%;
            transform: rotate(-45deg);
        }

        .fix_searchbx:focus::placeholder {
            color: white;
            opacity: 0.5;
            font-weight: bolder;
        }


        .fix_realtime {
            height: 90px;
            width: 100px;
            float: right;
            margin-right: 100px;
        }

        .fix_rt_div {
            position: absolute;
            bottom: 40px;
            right: 100px;
            width: 100px;
            transition: all 1s;

        }

        #fix_m_scroller {
            height: 15px;
            overflow: hidden;
            position: relative;
        }

        .tri {
            width: 0px;
            height: 0px;
            margin-top: 5px;
            border-top: 5px solid none;
            border-bottom: 5px solid red;
            border-right: 5px solid transparent;
            border-left: 5px solid transparent;
            float: right;
        }

        #fix_m_scroller .fix_item {
            display: block;
            animation: scroll 10s infinite;
        }

        #rtdrop {
            position: absolute;
            right: 100px;
            width: 200px;
            color: white;
            box-sizing: border-box;
            border: 1px solid rgb(74, 254, 0);
            border-radius: 15px;
            background-color: rgb(23, 26, 40);
            top: 60px;
            font-size: 12px;
            display: none;
            overflow: hidden;
        }

        #rtdrop:hover {
            display: block;
        }

        #rtdrop>tbody {
            width: 200px;
        }

        #rtdrop>tbody>tr>td {
            padding: 10px;

        }

        #rtdrop>tr>td {
            border: 1px;
        }

        .fix_realtime:hover~#rtdrop {
            display: block;
        }

        .fix_searchbx:focus~#rtdrop {
            right: 460px;
        }

        .rt_link {
            font-size: 15px;
            background: transparent;
            text-decoration: none;
            color: white;
        }

        .rt_link:hover {
            animation-play-state: paused;
            text-decoration: underline;
        }

        .fix_item:hover {
            animation-play-state: paused;
        }

        .fix_searchbx:focus~.fix_realtime>.fix_rt_div {
            right: 460px;
        }

        @keyframes scroll {
            0.0% {
                transform: translateY(0px)
            }

            10% {
                transform: translateY(0px)
            }

            20% {
                transform: translateY(-16px)
            }

            30% {
                transform: translateY(-32px)
            }

            40% {
                transform: translateY(-48px)
            }

            50% {
                transform: translateY(-64px)
            }

            60% {
                transform: translateY(-80px)
            }

            70% {
                transform: translateY(-96px)
            }

            80% {
                transform: translateY(-112px)
            }

            90% {
                transform: translateY(-128px)
            }

            100% {
                transform: translateY(-144px)
            }
        }
    </style>
    <!-- main -->
    <style>
        #content {
            min-height: 100%;
        }
    </style>
    <!--list-->
    <style>
 .list_container{
            position: relative;
            padding-bottom: 522px;
            padding-left: 255px;
            height: 10000px;
        }
        .list_content{
            position: relative;
            z-index: 10;
            display: block;
            width: 1200px;
            margin: 0 auto;
            position: relative;
            padding: 90px 0 88px;
        }
        .list_title{
            margin: 61px 0 25px;
            font-size: 30px;
            line-height: 36px;
            color: white;

        }
        .list_section{
            position: relative;
            padding: 18px 0 39px;
        }
        .station_wrap{
            margin-right: -11px;
        }
        .list_item{
            float: left;
            width: 25%;
             list-style: none;
         
        }
        .thumb_area{
            position: relative;
            padding-top: 100%;
        }
        .link{
            position: absolute;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
        }
        .lsit_item_img{
            width: 216px;
            height: 216px;
        }
    </style>
 
    <!-- fix_footer -->
    <style>
        #fix_footer {
            height: 100px;
            width: calc(100% - 259px);
            position: absolute;
            right: 0px;
            bottom: 0px;
            font-size: 11px;
            color: rgb(244, 244, 244);
            }

        #fix_fline {
            border: 0;
            height: 1px;
            background-color: rgb(168, 168, 169);
        }

        #fix_ft {
            margin-top: 21px;
        }

        .fix_fc {
            margin-left: 40px;
            margin-top: 5px;
        }

        #fix_copy {
            float: left;
        }

        #fix_national {
            float: right;
            margin-right: 40px;
        }

        #fix_link {
            width: 90%;
            float: left;
        }

        #fix_link>a {
            color: rgb(244, 244, 244);
        }

        #fix_info {
            float: left;
        }
    </style>
</head>
<body>
<body>
    <nav id="fix_side">
        <div id="fix_logo">
            <img src="#" id="fix_logo_img">
        </div>
        <div id="fix_user">
            <img src="image/001-user.svg" id="fix_prof">
            <a href="#">Hello, 누구누구!</a>
        </div>
        <div id="fix_side_menu">
            <div>
                <input type="radio" name="fix_drp" id="login">
                <input type="radio" name="fix_drp" id="song">
                <input type="radio" name="fix_drp" id="myplaylist">
                <input type="radio" name="fix_drp" id="recommend">
                <input type="radio" name="fix_drp" id="help">
                <input type="radio" name="fix_drp" id="membership">
                <div class="fix_each">
                    <img src="image/001-play.svg" class="fix_menu_icon">
                    <label for="login" class="fix_each_menu">마이페이지</label>
                </div>
                <ul>
                    <li><a href="#">구매내역</a></li>
                    <li><a href="#">보관함</a></li>
                    <li><a href="#">계정설정</a></li>
                    <li><a href="#">로그아웃</a></li>
                </ul>
                <div class="fix_each">
                    <img src="image/001-play.svg" class="fix_menu_icon">
                    <label for="song" class="fix_each_menu">노래</label>
                </div>
                <ul>
                    <li><a href="#">실시간 차트</a></li>
                    <li><a href="#">하트 차트</a></li>
                    <li><a href="#">장르</a></li>
                    <li><a href="#">무드별</a></li>
                </ul>
                <div class="fix_each">
                    <img src="image/001-play.svg" class="fix_menu_icon">
                    <label for="myplaylist" class="fix_each_menu">마이플레이리스트</label>
                </div>
                <div class="fix_each">
                    <img src="image/001-play.svg" class="fix_menu_icon">
                    <label for="recommend" class="fix_each_menu">나만의 추천</label>
                </div>
                <div class="fix_each">
                    <img src="image/001-play.svg" class="fix_menu_icon">
                    <label for="help" class="fix_each_menu">고객지원센터</label>
                </div>
                <ul>
                    <li><a href="#">공지사항</a></li>
                    <li><a href="#">Q&A</a></li>
                    <li><a href="#">자주하는 질문</a></li>
                    <li><a href="#">로그아웃</a></li>
                </ul>
                <div class="fix_each">
                    <img src="image/001-play.svg" class="fix_menu_icon">
                    <label for="membership" class="fix_each_menu">이용권구매</label>
                </div>
            </div>
        </div>
        <div class="fix_btn">
            <button class="fix_player_btn">Player</button>
        </div>
    </nav>
    <header class="fix_header">
        <input type="text" class="fix_searchbx">
        <div class="fix_search"></div>
        <div class="fix_realtime">
            <div class="fix_rt_div">
                <div id='fix_m_scroller'>
                    <div class='fix_item'>
                        <a class='rt_link' href='#'>1. 블랙핑크<div class="tri"></div></a>
                    </div>
                    <div class='fix_item'>
                        <a class='rt_link' href='#'>2. 블랙핑크<div class="tri"></div></a>
                    </div>
                    <div class='fix_item'>
                        <a class='rt_link' href='#'>3. 블랙핑크<div class="tri"></div></a>
                    </div>
                    <div class='fix_item'>
                        <a class='rt_link' href='#'>4. 블랙핑크<div class="tri"></div></a>
                    </div>
                    <div class='fix_item'>
                        <a class='rt_link' href='#'>5. 블랙핑크<div class="tri"></div></a>
                    </div>
                    <div class='fix_item'>
                        <a class='rt_link' href='#'>6. 블랙핑크<div class="tri"></div></a>
                    </div>
                    <div class='fix_item'>
                        <a class='rt_link' href='#'>7. 블랙핑크<div class="tri"></div></a>
                    </div>
                    <div class='fix_item'>
                        <a class='rt_link' href='#'>8. 블랙핑크<div class="tri"></div></a>
                    </div>
                    <div class='fix_item'>
                        <a class='rt_link' href='#'>9. 블랙핑크<div class="tri"></div></a>
                    </div>
                    <div class='fix_item'>
                        <a class='rt_link' href='#'>10. 블랙핑크<div class="tri"></div></a>
                    </div>
                </div>
            </div>
        </div>
        <table id="rtdrop">
            <tr>
                <td width="10%">1.</td>
                <td width="80%"><a href="#">블랙핑크ㅇ</a></td>
                <td width="10%">
                    <div class="tri"></div>
                </td>
            </tr>
            <tr>
                <td>2.</td>
                <td><a href="#">블랙핑크</a></td>
                <td>
                    <div class="tri"></div>
                </td>
            </tr>
            <tr>
                <td>3.</td>
                <td><a href="#">블랙핑크</a></td>
                <td>
                    <div class="tri"></div>
                </td>
            </tr>
            <tr>
                <td>4.</td>
                <td><a href="#">블랙핑크</a></td>
                <td>
                    <div class="tri"></div>
                </td>
            </tr>
            <tr>
                <td>5.</td>
                <td><a href="#">블랙핑크</a></td>
                <td>
                    <div class="tri"></div>
                </td>
            </tr>
            <tr>
                <td>6.</td>
                <td><a href="#">블랙핑크</a></td>
                <td>
                    <div class="tri"></div>
                </td>
            </tr>
            <tr>
                <td>7.</td>
                <td><a href="#">블랙핑크</a></td>
                <td>
                    <div class="tri"></div>
                </td>
            </tr>
            <tr>
                <td>8.</td>
                <td><a href="#">블랙핑크</a></td>
                <td>
                    <div class="tri"></div>
                </td>
            </tr>
            <tr>
                <td>9.</td>
                <td><a href="#">블랙핑크</a></td>
                <td>
                    <div class="tri"></div>
                </td>
            </tr>
            <tr>
                <td>10.</td>
                <td><a href="#">블랙핑크</a></td>
                <td>
                    <div class="tri"></div>
                </td>
            </tr>
        </table>
    </header>
    <div id="lsit_container" class="list_container">
        <div id="list_content" class="list_content">
            <h1 class="list_title">좋아요 스테이션</h1>
            <div class="list_section">
                <div class="station_wrap">
            <ul>
               <li class="list_item">
                   <div>
                       <div class="thumb_area">
                           <a href="#" class="link">
                               <img src="#" class="lsit_item_img">
                           </a>
                       </div>
                   </div>
               </li> 
               <li class="list_item">
                <div>
                    <div class="thumb_area">
                        <a href="#" class="link">
                            <img src="#" class="lsit_item_img">
                        </a>
                    </div>
                </div>
            </li> 
            <li class="list_item">
                <div>
                    <div class="thumb_area">
                        <a href="#" class="link">
                            <img src="#" class="lsit_item_img">
                        </a>
                    </div>
                </div>
            </li> 
            <li class="list_item">
                <div>
                    <div class="thumb_area">
                        <a href="#" class="link">
                            <img src="#" class="lsit_item_img">
                        </a>
                    </div>
                </div>
            </li> 
            <li class="list_item">
                <div>
                    <div class="thumb_area">
                        <a href="#" class="link">
                            <img src="#" class="lsit_item_img">
                        </a>
                    </div>
                </div>
            </li> 
            <li class="list_item">
                <div>
                    <div class="thumb_area">
                        <a href="#" class="link">
                            <img src="#" class="lsit_item_img">
                        </a>
                    </div>
                </div>
            </li> 
            <li class="list_item">
                <div>
                    <div class="thumb_area">
                        <a href="#" class="link">
                            <img src="#" class="lsit_item_img">
                        </a>
                    </div>
                </div>
            </li> 
            <li class="list_item">
                <div>
                    <div class="thumb_area">
                        <a href="#" class="link">
                            <img src="#" class="lsit_item_img">
                        </a>
                    </div>
                </div>
            </li> 
            <li class="list_item">
                <div>
                    <div class="thumb_area">
                        <a href="#" class="link">
                            <img src="#" class="lsit_item_img">
                        </a>
                    </div>
                </div>
            </li> 
            <li class="list_item">
                <div>
                    <div class="thumb_area">
                        <a href="#" class="link">
                            <img src="#" class="lsit_item_img">
                        </a>
                    </div>
                </div>
            </li> 
            <li class="list_item">
                <div>
                    <div class="thumb_area">
                        <a href="#" class="link">
                            <img src="#" class="lsit_item_img">
                        </a>
                    </div>
                </div>
            </li> 
            <li class="list_item">
                <div>
                    <div class="thumb_area">
                        <a href="#" class="link">
                            <img src="#" class="lsit_item_img">
                        </a>
                    </div>
                </div>
            </li> 
            </ul>
        </div>
            </div>
    </div>
    <footer id="fix_footer">
        <hr id="fix_fline">
        <div id="fix_ft">
            <div id="fix_copy" class="fix_fc">
                Copyright ⓒ 2020 Jelly. All rights reserved.
            </div>
            <div id="fix_national" class="fix_fc">
                Republic of Korea
            </div>
            <div id="fix_link" class="fix_fc">
                <a href="#">이용약관</a> | <a href="#">개인정보처리방침</a> | <a href="#">고객센터</a> | <a href="#">이메일주소무단수집거부</a>
            </div>
            <div id="fix_info" class="fix_fc">
                제작자 : 김경태 김수민 곽은지 김세진 김지용 장재혁
            </div>
        </div>
    </footer>
</body>
</body>
</html>