<link href="${pageContext.request.contextPath}/css/reset.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/main_login.css"
	rel="stylesheet" type="text/css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Jelly Music</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script type="text/javascript"
	src="https://code.jquery.com/jquery-3.2.1.min.js"></script>

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

<style type="text/css">
* {
	margin: 0;
}

body {
	width: 100%;
	position: relative;
}

table, td {
	border-collapse: collapse;
}

a {
	text-decoration: none;
}

a:visited {
	text-decoration: none;
	color: gray;
}

.post_section {
	padding-right: 150px;
	padding-top: 150px;
	float: right;
	width: 820px;
}

.head_aticle {
	padding: 5px 0 10px;
}

.tit {
	color: rgb(244, 244, 244);
	font-size: 25px;
}

.tit_sub {
	padding-left: 11px;
	font-size: 14px;
	color: rgb(244, 244, 244);
	line-height: 20px;
	letter-spacing: -.3px;
	vertical-align: 3px;
}

.post_board_content {
	width: 100%;
}

.post_board_content table {
	width: 100%;
	height: 450px;
	border: solid 1px;
	border-collapse: collapse;
}

.post_board_content tr td:nth-child(1) {
	background-color: rgb(22, 22, 22);
	color: rgb(244, 244, 244);
	font-size: 15px;
	text-align: center;
	font-weight: bold;
	width: 150px;
	line-height: 30px;
	border: solid 1px;
	vertical-align: middle;
	height: 10px;
}

.post_board_content tr td:nth-child(2) {
	background-color: rgb(46, 49, 66);
	color: rgb(244, 244, 244);
	font-size: 13px;
	width: 150px;
	border: solid 1px;
	text-align: center;
	vertical-align: middle;
}

.post_board_content tr td:nth-child(3) {
	background-color: rgb(22, 22, 22);
	color: rgb(244, 244, 244);
	font-size: 15px;
	width: 150px;
	text-align: center;
	vertical-align: middle;
	font-weight: bold;
	border: solid 1px;
}

.post_board_content tr td:nth-child(4) {
	background-color: rgb(46, 49, 66);
	color: rgb(244, 244, 244);
	border: solid 1px;
	font-size: 13px;
	width: 150px;
	text-align: center;
	vertical-align: middle;
}
</style>
</head>
<body>
<input type="hidden" id="mem_id" value="${mem_id }" name="mem_id">
	<nav id="fix_side">
		<div id="fix_logo">
			<div id="fix_logo_img"></div>
			<a href="mainServlet" id="fix_logo_title">Jelly Music</a>
		</div>
		<div id="fix_user">
			<img src="${pageContext.request.contextPath}/image/005-user.svg"
				id="fix_prof">
			<c:if test="${not empty himem }">
				<c:forEach items="${himem }" var="v" varStatus="s">
					<a href="#">Hello, ${v.mem_aka }</a>
				</c:forEach>
			</c:if>
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
					<li><a href="${pageContext.request.contextPath}/MemberPostListCtrl">공지사항</a></li>
					<li><a href="#">Q&A</a></li>
					<li><a href="${pageContext.request.contextPath}/mfreqQues/mfreqQues.jsp">자주하는 질문</a></li>
					<li><a href="#">로그아웃</a></li>
				</ul>
				<div class="fix_each">
					<img src="${pageContext.request.contextPath}/image/006-star.svg"
						class="fix_menu_icon"> <label for="membership"
						class="fix_each_menu">이용권구매</label>
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
	<div class="post_section">
		<div class="head_aticle">
			<h2 class="tit">
				공지사항 <span class="tit_sub"> 주요 소식 안내입니다. </span>
			</h2>
		</div>
		<br> <br>
		<form name="goRegister">
			<div class="post_board_content">
				<table>
					<c:if test="${not empty detailList }">
						<input type="hidden" name=p_no value="${detailList.p_no}">
						<tr>
							<td>번호</td>
							<td>${detailList.p_no}</td>
							<td>조회수</td>
							<td>${detailList.p_hits }</td>
						</tr>
						<tr>
							<td>작성자</td>
							<td>${detailList.mng_id }</td>
							<td>작성일</td>
							<td>${detailList.p_time }</td>
						</tr>
						<tr>
							<td>제목</td>
							<td colspan="3" style="padding-left: 8px;">${detailList.p_name}</td>
						</tr>
						<tr>
							<td>내용</td>
							<td colspan="3" style="padding-left: 8px; height: 300px;">${detailList.p_content }</td>
						</tr>
					</c:if>
				</table>
				<br><br>
				<div>
					 &nbsp;&nbsp; <a href="MemberPostListCtrl"><input
						type="button" value="목록보기">
				</div>
			</div>
		</form>
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
				type : "POST",
				url : "mainToPlayListSrv",
				data : {
					mem_id : showmemId,
					mu_no : showTvalue
				},
				success : function(resulttr) {

				}
			});
		});

		$(".tri_con").click(function() {
			var showTvalue = $(this).next().val();
			var showmemId = $("#mem_id").val();
			console.log(showTvalue + "update");
			console.log(showmemId);

			$.ajax({
				type : "POST",
				url : "updateCurrmusicServlet",
				data : {
					mem_id : showmemId,
					mu_no : showTvalue
				},
				success : function(resultcm) {
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
				type : "POST",
				url : "mainToPlayListSrv",
				data : {
					mem_id : showmemId,
					mu_no : showFvalue
				},
				success : function(resultfy) {

				}
			});
		});

		$(".for_you_con").click(function() {
			var showFvalue = $(this).next().val();
			var showmemId = $("#mem_id").val();
			console.log(showFvalue);
			console.log(showmemId);

			$.ajax({
				type : "POST",
				url : "updateCurrmusicServlet",
				data : {
					mem_id : showmemId,
					mu_no : showFvalue
				},
				success : function(resultcm) {

				}
			});
		});

		$(".lpm_con").click(function() {
			var showLvalue = $(this).next().val();
			var showmemId = $("#mem_id").val();
			console.log(showLvalue);
			console.log(showmemId);

			$.ajax({
				type : "POST",
				url : "mainToPlayListSrv",
				data : {
					mem_id : showmemId,
					mu_no : showLvalue
				},
				success : function(resultlp) {

				}
			});
		});

		$(".lpm_con").click(function() {
			var showLvalue = $(this).next().val();
			var showmemId = $("#mem_id").val();
			console.log(showLvalue);
			console.log(showmemId);

			$.ajax({
				type : "POST",
				url : "updateCurrmusicServlet",
				data : {
					mem_id : showmemId,
					mu_no : showLvalue
				},
				success : function(resultcm) {

				}
			});
		});

		$(".newrl_con").click(function() {
			var showNvalue = $(this).next().val();
			var showmemId = $("#mem_id").val();
			console.log(showNvalue);
			console.log(showmemId);

			$.ajax({
				type : "POST",
				url : "mainToPlayListSrv",
				data : {
					mem_id : showmemId,
					mu_no : showNvalue
				},
				success : function(resultnl) {

				}
			});
		});

		$(".newrl_con").click(function() {
			var showNvalue = $(this).next().val();
			var showmemId = $("#mem_id").val();
			console.log(showNvalue);
			console.log(showmemId);

			$.ajax({
				type : "POST",
				url : "updateCurrmusicServlet",
				data : {
					mem_id : showmemId,
					mu_no : showNvalue
				},
				success : function(resultcm) {

				}
			});
		});
	</script>
</body>
</html>