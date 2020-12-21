<link href="${pageContext.request.contextPath}/css/reset.css"
	rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/player.css"
	rel="stylesheet" type="text/css">
<%@page import="main.model.vo.MainVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<script src="http://code.jquery.com/jquery-latest.js"></script>
<title>Player</title>
<style>
#player_left>#hb_con {
	background-image:
		url('${pageContext.request.contextPath}/image/001-lyrics.svg');
	background-size: 30px;
}
/* #m1 {
                            background-image: url('${pageContext.request.contextPath}/image/playonce.svg');
                            background-size: 25px;
                        }
                        
                        #m1:hover {
                            background-image: url('${pageContext.request.contextPath}/image/playone.svg');
                        }
                        
                        #m2 {
                            background-image: url('${pageContext.request.contextPath}/image/playone.svg');
                            background-size: 25px;
                        }
                        
                        #m3 {
                            background-image: url('${pageContext.request.contextPath}/image/playone.svg');
                            background-size: 25px;
                        }
                        
                        #sf1 {
                            background-image: url('${pageContext.request.contextPath}/image/umshuffle.svg');
                            background-size: 25px;
                        }
                        
                        #sf1:hover {
                            background-image: url('${pageContext.request.contextPath}/image/shuffle.svg');
                        }
                        
                        #sf2 {
                            background-image: url('${pageContext.request.contextPath}/image/shuffle.svg');
                            background-size: 25px;
                        }
                         */
#plist {
	background-image:
		url('${pageContext.request.contextPath}/image/list.svg');
	background-size: 25px;
}

#pshw {
	/* background-image: url('${pageContext.request.contextPath}/image/list.svg'); */
	background-size: 25px;
}

#player_middle {
	/* background-image: url('${pageContext.request.contextPath}/image/music-3264716.jpg');
                            background-size: 720px; */
	/* 앨범 자켓 사진으로 바꿔야 함(임시 이미지) */
	
}

.vol {
	background-image:
		url('${pageContext.request.contextPath}/image/002-spaceship.svg');
	background-size: 40px;
}

#vol_con {
	position: absolute;
	width: 40px;
	height: 60px;
	left: 37.5px;
	bottom: 40px;
	z-index: 1;
}

.vol {
	position: absolute;
	width: 40px;
	height: 40px;
	bottom: 0px;
	background-repeat: no-repeat;
	cursor: pointer;
}

.next, .prev {
	cursor: pointer;
}

.heart {
	position: absolute;
	top: 20px;
	left: 18px;
	background-color: rgb(244, 244, 244);
	height: 15px;
	width: 15px;
	transform: rotate(-45deg);
	cursor: pointer;
}

.heart:after {
	background-color: rgb(244, 244, 244);
	content: "";
	border-radius: 50%;
	position: absolute;
	width: 15px;
	height: 15px;
	top: 0px;
	left: 8px;
}

.heart:before {
	background-color: rgb(244, 244, 244);
	content: "";
	border-radius: 50%;
	position: absolute;
	width: 15px;
	height: 15px;
	top: -8px;
	left: 0px;
}

#heart_con:hover>#whiteheart {
	background-color: rgb(74, 254, 0);
}

#heart_con:hover>#whiteheart:after {
	background-color: rgb(74, 254, 0);
}

#heart_con:hover>#whiteheart:before {
	background-color: rgb(74, 254, 0);
}

#greenheart {
	background-color: rgb(74, 254, 0);
}

#greenheart:after {
	background-color: rgb(74, 254, 0);
}

#greenheart:before {
	background-color: rgb(74, 254, 0);
}

.box {
	top: -300px;
	z-index: -1;
	position: absolute;
	width: 300px;
	height: 405px;
	border-radius: 5px;
	box-shadow: 0 2px 30px rgba(black, .2);
	background: lighten(#B58ECC, 10%);
	position: relative;
	overflow: hidden;
	transform: translate3d(0, 0, 0) rotate(180deg);
}

.wave {
	opacity: .4;
	position: absolute;
	top: 3%;
	left: 50%;
	background: #5DE6DE;
	width: 500px;
	height: 605px;
	margin-left: -250px;
	margin-top: -250px;
	transform-origin: 50% 48%;
	border-radius: 43%;
	animation: drift 3000ms infinite linear;
}

.wave.-three {
	animation: drift 5000ms infinite linear;
}

.wave.-two {
	animation: drift 7000ms infinite linear;
	opacity: .1;
	background: yellow;
}

.box:after {
	content: '';
	display: block;
	left: 0;
	top: 0;
	width: 100%;
	height: 100%;
	background: linear-gradient(to bottom, rgba(#e8a, 1), rgba(#def, 0) 80%,
		rgba(white, .5));
	z-index: 11;
	transform: translate3d(0, 0, 0);
}

.title {
	position: absolute;
	left: 0;
	top: 0;
	width: 100%;
	z-index: 1;
	line-height: 300px;
	text-align: center;
	transform: translate3d(0, 0, 0);
	color: white;
	text-transform: uppercase;
	font-family: 'Playfair Display', serif;
	letter-spacing: .4em;
	font-size: 24px;
	text-shadow: 0 1px 0 rgba(black, .1);
	text-indent: .3em;
}

@keyframes drift {from { transform:rotate(0deg);
	
}

from {
	transform: rotate(360deg);
}

}
#togo {
	display: none;
	position: absolute;
	left: 29px;
	width: 60px;
	height: 160px;
	bottom: 90px;
	border: 1px solid rgb(74, 254, 0);
	border-radius: 10px;
	cursor: pointer;
	text-align: center;
}

#tomusic {
	position: absolute;
	width: 40px;
	height: 40px;
	bottom: 10px;
	left: 10px;
	background-repeat: no-repeat;
	background-image: url('${pageContext.request.contextPath}/image/001-gems.svg');
	background-size: 40px;
}

