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
	<div id="content">
		<div id="wrapper">
			<form name="registerFrm" id="reg_con">
				<div id="con1" class="con">
					<div class="join_title">아이디</div>
					<input type="text" id="mem_id" name="mem_id" class="int"
						maxlength="20">
				</div>
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
				<div id="con4" class="con">
					<div class="join_title">성별</div>
					<select id="mem_gender" name="mem_gender" class="sel">
						<option value="1">남자</option>
						<option value="2">여자</option>
					</select>
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
					<button type="submit" id="btnJoin">가입하기</button>
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
			frm.action = "<%=ctxPath1%>/memberRegisterSrv.do";
			frm.method = "post";
			frm.submit();
		});
	</script>
</body>
</html>