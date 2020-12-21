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

.Header {
	width: 100%;
	height: 170px;
}

table, td {
	border-collapse: collapse;
}

#c_main {
	padding-top: 150px;
	width: 1080px;
	margin: auto;
}

.page_section {
	padding-bottom: 100px;
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

#qna_select {
	width: 150px;
	height: 30px;
}

.txt_no {
	text-align: center;
}

.txt_title {
	width: 180px;
}

.xans-board-listheader {
	font-size: 13px;
	line-height: 140%;
}

.xans-board-listheader th {
	color: rgb(244, 244, 244);
	padding: 15px 0px;
	vertical-align: middle;
	font-size: 12px;
}

.xans-board-listheader thead {
	border-top: 1px solid gray;
	border-bottom: 1px solid gray;
}

.xans-board-listheader tbody tr {
	color: rgb(244, 244, 244);
	text-align: center;
	border-bottom: 1px solid #e8e8e8;
}

.xans-board-listheader tbody tr td {
	color: rgb(244, 244, 244);
	padding: 20px 40px 20px 40px;
}

table thead tr {
	height: 40px;
	line-height: 40px;
	background-color: rgb(22, 22, 22);
	font-size: 12px;
}

.fq1_no {
	background-color: rgb(46, 49, 66);
}

.fq1_type {
	background-color: rgb(46, 49, 66);
}

.fq1_title {
	background-color: rgb(46, 49, 66);
	text-align: left;
}

.fq2 {
	text-align: left;
	display: none;
}

.fq2_none {
	width: 40px;
}

.fq2_desc {
	text-align: left;
}
</style>
</head>

