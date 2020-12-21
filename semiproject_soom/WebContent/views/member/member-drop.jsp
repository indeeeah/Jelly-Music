<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% request.setCharacterEncoding("UTF-8"); %>
<% response.setContentType("text/html; charset='UTF-8'"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <form name="registerdrop" action="../Memberdrop" method="post">
                <div>
                    <h3 class="join_title"><label for="mem_pwd">비밀번호를 입력해주세요</label></h3>
                    <span class="box int_pass">
                        <input type="password" id="mem_pwd" name="mem_pwd" class="int" maxlength="20">
                        
                  <div class="btn_area">
                    <button type="submit" id="btnJoin">
                        <span>삭제하기</span>
                    </button>
                     
                </div>
                <div class="btn_area">
                    <button type="reset" id="btnCancel">
                        <span>취소</span>
                    </button>
                     
                </div>

                     
                </div>
                </form>
</body>
</html>