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
<title><c:forEach items="${info }" var="v">${v.art_name }의 검색결과</c:forEach></title>
<script src="http://code.jquery.com/jquery-3.4.0.js"></script> 
<script src="https://kit.fontawesome.com/3929e16ef5.js"
	crossorigin="anonymous"></script>
<script src="{% static 'network/functions.js' %}"></script>
<link href="./reset.css" rel="stylesheet" type="text/css">
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
ul{
   list-style:none;
   }
</style>

<!-- 가수 정보 -->
<style>
.art_more_info {
	padding: 60px 0 50px;
}

.art_more_info_img {
	float: left;
	overflow: hidden;
	width: 195px;
	height: 195px;
	margin-right: 20px;
	border-radius: 50%;
}

.art_more_info_img img {
	width: 100%;
	height: 100%;
}

.art_more_info_intro, .option_area {
	padding-top: 15px;
	min-height: 100px;
	margin-left: 225px;
}

.art_name {
	font-size: 2.0em;
	height: 40px;
	font-weight: bold;
}

.art_info .items {
	font-size: 15px;
	color: rgb(168, 168, 169);
}

.art_summary {
	font-size: 1em;
	padding-top: 20px;
}
.art_summary span{
	line-height:20px;
}
.introBtn{
	display:block;
}
/* 소개 옵션 */
.option_area {
	width: 739px;
	height: 42px;
}

.option_area .option_play {
	display: inline-block;
	border-radius: 10px;
	vertical-align: top;
	background: #ff1150;
	width: 102px;
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
	background: #ff1150;
	width: 102px;
	height: 32px;
	line-height: 32px;
	text-align: center;
}

.option_area .buy_btn {
	width: 100px;
	margin: 10px;
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
}

#heart {
	font-size: 30px;
}

#heart:hover {
	color: red;
}


