<link href="${pageContext.request.contextPath}/css/reset.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/main_login.css"
	rel="stylesheet" type="text/css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title><c:forEach items="${info }" var="v">${v.al_name }의 검색결과</c:forEach></title>
<script src="http://code.jquery.com/jquery-3.4.0.js"></script> 
<script src="{% static 'network/functions.js' %}"></script>
<script src="https://kit.fontawesome.com/3929e16ef5.js"
	crossorigin="anonymous"></script>
<script src="{% static 'network/functions.js' %}"></script>
<script src="http://code.jquery.com/jquery-latest.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />
<style>
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
<!-- 초기화 -->
<style>
body {
	width: 100%;
	height: 100%;
	background-color: rgb(22, 25, 41);
	overflow: auto;
}

a {
	text-decoration: none;
	color: white;
}

* {
	color: rgb(244, 244, 244);
}
</style>
<style>
@import
	url('https://fonts.googleapis.com/css2?family=Raleway:wght@800&display=swap')
	;
</style>
<!-- nav -->
<style>
#side {
	width: 259px;
	height: 100%;
	background-color: rgb(20, 23, 38);
	display: block;
	position: fixed;
	z-index: 10;
}

#logo {
	width: 259px;
	height: 60px;
	top: 0px;
	margin-bottom: 30px;
}

#name {
	width: 259px;
	height: 60px;
	text-align: right;
}

#name>a {
	margin-right: 30px;
	line-height: 60px;
	left: 0px;
}

#sampleprof {
	width: 30px;
	height: 60px;
	float: left;
	margin-left: 30px;
}

#main_menu {
	overflow: hidden;
	margin-top: 11px;
	margin-left: 25px;
	width: 209px;
}

input[type="radio"] {
	display: none;
}

.each {
	box-sizing: border-box;
	border: 1px solid rgb(20, 23, 38);
	width: 209px;
	height: 35px;
	padding-left: 10px;
	margin-bottom: 10px;
}

.each:hover {
	box-sizing: border-box;
	border: 1px solid rgb(74, 254, 0);
	border-radius: 6px;
}

.m1 {
	width: 164px;
	color: rgb(244, 244, 244);
	float: right;
	line-height: 35px;
}

.m1:hover {
	color: rgb(168, 168, 169);
}

.each:hover>.m1 {
	width: 164px;
}

#main_menu>div>ul {
	display: none;
	width: 209px;
	margin-top: -10px;
	margin-bottom: 7px;
}

#main_menu>div>ul>li {
	height: 30px;
}

#main_menu>div>ul>li>a {
	line-height: 32px;
	margin-left: 45px;
	font-size: 15px;
}

#main_menu>div>ul>li>a:hover {
	color: rgb(168, 168, 169);
}

nav>#main_menu>div>input:nth-of-type(1):checked ~.each:nth-of-type(1) {
	box-sizing: border-box;
	border: 1px solid rgb(74, 254, 0);
	border-radius: 6px;
}

nav>#main_menu>div>input:nth-of-type(2):checked ~.each:nth-of-type(2) {
	box-sizing: border-box;
	border: 1px solid rgb(74, 254, 0);
	border-radius: 6px;
}

nav>#main_menu>div>input:nth-of-type(5):checked ~.each:nth-of-type(5) {
	box-sizing: border-box;
	border: 1px solid rgb(74, 254, 0);
	border-radius: 6px;
}

nav>#main_menu>div>input:nth-of-type(1):checked ~.each:nth-of-type(1)+ul
	{
	display: block;
}

nav>#main_menu>div>input:nth-of-type(2):checked ~.each:nth-of-type(2)+ul
	{
	display: block;
}

nav>#main_menu>div>input:nth-of-type(5):checked ~.each:nth-of-type(5)+ul
	{
	display: block;
}

.sampleimg {
	width: 20px;
	height: 35px;
}

.page {
	width: 209px;
	height: 40px;
	bottom: 40px;
}

.player-btn {
	width: 209px;
	height: 40px;
}
</style>

<!-- header -->
<style>
.main_header {
	height: 90px;
	width: calc(100% - 259px);
	box-shadow: 0px 8px 2px rgba(0, 0, 0, 0.2), 0 6px 20px
		rgba(0, 0, 0, 0.19);
	background-color: rgb(23, 26, 40);
	position: relative;
	float: right;
}

.search {
	position: absolute;
	top: 20px;
	right: 40px;
	width: 45px;
	height: 45px;
	border-radius: 50%;
	transition: all 1s;
	z-index: 4;
	box-shadow: 0 0 25px 0 rgba(0, 0, 0, 0.4);
}

.search:hover {
	cursor: pointer;
}

