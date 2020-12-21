<link href="${pageContext.request.contextPath}/css/reset.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/main_login.css"
	rel="stylesheet" type="text/css">
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%!SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");%>
<%
	int pageSize = 10;
int pageBlock = 10;
String ctxPath = request.getContextPath();
int bCount = (int) request.getAttribute("bCount");
int pageCount = (int) request.getAttribute("pageCount");
int currentPage = (int) request.getAttribute("currentPage");
int startPage = (int) request.getAttribute("startPage");
int endPage = (int) request.getAttribute("endPage");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<title>문의글 게시판</title>
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

#board {
	position: relative;
	overflow: hidden;
	font-size: 15px;
}

.board_wrap {
	padding-top: 100px;
}

table {
	width: 1080px;
	margin: 0 auto;
	top: 100px;
	border-collapse: 0;
}

table tr td {
	border: 1px solid white;
	padding: 15px 0;
	text-align: center;
	color: white;
}

table tr:nth-child(1) td:nth-child(1) {
	border: none;
}

table tr:nth-child(2) td {
	/* border-top: 2px solid white; */
	border-top: 2px solid white;
}

#search {
	float: right;
}

#search input:nth-child(1) {
	width: 200px;
	height: 30px;
	box-sizing: border-box;
}

#search input:nth-child(2) {
	width: 80px;
	height: 30px;
	border: none;
	background-color: #ea3855;
	color: white;
	border-radius: 3px;
}

.write_btn {
	border: none;
	color: #171928;
}

.write_btn button {
	float: right;
	width: 80px;
	height: 30px;
	background-color: #ea3855;
	border: none;
	border-radius: 3px;
}

.title {
	font-weight: 700;
}

#page {
	width: 1080px;
	margin: 0 auto;
	color: white;
	text-align: center;
	height: 50px;
	line-height: 50px;
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
			<div id="board">
				<div class="board_wrap">
					<table>
						<tr>
							<td colspan="5">
								<form action="postSearchCtrl" method="post" id="search">
									<input type="text" name="quesSearch" id="searchbar"> <input
										type="submit" value="검색">
								</form>
							</td>
						</tr>
						<tr>
							<td colspan="5" class="write_btn"><button>
									<a href="memberQuesWrite.jsp">글쓰기</a>
								</button></td>
						</tr>
						<tr class="title">
							<td class="number">글번호</td>
							<td id="subject">제목</td>
							<td class="writer">작성자</td>
							<td class="count">조회수</td>
							<td class="date">작성날짜</td>
						</tr>
		<c:if test="${not empty QSearchW }">
		<c:forEach items="${QSearchW }" var="v" varStatus="s">
		
			<tr>
				<td class="number">${v.que_no}</td>
				
									<td><c:if test="${v.que_level eq 2}">
                 							&nbsp;&nbsp;->
               							</c:if> 
               							<c:set var="O" value="O" />
               							<c:set var="writer" value="${v.mem_id }" />
               						<c:choose>
               							<c:when test="${v.que_secret ne O }">
               								<a class="que_cnt" href="<%=ctxPath %>/postContentServlet?que_no=${v.que_no}&pageNum=<%=currentPage%>">${v.que_name }</a>
               							</c:when>
               							<c:when test="${v.que_secret eq O && writer eq ssLogInfo.mem_id}">
               								<a class="que_cnt" href="<%=ctxPath %>/postContentServlet?que_no=${v.que_no}&pageNum=<%=currentPage%>">${v.que_name }</a>
               							</c:when>
               							<c:when test="${not empty mng_id}">
               								<a class="que_cnt" href="<%=ctxPath %>/postContentServlet?que_no=${v.que_no}&pageNum=<%=currentPage%>">${v.que_name }</a>
               							</c:when>
               							<c:otherwise>
               								(secret)
               							</c:otherwise>
               						</c:choose></td>
				
				<td class="writer">${v.mem_id }</td>
				<td class="count">${v.que_cnt }</td>
				<td class="date">${v.que_date }</td>
			<tr>
		</c:forEach>
	</c:if>
	</table>
	
	<input type="hidden" name="pageNum" value="<%=currentPage %>">
 	<div id="page">
<%
	if(startPage!=1){
%>
		<a href="<%=ctxPath %>/postSearchCtrl?pageNum=<%=currentPage-pageBlock%>">[이전]</a>
<%
	} else {
%>
		[이전]
<%
	}
%>
<%
		for( int i = startPage; i <= endPage; i++){
			if (currentPage != i) {
%>
			<a href="<%=ctxPath %>/postSearchCtrl?pageNum=<%=i%>">[<%=i%>]</a>
<%
		} else {
			%>
			[<%=i%>]
			<%
		}
	}
%>
<%
	if(currentPage!=pageCount){
%>
		<a href="<%=ctxPath %>/postSearchCtrl?pageNum=<%=startPage + pageBlock%>">[다음]</a>
<%
	} else {
%>
		[다음]
<%
	}
%> 
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
			<div id="fix_info" class="fix_fc">제작자 : 김경태 김수민 곽은지 김지용 장재혁${idLog }</div>
		</div>
	</footer>
</body>
</html>