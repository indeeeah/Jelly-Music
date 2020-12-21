<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 글쓰기</title>
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
	width: 180px;
	border: solid 1px;
	vertical-align: middle;
}
</style>
<script type="text/javascript">
	function writefrm_submit() {
		var form = document.writeFrm;
		form.action = "../ManagerPostWriteCtrl";
		form.method = "post";
		form.submit();
	}
</script>
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
			<form name="writeFrm">
				<table border="1">
					<tr>
						<td>제목</td>
						<td><input type="text" name="p_name" id="p_name"
							style="width: 640px; height: 30px;"></td>
					</tr>
					<tr>
						<td>내용</td>
						<td><textarea name="p_content" id="p_content"
								style="width: 640px; height: 340px;"></textarea></td>
					</tr>
					<tr>
						<td>작성자ID</td>
						<td><input type="text" name="mng_id" id="mng_id"
							style="width: 640px; height: 30px;"></td>
					</tr>
					<tr>
						<td colspan="3"><input type="submit" value="글등록"
							onclick="writefrm_submit()">&nbsp;&nbsp;&nbsp;&nbsp;
							<input type="reset" value="다시작성">&nbsp;&nbsp;&nbsp;&nbsp;
							<a href="../ManagerPostListCtrl"><input type="button" value="목록보기"></a></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>