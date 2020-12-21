<link href="${pageContext.request.contextPath}/css/reset.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/finishregister.css"
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
</style>
</head>

<body>
	<input type="hidden" id="mem_id" value="${mem_id }">
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
					<li><a
						href="${pageContext.request.contextPath}/memberLogoutServlet">로그아웃</a></li>
				</ul>
				<div class="fix_each">
					<img
						src="${pageContext.request.contextPath}/image/003-play-button.svg"
						class="fix_menu_icon"> <label for="song"
						class="fix_each_menu"
						onclick="location.href='unLoginMainListCtrl.do';">노래</label>
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
					<li><a href="${pageContext.request.contextPath}/MemberPostListCtrl">공지사항</a></li>
                            <li><a href="${pageContext.request.contextPath}/postListServlet">Q&A</a></li>
                            <li><a href="${pageContext.request.contextPath}/mfreqQues/mfreqQues.jsp">자주하는 질문</a></li>
				</ul>
				<div class="fix_each">
					<img src="${pageContext.request.contextPath}/image/006-star.svg"
						class="fix_menu_icon"> <label for="membership"
						class="fix_each_menu">이용권구매</label>
				</div>
			</div>
		</div>
		<div class="fix_btn">
			<button class="fix_player_btn"
				onclick="location.href='${pageContext.request.contextPath}/memberLoginServlet'">Player</button>
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
	<div id="fregister">
		<div id="j_con">
			<div id="j_img"></div>
			<p id="jm">"Welcome to the Jelly Music"</p>
			<div id="f1">${mem_id }님의가입을환영합니다!</div>
			<div id="f2">Jelly가 최선을 다해 ${mem_id }님의 취향을 분석할 거예요</div>
			<div id="f3">그러니까 좋아하는 음악이 나오면 하트를 눌러 Jelly에게 알려주세요</div>
			<input type="button" id="gomain" value="메인으로 이동"
				onclick="location.href='unLoginMainServlet';">
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
		$("#gomain").click(function() {
			var showmemId = $("#mem_id").val();
			console.log(showmemId);

			$.ajax({
				type : "POST",
				url : "finishRegMakeCurmusicServlet",
				data : {
					mem_id : showmemId
				},
				dataType : "json",
				success : function(resultmc) {

				}
			});
		});
	</script>
</body>

</html>