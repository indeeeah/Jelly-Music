<link href="${pageContext.request.contextPath}/css/reset.css"
	rel="stylesheet" type="text/css">
<%
	String ctxPath = request.getContextPath();
%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<title>Jelly Music</title>
<style>
@charset "UTF-8";

/* 초기화 */
@import
	url('https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap')
	;

@import
	url('https://fonts.googleapis.com/css2?family=Raleway:wght@800&display=swap')
	;

@import
	url('https://fonts.googleapis.com/css2?family=Roboto+Mono:wght@500&display=swap')
	;

@import
	url('https://fonts.googleapis.com/css2?family=Lemon&family=Lilita+One&family=Luckiest+Guy&family=Paytone+One&family=Sniglet:wght@800&family=Work+Sans:wght@900&display=swap')
	;

body {
	font-family: 'Nanum Gothic', sans-serif;
	width: 100%;
	height: 100%;
	background-color: rgb(22, 25, 41);
}

a {
	text-decoration: none;
	color: rgb(244, 244, 244);
	cursor: pointer;
}

/* fix_nav */
#fix_side {
    width: 259px;
    height: 100%;
    background-color: rgb(20, 23, 38);
    position: fixed;
    float: left;
}

#fix_logo {
    width: 209px;
    height: 60px;
    top: 0px;
    margin-top: 30px;
    margin-left: 25px;
}

#fix_logo_title {
    position: absolute;
    font-family: 'Lemon', cursive;
    font-size: 23px;
    color: rgb(244, 244, 244);
    line-height: 45px;
    right: 25px;
   	cursor:pointer;
}

#fix_logo_img {
    position: absolute;
    width: 45px;
    height: 45px;
    border: 2px solid rgb(74, 254, 0);
    border-radius: 50%;
    background-color: rgb(74, 254, 0);
    float: left;
       	cursor:pointer;
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
    font-weight: bold
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

#fix_side_menu>div>input[type="radio"] {
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
    outline: none;
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


/* fix_header */

.fix_header {
    height: 90px;
    width: calc(100% - 259px);
    box-shadow: 0px 8px 2px rgba(0, 0, 0, 0.2), 0 6px 20px rgba(0, 0, 0, 0.19);
    background-color: rgb(23, 26, 40);
    position: absolute;
    float: right;
    right: 0px;
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
    background: rgb(244, 244, 244);
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
    border: 4px solid rgb(244, 244, 244);
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
    background: rgb(244, 244, 244);
    border-radius: 0%;
    transform: rotate(-45deg);
}

.fix_searchbx:focus::placeholder {
    color: rgb(244, 244, 244);
    opacity: 0.5;
    font-weight: bolder;
}

.fix_realtime {
    height: 90px;
    width: 150px;
    float: right;
    margin-right: 100px;
}

.fix_rt_div {
    position: absolute;
    bottom: 40px;
    right: 100px;
    width: 150px;
    transition: all 1s;
    z-index: 10;
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
    color: rgb(244, 244, 244);
    box-sizing: border-box;
    border: 1px solid rgb(74, 254, 0);
    border-radius: 15px;
    background-color: rgb(23, 26, 40);
    top: 60px;
    font-size: 12px;
    display: none;
    overflow: hidden;
    z-index: 6;
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
    color: rgb(244, 244, 244);
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


/*fix_footer*/
#fix_footer {
    position: relative;
    height: 100px;
    width: calc(100% - 259px);
    bottom: 0px;
    font-size: 11px;
    color: rgb(244, 244, 244);
    float: right;
    right: 0px;
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
<style>
/* main content when login+unlogin */
.mms_container {
	position: relative;
	padding-bottom: 522px;
	padding-left: 255px;
	height: 10000px;
}

.mms_content {
	text-align: center;
	position: relative;
	z-index: 10;
	display: block;
	width: 1200px;
	margin: 0 auto;
	position: relative;
	padding: 90px 0 88px;
}

@font-face {
	font-family: neon;
	src: url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/707108/neon.ttf);
}

.banner {
	font-family: neon;
	color: rgb(74, 254, 0);
	font-size: 50px;
	line-height: 9vw;
	text-shadow: 0 0 3vw rgb(74, 254, 0);
}

.banner {
	animation: banner 2s linear infinite;
	-moz-animation: banner 2s linear infinite;
	-webkit-animation: banner 2s linear infinite;
	-o-animation: banner 2s linear infinite;
}