<body>
	<script>
		$(document).ready(
				function() {
					$(".fq1_title").css("cursor", "pointer");
					$(".fq1_title").on("click", function() {
						var title = $(this);
						if (!title.parent().next().is(":visible")) {
							title.parent().next().slideDown("fast");
						} else {
							title.parent().next().slideUp("fast");
						}
					});

					$("#qna_select").change(
							function() {
								var select = $("#qna_select option:selected")
										.val();
								if (select == "member") {
									$(".member").parent().show();
									$(".service").parent().hide();
									$(".membership").parent().hide();
								} else if ($("#qna_select option:selected")
										.val() == "service") {
									$(".member").parent().hide();
									$(".service").parent().show();
									$(".membership").parent().hide();
								} else if ($("#qna_select option:selected")
										.val() == "membership") {
									$(".member").parent().hide();
									$(".service").parent().hide();
									$(".membership").parent().show();
								} else {
									$(".member").parent().show();
									$(".service").parent().show();
									$(".membership").parent().show();
								}
							});
				});
	</script>
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
					<li><a href="${pageContext.request.contextPath}/mfreqQues/mfreqQues.jsp">자주하는
							질문</a></li>
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
	<div id="c_main">
		<div class="page_section">
			<div class="head_aticle">
				<h2 class="tit">
					자주하는 질문 <span class="tit_sub"> 자세한 문의는 Q&A게시판을 이용해 주세요</span>
				</h2>
				<br> <select name="qna_select" id="qna_select">
					<option value="">선택</option>
					<option value="member">회원정보</option>
					<option value="service">서비스문의</option>
					<option value="membership">이용권문의</option>
				</select>
			</div>
			<table width="100%" class="xans-board-listheader jh">
				<thead>
					<tr>
						<th class="txt_no">번호</th>
						<th class="txt_title">분류</th>
						<th class="txt_date">제목</th>
					</tr>
				</thead>
				<tbody>
					<tr class="fq1">
						<td class="fq1_no">1</td>
						<td class="fq1_type member">회원정보</td>
						<td class="fq1_title">비밀번호를 변경하려면 어떻게 해야 하나요?</td>
					</tr>
					<tr class="fq2" id="fq2_1">
						<td class="fq2_none"></td>
						<td class="fq2_desc" colspan="2">아이디/비밀번호를 사용 중인 회원<br />
							비밀번호 변경은 마이페이지 > 회원정보 수정 > 비밀번호 변경에서 할 수 있습니다.<br /> <br />
						</td>
					</tr>
					<tr class="fq1">
						<td class="fq1_no">2</td>
						<td class="fq1_type membership">이용권문의</td>
						<td class="fq1_title">이용권이란 뭔가요?</td>
					</tr>
					<tr class="fq2" id="fq2_2">
						<td class="fq2_none"></td>
						<td class="fq2_desc" colspan="2">음악 감상 서비스를 사용하기 위한 이용권을
							말합니다.<br /> <br />음악감상 서비스 여부에 따라 다양한 이용권을 제공하고 있으며, <br />
							결제/사용기간에 따라 일정 기간 동안 사용이 가능한 1일권, 30일권 티켓 이용권으로 구분됩니다.<br /> <br />
						</td>
					</tr>
					<tr class="fq1">
						<td class="fq1_no">3</td>
						<td class="fq1_type membership">이용권문의</td>
						<td class="fq1_title">음악 감상 서비스를 이용하려면 이용권이 꼭 있어야 하나요?</td>
					</tr>
					<tr class="fq2" id="fq2_3">
						<td class="fq2_none"></td>
						<td class="fq2_desc" colspan="2">이용권이 있어야만 음악 감상 서비스를 이용할 수
							있는건 아닙니다. <br />이용권을 사용하지 않는 회원은 1분만 음악 감상을 하실 수 있으며, <br />
							이용권을 사용하시는 회원은 완곡 듣기로 음악 감상 서비스를 이용할 수 있습니다.<br /> <br />
						</td>
					</tr>
					<tr class="fq1">
						<td class="fq1_no">4</td>
						<td class="fq1_type service">서비스문의</td>
						<td class="fq1_title">플레이어를 사용하려면 별도의 프로그램을 설치해야 하나요?</td>
					</tr>
					<tr class="fq2" id="fq2_4">
						<td class="fq2_none"></td>
						<td class="fq2_desc" colspan="2">음악 감상 서비스를 이용하기 위해서는 플레이어를
							이용해야 합니다.<br /> 하지만 별도의 프로그램을 설치하는 방식이 아닌 자체적으로 플레이어를 사용하는 방식으로
							<br /> 누구나 쉽게 음악 감상을 할 수 있습니다.<br /> <br />
						</td>
					</tr>
					<tr class="fq1">
						<td class="fq1_no">5</td>
						<td class="fq1_type membership">이용권문의</td>
						<td class="fq1_title">이용권 구매 후 결제 취소(청약 철회) 또는 환불 받을 수 있나요?</td>
					</tr>
					<tr class="fq2" id="fq2_5">
						<td class="fq2_none"></td>
						<td class="fq2_desc" colspan="2">모든 이용권은 먼저 결제를 하신 후 사용하는
							서비스입니다.<br /> 결제 후 7일 이내 스트리밍 및 다운로드 등 이용권 사용이력이 없는 경우에는 결제 방법에
							따라 <br /> 취소(청약철회)가 가능하며, 이미 이용권을 사용하신 경우라면 중도해지를 하실 수 있습니다.<br />
							중도 해지시에는 남은 기간에 따라 환불 받을 수 있습니다.<br /> <br />
						</td>
					</tr>
					<tr class="fq1">
						<td class="fq1_no">6</td>
						<td class="fq1_type service">서비스문의</td>
						<td class="fq1_title">장르는 무엇인가요?</td>
					</tr>
					<tr class="fq2" id="fq2_6">
						<td class="fq2_none"></td>
						<td class="fq2_desc" colspan="2">음악의 장르에 따라 분류 한 것을 말합니다.<br />
							국내와 해외를 나누어지며, 각각 세분화 돼 있습니다.<br /> 국내 - 발라드, 댄스, 힙합, R&B, 인디,
							트로트, 재즈 등<br /> 해외 - 발라드, 댄스, 힙합, R&B, 재즈 등 <br /> <br />
						</td>
					</tr>
					<tr class="fq1">
						<td class="fq1_no">7</td>
						<td class="fq1_type service">서비스문의</td>
						<td class="fq1_title">무드는 무엇인가요?</td>
					</tr>
					<tr class="fq2" id="fq2_7">
						<td class="fq2_none"></td>
						<td class="fq2_desc" colspan="2">음악을 느낌별로 분류 한 것을 말합니다.<br />
							우울할 떄, 신났을 때, 휴식할 때, 사랑할 때, 외로울 때 등으로 세분화 돼 있습니다.<br /> <br />
						</td>
					</tr>
					<tr class="fq1">
						<td class="fq1_no">8</td>
						<td class="fq1_type service">서비스문의</td>
						<td class="fq1_title">나에게 추천 해주는 음악은 어떻게 이루어 진건가요?</td>
					</tr>
					<tr class="fq2" id="fq2_8">
						<td class="fq2_none"></td>
						<td class="fq2_desc" colspan="2">회원들이 자주 들었던 음악을 분석하여, 비슷한
							성향의 회원들에게서 음악을 추천해 주는 식으로 이루어졌습니다. <br />취향에 맞는 추천을 제공하지만, 취향
							정보가 부족할 경우 맞지 않는 음악이 추천될 수도 있습니다.<br /> <br />
						</td>
					</tr>
					<tr class="fq1">
						<td class="fq1_no">9</td>
						<td class="fq1_type membership">이용권문의</td>
						<td class="fq1_title">이용권과 MP3의 차이는 무엇인가요?</td>
					</tr>
					<tr class="fq2" id="fq2_9">
						<td class="fq2_none"></td>
						<td class="fq2_desc" colspan="2">이용권은 기간동안 자유롭게 모든 음악을 완곡듣기를
							할 수 있습니다.<br /> MP3로 구매한 음악은 해당 음악만 완곡듣기가 가능하며, 다른 음악들은 1분 듣기만
							가능합니다.<br /> 또한 이용권으로는 음악을 다운로드 할 수 없습니다.<br /> <br />
						</td>
					</tr>
					<tr class="fq1">
						<td class="fq1_no">10</td>
						<td class="fq1_type member">회원정보</td>
						<td class="fq1_title">회원탈퇴는 어떻게 하면 되나요?</td>
					</tr>
					<tr class="fq2" id="fq2_10">
						<td class="fq2_none"></td>
						<td class="fq2_desc" colspan="2">왼쪽 메뉴 중에 마이페이지 > 회원정보 수정을 통해
							회원 탈퇴를 신청하실 수 있습니다. <br /> 회원탈퇴시 회원정보는 자동으로 삭제되며, 탈퇴 후 재가입은 가능하나
							다른 회원이 사용하는 ID로는 가입이 불가능합니다.<br /> <br />
						</td>
					</tr>
				</tbody>
			</table>
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