.search::before {
	content: "";
	position: absolute;
	margin: auto;
	top: 22px;
	right: 0;
	bottom: 0;
	left: 22px;
	width: 12px;
	height: 2px;
	background: white;
	transform: rotate(45deg);
	transition: all .5s;
}

.search::after {
	content: "";
	position: absolute;
	margin: auto;
	top: -5px;
	right: 0;
	bottom: 0;
	left: -5px;
	width: 25px;
	height: 25px;
	border-radius: 50%;
	border: 4px solid white;
	transition: all .5s;
}

.searchbx {
	position: absolute;
	top: 30px;
	right: 40px;
	width: 25px;
	height: 25px;
	outline: none;
	border: none;
	background: rgb(74, 254, 0);
	color: black;
	text-shadow: 0 0 10px rgb(74, 254, 0);
	padding: 0 80px 0 20px;
	border-radius: 30px;
	box-shadow: 0 0 25px 0 rgb(74, 254, 0), 0 20px 25px 0 rgba(0, 0, 0, 0.2);
	transition: all 1s;
	opacity: 0;
	z-index: 5;
	font-weight: bolder;
	letter-spacing: 0.1em;
}

.searchbx:hover {
	cursor: pointer;
}

.searchbx:focus {
	width: 300px;
	opacity: 1;
	cursor: text;
}

.searchbx:focus ~.search {
	background: #151515;
	z-index: 6;
}

.searchbx:focus ~.search::before {
	top: 0;
	left: 0;
	width: 25px;
}

.searchbx:focus ~.search::after {
	top: 0;
	left: 0;
	width: 25px;
	height: 2px;
	border: none;
	background: white;
	border-radius: 0%;
	transform: rotate(-45deg);
}

.searchbx:focus::placeholder {
	color: white;
	opacity: 0.5;
	font-weight: bolder;
}

.realtime {
	position: absolute;
	bottom: 40px;
	right: 100px;
	width: 100px;
	transition: all 1s;
}

.remenu {
	height: 90px;
	width: 100px;
	float: right;
	margin-right: 100px;
}

#rtdrop {
	position: absolute;
	right: 100px;
	width: 200px;
	color: white;
	box-sizing: border-box;
	border: 1px solid rgb(74, 254, 0);
	border-radius: 15px;
	background-color: rgb(23, 26, 40);
	top: 60px;
	font-size: 12px;
	display: none;
	overflow: hidden;
}

#rtdrop:hover {
	display: block;
}

#rtdrop>tbody {
	width: 200px;
}

#rtdrop>tbody>tr>td {
	padding: 10px;
}

#rtdrop>tr>td {
	border: 1px;
}

.remenu:hover ~#rtdrop {
	display: block;
}

.searchbx:focus ~#rtdrop {
	right: 460px;
}

#master-container-scroller {
	height: 15px;
	overflow: hidden;
	position: relative;
}

#master-container-scroller .master-container-scroller_item {
	display: block;
	animation: scroll 10s infinite;
}

.cta-link {
	font-size: 15px;
	background: transparent;
	text-decoration: none;
	color: white;
}

.cta-link:hover {
	animation-play-state: paused;
	text-decoration: underline;
}

.master-container-scroller_item:hover {
	animation-play-state: paused;
}

@
keyframes scroll { 0.0% {
	transform: translateY(0px)
}

10






%
{
transform






:






translateY




(






0px






)






}
20






%
{
transform






:






translateY




(






-16px






)






}
30






%
{
transform






:






translateY




(






-32px






)






}
40






%
{
transform






:






translateY




(






-48px






)






}
50






%
{
transform






:






translateY




(






-64px






)






}
60






%
{
transform






:






translateY




(






-80px






)






}
70






%
{
transform






:






translateY




(






-96px






)






}
80






%
{
transform






:






translateY




(






-112px






)






}
90






%
{
transform






:






translateY




(






-128px






)






}
100






%
{
transform






:






translateY




(






-144px






)






}
}
.searchbx:focus ~.remenu>.realtime {
	right: 460px;
}

.tri {
	width: 0px;
	height: 0px;
	margin-top: 5px;
	border-top: 5px solid none;
	border-bottom: 5px solid red;
	border-right: 5px solid transparent;
	border-left: 5px solid transparent;
	float: right;
}
</style>
<!-- main -->
<style>
.content {
	min-height: 600px;
	padding-left: 259px;
	padding-top: 90px;
}

a {
	cursor: pointer;
}

.container {
	position: relative;
	width: 1200px;
	margin: 0 auto;
}

hr {
	clear: both;
}
</style>

