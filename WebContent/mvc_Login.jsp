<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginCheckAction.bo" method="post">
		<table border="1">
			<tr>
				<td colspan="2">로그인</td>
			</tr>
			<tr>
				<td>아이디</td>
				<td><input type="text" name="id"></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" name="pw"></td>
			</tr>
			<tr>
				<td><input type="submit" value="로그인"></td>
				<td><input type="button" value="회원가입" onclick="location.href='mvc_join.jsp'"></td>
			</tr>
		</table>
	</form>
</body>
</html>