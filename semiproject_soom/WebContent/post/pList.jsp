<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 조회</title>
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
	padding-right: 100px;
	padding-top: 50px;
	float: right;
	width: 820px;
}

.head_aticle {
	padding: 5px 0 10px;
}

.tit {
	font-size: 25px;
}

.tit_sub {
	padding-left: 11px;
	font-size: 14px;
	color: #999;
	line-height: 20px;
	letter-spacing: -.3px;
	vertical-align: 3px;
}

.post_board_List_01 {
	font-size: 13px;
	line-height: 140%;
}

.post_board_List_01 th {
	padding: 20px 0;
	vertical-align: middle;
	font-size: 15px;
}

.post_board_List_01 thead {
	text-align: center;
	line-height: 20px;
	letter-spacing: -.3px;
	vertical-align: 3px;
	border-top: 1px solid gray;
	border-bottom: 1px solid gray;
	background-color: gray;
}

.post_board_List_01 tbody tr {
	text-align: center;
	border-bottom: 1px solid #e8e8e8;
}

.post_board_List_01 tbody tr td {
	padding: 20px 0;
}
</style>
</head>
<body>
	<div class="post_section">
		<div class="head_aticle">
			<h2 class="tit">
				공지사항 <span class="tit_sub"> 주요 소식 안내입니다. </span>
			</h2>
		</div>
		<br> <br>
		<table width="100%" align="center" cellpadding="0" cellspacing="0">
			<tbody>
				<tr>
					<td>
						<div class="post_board_List">
							<table width="100%" class="post_board_List_01" cellpadding="0"
								cellspacing="0">
								<thead>
									<tr>
										<th>글번호</th>
										<th>제목</th>
										<th>작성자</th>
										<th>작성일</th>
										<th>조회수</th>
									</tr>
								</thead>
								<tbody>
									<c:if test="${not empty postList}">
										<c:forEach items="${postList}" var="list" varStatus="s">
											<tr>
												<td>${s.count}</td>
												<td><a href="ManagerPostDetailCtrl?p_no=${list.p_no}">${list.p_name}</a></td>
												<td>${list.mng_id}</td>
												<td>${list.p_time}</td>
												<td>${list.p_hits}</td>
											</tr>
										</c:forEach>
									</c:if>
								</tbody>
							</table>
						</div>
					</td>
				</tr>
			</tbody>
		</table>
		<br>
		<br>
		<div>
			<button type="button" id="btn"
				onclick="location.href='managerMain.jsp';">메인으로 가기</button>
			&nbsp;&nbsp;&nbsp;&nbsp; <a href="./post/pWrite.jsp"><input
				type="button" value="글작성"></a>
		</div>

		<!--페이징 아래 숫자-->
		<div class="pagediv">
			<c:if test="${startPage != endPage}">
				<c:forEach varStatus="s" begin="${startPage}" end="${endPage}"
					step="1">
					<a href="ManagerPostListCtrl?pageNum=${s.count}">${s.count}</a>
					<!--변경 : href 경로 -->
				</c:forEach>
			</c:if>
		</div>
	</div>
</body>
</html>