<!-- 가수 정보 -->
<style>
	.al_more_info {
		padding: 60px 0 50px 0;
		word-break: break-all;
		line-height: 20px;
	}
	
	.al_more_info_img {
		float: left;
		overflow: hidden;
		width: 195px;
		height: 195px;
		margin-right: 20px;
	}
	
	.al_more_info_img img {
		width: 100%;
		height: 100%;
	}
	
	.al_title {
		font-size: 2.0em;
		height: 40px;
		font-weight: bold;
	}
	
	.al_name {
		font-size: 1.4em;
		height: 35px;
	}
	
	.al_info .items {
		font-size: 15px;
		color: rgb(168, 168, 169);
	}
	
	.al_summary {
		font-size: 1em;
		padding-top: 10px;
		overflow: hidden;
		height: 40px;
		line-height:20px;
		-webkit-line-clamp: 2;
		-webkit-box-orient: vertical;
		display: -webkit-box;
	}
	
	.summary_more {
		visibility: visible;
		font-size: 13px;
		line-height: 17px
	}
	/* 소개 옵션 */
	.al_more_info_intro, .option_area {
		min-height: 100px;
		margin-left: 225px;
	}
	/* The Modal (background) */
	.modal {
	  display:none;
	  position: fixed; /* Stay in place */
	  z-index: 100; /* Sit on top */
	  padding-top: 100px; /* Location of the box */
	  left: 0;
	  top: 0;
	  width: 700px; /* Full width */
	  height: 700px; /* Full height */
	  overflow-y: hidden; /* Enable scroll if needed */
	  background-color: rgb(0,0,0); /* Fallback color */
	  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
	}
	
	/* Modal Content */
	.modal-content {
	  overflow:hidden;
	  overflow-y:auto;
	  background-color: white;
	  margin: auto;
	  padding: 20px;
	  border: 1px solid #888;
	  width: 668px;
	  height: 549px;
	  line-height:20px;
	  border-radius:4px;
	  margin-top:25px;
	  padding:50px 35px;
	}
	.introClose span{
		color:grey;
	}
	.modal-content pre {
		color: #000;
	}
	/* The Close Button */
	.introClose {
	  color: #aaaaaa;
	  float: right;
	  font-size: 28px;
	  font-weight: bold;
	}
	.introClose:hover span, .introClose:focus span{
	  color: #000;
	  text-decoration: none;
	  cursor: pointer;
	}
	
	.option_area {
		width: 739px;
		height: 42px;
		padding-top: 15px;
	}
	
	.option_area .option_play {
		display: inline-block;
		border-radius: 10px;
		vertical-align: top;
		background: #ff1150;
		width: 120px;
		height: 32px;
		line-height: 32px;
		text-align: center;
	}
	
	.play_btn {
		width: 5px;
		height: 5px;
		border-color: transparent transparent transparent rgb(244, 244, 244);
		border-style: solid solid solid solid;
		border-width: 8px 0 8px 16px;
		background: #ff1150;
	}
	
	.option_area .play_btn {
		display: inline-block;
		border-radius: 4px;
		vertical-align: text-bottom;
		text-align: center;
		box-sizing: border-box;
	}
	
	.option_area .option_buy {
		display: inline-block;
		border-radius: 10px;
		vertical-align: top;
		background: white;
		width: 102px;
		height: 32px;
		line-height: 32px;
		text-align: center;
		border: 1px solid black;
		box-sizing: border-box;
	}
	
	.option_area .buy_btn {
		color: black;
		width: 100px;
	}
	
	.option_area .option_more {
		display: inline-block;
		vertical-align: top;
		text-align: center;
	}
	
	.option_like {
		border-radius: 20px;
		box-shadow: 0 2px 8px rgba(0, 0, 0, .1);
		display: inline-block;
		margin-left: 10px;
		width: 42px;
		height: 42px;
	}
	
	#heal {
		font-size: 30px;
	}
	
	#heal:hover {
		color: red;
	}
	
	.option_drop {
		display: inline-block;
		width: 42px;
		height: 42px;
		vertical-align: top;
		text-align: center;
		font-size: 20px;
		font-weight: bold;
		position: relative;
	}
	
	.option_drop_menu ul {
		top: 0;
		left: 44px;
	}
	
	.option_drop_menu {
		display: none;
		position: absolute;
		border-radius: 4px;
		background-color: white;
	}
	
	.option_drop:hover .option_drop_menu {
		display: block;
		border-radius: 4px;
		margin-left: 5px;
	}
	
	.option_drop_menu li a {
		display: block;
		padding: 6px 20px 7px;
		font-size: 14px;
		text-align: left;
		color: black;
		white-space: nowrap;
	}
</style>

