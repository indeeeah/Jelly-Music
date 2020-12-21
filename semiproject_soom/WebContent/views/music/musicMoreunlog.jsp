<link href="${pageContext.request.contextPath}/css/reset.css" rel="stylesheet" type="text/css">
<link href="${pageContext.request.contextPath}/css/musicMoreunlog.css" rel="stylesheet" type="text/css">
<%@page import="java.text.SimpleDateFormat"%>
    <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
            <!DOCTYPE html>
            <html lang="en">

            <head>
                <meta charset="UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <title>main page</title>
                <script src="https://kit.fontawesome.com/3929e16ef5.js" crossorigin="anonymous"></script>
                <script src="{% static 'network/functions.js' %}"></script>
                <script src="http://code.jquery.com/jquery-latest.js"></script>
                <script src="https://cdn.jsdelivr.net/npm/sweetalert2@9"></script>
                <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.8.2/css/all.min.css" />

                <style>
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
                        <a href="mainServlet" id="fix_logo_title">Jelly Music</a>
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
                                <li><a href="#">구매내역</a></li>
                                <li><a href="#">보관함</a></li>
                                <li><a href="#">계정설정</a></li>
                                <li><a href="${pageContext.request.contextPath}/memberLogoutServlet">로그아웃</a></li>
                            </ul>
                            <div class="fix_each">
                                <img src="${pageContext.request.contextPath}/image/003-play-button.svg" class="fix_menu_icon"> <label for="song" class="fix_each_menu" onclick="location.href='unLoginMainListCtrl.do';">노래</label>
                            </div>
                            <ul>
                                <li><a href="#">실시간 차트</a></li>
                                <li><a href="#">하트 차트</a></li>
                                <li><a href="#">장르</a></li>
                                <li><a href="#">무드별</a></li>
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
                                <li><a href="#">공지사항</a></li>
                                <li><a href="#">Q&A</a></li>
                                <li><a href="#">자주하는 질문</a></li>
                                <li><a href="${pageContext.request.contextPath}/memberLogoutServlet">로그아웃</a></li>
                            </ul>
                            <div class="fix_each">
                                <img src="${pageContext.request.contextPath}/image/006-star.svg" class="fix_menu_icon"> <label for="membership" class="fix_each_menu">이용권구매</label>
                            </div>
                        </div>
                    </div>
                    <div class="fix_btn">
                        <button class="fix_player_btn" onclick="window.open('<%=request.getContextPath()%>/playerCtrl.do','','width=1200,height=720')">Player</button>
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
                        <div class="music_more_info">
                            <c:if test="${not empty info }">
                                <c:forEach items="${info }" var="v">
                                    <div class="music_more_info_img">
                                        <a href="<%=request.getContextPath() %>/albumMoreServlet?al_no=${v.al_no }"><img src="image/bts-dynamite-cover.jpg"></a>
                                    </div>
                                    <div class="music_more_info_intro">
                                        <div class="music_title">
                                            <span class="items">${v.mu_name }</span><br> <br>
                                        </div>
                                        <div class="music_artist">
                                            <span class="items"><a
									href="<%=request.getContextPath() %>/artistMoreServlet?art_no=${v.art_no }">${v.art_name
                                            }</a></span>
                                        </div>
                                        <div class="music_summary">
                                            <span class="items">작사</span><br> <span class="items">작곡</span>
                                        </div>
                                    </div>
                                </c:forEach>
                            </c:if>
                            <div class="option_area">
                                <div class="option_inner">
                                    <a href="#" class="option_play">
                                        <button class="play_btn"></button>재생
                                    </a>
                                    <div href="#" class="option_buy">
                                        <a class="buy_btn">Mp3구매</a>
                                    </div>
                                    <div class="option_more">
                                        <div class="option_like">
                                            <a id="heart" class="far fa-heart"></a>
                                        </div>
                                        <div class="option_drop">
                                            <a class="drop_more">...</a>
                                            <div class="option_drop_menu">
                                                <ul>
                                                    <li><a>내 플레이리스트 추가</a></li>
                                                    <li><a>좋아요</a></li>
                                                    <li><a>보관함에 넣기</a></li>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <hr>

                        <div class="music_more_lyrics">
                            <div class="music_more_lyrics_section">가사</div>
                            <div class="music_more_lyrics_inner">
                                <input type="checkbox" class="lyrics_btn" id="lyrics_btn" />
                                <div class="music_more_lyrics_hide">
                                    <pre>
            			<c:if test="${not empty lyrics }">
            				<c:forEach items="${lyrics }" var="v" varStatus="s">
            					${v.mu_ly }
            				</c:forEach>
            			</c:if>				
            			</pre>
                                </div>
                                <br> <label for="lyrics_btn">가사</label>
                            </div>
                        </div>

                        <hr>

                        <div class="music_more_include">
                            <div class="music_more_include_section">수록 앨범</div>
                            <div class="music_more_include_inner">
                                <div class="music_more_include_img">
                                    <a><img src="image/bts-dynamite-cover.jpg"></a>
                                </div>
                                <div class="music_more_include_text">
                                    <c:if test="${not empty ainclude }">
                                        <c:forEach items="${ainclude }" var="v" varStatus="s">
                                            <div class="music_more_include_title">
                                                <span class="items"><a
										href="<%=request.getContextPath() %>/albumMoreServlet?al_no=${v.al_no }">${v.al_name
                                                }</a></span><br>
                                                <br>
                                            </div>
                                            <div class="music_more_include_artist">
                                                <a href="<%=request.getContextPath() %>/artistMoreServlet?art_no=${v.art_no }"><span
										class="items">${v.art_name }</span></a>
                                            </div>
                                            <div class="music_more_include_info">
                                                <span class="items">${v.al_release }</span>
                                            </div>
                                        </c:forEach>
                                    </c:if>
                                </div>
                            </div>
                        </div>

                        <hr>

                        <div class="music_more_video">
                            <div class="music_more_video_text">
                                <div class="music_more_video_section">VIDEO</div>
                            </div>
                            <div class="music_more_video_inner">
                                <div class="music_more_video_seriese">
                                    <div class="music_more_video_thumb"></div>
                                    <div class="music_more_video_headline">다이나마이트 뮤비</div>
                                    <div class="music_more_video_name">방탄소년단</div>
                                </div>
                                <div class="music_more_video_seriese">
                                    <div class="music_more_video_thumb"></div>
                                    <div class="music_more_video_headline">다이나마이트 뮤비</div>
                                    <div class="music_more_video_name">방탄소년단</div>
                                </div>
                                <div class="music_more_video_seriese">
                                    <div class="music_more_video_thumb"></div>
                                    <div class="music_more_video_headline">다이나마이트 뮤비</div>
                                    <div class="music_more_video_name">방탄소년단</div>
                                </div>
                            </div>
                        </div>

                        <hr>

                        <div class="music_more_singles">
                            <div class="music_more_singles_text">
                                <div class="music_more_singles_section">Singles</div>
                                <div class="music_more_singles_plus">
                                    <div>
                                        <select name="sor" id="sort">
								<option value="1">인기순</option>
								<option value="2">최신곡</option>
								<option value="3">이름순</option>
							</select>
                                    </div>
                                    <a href="">
                                        <div>모아보기</div>
                                    </a>
                                    <a href="">
                                        <div>리스트로보기</div>
                                    </a>
                                </div>
                            </div>
                            <div class="music_more_singles_inner">
                                <a href="#">
                                    <c:if test="${not empty slist}">
                                        <c:forEach items="${slist }" var="v" varStatus="s">
                                            <div class="music_more_singles_seriese">
                                                <table>
                                                    <tr>
                                                        <td><img src="image/bts-img.png" width="150px" height="150px"></td>
                                                    </tr>
                                                    <tr>
                                                        <td><a href="<%=request.getContextPath() %>/albumMoreServlet?al_no=${v.al_no }">${v.al_name}</a>
                                                        </td>
                                                    </tr>
                                                    <tr>
                                                        <td><a href="<%=request.getContextPath() %>/artistMoreServlet?art_no=${v.art_no }">${v.art_name}</td>
										</tr>
									</table>
								</div>
							</c:forEach>
						</c:if>
					</a>
                                            </div>
                            </div>

                            <hr>

                            <div class="music_more_related">
                                <div class="music_more_related_text">
                                    <div class="music_more_related_section">Related Music</div>
                                    <div class="music_more_related_plus">더보기</div>
                                </div>
                                <div class="music_more_related_inner">
                                    <c:if test="${not empty related }">
                                        <c:forEach items="${related }" var="v">
                                            <ul>
                                                <li>
                                                    <div class="music_more_related_another">
                                                        <div>
                                                            <a><img src="image/bts-img.png"></a>
                                                        </div>
                                                        <div class="music_more_related_title">
                                                            <a href="<%=request.getContextPath() %>/musicMoreServlet?mu_no=${v.mu_no }">${v.mu_name
                                                    }</a>
                                                        </div>
                                                        <div class="music_more_related_artist">
                                                            <a href="<%=request.getContextPath() %>/artistMoreServlet?art_no=${v.art_no }">${v.art_name
                                                    }</a>
                                                        </div>
                                                    </div>
                                                </li>
                                            </ul>
                                        </c:forEach>
                                    </c:if>
                                </div>
                            </div>

                            <hr>

                            <div class="music_more_comments">
                                <div class="music_comments_write">
                                    <form method="post" action="<%=request.getContextPath()%>/musicCommentWriteCtrl.lo" ">
						<%
							String mu_co_no = (request.getParameter("mu_co_no ") != null) ? request.getParameter("mu_co_no ") : "0 ";
						String mu_ref = (request.getParameter("mu_ref ") != null) ? request.getParameter("mu_ref ") : "0 ";
						String mu_step = (request.getParameter("mu_step ") != null) ? request.getParameter("mu_step ") : "0 ";
						String mu_level = (request.getParameter("mu_level ") != null) ? request.getParameter("mu_level ") : "0 ";
						String mu_no = (request.getParameter("mu_no ") != null) ? request.getParameter("mu_no ") : "0 ";
						%>
						<input type=" hidden " name="mu_co_no " value="<%=mu_co_no%>" class="commenthidden"> <input type="hidden" name="mu_ref" value="<%=mu_ref%>" class="commenthidden"> <input type="hidden" name="mu_step" value="<%=mu_step%>" class="commenthidden"> <input type="hidden" name="mu_level"
                                            value="<%=mu_level%>" class="commenthidden">
                                        <input type="hidden" name="mem_id" value="${mem_id }" class="commenthidden" id="mem_id"> <input type="hidden" name="mu_no" value="<%=mu_no%>" class="commenthidden">
                                        <table border="1">
                                            <tr>
                                                <td>글쓰기</td>
                                            </tr>
                                            <tr>
                                                <td><input type="text" name="mu_cont" id="mu_cont"></td>
                                                <tr>
                                                    <td colspan="2"><input type="submit" value="글등록"> <input type="reset" value="취소"></td>
                                                </tr>
                                        </table>
                                    </form>
                                </div>
                                <c:forEach items="${clist }" var="v" varStatus="s">
                                    <div class="music_comments_box">
                                        <div class="music_comments_author">
                                            <div class="music_comments_id">
                                                <a>${v.mem_id }</a>&nbsp;님
                                            </div>
                                        </div>
                                        <div class="music_comments_base">
                                            <div class="music_comments_date">${v.mu_date}</div>
                                            <div class="music_comments_report">
                                                <i class="far ${v.mu_co_no}f fa-angry" data-toggle="modal" data-target="#sendReport" onclick="reportshow('${v.mem_id }','${v.mu_co_no}');" style="float: right; padding: 15px 30px 10px 10px; font-size: 11px;">
									신고하기</i>
                                            </div>
                                        </div>
                                        <div class="music_comments_cont">${v.mu_cont }</div>
                                        <div class="music_comments_recomm">
                                            <div class="music_comments_recomm_area">
                                                <div class="music_comments_likes">
                                                    <%-- onclick="return confirm('추천하시겠습니까?')" href="./musicCommentLikePro.jsp?mem_id=${v.mem_id }" --%>
                                                        <div style="cursor: pointer;" onClick="golikeAdd('${v.mu_co_no}');" id="${ v.mu_co_no}like">
                                                            Like</div>
                                                        <!--                                     <div id="likeCnt"> </div>
 -->
                                                        <input type="hidden" value=${v.mu_co_no } id="com_like_no">
                                                        <%--                                     <div>${v.mu_co_no }</div>
 --%>
                                                </div>
                                                <div class="music_comments_hates">
                                                    <div style="cursor: pointer;" onClick="godislikeAdd('${v.mu_co_no}');" id="${v.mu_co_no}dislike">Dislike</div>
                                                    <!--                                     <div id="dislikeCnt"> </div>
 -->
                                                    <!-- {v.mu_hates} -->
                                                </div>
                                                <c:set var="writer" value="${mem_id } "></c:set>
                                                <c:if test="${mem_id eq v.mem_id }">
                                                    <div class="music_comments_delete">
                                                        <input type="button" onclick="window.location='musicCommentDeleteCtrl?mu_co_no=${v.mu_co_no}&mu_no=${v.mu_no }'" value="삭제">
                                                    </div>
                                                    <input type="hidden" name="mu_co_no1" value="${v.mu_co_no }">
                                                    <input type="hidden" name="mu_co_no2" value="${v.mu_co_no }">
                                                    <%-- <input type="button" style="cursor: pointer;"
                                        onclick="goLikeDislikeCount(${v.mu_co_no}, ${v.mu_co_no});" value="클릭"> --%>
                                                </c:if>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
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
                        <div class="modal" tabindex="-1" role="dialog" id="sendReport">
                            <div class="modal-dialog" role="document" style="width: 300px;">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title">신고 작성</h5>

                                    </div>
                                    <div class="modal-body">
                                        <p>신고사유 선택</p>
                                        <form id="reportform" class="sendReport">
                                            <div class="custom-control custom-radio">
                                                <input type="radio" id="customRadio1" name="reportReason" class="custom-control-input" value="F"> <label class="custom-control-label" for="customRadio1" style="font-size: 13px; padding-bottom: 6px;">욕설</label>
                                            </div>
                                            <div class="custom-control custom-radio">
                                                <input type="radio" id="customRadio2" name="reportReason" class="custom-control-input" value="A"> <label class="custom-control-label" for="customRadio2" style="font-size: 13px; padding-bottom: 6px;">음란물</label>
                                            </div>
                                            <div class="custom-control custom-radio">
                                                <input type="radio" id="customRadio3" name="reportReason" class="custom-control-input" value="R"> <label class="custom-control-label" for="customRadio3" style="font-size: 13px; padding-bottom: 6px;">허위사실</label>
                                            </div>
                                            <div class="custom-control custom-radio">
                                                <input type="radio" id="customRadio4" name="reportReason" class="custom-control-input" value="E"> <label class="custom-control-label" for="customRadio4" style="font-size: 13px;">기타</label> <input type="text"
                                                    class="form-control" id="reportContent" name="reportContent" placeholder="기타 내용을 입력하세요." style="font-size: 13px;" />
                                            </div>
                                            <input type="hidden" id="mem_id_forre" name="mem_id" value="">
                                            <input type="hidden" id="mu_co_no" name="mu_co_no" value="">
                                        </form>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal" onclick="closeModal('sendReport');" id="endReport">Close</button>
                                        <button type="button" class="btn btn-primary" id="addReport">send
							report</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <script>
                        // $("#com_like").click(function(){
                        // 	var showmemId = $("#mem_id").val();
                        // 	var showMuconu = $("#com_like_no").val();
                        // 	console.log(showmemId);
                        // 	console.log(showMuconu);

                        // 	$.ajax({
                        // 		type:"POST",
                        // 		url: "pressLikeInsertServlet.do",
                        // 		data:{
                        // 			mem_id:showmemId,
                        // 			mu_co_no:showMuconu
                        // 		},
                        // 		success:function(result){
                        // 			console.log("에이작스 성공!");
                        // 		}
                        // 	});
                        // });
                        function golikeAdd(mu_co_no) {
                            var showmemId = $("#mem_id").val();
                            console.log(showmemId);
                            console.log(mu_co_no);
                            $.ajax({
                                url: "likeAddAction",
                                type: "POST",
                                data: {
                                    mu_co_no: mu_co_no,
                                    mem_id: showmemId
                                },
                                success: function(result) {
                                    $("#" + mu_co_no + "like").css("color", "blue");
                                    $("#" + mu_co_no + "dislike").css("color", "black");
                                }
                            });
                        }

                        function godislikeAdd(mu_co_no) {
                            var showmemId = $("#mem_id").val();
                            console.log(showmemId);
                            console.log(mu_co_no);
                            $.ajax({
                                url: "dislikeAddAction",
                                type: "POST",
                                data: {
                                    mu_co_no: mu_co_no,
                                    mem_id: showmemId
                                },
                                success: function(result) {
                                    $("#" + mu_co_no + "like").css("color", "blue");
                                    $("#" + mu_co_no + "dislike").css("color", "black");
                                }
                            });
                        }

                        function goLikeDislikeCount(mu_co_no1, mu_co_no2) {
                            $.ajax({
                                url: "likeDisLikeCount",
                                data: {
                                    mu_co_no1: mu_co_no1,
                                    mu_co_no2: mu_co_no2
                                },
                                dataType: "json",
                                success: function(result) {
                                    console.log("카운트 성공!");
                                    console.log(mu_co_no1);
                                    console.log(mu_co_no2);
                                    $("#likeCnt").html(json.likecnt);
                                    $("#dislikeCnt").html(json.dislikecnt);
                                }
                            });
                        }

                        $(".music_comments_report").click(function() {
                            $(".modal").css("display", "block");
                        })

                        function reportshow(mem_id, mu_co_no) {
                            $("#mem_id_forre").attr('value', '' + mem_id + '');
                            $("#mu_co_no").val(mu_co_no);
                            $('#sendReport').on('shown.bs.modal');
                            console.log(mem_id);
                            console.log(mu_co_no);
                        };

                        $(function() {
                            $("#addReport").on(
                                "click",
                                function() {
                                    // if (!$("input:radio[name='reportReason']:checked").val()) {
                                    //     swal({
                                    //         icon: 'warning',
                                    //         title: '신고사유는 반드시 선택해주세요.',
                                    //         text: " ",
                                    //         button: false,
                                    //         timer: 700
                                    //     });
                                    //     return;
                                    // }
                                    // if ($("input:radio[id='customRadio4']").is(":checked") == true) {
                                    //     var reportContent = $("input[name='reportContent']").val();
                                    //     if (reportContent.trim() == 0 || reportContent.length < 1) {
                                    //         swal({
                                    //             icon: 'warning',
                                    //             title: '내용은 반드시 입력하세요.',
                                    //             text: " ",
                                    //             button: false,
                                    //             timer: 700
                                    //         });
                                    //         return;
                                    //     }
                                    // } else if ($("input:radio[id='customRadio4']").is(":checked") == false) {
                                    //     if ($("input[name='reportContent']").val() != "") {
                                    //         swal({
                                    //             icon: 'warning',
                                    //             title: '기타선택시 내용 작성이 가능합니다.',
                                    //             text: " ",
                                    //             button: false,
                                    //             timer: 700
                                    //         });
                                    //         return;
                                    //     }
                                    // }

                                    var showmemId = $("#mem_id").val();
                                    var showMuconuRe = $("#mu_co_no").val();
                                    var rpreason = $(
                                            "input:radio[name='reportReason']:checked")
                                        .val();
                                    var rptext = $("input[name='reportContent']").val();

                                    console.log(showmemId);
                                    console.log(showMuconuRe);
                                    $.ajax({
                                        url: "addReport",
                                        type: "POST",
                                        data: {
                                            mem_id: showmemId,
                                            mu_co_no: showMuconuRe,
                                            report_reason: rpreason,
                                            report_content: rptext
                                        },
                                        success: function(result) {
                                            $(".modal").css("display", "none");
                                            console.log(showmemId);
                                            console.log(showMuconuRe);
                                            console.log(rpreason);
                                            console.log(rptext);
                                        }
                                    });
                                });

                            $("#endReport").click(function() {
                                $(".modal").css("display", "none");
                            });
                        });
                    </script>
            </body>

            </html>