@
keyframes banner { 0%, 100% {
	text-shadow: 0 0 1vw rgb(74, 254, 0), 0 0 3vwrgb(74, 254, 0), 0 0
		10vwrgb(74, 254, 0), 0 0 10vw rgb(74, 254, 0) 0 0 .4vw
		rgb(168, 238, 141) #2f9451;
	color: rgb(74, 254, 0);
}

50


%
{
text-shadow


:


0


0


.5vw


#082180
,
0


0


1
.5vw


#082180
,
0


0


5vw


#082180
,
0


0


5vw


#082180
,
0


0


.2vw


#082180
,
.5vw


.5vw


.1vw


#0A3940
;


color


:


#146C80
;


}
}
.cash {
	padding-left: 800px;
	font-family: neon;
	color: rgb(74, 254, 0);
	font-size: 20px;
}

.mms_section {
	position: relative;
	width: 940px;
	margin: -60px auto 0;
	z-index: 20;
}

.mms_item {
	position: relative;
	height: 300px;
	margin-bottom: 15px;
	padding-left: 38px;
	border: 1px solid rgb(74, 254, 0);
	border-radius: 30px;
	background-color: rgb(20, 23, 38);
	background-position: 100% 0;
	background-repeat: no-repeat;
}

.mms_item .mms_title {
	display: block;
	margin: 28px 0 20px;
	font-size: 25px;
	font-weight: normal;
	line-height: 40px;
	color: white;
}

.mms_item .item01 {
	margin-bottom: 16px;
	font-size: 17px;
	color: #969594;
	line-height: 28px;
}

.mms_item .item01>em {
	display: block;
	padding-top: 2px;
	font-size: 21px;
	color: #33ff88;
}

.mms_item .item01 small {
	font-size: 13px;
}

.mms_item .btns {
	position: absolute;
	bottom: 44px;
	left: 39px;
	overflow: hidden;
}

.mms_item .btns a {
	float: left;
}

.mms_buy_btn {
	padding-left: 21px;
	color: white;
	background: rgb(20, 23, 38);
}
</style>
<style>
/*모달 시작*/
/* The Modal (background) */
.modal {
	display: none; /* Hidden by default */
	position: fixed; /* Stay in place */
	z-index: 1; /* Sit on top */
	padding-top: 100px; /* Location of the box */
	left: 0;
	top: 0;
	width: 100%; /* Full width */
	height: 100%; /* Full height */
	overflow: auto; /* Enable scroll if needed */
	background-color: rgb(0, 0, 0); /* Fallback color */
	background-color: rgba(0, 0, 0, 0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
	position: relative;
	background-color: rgb(20, 23, 38);
	margin: auto;
	padding: 0;
	width: 70%;
	height: 150px;
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0
		rgba(0, 0, 0, 0.19);
	-webkit-animation-name: animatetop;
	-webkit-animation-duration: 1.5s;
	animation-name: animatetop;
	animation-duration: 1.5s;
	text-align: center;
	border-radius: 30px;
	padding: 20px;
}

/* Add Animation */
@
-webkit-keyframes animatetop {from { top:-300px;
	opacity: 0
}

to {
	top: 0;
	opacity: 1
}

}
@
keyframes animatetop {from { top:-300px;
	opacity: 0
}

to {
	top: 0;
	opacity: 1
}

}

/* The Close Button */
.close {
	color: rgb(74, 254, 0);
	float: right;
	padding-top: 10px;
	font-size: 20px;
	font-weight: bold;
	font-size: 20px;
}

.close:hover, .close:focus {
	color: #4D4D4D;
	text-decoration: none;
	cursor: pointer;
}

.modal-header {
	background-color: rgb(20, 23, 38);
	padding: 2px 16px;
	color: white;
	height: 150px;
	border-radius: 30px;
}

/*모달 끝*/
</style>
<style>
.main_content {
	background: linear-gradient(to right, rgba(22, 25, 41, 0) 30%,
		rgba(22, 25, 41, 0.25) 55%, rgba(22, 25, 41, 0.5) 70%,
		rgba(22, 25, 41, 0.75) 75%, rgba(22, 25, 41, 1) 100%),
		linear-gradient(to bottom, rgba(22, 25, 41, 0) 80%,
		rgba(22, 25, 41, 0.25) 85%, rgba(22, 25, 41, 0.5) 90%,
		rgba(22, 25, 41, 0.75) 95%, rgba(22, 25, 41, 1) 100%),
		url('${pageContext.request.contextPath}/image/hostile-886034.jpg');
	background-size: calc(100% - 259px);
	background-repeat: no-repeat;
}

#fix_logo_img {
	background-image:
		url('${pageContext.request.contextPath}/image/logo.svg');
	background-size: 45px;
}