<!-- top tracks -->
<style>
	.al_more_tracks {
		width: 100%;
		padding: 20px 0;
		display: block;
	}
	
	.al_more_tracks_section, .al_more_singles_title, .al_more_alike_title,
		.al_more_video_title {
		font-size: 1.5em;
		padding-bottom: 15px;
	}
	.al_more_tracks_title{
		padding-bottom:10px;
		display: flex;
	}
	.al_more_tracks_title div {
		text-align: center;
	}
	
	.al_more_tracks_line div {
		display: inline;
		height: 40px;
		line-height: 40px;
		text-align: center;
	}
	.al_more_tracks_title1{
		width:18%;
	}
	.al_more_tracks_title2{
		width:30%;
	}
	.al_more_tracks_title3{
		width:25%;
	}
	.al_more_tracks_title4{
		width:30%;
	}
	.al_more_tracks_line img {
		width: 40px;
		height: 40px;
	}
	
	.al_more_tracks_line {
		border-top: 1px solid white;
		display: flex;
	}
	.al_more_tracks_line1{
		width:7%;
	}
	.al_more_tracks_line2{
		width:4%;
	}
	.al_more_tracks_line3{
		width:7%;
	}
	.al_more_tracks_line4{
		width:30%;
	}
	.al_more_tracks_line5{
		width:25%;
	}
	.al_more_tracks_line6{
		width:12%;
	}
	.al_more_tracks_line7{
		width:7%;
	}
	.al_more_tracks_line8{
		width:12%;
	}

	.al_more_tracks_plus {
		text-align: center;
		right: 0px;
	}
	.myBtn{
	    width: 60px;
	    height: 25px;
	    color: rgb(20, 23, 38);
	    background-color: rgb(244, 244, 244);
	    outline: none;
	    border: none;
	    border-radius: 10px;
	    margin-top: 8px;
	}
	/* The Modal (background) */
	.modal {
	  display:none;
	  position: fixed; /* Stay in place */
	  z-index: 10; /* Sit on top */
	  padding-top: 100px; /* Location of the box */
	  left: 0;
	  top: 0;
	  width: 100%; /* Full width */
	  height: 100%; /* Full height */
	  overflow: auto; /* Enable scroll if needed */
	  background-color: rgb(0,0,0); /* Fallback color */
	  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
	}
	
	/* Modal Content */
	.modal-content {
	  background-color: white;
	  margin: auto;
	  padding: 20px;
	  border: 1px solid #888;
	  width: 80%;
	  overflow: scroll;
	  line-height:20px;
	}
	
	/* The Close Button */
	.close {
	  color: #aaaaaa;
	  float: right;
	  font-size: 28px;
	  font-weight: bold;
	}
	
	.close:hover, .close:focus {
	  color: #000;
	  text-decoration: none;
	  cursor: pointer;
	}
/* hr{
			border:1px solid black;
		} */
</style>

<!-- 가수 다른 앨범 -->
	<style>
	.al_more_singles_title {
		float: left;
	}
	
	.al_more_singles_title {
		right: 0px;
	}
	
	.al_more_singles_plus div {
		display: inline-block;
	}
	
	/* 	.al_more_singles_src_img{
			width:150px;
			height:150px;
		} */
	.al_more_singles_sereise {
		display: felx;
	}
	
	.al_more_singles_seriese0 {
		float:left;
	}
	
	.al_more_singles_seriese td {
		text-align: center;
	}
	
	.al_more_singles_seriese a {
		padding-right: 19px;
	}
	
	.al_more_singles_seriese td {
		padding-bottom: 10px;
	}
	
	.al_more_singles_plus {
		position: absolute;
		right: 0px;
	}
	
	table tr {
		background: grey;
	}
	
	.al_more_singles_section {
		display: flex;
	}
	
	.al_more_singles_plus div select {
		color: black;
	}
	
	.al_more_singles_plus div select option {
		color: black;
	}
</style>

<!-- 유사한 아티스트 -->
<style>
	.al_more_alike_section {
		padding-bottom: 10px;
	}
	
	.al_more_alike_section div {
		display: inline;
		right: 0px;
	}
	
	.al_more_alike_plus {
		right: 0px;
		position: absolute;
	}
	
	.al_more_alike_another div {
		padding-top: 10px;
		text-align: center;
	}
	
	.al_more_alike_another {
		display: inline-block;
	}
	
	.al_more_alike_another img {
		float: left;
		overflow: hidden;
		width: 150px;
		height: 150px;
		border: 1px solid white;
		margin-bottom: 10px;
	}
	
	.al_more_alike_another {
		padding-right: 19px;
	}
</style>

<!-- 댓글 -->
<style>
	/* .music_more_comments{
				display:block;
			} */
	#al_cont {
		width: 900px;
		height: 50px;
		background: white;
	}
	
	table input {
		color: black;
	}
	
	.album_comments_author, .album_comments_base {
		display: flex;
	}
	
	.album_comments_author {
		margin-bottom: 10px;
	}
	
	.album_comments_nick {
		margin-left: 10px;
	}
	
	.album_comments_report {
		margin-left: 20px;
	}
	
	.album_comments_cont {
		margin-top: 15px;
		margin-bottom: 15px;
	}
	
	.album_comments_recomm_area {
		display: flex;
		right: 0px;
	}
	
	.album_comments_likes {
		margin-right: 10px;
	}
	/* .div{
				display:block;
			} */
	.album_comments_box {
		margin-bottom: 10px;
		border-top: 0.5px solid white;
	}
	
	.album_comments_recomm_area {
		margin-bottom: 10px;
	}
	
	td, tr {
		background: rgb(20, 23, 38);
	}
	
	.album_comments_write .commenthidden {
		display: hidden;
	}
