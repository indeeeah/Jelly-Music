<link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/main_unlogin.css" rel="stylesheet" type="text/css">
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

        <!DOCTYPE html>
        <html lang="en">

        <head>
            <meta charset="UTF-8">
            <meta name="viewport" content="width=device-width, initial-scale=1.0">
            <title>Jelly Music</title>
            <style>
                .main_content {
                    background: linear-gradient(to right, rgba(22, 25, 41, 0) 30%, rgba(22, 25, 41, 0.25) 55%, rgba(22, 25, 41, 0.5) 70%, rgba(22, 25, 41, 0.75) 75%, rgba(22, 25, 41, 1) 100%),
                    linear-gradient(to bottom, rgba(22, 25, 41, 0) 80%, rgba(22, 25, 41, 0.25) 85%, rgba(22, 25, 41, 0.5) 90%, rgba(22, 25, 41, 0.75) 95%, rgba(22, 25, 41, 1) 100%),
                    url('${pageContext.request.contextPath}/image/hostile-886034.jpg');
                    background-size: calc(100% - 259px);
                    background-repeat: no-repeat;
                }
                
                #fix_logo_img {
                    background-image: url('${pageContext.request.contextPath}/image/logo.svg');
                    background-size: 45px;
                }
                
                #j_img {
                    background-image: url('${pageContext.request.contextPath}/image/logo.svg');
                    background-size: 100px;
                }
            </style>
        </head>

        <body>
            <nav id="fix_side">
                <div id="fix_logo">
                    <div id="fix_logo_img"></div>
                    <a href="unLoginMainServlet" id="fix_logo_title">Jelly Music</a>
                </div>
                <div id="fix_user">
                    <a href="${pageContext.request.contextPath}/memberLoginServlet">Login</a>
                </div>
                <div id="fix_side_menu">
                    <div>
                        <input type="radio" name="fix_drp" id="login"> <input type="radio" name="fix_drp" id="song"> <input type="radio" name="fix_drp" id="myplaylist"> <input type="radio" name="fix_drp" id="recommend">
                        <input type="radio" name="fix_drp" id="help"> <input type="radio" name="fix_drp" id="membership">
                        <div class="fix_each">
                            <img src="${pageContext.request.contextPath}/image/007-settings.svg" class="fix_menu_icon"> <label for="login" class="fix_each_menu">마이페이지</label>
                        </div>
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/memberLogoutServlet">로그아웃</a></li>
                        </ul>
                        <div class="fix_each">
                            <img src="${pageContext.request.contextPath}/image/003-play-button.svg" class="fix_menu_icon"> <label for="song" class="fix_each_menu" onclick="location.href='unLoginMainListCtrl.do';">노래</label>
                        </div>
                        <ul>
                            <li><a href="#">실시간 차트</a></li>
                            <li><a href="#">하트 차트</a></li>
                            <li><a href="<%=request.getContextPath()%>/Genre.jsp">장르</a></li>
                            <li><a href="<%=request.getContextPath()%>/Mood.jsp">무드별</a></li>
                        </ul>
                        <div class="fix_each">
                            <img src="${pageContext.request.contextPath}/image/002-music-1.svg" class="fix_menu_icon"> <label for="myplaylist" class="fix_each_menu">마이플레이리스트</label>
                        </div>
                        <div class="fix_each">
                            <img src="${pageContext.request.contextPath}/image/001-music.svg" class="fix_menu_icon"> <label for="recommend" class="fix_each_menu">나만의 추천</label>
                        </div>
                        <div class="fix_each">
                            <img src="${pageContext.request.contextPath}/image/008-internet.svg" class="fix_menu_icon"> <label for="help" class="fix_each_menu">고객지원센터</label>
                        </div>
                        <ul>
                            <li><a href="${pageContext.request.contextPath}/MemberPostListCtrl">공지사항</a></li>
                            <li><a href="${pageContext.request.contextPath}/postListServlet">Q&A</a></li>
                            <li><a href="${pageContext.request.contextPath}/mfreqQues/mfreqQues.jsp">자주하는 질문</a></li>
                        </ul>
                        <div class="fix_each">
                            <img src="${pageContext.request.contextPath}/image/006-star.svg" class="fix_menu_icon"> <label for="membership" class="fix_each_menu" onclick="location.href='MembershipServlet';">이용권구매</label>
                        </div>
                    </div>
                </div>
                <div class="fix_btn">
                    <button class="fix_player_btn" onclick="location.href='${pageContext.request.contextPath}/memberLoginServlet'">Player</button>
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
            <div class="main_content">
                <input type="radio" name="main_title" id="m1" checked> <input type="radio" name="main_title" id="m2"> <input type="radio" name="main_title" id="m3"> <span class="cus_radio" id="for_m1"></span> <span class="cus_radio" id="for_m2"></span>                <span class="cus_radio" id="for_m3"></span>
                <div class="mt">
                    <label for="m1" class="main_title_01" id="title_m1">BLACK
				PINK new<br>album
				</h1>
			</label> <label for="m2" class="main_title_01" id="title_m2">Muse<br>is
				Back
				</h1></label> <label for="m3" class="main_title_01" id="title_m3">Xxxahah
				new<br>album
				</h1>
			</label>
                </div>
                <div id="title_p">
                    <a href="<%=request.getContextPath()%>/registerServlet">Register</a>
                </div>
                <div class="top100">
                    <h1 id="ct4">Top100</h1>
                    <input type="button" class="more" value="더보기">
                    <hr class="up">
                    <div>
                        <div class="top100_each_left">
                            <c:if test="${not empty t1p }">
                                <c:forEach items="${t1p }" var="v" varStatus="s">
                                    <div class="top100_each_l">
                                        <a href="<%=request.getContextPath()%>/playerCtrl.do?mu_no=${v.mu_no}" onclick="window.open(this.href,'','width=1200,height=720,scrollbars=no'); return false;" class="tri_con"> 
                                        <img src="${pageContext.request.contextPath}/allfile/${v.f_name }" class="t100_l_album" onclick="window.open('playerCtrl.do')"></img>
                                            <div class="top100_tri"></div>
                                        </a><input type="hidden" class="top100go" name="mu_no" value=${v.mu_no }>
                                        <div>
                                            <div class="t100_title">
                                                <a href="${pageContext.request.contextPath}/musicMoreServlet?mu_no=${v.mu_no}">${v.mu_name }</a>
                                            </div>
                                            <div class="t100_name">
                                                <a href="${pageContext.request.contextPath}/artistMoreServlet?art_no=1">${v.art_name }</a>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>
                        </div>
                        <div class="top100_each_right">
                            <c:if test="${not empty t6p }">
                                <c:forEach items="${t6p }" var="v" varStatus="s">
                                    <div class="top100_each_r">
                                        <a href="<%=request.getContextPath()%>/playerCtrl.do?mu_no=${v.mu_no}" onclick="window.open(this.href,'','width=1200,height=720,scrollbars=no'); return false;" class="tri_con">
                                            <img src="${pageContext.request.contextPath}/allfile/${v.f_name }"  class="t100_l_album" onclick="window.open('playerCtrl.do')"></img>
                                            <div class="top100_tri"></div>
                                        </a><input type="hidden" class="top100go" name="mu_no" value=${v.mu_no }>
                                        <div>
                                            <div class="t100_title">
                                                <a href="${pageContext.request.contextPath}/musicMoreServlet?mu_no=${v.mu_no}">${v.mu_name }</a>
                                            </div>
                                            <div class="t100_name">
                                                <a href="${pageContext.request.contextPath}/artistMoreServlet?art_no=1">${v.art_name }</a>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>
                        </div>
                    </div>
                    <hr class="down">
                </div>
                <div class="newrl">
                    <h1 id="ct5">New Release</h1>
                    <input type="button" class="more" value="더보기">
                    <hr class="up">
                    <table class="newrltbl">
                        <c:if test="${not empty nrm }">
                            <tr>
                                <c:forEach items="${nrm }" var="v" varStatus="s">
                                    <td>
                                        <a href="<%=request.getContextPath()%>/playerCtrl.do?mu_no=${v.mu_no}" 
                                        onclick="window.open(this.href,'','width=1200,height=720,scrollbars=no'); return false;" class="newrl_con">
                                        <img src="${pageContext.request.contextPath}/allfile/${v.f_name }" class="album"></img>
                                        </a><input type="hidden" class="nrgo" name="mu_no" value=${v.mu_no}>
                                    </td>
                                </c:forEach>
                            </tr>
                            <tr>
                                <c:forEach items="${nrm }" var="v" varStatus="s">
                                    <td>
                                        <div class="album_title">
                                            <a href="#">
                                                <h1>${v.al_name }</h1>${v.art_name }
                                            </a>
                                        </div>
                                    </td>
                                </c:forEach>
                            </tr>
                        </c:if>
                    </table>
                    <hr class="down">
                </div>
                <div class="mood">
                    <h1 id="ct6">Mood</h1>
                    <input type="button" class="more" value="더보기">
                    <hr class="up">
                    <table class="moodtbl">
                        <c:if test="${not empty mood }">
                            <tr>
                                <c:forEach items="${mood }" var="v" varStatus="s">
                                    <td>
                                        <a href="#">
                                            <div class="mood_l" id="${v.f_name }mood">
                                            </div>
                                        </a>
                                    </td>
                                </c:forEach>
                            </tr>
                            <tr>
                                <c:forEach items="${mood }" var="v" varStatus="s">
                                    <td>
                                        <div class="mood_l_title" id="moodtbl_title_01">
                                            <a href="#">
                                                <h1>#${v.mo_name }</h1>
                                            </a>
                                        </div>
                                    </td>
                                </c:forEach>
                            </tr>
                        </c:if>
                    </table>
                    <hr class="down">
                </div>
                <div class="genre">
                    <h1 id="ct7">Genre</h1>
                    <hr class="up">
                    <table class="genretbl">
                        <tr>
                            <c:if test="${not empty gf }">
                                <c:forEach items="${gf }" var="v" varStatus="s">
                                    <td>
                                        <a href="${v.f_name }">
                                            <div class="genre_l">${v.gn_name }</div>
                                        </a>
                                    </td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <c:if test="${not empty gs }">
                                <c:forEach items="${gs }" var="v" varStatus="s">
                                    <td>
                                        <a href="${v.f_name }">
                                            <div class="genre_l">${v.gn_name }</div>
                                        </a>
                                    </td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <c:if test="${not empty gth }">
                                <c:forEach items="${gth }" var="v" varStatus="s">
                                    <td>
                                        <a href="${v.f_name }">
                                            <div class="genre_l">${v.gn_name }</div>
                                        </a>
                                    </td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <c:if test="${not empty gfo }">
                                <c:forEach items="${gfo }" var="v" varStatus="s">
                                    <td>
                                        <a href="${v.f_name }">
                                            <div class="genre_l">${v.gn_name }</div>
                                        </a>
                                    </td>
                                </c:forEach>
                            </c:if>
                        </tr>
                        <tr>
                            <c:if test="${not empty gfi }">
                                <c:forEach items="${gfi }" var="v" varStatus="s">
                                    <td>
                                        <a href="${v.f_name }">
                                            <div class="genre_l">${v.gn_name }</div>
                                        </a>
                                    </td>
                                </c:forEach>
                            </c:if>
                        </tr>
                    </table>
                    <hr class="down">
                </div>
                <footer id="fix_footer">
                    <hr id="fix_fline">
                    <div id="fix_ft">
                        <div id="fix_copy" class="fix_fc">Copyright ⓒ 2020 Jelly. All rights reserved.</div>
                        <div id="fix_national" class="fix_fc">Republic of Korea</div>
                        <div id="fix_link" class="fix_fc">
                            <a href="#">이용약관</a> | <a href="#">개인정보처리방침</a> | <a href="#">고객센터</a> | <a href="#">이메일주소무단수집거부</a>
                        </div>
                        <div id="fix_info" class="fix_fc">제작자 : 김경태 김수민 곽은지 김지용 장재혁</div>
                    </div>
                </footer>
            </div>

        </body>

        </html>