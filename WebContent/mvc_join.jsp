<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 페이지</title>
</head>
<body>
	<form action="JoinAction.bo" method="post">
		<table border="1">
			<tr>
				<td colspan="2">회원가입</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pw"></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="email" name="id"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="가입하기"></td>
			</tr>
		</table>
	</form>
</body>
</html>