</style>

<!-- footer -->
<style>
	footer {
		height: 100px;
		width: calc(100% - 259px);
		right: 0px;
		bottom: 0px;
		font-size: 11px;
		color: rgb(244, 244, 244);
		display: block;
		padding-left: 259px;
	}
	
	#link>a {
		color: rgb(244, 244, 244);
	}
	
	#ft {
		margin-top: 21px;
	}
	
	.fc {
		margin-left: 40px;
		margin-top: 5px;
	}
	
	#copy {
		float: left;
	}
	
	#national {
		float: right;
		margin-right: 40px;
	}
	
	#link {
		width: 90%;
		float: left;
	}
	
	#info {
		float: left;
	}
	
	#fline {
		border: 0;
		height: 1px;
		background-color: rgb(168, 168, 169);
	}
</style>
</head>

<body>
<input type="hidden" id="mem_id" value=${ssLogInfo.mem_id } name="mem_id">
	<nav id="fix_side">
		<div id="fix_logo">
			<div id="fix_logo_img"></div>
			<a href="mainServlet" id="fix_logo_title">Jelly Music</a>
		</div>
		<div id="fix_user">
			<img src="${pageContext.request.contextPath}/image/005-user.svg"
				id="fix_prof">
					<a href="#">Hello, ${ssLogInfo.mem_id }</a>
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
					<li><a href="${pageContext.request.contextPath}/memberLogoutServlet">로그아웃</a></li>
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
					<li><a href="#">공지사항</a></li>
					<li><a href="#">Q&A</a></li>
					<li><a href="#">자주하는 질문</a></li>
					<li><a href="${pageContext.request.contextPath}/memberLogoutServlet">로그아웃</a></li>
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
		<div class="modal" tabindex="-1" role="dialog" id="sendReport">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title">신고 작성</h5>

					</div>
					<div class="modal-body">
						<p>신고사유 선택</p>
						<form id="reportform" class="sendReport">
							<div class="custom-control custom-radio">
								<input type="radio" id="customRadio1" name="reportReason"
									class="custom-control-input" value="F"> <label
									class="custom-control-label" for="customRadio1"
									style="font-size: 13px; padding-bottom: 6px;">욕설</label>
							</div>
							<div class="custom-control custom-radio">
								<input type="radio" id="customRadio2" name="reportReason"
									class="custom-control-input" value="A"> <label
									class="custom-control-label" for="customRadio2"
									style="font-size: 13px; padding-bottom: 6px;">음란물</label>
							</div>
							<div class="custom-control custom-radio">
								<input type="radio" id="customRadio3" name="reportReason"
									class="custom-control-input" value="R"> <label
									class="custom-control-label" for="customRadio3"
									style="font-size: 13px; padding-bottom: 6px;">허위사실</label>
							</div>
							<div class="custom-control custom-radio">
								<input type="radio" id="customRadio4" name="reportReason"
									class="custom-control-input" value="E"> <label
									class="custom-control-label" for="customRadio4"
									style="font-size: 13px;">기타</label> <input type="text"
									class="form-control" id="reportContent" name="reportContent"
									placeholder="기타 내용을 입력하세요." style="font-size: 13px;" />
							</div>
							<input type="hidden" id="mem_id_forre" name="mem_id" value="">
							<input type="hidden" id="mu_co_no" name="mu_co_no" value="">
						</form>
					</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal" onclick="closeModal('sendReport');"
							id="endReport">Close</button>
						<button type="button" class="btn btn-primary" id="addReport">send
							report</button>
					</div>
				</div>
			</div>
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
	<div class="content">
		<div class="container">
			<div class="al_more_info">
				<div class="al_more_info_img">
					<img src="${pageContext.request.contextPath}/allfile/${v.f_name }">
				</div>
				<div class="al_more_info_intro">
					<c:if test="${not empty info }">
						<c:forEach items="${info }" var="v" varStatus="s">
							<div class="al_title">
								<span class="items">${v.al_name}</span></a><br> <br>
							</div>
							<div class="al_name">
								<a href="<%=request.getContextPath() %>/artistMoreServlet?art_no=${v.art_no }"><span class="items">${v.art_name }</span></a><br> <br>
							</div>
							<div class="al_info">
								<span class="items">${v.al_release }</span>
							</div>
							<div class="al_summary">
								<span class="items">${v.al_intro }</span>
							</div>
							<div style="cursor:pointer" class="introBtn">더보기</div>
							<div id="introModal" class="modal">
								<div class="modal-content ">
									<a class="introClose"><span>&times;</span></a>
									<pre>${v.al_intro }</pre>
								</div>
							</div>
						</c:forEach>
					</c:if>
				</div>
				<div class="option_area">
					<div class="option_inner">
						<a href="<%=request.getContextPath()%>/playerCtrl.do?mu_no=${v.mu_no}" onclick="window.open(this.href,'','width=1200,height=720,scrollbars=no'); return false;" class="all_play option_play">
                                        <button type="button" class="play_btn" name="mu_no" value=${v.mu_no}></button>전체재생</a>
						<!-- <a href="#" class="option_play">
							<button class="play_btn"></button>랜덤재생
						</a> -->
						<a href="<%=request.getContextPath()%>/playerCtrl.do?mu_no=${v.mu_no}" onclick="window.open(this.href,'','width=1200,height=720,scrollbars=no'); return false;" class="random_play option_play">
                                        <button type="button" class="play_btn" name="mu_no" value=${v.mu_no}></button>랜덤재생</a>
						<div class="option_buy">
							<a href="<%=request.getContextPath() %>/MembershipServlet" class="buy_btn">이용권구매</a>
						</div>
						<div class="option_more">
							<div class="option_like">
								<a id="heal" class="far fa-heal"></a>
							</div>
							<!-- <div class="option_drop">
								<a class="drop_more">...</a>
								<div class="option_drop_menu">
									<ul>
										<li><a>내 플레이리스트 추가</a></li>
										<li><a>좋아요</a></li>
										<li><a>보관함에 넣기</a></li>
									</ul>
								</div>
							</div> -->
						</div>
					</div>
				</div>
			</div>

			<hr>

			<div class="al_more_tracks">
				<div class="al_more_tracks_section">Tracks</div>
				<div class="al_more_tracks_inner">
					<div class="al_more_tracks_list">
						<div class="al_more_tracks_title">
							<div class="al_more_tracks_title1">#</div>
							<div class="al_more_tracks_title2">SONG</div>
							<div class="al_more_tracks_title3">ALBUM</div>
							<div class="al_more_tracks_title4">OPTION</div>
							<div></div>
						</div>
						<div>
						<c:if test="${not empty minclude }">
							<c:forEach items="${minclude }" var="v" varStatus="s">
								<div class="al_more_tracks_line">
									<div class="al_more_tracks_line1">
										<input type="checkbox" id="" class="tracks_check">
									</div>
									<div class="al_more_tracks_line2">${s.count }</div>
									<div class="al_more_tracks_line3">
										<%-- <a href="#" class="tracks_play">
											<button class="playBtn" value="${v.mu_name }" onclick="openWin()" type="button" >재생</button>
										</a> --%>
										<a href="<%=request.getContextPath()%>/playerCtrl.do?mu_no=${v.mu_no}" onclick="window.open(this.href,'','width=1200,height=720,scrollbars=no'); return false;" class="tracks_play"> 재생
                                        </a><input type="hidden" class="nrgo" name="mu_no" value=${v.mu_no}>
									</div>
									<div class="al_more_tracks_line4"><a href="<%=request.getContextPath() %>/musicMoreServlet?mu_no=${v.mu_no }" class="tracks_music">${v.mu_name}</a></div>
									<div class="al_more_tracks_line5"><a href="<%=request.getContextPath() %>/artistMoreServlet?art_no=${v.art_no }" class="tracks_name">${v.art_name }</a></div>
									<div class="al_more_tracks_line6"><button type="button" class="tracks_lyrics myBtn" value="${v.mu_name }">가사</button></div>
									<div class="al_more_tracks_line7"><a href="<%=request.getContextPath() %>/MembershipServlet" class="tracks_buy">이용권구매</a></div>
								</div>
								<div id="${v.mu_name }" class="modal">
									<div class="modal-content ">
										<button type="button" class="close" value="${v.mu_name }">&times;</button>
										<pre>${v.mu_ly }</pre>
									</div>
								</div>
							</c:forEach>
						</c:if>
						</div>
					</div>
				</div>
			</div>
			
			<hr>

			<div class="al_more_singles">
				<div class="al_more_singles_inner">
					<div class="al_more_singles_section">
						<div class="al_more_singles_title">Singles</div>
						<div class="al_more_singles_plus">
							<div>
								<select name="sor" id="sort">
									<option value="1">인기순</option>
									<option value="2">최신곡</option>
									<option value="3">이름순</option>
								</select>
							</div>
							<a href=""><div>모아보기</div></a> <a href=""><div>리스트로보기</div></a>
						</div>
					</div>
					<div class="al_more_singles_seriese">
						<c:if test="${not empty sList }">
							<c:forEach items="${sList }" var="v" varStatus="s">
								<div class="al_more_singles_seriese0">
									<table>
										<tr>
											<td><a href="#"><img src="image/bts-img.png" width="150px"
												height="150px"></a></td>
										</tr>
										<tr>
											<td><a href="<%=request.getContextPath() %>/albumMoreServlet?al_no=${v.al_no }">${v.al_name}</a></td>
										</tr>
										<tr>
											<td><a href="<%=request.getContextPath() %>/artistMoreServlet?art_no=${v.art_no }">${v.art_name }</a></td>
										</tr>
									</table>
	
								</div>
							</c:forEach>
						</c:if>
					</div>
				</div>
			</div>

			<hr>

			<div class="al_more_alike">
				<div class="al_more_alike_section">
					<div class="al_more_alike_title">Alike Album</div>
					<div class="al_more_alike_plus">더보기</div>
				</div>
				<div class="al_more_alike_inner">
				<c:if test="${not empty alist }">
					<c:forEach items="${alist }" var="v">
						<a href="#">
							<div class="al_more_alike_another">
								<img src="image/bts-img.png">
								<div><a href="<%=request.getContextPath() %>/albumMoreServlet?al_no=${v.al_no }">${v.al_name }</a></div>
								<div><a href="<%=request.getContextPath() %>/artistMoreServlet?art_no=${v.art_no }">${v.art_name }</a></div>
							</div>
						</a> 
					</c:forEach>
				</c:if>
				</div>
			</div>

			<hr>

			<div class="al_more_comments">
					<div class="al_comments_write">
						<form method="post" action="<%=request.getContextPath()%>/albumCommentWriteCtrl" >
						<%
							String al_co_no = (request.getParameter("al_co_no") != null) ? request.getParameter("al_co_no") : "0";
							String al_ref = (request.getParameter("al_ref") != null) ? request.getParameter("al_ref") : "0";
							String al_step = (request.getParameter("al_step") != null) ? request.getParameter("al_step") : "0";
							String al_level = (request.getParameter("al_level") != null) ? request.getParameter("al_level") : "0";
							String al_no = request.getParameter("al_no");
						%>
							<input type="hidden" name="al_co_no" value="<%=al_co_no%>" class="commenthidden"> 
							<input type="hidden" name="al_ref" value="<%=al_ref%>" class="commenthidden"> 
							<input type="hidden" name="al_step" value="<%=al_step%>" class="commenthidden"> 
							<input type="hidden" name="al_level" value="<%=al_level%>" class="commenthidden">
							<input type="hidden" name="al_no" value="<%=al_no%>" class="commenthidden">
							<input type="hidden" name="mem_id" value="${ssLogInfo.mem_id}" class="commenthidden">
							<table border="1">
								<tr>
									<td>글쓰기</td>
								</tr>
								<tr>
									<td><input type="text" name="al_cont" id="al_cont"></td>
								<tr>
									<td colspan="2">
										<input type="submit" value="글등록">
										<input type="reset" value="취소"> 
									</td>
								</tr>
							</table>
						</form>
					</div>
					<c:if test="${not empty clist }">
						<c:forEach items="${clist }" var="v" varStatus="s">
							<div class="album_comments_box">
								<div class="album_comments_author">
									<div class="album_comments_id">
										<a>${v.mem_name }</a>&nbsp;님&nbsp;<span class="mem_id">(${v.mem_id })</span>
									</div>
								</div>
								<div class="album_comments_base">
									<div class="album_comments_date">
										${v.al_date}
									</div>
									<div class="album_comments_report">
										<a>신고</a>
									</div>
								</div>
								<div class="album_comments_cont">
									${v.al_cont }
								</div>
								<div class="album_comments_recomm">
									<div class="album_comments_recomm_area">
										<div class="album_comments_likes">
											<a class="likes" onclick="return confirm('추천하시겠습니까?')" href="./albumCommentLikePro.jsp?mem_id=${v.mem_id }">likes </a> ${v.al_likes}
										</div>
										<div class="album_comments_hates">
											<a>hates </a> ${v.al_hates}
										</div>
										<c:if test ="${ssLogInfo.mem_id eq v.mem_id }">
										<div class="album_comments_delete">
											<input type="button" onclick="window.location='albumCommentDeleteCtrl?al_co_no=${v.al_co_no}&al_no=${v.al_no }'" value="삭제">
										</div>
										</c:if>
									</div>
								</div>
							</div>
						</c:forEach>
					</c:if>
				</div>
			</div>
		</div>

		<footer>
			<hr id="fline">
			<div id="ft">
				<div id="copy" class="fc">Copyright ⓒ 2020 Jelly. All rights
					reserved.</div>
				<div id="national" class="fc">Republic of Korea</div>
				<div id="link" class="fc">
					<a href="#">이용약관</a> | <a href="#">개인정보처리방침</a> | <a href="#">고객센터</a>
					| <a href="#">이메일주소무단수집거부</a>
				</div>
				<div id="info" class="fc">제작자 : 김경태 김수민 곽은지 김세진 김지용 장재혁</div>
			</div>
		</footer>