#tomusic:hover {
	background-image: url('${pageContext.request.contextPath}/image/gemsgreen.svg');
	background-size: 40px;
}

#tomusic:hover>a {
	display: block;
}

#toartist {
	position: absolute;
	width: 40px;
	height: 40px;
	bottom: 60px;
	left: 10px;
	background-repeat: no-repeat;
	background-image: url('${pageContext.request.contextPath}/image/001-gems.svg');
	background-size: 40px;
}

#toartist:hover {
	background-image: url('${pageContext.request.contextPath}/image/gemsgreen.svg');
	background-size: 40px;
}

#toartist:hover>a {
	display: block;
}

#toalbum {
	position: absolute;
	width: 40px;
	height: 40px;
	bottom: 110px;
	left: 10px;
	background-repeat: no-repeat;
	background-image: url('${pageContext.request.contextPath}/image/001-gems.svg');
	background-size: 40px;
}

#toalbum:hover {
	background-image: url('${pageContext.request.contextPath}/image/gemsgreen.svg');
	background-size: 40px;
}

#toalbum:hover>a {
	display: block;
}

.togogo {
	display: none;
	background-color: rgb(22, 25, 41);
	color: rgb(74, 254, 0);
	font-size: 15px;
	position: absolute;
	left: 0px;
	top: 12px;
}
</style>
</head>

<body>
	<c:if test="${not empty scm }">
		<c:forEach items="${scm }" var="v" varStatus="s">
			<input type="hidden" id="mumuno" value=${v.mu_no }>
			<input type="hidden" id="mem_id" value=${v.mem_id }>
		</c:forEach>
	</c:if>
	<div id="player_left">
		<div id="hb_con"></div>
		<input type="checkbox" id="lyrics" name="lyrics"><label
			for="lyrics">가사</label>
		<div id="lyrics_con">
			<p id="ly">
				<c:if test="${not empty mplist }">
					<c:forEach items="${mplist }" var="v" varStatus="s" end="0">
                                        ${v.mu_ly}
                                    </c:forEach>
                                </c:if>
                            </p>
                        </div>
                        <div class="album__song__position"></div>
                        <c:if test="${not empty scm }">
                            <c:forEach items="${scm }" var="v" varStatus="s">
                                <div id="player_info">
                                    <div id="pt1">
                                        <a href="${pageContext.request.contextPath}/albumMoreServlet?al_no=${v.al_no}" class="album" id="albumTi">${v.al_name} - </a><a href="${pageContext.request.contextPath}/artistMoreServlet?art_no=${v.art_no}" class="arti" id="artiName">${v.art_name}</a>
                                    </div>
                                    <a href="${pageContext.request.contextPath}/musicMoreServlet?mu_no=${v.mu_no}" class="music" id="musicName">${v.mu_name}</a>
                                </div>
                                <div id="player_bar">
                                <%-- <c:if test="${empty membership }">
                                    <audio controls="" id="player" autoplay onplaying="myFunction1()">
										<source
											src="${pageContext.request.contextPath}/mp3/K.Will - 그립고 그립고 그립다.mp3"
											type="audio/mpeg" id="musicaudio">
										<source src="${pageContext.request.contextPath}/mp3/${v.musicfile}.mp3" type="audio/mpeg" id="musicaudio">
										Your browser dose not Support the audio Tag
									</audio>
                                </c:if> --%>
<%--                                 <c:if test="${empty not membership }">
 --%>                                    <audio controls="" id="player" autoplay >
										<source
											src="${pageContext.request.contextPath}/mp3/K.Will - 그립고 그립고 그립다.mp3"
											type="audio/mpeg" id="musicaudio">
										<%-- <source src="${pageContext.request.contextPath}/mp3/${v.musicfile}.mp3" type="audio/mpeg" id="musicaudio"> --%>
										Your browser dose not Support the audio Tag
									</audio>
