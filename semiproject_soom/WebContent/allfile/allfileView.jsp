<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
table, td {
	border: 1px solid black;
	border-collapse: collapse;
}
#img {
	width: 300px;
	height: 300px;
}
</style>
</head>
<body>
<div>
	<button type="button" id="btn" onclick="location.href='managerMain.jsp';">메인으로 가기</button>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<button type="button" id="btn" onclick="location.href='selectService';">파일목록</button>
</div>
<br>
	<table>
		<tr>
			<td>번호</td>
			<td>${requestScope.vo.num}</td>
		</tr>
		<tr>
			<td>파일번호</td>
			<td>${requestScope.vo.f_no}</td>
		</tr>
		<tr>
			<td>파일이름</td>
			<td>${requestScope.vo.f_name}</td>
		</tr>
		<tr>
			<td colspan="2"><img id="img" src="Upload/${requestScope.vo.f_name}"></td>
		</tr> 
	</table>
</body>
</html>