<c:if test="${not empty minclude }">
<c:forEach items="${minclude }" var="v" varStatus="s">
<audio id="${v.mu_name }">
  <source src="horse.ogg" type="audio/ogg">
  <source src="./mp3/K.Will - 그립고 그립고 그립다.mp3" type="audio/mpeg">
</audio>
</c:forEach>
</c:if>
<script type="text/javascript">
$(".tri_con").click(function() {
    var showTvalue = $(this).next().val();
    var showmemId = $("#mem_id").val();
    console.log(showTvalue);
    console.log(showmemId);

    $.ajax({
        type: "POST",
        url: "mainToPlayListSrv",
        data: {
            mem_id: showmemId,
            mu_no: showTvalue
        },
        success: function(resulttr) {

        }
    });
});

$(".tri_con").click(function() {
    var showTvalue = $(this).next().val();
    var showmemId = $("#mem_id").val();
    console.log(showTvalue);
    console.log(showmemId);

    $.ajax({
        type: "POST",
        url: "updateCurrmusicServlet",
        data: {
            mem_id: showmemId,
            mu_no: showTvalue
        },
        success: function(resultcm) {

        }
    });
});
$('.myBtn').on('click', function() {
	var a = $(this).val();
	console.log(a);
	var x = document.getElementById(a);
	console.log(x);
    x.style.display="block";
});
$('.close').on('click', function() {
	/* $('#modal').hide(); */
	var a = $(this).val();
	console.log(a);
	var x = document.getElementById(a);
	console.log(x);
    x.style.display="none";
});
function openWin(){  
    window.open('<%=request.getContextPath() %>/playerCtrl.do', "네이버새창", "width=800, height=700, toolbar=no, menubar=no, scrollbars=no, resizable=yes" );  
}  
$('.introBtn').on('click', function() {
	$('#introModal').show();
});
$('.introClose').on('click', function() {
	$('#introModal').hide();
});

