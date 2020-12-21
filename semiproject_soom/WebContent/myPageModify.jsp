<link href="${pageContext.request.contextPath}/css/reset.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/memberRegister.css"
	rel="stylesheet" type="text/css">
<%@page import="member.model.dao.MemberLoginDao"%>
<%@page import="member.model.vo.MemberLoginVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	String ctxPath1 = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Jelly Music - 회원가입</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<style>
#fix_logo_img {
	background-image:
		url('${pageContext.request.contextPath}/image/logo.svg');
	background-size: 45px;
}
</style>
<style type="text/css">
@charset "UTF-8";
/* 초기화 */

@import url('https://fonts.googleapis.com/css2?family=Nanum+Gothic&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Raleway:wght@800&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Roboto+Mono:wght@500&display=swap');
@import url('https://fonts.googleapis.com/css2?family=Lemon&family=Lilita+One&family=Luckiest+Guy&family=Paytone+One&family=Sniglet:wght@800&family=Work+Sans:wght@900&display=swap');
body {
	font-family: 'Nanum Gothic', sans-serif;
	width: 100%;
	height: 100%;
	background-color: rgb(22, 25, 41);
	overflow: auto;
}

a {
	text-decoration: none;
	color: white;
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
}

#fix_logo_img {
	position: absolute;
	width: 45px;
	height: 45px;
	border: 2px solid rgb(74, 254, 0);
	border-radius: 50%;
	background-color: rgb(74, 254, 0);
	float: left;
}

#fix_user {
	width: 209px;
	height: 60px;
	margin-left: 25px;
	border-radius: 20px;
	box-sizing: border-box;
	text-align: center;
	padding-top: 15px;
}

#fix_user>a {
	display: block;
	color: rgb(244, 244, 244);
	line-height: 30px;
	font-size: 16px;
	font-weight: bold;
	height: 30px;
	width: 100px;
	border: 2px solid rgb(244, 244, 244);
	border-radius: 20px;
	margin-left: 54.5px;
}

#fix_user>a:hover {
	color: black;
	background-color: rgb(244, 244, 244);
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
		transform: translateY ( 0px)
	}
	20% {
		transform: translateY ( -16px)
	}
	30% {
		transform: translateY ( -32px)
	}
	40% {
		transform: translateY ( -48px)
	}
	50% {
		transform: translateY ( -64px)
	}
	60% {
		transform: translateY ( -80px)
	}
	70% {
		transform: translateY ( -96px)
	}
	80% {
		transform: translateY ( -112px)
	}
	90% {
		transform: translateY ( -128px)
	}
	100% {
		transform: translateY ( -144px)
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

#content {
	margin-top: 90px;
	width: 100%;
	height: 800px;
	float: right;
}

#wrapper {
	position: relative;
	color: rgb(244, 244, 244);
	width: 1200px;
	height: 800px;
	left: 379px;
}

#reg_con {
	position: absolute;
	top: 100px;
	width: 500px;
	left: 350px;
	height: 540px;
	border: 2px solid rgb(74, 254, 0);
	border-radius: 30px;
	padding-top: 50px;
}

.con {
	width: 500px;
	height: 70px;
}

.int {
	position: absolute;
	height: 50px;
	width: 220px;
	right: 0px;
	background-color: transparent;
	outline: none;
	border: 2px solid rgb(244, 244, 244);
	border-radius: 30px;
	color: rgb(74, 254, 0);
	right: 50px;
	padding-left: 30px;
}

.int:focus {
	border: 2px solid rgb(74, 254, 0);
}

.join_title {
	width: 200px;
	position: absolute;
	left: 50px;
	line-height: 50px;
}

#btnJoin {
	position: absolute;
	height: 50px;
	width: 300px;
	background-color: transparent;
	border: 2px solid rgb(244, 244, 244);
	border-radius: 30px;
	color: rgb(244, 244, 244);
	cursor: pointer;
	left: 100px;
	bottom: 40px;
}

