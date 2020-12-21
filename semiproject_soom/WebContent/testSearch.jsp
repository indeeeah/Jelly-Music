<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<% 
String ctxPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.4.0.js"></script>
</head>
<body>
	<c:if test="${not empty loginOk }">
		<form action="testSearchServlet" method="post" class="search">
		<button type="submit" name="click" class="img-button" value="">
			<i class="fas fa-search">검색</i>
		</button>
		<input class="keyword" type="text" name="search" maxlength=255 value="" autocomplete="off">
		<select class="SelectSearch" name="WhichSearch">
			<option type="google" value="google">Google</option>
			<option type="naver" value="naver">Naver</option>
		</select>
		</form>
	</c:if>
	<c:if test="${empty loginOk }">
		로그인 해주세요.<a href="testLogin.jsp">로그인화면</a>
	</c:if>
	<hr>
	<c:if test="${not empty result }">
		<c:forEach items="${result }" var="v" varStatus="s">
			<table>
				<tr>
					<td>${s.count }</td>
					<td>${v.mu_no}</td>
					<td><a href="<%=ctxPath %>/musicMoreServlet?mu_no=${v.mu_no }">${v.mu_name}</a></td>
					<td>${v.al_no}</td>
					<td><a href="<%=ctxPath %>/albumMoreServlet?al_no=${v.al_no }">${v.al_name}</a></td>
					<td>${v.art_no}</td>
					<td><a href="<%=ctxPath %>/artistMoreServlet?art_no=${v.art_no }">${v.art_name}</a></td>
				</tr>
			</table>
		</c:forEach>
	</c:if>
</body>
</html>