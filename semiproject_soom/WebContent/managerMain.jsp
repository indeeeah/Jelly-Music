<%@page import="manager.login.vo.ManagerLoginVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core"%>
<% request.setCharacterEncoding("utf-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 메인 페이지</title>
<link href="./css/managerMain.css" rel="stylesheet" type="text/css">
</head>
<body>
<body>
<%
	String mng_id = (String)session.getAttribute("mng_id");
	ManagerLoginVo loginMng = (ManagerLoginVo)request.getAttribute("vo");
	
	if (mng_id.equals("admin")) {
%>
	<p>관리자님, 어서오세요.</p>
    <nav id="side">
        <div id="name">
            <a href="managerLogin.jsp">로그아웃</a>
        </div>
        <div id="main_menu">
            <div>
                <input type="radio" name="tab" id="mem" class="m1_01">
                <input type="radio" name="tab" id="song" class="m1_01">
                <input type="radio" name="tab" id="post" class="m1_01">
                <input type="radio" name="tab" id="stat" class="m1_01">
                <div class="each">
                    <label for="mem" class="m1">회원관리</label>
                </div>
                <ul>
                    <li><a href="SearchMgMemberCtrl.do">전체회원조회</a></li>
                </ul>
                <div class="each">
                    <label for="song" class="m1">파일관리</label>
                </div>
                <ul>
                    <li><a href="allfile/allfileUpload.html">파일등록</a></li>
                    <li><a href="selectService">파일목록</a></li>
                </ul>
               <div class="each">
                    <label for="post" class="m1">게시판 관리</label>
                </div>
                <ul>
                    <li><a href="ManagerPostListCtrl">공지사항 관리</a></li>
                    <li><a href="freqQues/freqQues.jsp">자주하는 질문 관리</a></li>
                    <li><a href="#">Q&A관리</a></li>
                </ul>
                <div class="each">
                    <label for="stat" class="m1">통계(구현 마지막에)</label>
                </div>
                <ul>
                    <li><a href="#">누적 방문자 수</a></li>
                    <li><a href="#">누적 회원가입자 수</a></li>
                </ul>
            </div>
        </div>
    </nav>
<%
	}
%>
    <header class="main_header">
        <h1>Manager Page</h1>
      	
    </header>
    <div id="content"></div>
    <footer>
      
    </footer>
</body>
</html>