.option_drop {
	display: inline-block;
	width: 30px;
	height: 30px;
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

.introClose {
  color: #aaaaaa;
  float: right;
  font-size: 28px;
  font-weight: bold;
}

.introClose:hover, .introClose:focus {
  color: #000;
  text-decoration: none;
  cursor: pointer;
}
</style>

<!-- top tracks -->
<style>
.art_more_tracks {
	width: 100%;
	padding: 20px 0;
	display: block;
}

.art_more_tracks_text, .art_more_singles_title, .art_more_similar_title,
	.art_more_video_title {
	font-size: 1.5em;
	padding-bottom: 15px;
}

.art_more_tracks_title {
	padding-bottom: 10px;
	display: flex;
}
.art_more_tracks_title div {
	text-align:center;
}
.art_more_tracks_title1{
	width:18%;
}
.art_more_tracks_title2{
	width:30%;
}
.art_more_tracks_title3{
	width:25%;
}
.art_more_tracks_title4{
	width:30%;
}

.art_more_tracks_line img {
	vertical-align: text-top;
}

.art_more_tracks_line div {
	display:inline;
	height: 40px;
	line-height: 40px;
	text-align: center;
}

.art_more_tracks_line img {
	width: 40px;
	height: 40px;
}

.art_more_tracks_line {
	border-top: 1px solid white;
	display: flex;
}
.art_more_tracks_line1{
	width:7%;
}
.art_more_tracks_line2{
	width:4%;
}
.art_more_tracks_line3{
	width:7%;
}
.art_more_tracks_line4{
	width:30%;
}
.art_more_tracks_line5{
	width:25%;
}
.art_more_tracks_line6{
	width:30%;
}

.art_more_tracks_plus {
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
  z-index: 100; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow-y: hidden; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}

/* Modal Content */
.modal-content {
  overflow-x:hidden;
  overflow-y:auto;
  background-color: white;
  margin: auto;
  padding: 20px;
  border: 1px solid #888;
  width: 668px;
  height: 549px;
  border-radius:4px;
  margin-top:25px;
  padding:50px 35px;
}
.modal-content pre {
	color: #000;
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
.art_summary {
	font-size: 1em;
	padding-top: 10px;
	overflow: hidden;
	height: 40px;
	-webkit-line-clamp: 2;
	-webkit-box-orient: vertical;
	display: -webkit-box;
}

/* hr{
			border:1px solid black;
		} */
</style>

<!-- 가수 다른 앨범 -->
<style>
.art_more_singles_title {
	float: left;
}

.art_more_singles_title {
	right: 0px;
}

.art_more_singles_plus div {
	display: inline-block;
}

/* 	.art_more_singles_src_img{
		width:150px;
		height:150px;
	} */
.art_more_singles_seriese div {
	display: inline;
}

.art_more_singles_seriese table {
	display: inline;
}

.art_more_singles_seriese0 td {
	text-align: center;
}

.art_more_singles_seriese a {
	padding-right: 19px;
}

.art_more_singles_seriese td {
	padding-bottom: 10px;
}

.art_more_singles_plus {
	position: absolute;
	right: 0px;
}

table tr {
	background: grey;
}

.art_more_singles_text {
	display: flex;
}

.art_more_singles_plus div select {
	color: black;
}

.art_more_singles_plus div select option {
	color: black;
}
</style>

<!-- 유사한 아티스트 -->
<style>
.art_more_similar_text {
	padding-bottom: 10px;
}

.art_more_similar_text div {
	display: inline;
	right: 0px;
}

.art_more_similar_plus {
	right: 0px;
	position: absolute;
}

.art_more_similar_another div {
	padding-top: 10px;
	text-align: center;
}

.art_more_similar_another {
	display: inline-block;
}

.art_more_similar_another img {
	float: left;
	overflow: hidden;
	width: 150px;
	height: 150px;
	border-radius: 50%;
	border: 1px solid white;
	margin-bottom: 10px;
}

.art_more_similar_another {
	padding-right: 19px;
}
</style>

<!-- 댓글 -->
<style>
/* .music_more_comments{
			display:block;
		} */
#art_cont {
	width: 900px;
	height: 50px;
	background: white;
}

table input {
	color: black;
}

.artist_comments_author, .artist_comments_base {
	display: flex;
}

.artist_comments_author {
	margin-bottom: 10px;
}
.artist_comments_id{
	margin-top:10px;
}
.artist_comments_nick {
	margin-left: 10px;
}

.artist_comments_report {
	margin-left: 20px;
}

.artist_comments_cont {
	margin-top: 15px;
	margin-bottom: 15px;
}

.artist_comments_recomm_area {
	display: flex;
	right: 0px;
}

.artist_comments_likes {
	margin-right: 10px;
}
/* .div{
			display:block;
		} */
.artist_comments_box {
	margin-bottom: 10px;
	border-top: 0.5px solid white;
}

.artist_comments_recomm_area {
	margin-bottom: 10px;
}

td, tr {
	background: rgb(20, 23, 38);
}

.artist_comments_write .commenthidden {
	display: hidden;
}
.album_comments_delete{
	padding-left: 1000px;
}

.album_comments_delete > label{
	cursor:pointer;
	
}
tbody > tr > td {
	color:white;
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
	<nav id="side">
		<div id="logo">
			<img src="#" id="logo_img">
		</div>
		<div id="name">
			<img src="image/001-user.svg" id="sampleprof"> <a href="#">안녕하세요
				"누구누구"님</a>
		</div>
		<div id="main_menu">
			<div>
				<input type="radio" name="tab" id="login" class="m1_01"> <input
					type="radio" name="tab" id="song" class="m1_01"> <input
					type="radio" name="tab" id="myplaylist" class="m1_01"> <input
					type="radio" name="tab" id="recommend" class="m1_01"> <input
					type="radio" name="tab" id="help" class="m1_01"> <input
					type="radio" name="tab" id="membership" class="m1_01">
				<div class="each">
					<img src="image/001-play.svg" class="sampleimg"> <label
						for="login" class="m1">마이페이지</label>
				</div>
				<ul>
					<li><a href="#">구매내역</a></li>
					<li><a href="#">보관함</a></li>
					<li><a href="#">계정설정</a></li>
					<li><a href="${pageContext.request.contextPath}/memberLogoutServlet">로그아웃</a></li>
				</ul>
				<div class="each">
					<img src="image/001-play.svg" class="sampleimg"> <label
						for="song" class="m1">노래</label>
				</div>
				<ul>
					<li><a href="#">실시간 차트</a></li>
					<li><a href="#">하트 차트</a></li>
					<li><a href="#">장르</a></li>
					<li><a href="#">무드별</a></li>
				</ul>
				<div class="each">
					<img src="image/001-play.svg" class="sampleimg"> <label
						for="myplaylist" class="m1">마이플레이리스트</label>
				</div>
				<div class="each">
					<img src="image/001-play.svg" class="sampleimg"> <label
						for="recommend" class="m1">나만의 추천</label>
				</div>
				<div class="each">
					<img src="image/001-play.svg" class="sampleimg"> <label
						for="help" class="m1">고객지원센터</label>
				</div>
				<ul>
					<li><a href="#">공지사항</a></li>
					<li><a href="#">Q&A</a></li>
					<li><a href="#">자주하는 질문</a></li>
					<li><a href="${pageContext.request.contextPath}/memberLogoutServlet">로그아웃</a></li>
				</ul>
				<div class="each">
					<img src="image/001-play.svg" class="sampleimg"> <label
						for="membership" class="m1">이용권구매</label>
				</div>
			</div>
		</div>
		<div class="page">
			<button class="player-btn">Player</button>
		</div>
	</nav>
	<header class="main_header">
		<input type="text" class="searchbx">
		<div class="search"></div>
		<div class="remenu">
			<div class="realtime">
				<div class='masthead-image' id='master-container'>
					<div id='master-container-scroller'>
						<div class='master-container-scroller_item'>
							<a class='cta-link' href='#'>1. 블랙핑크
								<div class="tri"></div>
							</a>
						</div>
						<div class='master-container-scroller_item'>
							<a class='cta-link' href='#'>2. 트와이스
								<div class="tri"></div>
							</a>
						</div>
						<div class='master-container-scroller_item'>
							<a class='cta-link' href='#'>3. 소녀시대
								<div class="tri"></div>
							</a>
						</div>
						<div class='master-container-scroller_item'>
							<a class='cta-link' href='#'>4. 원더걸스
								<div class="tri"></div>
							</a>
						</div>
						<div class='master-container-scroller_item'>
							<a class='cta-link' href='#'>5. 카라
								<div class="tri"></div>
							</a>
						</div>
						<div class='master-container-scroller_item'>
							<a class='cta-link' href='#'>6. SES
								<div class="tri"></div>
							</a>
						</div>
						<div class='master-container-scroller_item'>
							<a class='cta-link' href='#'>7. 블랙핑크
								<div class="tri"></div>
							</a>
						</div>
						<div class='master-container-scroller_item'>
							<a class='cta-link' href='#'>8. 블랙핑크
								<div class="tri"></div>
							</a>
						</div>
						<div class='master-container-scroller_item'>
							<a class='cta-link' href='#'>9. 블랙핑크
								<div class="tri"></div>
							</a>
						</div>
						<div class='master-container-scroller_item'>
							<a class='cta-link' href='#'>10. 블랙핑크
								<div class="tri"></div>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<table id="rtdrop">
			<tr>
				<td width="10%">1.</td>
				<td width="80%"><a href="#">블랙핑크ㅇ</a></td>
				<td width="10%">
					<div class="tri"></div>
				</td>
			</tr>
			<tr>
				<td>2.</td>
				<td><a href="#">블랙핑크</a></td>
				<td>
					<div class="tri"></div>
				</td>
			</tr>
			<tr>
				<td>3.</td>
				<td><a href="#">블랙핑크</a></td>
				<td>
					<div class="tri"></div>
				</td>
			</tr>
			<tr>
				<td>4.</td>
				<td><a href="#">블랙핑크</a></td>
				<td>
					<div class="tri"></div>
				</td>
			</tr>
			<tr>
				<td>5.</td>
				<td><a href="#">블랙핑크</a></td>
				<td>
					<div class="tri"></div>
				</td>
			</tr>
			<tr>
				<td>6.</td>
				<td><a href="#">블랙핑크</a></td>
				<td>
					<div class="tri"></div>
				</td>
			</tr>
			<tr>
				<td>7.</td>
				<td><a href="#">블랙핑크</a></td>
				<td>
					<div class="tri"></div>
				</td>
			</tr>
			<tr>
				<td>8.</td>
				<td><a href="#">블랙핑크</a></td>
				<td>
					<div class="tri"></div>
				</td>
			</tr>
			<tr>
				<td>9.</td>
				<td><a href="#">블랙핑크</a></td>
				<td>
					<div class="tri"></div>
				</td>
			</tr>
			<tr>
				<td>10.</td>
				<td><a href="#">블랙핑크</a></td>
				<td>
					<div class="tri"></div>
				</td>
			</tr>
		</table>
	</header>
	<div class="content">
		<div class="container">
			
			<div class="art_more_info">
				<c:if test="${not empty info }">
					<c:forEach items="${info }" var="v" varStatus="s">
						<div class="art_more_info_img">
							<img src="image/bts-img.png">
						</div>
						<div class="art_more_info_intro">
							<div class="art_name">
								<span class="items">${v.art_name }</span><br> <br>
							</div>
							<div class="art_info">
								<span class="items">2013.6.12 데뷔 - 댄스, 랩/힙합</span>
							</div>
							<div class="art_summary">
								<span class="items">${v.art_intro }</span>
							</div>
								<div style="cursor:pointer" class="introBtn">더보기</div>
						</div>
						<div id="introModal" class="modal">
							<div class="modal-content ">
								<!-- <a class="introClose">&times;</a> -->
								<button type="button" class="introClose" value="${v.mu_name }">&times;</button>
								<pre>${v.art_intro }</pre>
							</div>
						</div>
					</c:forEach>
				</c:if>
				<div class="option_area">
					<div class="option_inner">
						<!-- <a onclick="openWin()" class="option_play">
							<button class="play_btn"></button>재생
						</a> -->
						<div class="option_buy">
							<a href="<%=request.getContextPath() %>/MembershipServlet" class="buy_btn">이용권구매</a>
						</div>
						<div class="option_more">
							<div class="option_like">
								<a id="heart" class="far fa-heart"></a>
							</div>
						</div>
					</div>
				</div>
			</div>

			<hr>

			<div class="art_more_tracks">
				<div class="art_more_tracks_text">Top Tracks</div>
				<div class="art_more_tracks_inner">
					<div class="art_more_tracks_list">
						<div class="art_more_tracks_title">
							<div class="art_more_tracks_title1">#</div>
							<div class="art_more_tracks_title2">SONG</div>
							<div class="art_more_tracks_title3">ALBUM</div>
							<div class="art_more_tracks_title4">OPTION</div>
							<div class="art_more_tracks_title5"></div>
						</div>
						<c:if test="${not empty tracks }">
							<c:forEach items="${tracks }" var="v" varStatus="s">
								<div class="art_more_tracks_line">
									<div class="art_more_tracks_line1"><a href="#"><img src="image/bts-dynamite-cover.jpg"></a></div>
									<div class="art_more_tracks_line2">${s.count }</div>
									<div class="art_more_tracks_line3"><!-- <a onclick="openWin()" class="tracks_play"><div>재생</div></a> -->
									<a href="<%=request.getContextPath()%>/playerCtrl.do?mu_no=${v.mu_no}" onclick="window.open(this.href,'','width=1200,height=720,scrollbars=no'); return false;" class="tracks_play"> 
                                        재생</a><input type="hidden" class="nrgo" name="mu_no" value=${v.mu_no}></div>
									<div class="art_more_tracks_line4"><a href="<%=request.getContextPath() %>/musicMoreServlet?mu_no=${v.mu_no }" class="tracks_name"><div>${v.mu_name}</div></a></div>
									<div class="art_more_tracks_line5"><a href="<%=request.getContextPath() %>/albumMoreServlet?al_no=${v.al_no }" class="tracks_album"><div>${v.al_name }</div></a></div>
									<div class="art_more_tracks_line6">
										<button type="button" class="tracks_lyrics myBtn" value="${v.mu_name }">가사</button> 
										<a href="<%=request.getContextPath() %>/MembershipServlet" class="tracks_buy"><div>이용권구매</div></a> 
									</div>
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
					<div class="art_more_tracks_plus">
					<c:forEach items="${info }" var="v">
						<a href="<%=request.getContextPath() %>/artistSearchCtrl?art_no=${v.art_no}">SHOW MORE</a>
					</c:forEach>
					</div>
				</div>
			</div>

			<hr>

			<div class="art_more_singles">
				<div class="art_more_singles_inner">
					<div class="art_more_singles_text">
						<div class="art_more_singles_title">Singles</div>
						<div class="art_more_singles_plus">
							<a href=""><div>더보기</div></a>
						</div>
					</div>
					<div class="art_more_singles_seriese">
						<c:if test="${not empty sList }">
							<c:forEach items="${sList }" var="v" varStatus="s">
								
									<div class="art_more_singles_seriese0">
										<table>
											<tr>
												<td><a href="#"><img src="image/bts-img.png" width="150px"
													height="150px"></a></td>
											</tr>
											<tr>
												<td><a href="<%=request.getContextPath() %>/albumMoreServlet?al_no=${v.al_no }">${v.al_name}</a></td>
											</tr>
											<tr>
												<td>${v.art_name }</td>
											</tr>
										</table>
									</div>
								
							</c:forEach>
						</c:if>
					</div>
				</div>
			</div>

			<hr>

			<div class="art_more_similar">
				<div class="art_more_similar_text">
					<div class="art_more_similar_title">Similar Artists</div>
					<div class="art_more_similar_plus"><a>더보기</a></div>
				</div>
				<div class="art_more_similar_inner">
				<c:if test="${not empty similar }">
					<c:forEach items="${similar }" var="v">
					<a href="#">
						<div class="art_more_similar_another">
							<img src="image/bts-img.png">
							<div><a href="<%=request.getContextPath() %>/artistMoreServlet?art_no=${v.art_no }">${v.art_name }</div>
						</div>
					</a> 
					</c:forEach>
				</c:if>
				</div>
			</div>

			<hr>

			<div class="art_more_comments">
					<div class="art_comments_write">
						<form method="post"
							action="<%=request.getContextPath()%>/artistCommentWriteCtrl"
							onsubmit="return writefrm_submit();">
							<%
							String art_co_no = (request.getParameter("art_co_no") != null) ? request.getParameter("art_co_no") : "0";
							String art_ref = (request.getParameter("art_ref") != null) ? request.getParameter("art_ref") : "0";
							String art_step = (request.getParameter("art_step") != null) ? request.getParameter("art_step") : "0";
							String art_level = (request.getParameter("art_level") != null) ? request.getParameter("art_level") : "0";
							String art_no= request.getParameter("art_no");
							%>
							<input type="hidden" name="art_co_no" value="<%=art_co_no%>" class="commenthidden"> 
							<input type="hidden" name="art_ref" value="<%=art_ref%>" class="commenthidden"> 
							<input type="hidden" name="art_step" value="<%=art_step%>" class="commenthidden"> 
							<input type="hidden" name="art_level" value="<%=art_level%>" class="commenthidden">
							<input type="hidden" name="art_no" value="<%=art_no%>" class="commenthidden">
							<input type="hidden" name="mem_id" value="${idLog}" class="commenthidden">
							<table border="1">
								<tr>
									<td>글쓰기<%=art_no%>${idLog}</td>
								</tr>
								<tr>
									<td><input type="text" name="art_cont" id="art_cont"></td>
								<tr>
									<td colspan="2">
										<input type="submit" value="글등록">
										<input type="reset" value="지우기"> 
										<input type="button" value="글목록" onclick="window.location='artistCommentListCtrl.lo'">
									</td>
								</tr>
							</table>
						</form>
					</div>
					<c:if test="${not empty clist }">
						<c:forEach items="${clist }" var="v" varStatus="s">
							<div class="artist_comments_box">
								<div class="artist_comments_author">
									<div class="artist_comments_id">
										<a>${v.mem_name }</a>&nbsp;님&nbsp;<span class="mem_id">(${v.mem_id })</span>
									</div>
								</div>
								<div class="artist_comments_base">
									<div class="artist_comments_date">
										${v.art_date}
									</div>
									<div class="artist_comments_report">
										<a>신고</a>
									</div>
								</div>
								<div class="artist_comments_cont">
									${v.art_cont }
								</div>
								<div class="artist_comments_recomm">
									<div class="artist_comments_recomm_area">
										<div class="artist_comments_likes">
											<a class="likes" onclick="return confirm('추천하시겠습니까?')" href="./albumCommentLikePro.jsp?mem_id=${v.mem_id }">likes </a> ${v.art_likes}
										</div>
										<div class="artist_comments_hates">
											<a>hates </a> ${v.art_hates}
										</div>
										<c:if test ="${idLog eq v.mem_id }">
										<div class="album_comments_delete">
											<label for="delete">삭제</label><input type="hidden" id="delete" onclick="window.location='artistCommentDeleteCtrl?art_co_no=${v.art_co_no}&art_no=${v.art_no }'" value="삭제">
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
$('.introBtn').on('click', function() {
	$('#introModal').show();
});
$('.introClose').on('click', function() {
	$('#introModal').hide();
});

/* window.onclick = function(event) {
	var a = $(this).val();
	var x = document.getElementById(a);
	  if (event.target == x) {
	    x.style.display = "none";
	  }
	} 
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}
*/ 
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
</script>
</body>
</html>