#btnJoin:hover {
	border: 2px solid rgb(74, 254, 0);
	color: rgb(244, 244, 244);
	text-shadow: 0 0 10px rgb(74, 254, 0);
	box-shadow: 0 0 25px 0 rgb(74, 254, 0), 0 20px 25px 0 rgba(0, 0, 0, 0.2);
}

.sel {
	position: absolute;
	height: 50px;
	width: 100px;
	right: 50px;
	background-color: transparent;
	outline: none;
	border: 2px solid rgb(244, 244, 244);
	border-radius: 30px;
	color: rgb(74, 254, 0);
	padding-left: 30px;
}
</style>
</head>
<body>
	<nav id="fix_side">
		<div id="fix_logo">
			<div id="fix_logo_img"></div>
			<a href="unLoginMainServlet" id="fix_logo_title">Jelly Music</a>
		</div>
		<div id="fix_user">
			<a href="${pageContext.request.contextPath}/memberLoginServlet">Login</a>
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
					<li><a href="#">구매내역</a></li>
					<li><a href="#">보관함</a></li>
					<li><a href="#">계정설정</a></li>
					<li><a href="#">로그아웃</a></li>
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
					<li><a href="#">장르</a></li>
					<li><a href="#">무드별</a></li>
				</ul>
				<div class="fix_each">
					<img src="${pageContext.request.contextPath}/image/002-music-1.svg"
						class="fix_menu_icon"> <label for="myplaylist"
						class="fix_each_menu">마이플레이리스트</label>
				</div>
				<div class="fix_each">
					<img src="${pageContext.request.contextPath}/image/001-music.svg"
						class=" fix_menu_icon "> <label for="recommend "
						class="fix_each_menu ">나만의 추천</label>
				</div>
				<div class="fix_each ">
					<img
						src="${pageContext.request.contextPath}/image/008-internet.svg "
						class="fix_menu_icon "> <label for="help "
						class="fix_each_menu ">고객지원센터</label>
				</div>
				<ul>
					<li><a href="# ">공지사항</a></li>
					<li><a href="# ">Q&A</a></li>
					<li><a href="# ">자주하는 질문</a></li>
					<li><a href="# ">로그아웃</a></li>
				</ul>
				<div class="fix_each ">
					<img src="${pageContext.request.contextPath}/image/006-star.svg"
						class="fix_menu_icon "> <label for="membership "
						class="fix_each_menu ">이용권구매</label>
				</div>
			</div>
		</div>
		<div class="fix_btn ">
			<button class="fix_player_btn"
				onclick="location.href='unLoginMainServlet'">Player</button>
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
	<div id="content">
		<div id="wrapper">
			<form name="registerChange" id="reg_con" " action="<%=request.getContextPath() %>/MyPageModifyCtrlSrv" method="post">
				<div id="con2" class="con">
					<div class="join_title">비밀번호</div>
					<input type="password" id="mem_pwd" name="mem_pwd" class="int"
						maxlength="20">
				</div>
				<div id="con3" class="con">
					<div class="join_title">이름</div>
					<input type="text" id="mem_name" name="mem_name" class="int"
						maxlength="20">
				</div>
				<div id="con5" class="con">
					<div class="join_title">본인확인 이메일</div>
					<input type="text" id="mem_email" name="mem_email" class="int"
						maxlength="100" placeholder="선택입력">
				</div>
				<div id="con6" class="con">
					<div class="join_title">휴대전화</div>
					<input type="tel" id="mem_phone" name="mem_phone" class="int"
						maxlength="16" placeholder="전화번호 입력">
				</div>
				<div class="btn_area">
					<button type="submit" id="btnJoin">수정</button>
				</div>
			</form>
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


	<script type="text/javascript">
		$("form").submit(function() {
			var frm = document.registerFrm;
			frm.action = "<%=ctxPath1%>memberRegisterSrv.do";
			frm.method = "post";
			frm.submit();
		});
	</script>
</body>
</html>