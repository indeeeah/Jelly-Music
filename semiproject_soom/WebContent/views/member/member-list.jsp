<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset='UTF-8'"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List View</title>
</head>
<body>
	<div>
		<table border="1">
			<tr>
				<td>번호</td>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td>나이</td>
				<td>성별</td>
				<td>이메일</td>
				<td>전화번호</td>
			</tr>
	<c:if test="${not empty memberVoList}">
	 	<c:forEach items="${ memberVoList }" var="mvo" varStatus="s">
			<tr>
				<td>${s.count}</td>
				<td>${mvo.id}</td>
				<td>${mvo.pwd}</td>
				<td>${mvo.name}</td>
				<td>${mvo.age}</td>
				<td>${mvo.sexual}</td>
				<td>${mvo.email}</td>
				<td>${mvo.phone}</td>
			</tr>
		</c:forEach>
	</c:if>
	<c:if test="${empty memberVoList }">
			<tr>
				<td colspan="8">가입된 회원이 없습니다.</td>
			</tr>
	</c:if>
		</table>
	</div>
</body>
</html>