$(".tracks_play").click(function() {
    var showNvalue = $(this).next().val();
    var showmemId = $("#mem_id").val();
    console.log(showNvalue);
    console.log(showmemId);

    $.ajax({
        type: "POST",
        url: "mainToPlayListSrv",
        data: {
            mem_id: showmemId,
            mu_no: showNvalue
        },
        success: function(resultnl) {

        }
    });
});

$(".tracks_play").click(function() {
   var showNvalue = $(this).next().val();
   var showmemId = $("#mem_id").val();
   console.log(showNvalue);
   console.log(showmemId);

   $.ajax({
       type: "POST",
       url: "updateCurrmusicServlet",
       data: {
           mem_id: showmemId,
           mu_no: showNvalue
       },
       success: function(resultcm) {

       }
   });
});
$(".all_play").click(function() {
    var showNvalue = $(this).next().val();
    var showmemId = $("#mem_id").val();
    console.log(showNvalue);
    console.log(showmemId);

    $.ajax({
        type: "POST",
        url: "mainToPlayListSrv",
        data: {
            mem_id: showmemId,
            mu_no: showNvalue
        },
        success: function(resultnl) {

        }
    });
});

$(".all_play").click(function() {
   var showNvalue = $(this).next().val();
   var showmemId = $("#mem_id").val();
   console.log(showNvalue);
   console.log(showmemId);

   $.ajax({
       type: "POST",
       url: "updateCurrmusicServlet",
       data: {
           mem_id: showmemId,
           mu_no: showNvalue
       },
       success: function(resultcm) {

       }
   });
});
$(".random_play").click(function() {
    var showNvalue = $(this).next().val();
    var showmemId = $("#mem_id").val();
    console.log(showNvalue);
    console.log(showmemId);

    $.ajax({
        type: "POST",
        url: "mainToPlayListSrv",
        data: {
            mem_id: showmemId,
            mu_no: showNvalue
        },
        success: function(resultnl) {

        }
    });
});

$(".random_play").click(function() {
   var showNvalue = $(this).next().val();
   var showmemId = $("#mem_id").val();
   console.log(showNvalue);
   console.log(showmemId);

   $.ajax({
       type: "POST",
       url: "updateCurrmusicServlet",
       data: {
           mem_id: showmemId,
           mu_no: showNvalue
       },
       success: function(resultcm) {

       }
   });
});
</script>


</body>
</html>