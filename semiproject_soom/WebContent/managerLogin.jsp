<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form name="login" action="ManagerLoginCtrl" method="post">
		<table border=1 style="margin-left:auto; margin-right:auto; ">
			<tr>
				<td colspan="2" align="center"><b><font size=5>LOGIN</font></b></td>
			</tr>
			<tr align="center">
				<td>아이디 :</td>
				<td><input type="text" name="mng_id" id="mng_id"></td>
			</tr>
			<tr align="center">
				<td>비밀번호 :</td>
				<td><input type="password" name="mng_pwd" id="mng_pwd"></td>
			</tr>
			<tr>
				<td colspan="2"  align="center">
					<input type="submit" value="login">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>