<%-- 								</c:if>
 --%>                                </div>
                            </c:forEach>
                        </c:if>
                        <div id="play_method">
                            <div id="plist"></div>
                            <div class='box'>
                                <div class='wave -one'></div>
                                <div class='wave -two'></div>
                                <div class='wave -three'></div>
                            </div>
                        </div>
                        <input type="checkbox" id="pshw" name="pshw">
                        <div id="musiclist">
                            <div id="playlstitle">Jelly Music</div>
                            <div id="pmlist">
                                <c:if test="${not empty mplist }">
                                    <c:forEach items="${mplist }" var="v" varStatus="s">
                                        <div class="mulist" id="${v.mu_no }fordelete">
                                            <div class="dplay">X</div>
                                            <a href="<%=request.getContextPath()%>/playerCtrl.do?mu_no=${v.mu_no}" class="mulist_con"> <img src="${pageContext.request.contextPath}/allfile/${v.f_name }" class="mulist_album"></img>
                                                <p class="mulist_title">${v.mu_name }</p>
                                                <p class="mulist_artist">${v.art_name }</p>
                                            </a> <input type="hidden" class="nowmuno" name="mu_no1" id="muuno" value=${v.mu_no }> <input type="hidden" class="nowmuname" name="mu_name" value=${v.mu_name }> <input type="hidden" class="nowartname" name="art_name"
                                                value=${v.art_name }> <input type="hidden" class="nowalname" name="al_name" value=${v.al_name }> <input type="hidden" class="nowmuly" name="mu_ly" value=${v.mu_ly }>
                                        </div>
                                    </c:forEach>
                                </c:if>
                            </div>
                        </div>
                    </div>
                    <c:if test="${not empty scm }">
                        <c:forEach items="${scm }" var="v" varStatus="s">
                            <img src="${pageContext.request.contextPath}/allfile/${v.albumfile}" id="player_middle"></img>
                        </c:forEach>
                    </c:if>
                    <div id="player_right">
                        <%-- <c:if test="${not empty mprof}">
                            <c:forEach items="${mprof }" var="v" varStatus="s"> --%>
                                <img src="${pageContext.request.contextPath}/image/001-character.svg" id="userpro"></img>
                            <%-- </c:forEach>
                        </c:if> --%>
                        <div id="heart_con">
                            <c:if test="${not empty heart }">
                                <c:if test="${heart eq 0}">
                                    <input type="radio" name="heart_check" id="towhiteheart_chk" value="heartup" class="heartchkbox" checked style="display: none;">
                                    <label for="togreenheart_chk">
						<div class="heart" id="whiteheart"></div>
					</label>
					<input type="radio" name="heart_check" id="togreenheart_chk"
						value="heartdown" class="heartchkbox" style="display: none;">
					<label for="towhiteheart_chk">
						<div class="heart" id="greenheart" style="display: none;"></div>
					</label>
					<c:if test="${not empty scm }">
						<c:forEach items="${scm }" var="v" varStatus="s" end="0">
							<input type="hidden" name="mu_no" id="munoforheart"
								value=${v.mu_no }>
							<input type="hidden" name="mu_no" id="munoforheartd"
								value=${v.mu_no }>
						</c:forEach>
					</c:if>
				</c:if>
				<c:if test="${heart eq 1}">
					<input type="radio" name="heart_check" id="towhiteheart_chk"
						value="heartup" class="heartchkbox" style="display: none;">
					<label for="togreenheart_chk">
						<div class="heart" id="whiteheart" style="display: none;"></div>
					</label>
					<input type="radio" name="heart_check" id="togreenheart_chk"
						value="heartdown" class="heartchkbox" checked
						style="display: none;">
					<label for="towhiteheart_chk">
						<div class="heart" id="greenheart"></div>
					</label>
					<c:if test="${not empty scm }">
						<c:forEach items="${scm }" var="v" varStatus="s" end="0">
							<input type="hidden" name="mu_no" id="munoforheart"
								value=${v.mu_no }>
							<input type="hidden" name="mu_no" id="munoforheartd"
								value=${v.mu_no }>
						</c:forEach>
					</c:if>
				</c:if>
			</c:if>
		</div>
		<!-- </a> -->
		<div id="vol_con">
			<div class="vol"></div>
		</div>
		<c:if test="${not empty scm }">
			<c:forEach items="${scm }" var="v" varStatus="s" end="0">
				<div id="togo">
					<div id="tomusic">
						<a class="togogo" href="${pageContext.request.contextPath}/musicMoreServlet?mu_no=${v.mu_no}">music</a>
					</div>
					<div id="toartist">
						<a class="togogo" href="${pageContext.request.contextPath}/artistMoreServlet?art_no=${v.art_no}">artist</a>
					</div>
					<div id="toalbum">
						<a class="togogo" href="${pageContext.request.contextPath}/albumMoreServlet?al_no=${v.al_no}">album</a>
					</div>
				</div>
			</c:forEach>
		</c:if>
		<!-- <input type="range" min="1" max="100" value="50" class="slider" id="myRange"> -->
	</div>
	<script>
		$(".mulist_con").click(function() {
			var showMuno = $(this).next().val();
			var showMuname = $(this).next().next().val();
			var showArtname = $(this).next().next().next().val();
			var showAlname = $(this).next().next().next().next().val();
			var showMuly = $(this).next().next().next().next().next().val();
			var showmemId = $("#mem_id").val();

			console.log(showMuno);
			console.log(showMuname);
			console.log(showArtname);
			console.log(showAlname);
			console.log(showMuly);
			console.log(showmemId);

			document.getElementById("ly").innerHTML = showMuly;
			document.getElementById("albumTi").innerHTML = showAlname;
			document.getElementById("artiName").innerHTML = showArtname;
			document.getElementById("musicName").innerHTML = showMuname;
			$("#munoforheart").val(showMuno);
			$("#munoforheartd").val(showMuno);

			$.ajax({
				type : "POST",
				url : "updateCurrmusicServlet",
				data : {
					mem_id : showmemId,
					mu_no : showMuno
				},
				success : function(resultcm) {

				}
			});

		});

		$(".dplay").click(function() {
			var showMuno = $(this).next().next().val();
			var showmemId = $("#mem_id").val();
			console.log(showMuno);
			console.log(showmemId);
			$("#" + showMuno + "fordelete").css("display", "none");

			$.ajax({
				type : "POST",
				url : "playerListDelete.do",
				data : {
					mem_id : showmemId,
					mu_no : showMuno
				},
				success : function(resultd) {
					$(this).parent(".mulist").css("display", "none");
				}
			});
		});

		$("#whiteheart").click(function() {
			var showMuno = $("#munoforheart").val();
			var showmemId = $("#mem_id").val();
			console.log(showMuno);
			console.log(showmemId);

			$("#whiteheart").css("display", "none");
			$("#greenheart").css("display", "block");

			$.ajax({
				type : "POST",
				url : "playerPressHeart.do",
				data : {
					mem_id : showmemId,
					mu_no : showMuno
				},
				success : function(resulthi) {
					console.log("에이작스 성공!1");
					// $(this).prop("checked", false);
					$("#togreenheart_chk").prop("checked", true);

				}
			});
		});
		$("#greenheart").click(function() {
			var showMuno = $("#munoforheartd").val();
			var showmemId = $("#mem_id").val();
			console.log(showMuno + "그린하트");
			console.log(showmemId + "그린하트");

			$("#whiteheart").css("display", "block");
			$("#greenheart").css("display", "none");

			$.ajax({
				type : "POST",
				url : "playerDeleteHeart.do",
				data : {
					mem_id : showmemId,
					mu_no : showMuno
				},
				success : function(resulthd) {
					console.log("에이작스 성공!2");
					// $(this).prop("checked", false);
					$("#towhiteheart_chk").prop("checked", true);
				}
			});
		});

		$(function() {
			$("#m1").css("display", "block");
			$("#m2").css("display", "none");
			$("#m3").css("display", "none");

			$("#m1").click(function() {
				$("#m1").css("display", "none");
				$("#m2").css("display", "block");
				$("#m3").css("display", "none");
			});
			$("#m2").click(function() {
				$("#m1").css("display", "none");
				$("#m2").css("display", "none");
				$("#m3").css("display", "block");
			});
			$("#m3").click(function() {
				$("#m1").css("display", "block");
				$("#m2").css("display", "none");
				$("#m3").css("display", "none");
			});
			$("#sf1").click(function() {
				$("#sf1").css("display", "none");
				$("#sf2").css("display", "block");
			});
			$("#sf2").click(function() {
				$("#sf1").css("display", "block");
				$("#sf2").css("display", "none");
			});

		});

                        $("#vol_con").hover(function() {
                            $("#togo").css("display", "block");
                        });
                        
                        <%-- var vid = document.getElementById("player");
                    	vid.onplaying = function() {
                    	  timeOut = setTimeout(function(){ 
                    			vid.pause(); 
                    			alert("이용권을 구매해주세요");
                    			window.opener.location.href="<%=request.getContextPath() %>/MembershipServlet"
                    		}, 3000);
                    	}; --%>
                    </script>
                </body>

</html>