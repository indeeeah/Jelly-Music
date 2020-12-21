<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = (String) session.getAttribute("idKey"); //세션에서 idkey를 가져온다
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-3.4.0.js"></script>
<script type="text/javascript">
	function loginCheck() {
		if (document.loginFrm.id.value == "") {
			alert("아이디를 입력해 주세요.");
			document.loginFrm.id.focus();
			return;
		}
		if (document.loginFrm.pwd.value == "") {
			alert("비밀번호를 입력해 주세요.");
			document.loginFrm.pwd.focus();
			return;
		}
		document.loginFrm.submit();
	}
</script>
</head>
<body>

	<form action="<%=request.getContextPath()%>/loginServlet" method="post">
        <table>
        <caption>로그인 화면</caption>
        <tr>
            <td>아이디 : </td><td><input type="text" name="id"></td>
        </tr>
        <tr>
            <td>비밀번호 : </td><td><input type="password" name="pw"></td>
        </tr>
        <tr>
            <td><input type="submit" value="로그인"></td><td><input type="reset" value="초기화"></td>
        </tr>
    </table>
    </form>
</body>
</html>