<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function doSearch() {
		var form = document.search;
		form.action = "SearchMgMemberSearchCtrl";
		form.method = "post";
		form.submit();
	}
</script>
</head>
<body>
<div>
	<button type="button" id="btn" onclick="location.href='managerMain.jsp';">메인으로 가기</button>
</div><br>
	<form name="search">
		<input type="text" name="searchWord" id="searchWord" placeholder="아이디"> 
		<input type="submit" id="submit" value="검색" onclick="doSearch()">
	</form><br>
	<div>
		<table border="1">
			<tr>
				<td>번호</td>
				<td>아이디</td>
				<td>비밀번호</td>
				<td>이름</td>
				<td>이메일</td>
				<td>전화번호</td>
				<td>성별</td>
				<td>가입일</td>	
			</tr>
		<c:if test="${not empty memList}">
			<c:forEach items="${memList}" var="mvo" varStatus="s">
			
			<tr>
				<td>${s.count}</td>
				<td>${mvo.mem_id}</td>  
				<td>${mvo.mem_pwd}</td>  
				<td>${mvo.mem_name}</td>  
				<td>${mvo.mem_email}</td>  
				<td>${mvo.mem_phone}</td>  
				<td>${mvo.mem_sexual}</td>
				<td>${mvo.mem_reg_date}</td>
			</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty memList}">
			<tr>
				<td colspan="5">가입된 회원이 없습니다.</td>
			</tr>
		</c:if>
		</table>
		<div class="pagediv">
		<c:if test="${startPage != endPage}">
			<c:forEach varStatus="s" begin="${startPage}" end="${endPage}"
				step="1">
				<a href="SearchMgMemberCtrl.do?pageNum=${s.count}">${s.count}</a>
				<!--변경 : href 경로 -->
			</c:forEach>
		</c:if>
	</div>
	</div>
</body>
</html>