<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
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
	font-size: 13px;
	width: 150px;
	border: solid 1px;
	text-align: center;
	vertical-align: middle;
}

.post_board_content tr td:nth-child(3) {
	font-size: 15px;
	width: 150px;
	text-align: center;
	font-weight: bold;
	border: solid 1px;
}

.post_board_content tr td:nth-child(4) {
	border: solid 1px;
	font-size: 13px;
	width: 150px;
	text-align: center;
	vertical-align: middle;
}
</style>

<script type="text/javascript">
	function doUpdate() {
		var form = document.doUpdate;
		form.action = "../ManagerPostUpdateCtrl";
		form.method = "post";
		form.submit();
	}
</script>
<title>Insert title here</title>
</head>
<body>
	<div class="post_section">
		<div class="head_aticle">
			<h2 class="tit">
				공지사항 <span class="tit_sub"> 주요 소식 안내입니다. </span>
			</h2>
		</div>
		<br> <br>
		<div class="post_board_content">
			<form name=doUpdate action="ManagerPostUpdateCtrl">
				<table width="500" cellpadding="0" cellspacing="0" border="1">
					<c:if test="${not empty updateList }" var="list">
						<input type="hidden" name=p_no value="${updateList.p_no}">

						<tr>
							<td>번호</td>
							<td>${updateList.p_no}</td>
							<td>조회수</td>
							<td>${updateList.p_hits }</td>
						</tr>
						<tr>

							<td>작성자</td>
							<td>${updateList.mng_id }</td>
							<td>작성일</td>
							<td>${updateList.p_time }</td>
						</tr>
						<tr>
							<td>제목</td>
							<td colspan="3" style="padding-left: 8px;"><input
								type="text" name="p_name" style="width: 640px; height: 30px;" value="${updateList.p_name}"></td>

						</tr>
						<tr>
							<td>내용</td>
							<td colspan="3" style="padding-left: 8px;"><input
								type="text" name="p_content" style="width: 640px; height: 350px;" value="${updateList.p_content }"></td>
						</tr>
					</c:if>
				</table>
				<br><br>
				<div>
					<input type="submit" value="수정"> &nbsp;&nbsp;<a
						href="ManagerPostListCtrl"><input type="button" value="목록보기"></a>

				</div>
			</form>
		</div>
	</div>
</body>
</html>