#j_img {
	background-image:
		url('${pageContext.request.contextPath}/image/logo.svg');
	background-size: 100px;
}
</style>
</head>

<body>
	<nav id="fix_side">
		<div id="fix_logo">
			<div id="fix_logo_img"></div>
			<a href="mainServlet" id="fix_logo_title">Jelly Music</a>
		</div>
		<div id="fix_user">
			<img src="${pageContext.request.contextPath}/image/005-user.svg"
				id="fix_prof"> <a href="#">Hello, ${ssLogInfo.mem_id }</a>
		</div>
		<div id="fix_side_menu">
			<div>
				<input type="radio" name="fix_drp" id="login"> <input
					type="radio" name="fix_drp" id="song"> <input type="radio"
					name="fix_drp" id="myplaylist"> <input type="radio"
					name="fix_drp" id="recommend"> <input type="radio"
					name="fix_drp" id="help"> <input type="radio"
					name="fix_drp" id="membership">
				<div class="fix_each">
					<img
						src="${pageContext.request.contextPath}/image/007-settings.svg"
						class="fix_menu_icon"> <label for="login"
						class="fix_each_menu">마이페이지</label>
				</div>
				<ul>
					<li><a
						href="${pageContext.request.contextPath}/memberLogoutServlet">로그아웃</a></li>
				</ul>
				<div class="fix_each">
					<img
						src="${pageContext.request.contextPath}/image/003-play-button.svg"
						class="fix_menu_icon"> <label for="song"
						class="fix_each_menu" onclick="location.href='mainListCtrl.do';">노래</label>
				</div>
				<ul>
					<li><a href="#">실시간 차트</a></li>
					<li><a href="#">하트 차트</a></li>
					<li><a href="<%=request.getContextPath()%>/Genre.jsp">장르</a></li>
					<li><a href="<%=request.getContextPath()%>/Mood.jsp">무드별</a></li>
				</ul>
				<div class="fix_each">
					<img src="${pageContext.request.contextPath}/image/002-music-1.svg"
						class="fix_menu_icon"> <label for="myplaylist"
						class="fix_each_menu">마이플레이리스트</label>
				</div>
				<div class="fix_each">
					<img src="${pageContext.request.contextPath}/image/001-music.svg"
						class="fix_menu_icon"> <label for="recommend"
						class="fix_each_menu">나만의 추천</label>
				</div>
				<div class="fix_each">
					<img
						src="${pageContext.request.contextPath}/image/008-internet.svg"
						class="fix_menu_icon"> <label for="help"
						class="fix_each_menu">고객지원센터</label>
				</div>
				<ul>
					<li><a
						href="${pageContext.request.contextPath}/MemberPostListCtrl">공지사항</a></li>
					<li><a
						href="${pageContext.request.contextPath}/postListServlet">Q&A</a></li>
					<li><a
						href="${pageContext.request.contextPath}/mfreqQues/mfreqQues.jsp">자주하는
							질문</a></li>
				</ul>
				<div class="fix_each">
					<img src="${pageContext.request.contextPath}/image/006-star.svg"
						class="fix_menu_icon"> <label for="membership"
						class="fix_each_menu" onclick="location.href='MembershipServlet';">이용권구매</label>
				</div>
			</div>
		</div>
		<div class="fix_btn">
			<c:if test="${not empty scm }">
				<c:forEach items="${scm }" var="v" varStatus="s" end="0">
					<input type="hidden" name="mu_no" value=${v.mu_no }>
					<input type="hidden" id="mem_id" name="mem_id" value=${v.mem_id }>
					<button class="fix_player_btn"
						onclick="window.open('<%=request.getContextPath()%>/playerCtrl.do?mu_no=${v.mu_no}','','width=1200,height=720')">Player</button>
				</c:forEach>
			</c:if>
		</div>
	</nav>
	<header class="fix_header">
		<input type="text" class="fix_searchbx">
		<div class="fix_search"></div>
		<div class="fix_realtime">
			<div class="fix_rt_div">
				<div id='fix_m_scroller'>
					<c:if test="${not empty searlist}">
						<c:forEach items="${searlist }" var="vo" varStatus="s">
							<c:set var="sum" value="${sum+1 }" />
							<div class='fix_item'>
								<a class='rt_link' href='#'>${sum }. ${vo.sear_word }
									<div class="tri"></div>
								</a>
							</div>
						</c:forEach>
					</c:if>
				</div>
			</div>
		</div>
		<table id="rtdrop">
			<c:if test="${not empty searlist}">
				<c:forEach items="${searlist }" var="vo" varStatus="s">
					<c:set var="sum2" value="${sum2+1 }" />
					<tr>
						<td width="10%">${sum2 }.</td>
						<td width="80%"><a href="#">${vo.sear_word }</a></td>
						<td width="10%">
							<div class="tri"></div>
						</td>
					</tr>
				</c:forEach>
			</c:if>
		</table>
	</header>
	<div class="mms_container">
		<div class="mms_content">
			<div class="banner">Jelly Membership</div>
			<div>
				<a href="Cash.jsp" class="cash">Cash</a>
			</div>
		</div>
		<div class="mms_section">
			<ul>

				<c:if test="${not empty membership }">
					<c:forEach items="${membership }" var="v" varStatus="s">
						<c:choose>
							<c:when test="${v.ms_no eq '2'}">
								<li class="mms_item"><strong class="mms_title">Jelly
										Streaming</strong>
									<p class="item01">
										PC+모바일, AI 스피커 등 모든 기기<em>무제한 듣기 3개월간 매월 ${v.ms_price}원</em> <small><em>(3개월후
												이용권 이용불가)</em></small>
									</p>
									<div class="btns">
										<%-- <a
											href="${pageContext.request.contextPath}/Membership01.jsp?no=${v.ms_no}&type=${v.ms_type}"
											class="mms_buy_btn">구매하기</a> --%>
										<button type="button" class="mms_buy_btn" id="ms_no"
											value="${v.ms_no }">구매하기</button>
									</div></li>
								<div id="myModal" class="modal">
									<!-- Modal content -->
									<div class="modal-content">
										<div class="modal-header">
											<span class="close">&times;</span>
											<div id="content" class="content">
												<table class="content_tbl" align="center">
													<tr>
														<th>회원ID</th>
														<td><input type="text" size="40" maxlength="10"
															name="u_id" id="u_id" onkeyup="spaceChk(this);"
															onchange="spaceChk"></td>
													</tr>
													<tr>
														<th>이름</th>
														<td><input type="text" size="40" name="name"
															id="name" onkeyup="spaceChk(this);" onchange="spaceChk"></td>
													</tr>
													<tr>
														<th>비밀번호</th>
														<td><input type="password" size="40" name="pwd"
															id="pwd" onkeyup="spaceChk(this);" onchange="spaceChk"></td>
													</tr>
													<tr>
														<th>전화번호</th>
														<td><input type="text" size="40" name="tel" id="tel"
															onkeyup="spaceChk(this);" onchange="spaceChk"></td>
													</tr>
													<tr>
														<td colspan="2" style="text-align: center">
															<form id="frm">
																<input type=hidden name="ms_no" id="ms_no"
																	value="<%=request.getParameter("no")%>"> <input
																	id="ms_submit" type="button" value="구매완료"
																	style="margin-top: 10px;" onclick="goSubmit();">
															</form>
														</td>
													</tr>
												</table>
											</div>
										</div>

									</div>
								</div>
							</c:when>
							<c:when test="${v.ms_no eq '3'}">
								<li class="mms_item"><strong class="mms_title">Jelly
										Mp3 50</strong>
									<p class="item01">
										PC+모바일, AI 스피커 등 모든 기기<em>mp3다운 50곡 한달 무제한 듣기
											${v.ms_price}원</em> <small><em>(1개월후 이용권 이용불가)</em></small>
									</p>
									<div class="btns">
										<a
											href="${pageContext.request.contextPath}/Membership01.jsp?no=${v.ms_no}&type=${v.ms_type}"
											class="mms_buy_btn">구매하기</a>
									</div></li>
								<div id="myModal" class="modal">
									<!-- Modal content -->
									<div class="modal-content">
										<div class="modal-header">
											<span class="close">&times;</span>
											<div id="content" class="content">
												<table class="content_tbl" align="center">
													<tr>
														<th>회원ID</th>
														<td><input type="text" size="40" maxlength="10"
															name="u_id" id="u_id" onkeyup="spaceChk(this);"
															onchange="spaceChk"></td>
													</tr>
													<tr>
														<th>이름</th>
														<td><input type="text" size="40" name="name"
															id="name" onkeyup="spaceChk(this);" onchange="spaceChk"></td>
													</tr>
													<tr>
														<th>비밀번호</th>
														<td><input type="password" size="40" name="pwd"
															id="pwd" onkeyup="spaceChk(this);" onchange="spaceChk"></td>
													</tr>
													<tr>
														<th>전화번호</th>
														<td><input type="text" size="40" name="tel" id="tel"
															onkeyup="spaceChk(this);" onchange="spaceChk"></td>
													</tr>
													<tr>
														<td colspan="2" style="text-align: center">
															<form id="frm">
																<input type=hidden name="ms_no" id="ms_no"
																	value="<%=request.getParameter("no")%>"> <input
																	id="ms_submit" type="button" value="구매완료"
																	style="margin-top: 10px;" onclick="goSubmit();">
															</form>
														</td>
													</tr>
												</table>
											</div>
										</div>
									</div>
								</div>
							</c:when>
							<c:when test="${v.ms_no eq '4'}">
								<li class="mms_item"><strong class="mms_title">Jelly
										Mp3 40</strong>
									<p class="item01">
										PC+모바일, AI 스피커 등 모든 기기<em>mp3다운 40곡 한달 무제한 듣기
											${v.ms_price}원</em> <small><em>(1개월후 이용권 이용불가)</em></small>
									</p>
									<div class="btns">
										<a
											href="${pageContext.request.contextPath}/Membership01.jsp?no=${v.ms_no}&type=${v.ms_type}"
											class="mms_buy_btn">구매하기</a>
									</div></li>
								<div id="myModal" class="modal">
									<!-- Modal content -->
									<div class="modal-content">
										<div class="modal-header">
											<span class="close">&times;</span>
											<div id="content" class="content">
												<table class="content_tbl" align="center">
													<tr>
														<th>회원ID</th>
														<td><input type="text" size="40" maxlength="10"
															name="u_id" id="u_id" onkeyup="spaceChk(this);"
															onchange="spaceChk"></td>
													</tr>
													<tr>
														<th>이름</th>
														<td><input type="text" size="40" name="name"
															id="name" onkeyup="spaceChk(this);" onchange="spaceChk"></td>
													</tr>
													<tr>
														<th>비밀번호</th>
														<td><input type="password" size="40" name="pwd"
															id="pwd" onkeyup="spaceChk(this);" onchange="spaceChk"></td>
													</tr>
													<tr>
														<th>전화번호</th>
														<td><input type="text" size="40" name="tel" id="tel"
															onkeyup="spaceChk(this);" onchange="spaceChk"></td>
													</tr>
													<tr>
														<td colspan="2" style="text-align: center">
															<form id="frm">
																<input type=hidden name="ms_no" id="ms_no"
																	value="<%=request.getParameter("no")%>"> <input
																	id="ms_submit" type="button" value="구매완료"
																	style="margin-top: 10px;" onclick="goSubmit();">
															</form>
														</td>
													</tr>
												</table>
											</div>
										</div>
									</div>
								</div>
							</c:when>
						</c:choose>
					</c:forEach>
				</c:if>
			</ul>
		</div>
	</div>
	<footer id="fix_footer">
		<hr id="fix_fline">
		<div id="fix_ft">
			<div id="fix_copy" class="fix_fc">Copyright ⓒ 2020 Jelly. All
				rights reserved.</div>
			<div id="fix_national" class="fix_fc">Republic of Korea</div>
			<div id="fix_link" class="fix_fc">
				<a href="#">이용약관</a> | <a href="#">개인정보처리방침</a> | <a href="#">고객센터</a>
				| <a href="#">이메일주소무단수집거부</a>
			</div>
			<div id="fix_info" class="fix_fc">제작자 : 김경태 김수민 곽은지 김지용 장재혁</div>
		</div>
	</footer>

	<script>
                $(".tri_con").click(function() {
                    var showTvalue = $(this).next().val();
                    var showmemId = $("#mem_id").val();
                    console.log(showTvalue);
                    console.log(showmemId);

                    $.ajax({
                        type: "POST",
                        url: "mainToPlayListSrv",
                        data: {
                            mem_id: showmemId,
                            mu_no: showTvalue
                        },
                        success: function(resulttr) {

                        }
                    });
                });

                $(".tri_con").click(function() {
                    var showTvalue = $(this).next().val();
                    var showmemId = $("#mem_id").val();
                    console.log(showTvalue + "update");
                    console.log(showmemId);

                    $.ajax({
                        type: "POST",
                        url: "updateCurrmusicServlet",
                        data: {
                            mem_id: showmemId,
                            mu_no: showTvalue
                        },
                        success: function(resultcm) {
                            console.log("업뎃 성공!");
                        }
                    });
                });

                $(".for_you_con").click(function() {
                     var showFvalue = $(this).next().val();
                     var showmemId = $("#mem_id").val();
                     console.log(showFvalue);
                     console.log(showmemId);


                     $.ajax({
                         type: "POST",
                         url: "mainToPlayListSrv",
                         data: {
                             mem_id: showmemId,
                             mu_no: showFvalue
                         },
                         success: function(resultfy) {

                         }
                     });
                 });

                $(".for_you_con").click(function() {
                    var showFvalue = $(this).next().val();
                    var showmemId = $("#mem_id").val();
                    console.log(showFvalue);
                    console.log(showmemId);


                    $.ajax({
                        type: "POST",
                        url: "updateCurrmusicServlet",
                        data: {
                            mem_id: showmemId,
                            mu_no: showFvalue
                        },
                        success: function(resultcm) {

                        }
                    });
                });

                $(".lpm_con").click(function() {
                    var showLvalue = $(this).next().val();
                    var showmemId = $("#mem_id").val();
                    console.log(showLvalue);
                    console.log(showmemId);


                    $.ajax({
                        type: "POST",
                        url: "mainToPlayListSrv",
                        data: {
                            mem_id: showmemId,
                            mu_no: showLvalue
                        },
                        success: function(resultlp) {

                        }
                    });
                });

                $(".lpm_con").click(function() {
                    var showLvalue = $(this).next().val();
                    var showmemId = $("#mem_id").val();
                    console.log(showLvalue);
                    console.log(showmemId);


                    $.ajax({
                        type: "POST",
                        url: "updateCurrmusicServlet",
                        data: {
                            mem_id: showmemId,
                            mu_no: showLvalue
                        },
                        success: function(resultcm) {

                        }
                    });
                });

                $(".newrl_con").click(function() {
                     var showNvalue = $(this).next().val();
                     var showmemId = $("#mem_id").val();
                     console.log(showNvalue);
                     console.log(showmemId);

                     $.ajax({
                         type: "POST",
                         url: "mainToPlayListSrv",
                         data: {
                             mem_id: showmemId,
                             mu_no: showNvalue
                         },
                         success: function(resultnl) {

                         }
                     });
                 });

                $(".newrl_con").click(function() {
                    var showNvalue = $(this).next().val();
                    var showmemId = $("#mem_id").val();
                    console.log(showNvalue);
                    console.log(showmemId);

                    $.ajax({
                        type: "POST",
                        url: "updateCurrmusicServlet",
                        data: {
                            mem_id: showmemId,
                            mu_no: showNvalue
                        },
                        success: function(resultcm) {

                        }
                    });
                });
            </script>
	<script type="text/javascript">
      /*모달 시작*/
      // Get the modal
      var modal = document.getElementById("myModal");
      // Get the button that opens the modal
      var btn = document.getElementsByClassName("mms_buy_btn");
      // Get the <span> element that closes the modal
      var span = document.getElementsByClassName("close")[0];

      // When the user clicks the button, open the modal 
      for(var i = 0; i < btn.length; i++) {
         btn[i].onclick = function() {
            modal.style.display = "block";
      }}
      // When the user clicks on <span> (x), close the modal
      span.onclick = function() {
         modal.style.display = "none";
      }
      // When the user clicks anywhere outside of the modal, close it
      window.onclick = function(event) {
         if (event.target == modal) {
            modal.style.display = "none";
         }
      };
      /*모달 끝*/
      function goSubmit(){
         console.log( $("#ms_no").val() );
         console.log('<%=request.getParameter("no")%>');
         var no = $("#ms_no").val();
         if($("#ms_no").val() == '2') {
            $.ajax({
               url: '<%=ctxPath%>/StreamingServlet',
               data: { ms_no : no},
               success: function(result) {
                  alert(result);    
               }         
            });
         }
         else if($("#ms_no").val() == '3')  {
            $.ajax({
               url: '<%=ctxPath%>/BuypackageServlet',
               data: { ms_no : no},
               type : '<%=request.getParameter("no")%>',
               success : function(result) {
                  alert(result);
               }
            });
         }
      }
      ${pageContext.request.contextPath}/Membership01.jsp?no=${v.ms_no}&type=${v.ms_type}
      </script>
</body>

</html>