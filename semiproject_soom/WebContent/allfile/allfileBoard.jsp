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
</style>

</head>
<body>
<div>
	<button type="button" id="btn" onclick="location.href='managerMain.jsp';">메인으로 가기</button>
	&nbsp;&nbsp;&nbsp;&nbsp;
	<button type="button" id="btn" onclick="location.href='allfile/allfileUpload.html';">파일 업로드</button>
</div>

<br>
	<table>
		<tr>
			<td>번호</td>
			<td>파일번호</td>
			<td>파일이름</td>
			
		</tr>
		<c:if test="${ not empty allList }">
			<c:forEach items="${ allList }" var="i" varStatus="s">
		
			<tr>
				<td>${s.count}</td>
				<td>${i.f_no }</td>
				<td><a href="SelectOne?num=${i.num}">${i.f_name}</a></td>
			</tr>
	
		</c:forEach>
		</c:if>
	</table>
	<div class="pagediv">
		<c:if test="${startPage != endPage}">
			<c:forEach varStatus="s" begin="${startPage}" end="${endPage}"
				step="1">
				<a href="selectService?pageNum=${s.count}">${s.count}</a>
				<!--변경 : href 경로 -->
			</c:forEach>
		</c:if>
	</div>
</body>
</html>