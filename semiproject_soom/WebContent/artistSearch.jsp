<link href="${pageContext.request.contextPath}/css/reset.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/main_login.css"
	rel="stylesheet" type="text/css">

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
<style>
.container {
	position: relative;
	color: rgb(244, 244, 244);
	width: 1200px;
	min-height: 680px;
	left: 379px;
}

.al_more_tracks {
	width: 100%;
	padding: 20px 0;
	display: block;
}

.al_more_tracks_section, .al_more_singles_title, .al_more_alike_title,
	.al_more_video_title {
	font-size: 1.5em;
	padding-bottom: 15px;
}

.al_more_tracks_title {
	padding-bottom: 10px;
	display: flex;
}
.al_more_tracks_title{
	text-align:center;
}
.al_more_tracks_title1{
	width:18%;
}
.al_more_tracks_title2{
	width:30%;
}
.al_more_tracks_title3{
	width:25%;
}
.al_more_tracks_title4{
	width:30%;
}

.al_more_tracks_line img {
	
}

.al_more_tracks_line div {
	display: inline;
	height: 40px;
	line-height: 40px;
	text-align: center;
}

.al_more_tracks_line img {
	width: 40px;
	height: 40px;
}

.al_more_tracks_line {
	border-top: 1px solid white;
	display: flex;
}

.al_more_tracks_line1 {
	width: 7%;
}

.al_more_tracks_line2 {
	width: 4%;
}

.al_more_tracks_line3 {
	width: 7%;
}

.al_more_tracks_line4 {
	width: 30%;
}

.al_more_tracks_line5 {
	width: 25%;
}

.al_more_tracks_line6 {
	width: 10%;
}

.al_more_tracks_line7 {
	width: 10%;
}

.al_more_tracks_line8 {
	width: 10%;
}

.al_more_tracks_plus {
	text-align: center;
	right: 0px;
}
/* The Modal (background) */
.modal {
	display: none;
	position: fixed; /* Stay in place */
	z-index: 100; /* Sit on top */
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
	background-color: white;
	margin: auto;
	padding: 20px;
	border: 1px solid #888;
	width: 80%;
	overflow: scroll;
}

/* The Close Button */
.close {
	color: #aaaaaa;
	float: right;
	font-size: 28px;
	font-weight: bold;
}

.close:hover, .close:focus {
	color: #000;
	text-decoration: none;
	cursor: pointer;
}
/* hr{
				border:1px solid black;
			} */
</style>
</head>

<body>
	<input type="hidden" id="mem_id" value="${mem_id }">
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
					<a href="#">Hello, ${v.mem_id }</a>
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
					<li><a href="#">공지사항</a></li>
					<li><a href="#">Q&A</a></li>
					<li><a href="#">자주하는 질문</a></li>
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
			<%-- <c:if test="${not empty scm }">
                        <c:forEach items="${scm }" var="v" varStatus="s">
                            <input type="hidden" name="mu_no" value=${v.mu_no }>
                            <input type="hidden" id="mem_id" name="mem_id" value=${v.mem_id }>
                            <button class="fix_player_btn" onclick="window.open('<%=request.getContextPath()%>/playerCtrl.do?mu_no=${v.mu_no}','','width=1200,height=720')">Player</button>
                        </c:forEach>
                    </c:if> --%>
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
	<div class="main_content">
		<div class="container">
			<div class="al_more_tracks">
				<div class="al_more_tracks_section">Tracks</div>
				<div class="al_more_tracks_inner">
					<div class="al_more_tracks_list">
						<div class="al_more_tracks_title">
							<div class="al_more_tracks_title1">#</div>
							<div class="al_more_tracks_title2">SONG</div>
							<div class="al_more_tracks_title3">ALBUM</div>
							<div class="al_more_tracks_title4">OPTION</div>
						</div>
						<div>
							<c:if test="${not empty aslist }">
								<c:forEach items="${aslist }" var="v" varStatus="s">
									<div class="al_more_tracks_line">
										<div class="al_more_tracks_line1">
											
										</div>
										<div class="al_more_tracks_line2">${s.count }</div>
										<div class="al_more_tracks_line3">
											<a href="#" class="tracks_play">
												<button class="playBtn" value="${v.mu_name }" name="mu_no"
													onclick="openWin()" type="button">재생</button>

											</a>
										</div>
										<div class="al_more_tracks_line4">
											<a
												href="<%=request.getContextPath() %>/musicMoreServlet?mu_no=${v.mu_no }"
												class="tracks_music">${v.mu_name}</a>
										</div>
										<div class="al_more_tracks_line5">
											<a
												href="<%=request.getContextPath() %>/artistMoreServlet?art_no=${v.art_no }"
												class="tracks_name">${v.art_name }</a>
										</div>
										<div class="al_more_tracks_line6">
											<button type="button" class="tracks_lyrics myBtn"
												value="${v.mu_name }">가사보기</button>
										</div>
										<div class="al_more_tracks_line7">
											<a href="<%=request.getContextPath()%>/MembershipServlet"
												class="tracks_buy">이용권구매</a>
										</div>
										<div class="al_more_tracks_line8">
											<a href="#" class="tracks_more"></a>
										</div>
									</div>
									<div id="${v.mu_name }" class="modal">
										<div class="modal-content ">
											<button type="button" class="close" value="${v.mu_name }">&times;</button>
											<pre>${v.mu_ly }</pre>
										</div>
									</div>
								</c:forEach>
							</c:if>
						</div>
					</div>
				</div>
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
	</div>
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
			console.log(showTvalue);
			console.log(showmemId);

			$.ajax({
				type : "POST",
				url : "updateCurrmusicServlet",
				data : {
					mem_id : showmemId,
					mu_no : showTvalue
				},
				success : function(resultcm) {

				}
			});
		});

		$(".for_you_con").click(function() {
			var showFvalue = $(this).next().val();
			var showmemId = $("#mem_id").val();
			console.log(showFvalue);

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
	<script>
		$('.myBtn').on('click', function() {
			var a = $(this).val();
			console.log(a);
			var x = document.getElementById(a);
			console.log(x);
			x.style.display = "block";
		});
		$('.close').on('click', function() {
			/* $('#modal').hide(); */
			var a = $(this).val();
			console.log(a);
			var x = document.getElementById(a);
			console.log(x);
			x.style.display = "none";
		});
	</script>
</body>

</html>