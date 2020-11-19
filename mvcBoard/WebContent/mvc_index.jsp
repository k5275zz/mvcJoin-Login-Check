<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList"%>
<%@page import="net.board.db.LoginBean" %>
<%@ page import="java.io.PrintWriter" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	// ArrayList<LoginBean> list = (ArrayList<LoginBean>)request.getAttribute("loginlist");
	int logincheck=(int)request.getAttribute("logincheck");
	
	if(logincheck==1){}else {
		PrintWriter script = response.getWriter();
		script.println("<script>");
		script.println("alert('비밀번호가 틀렸습니다.');");
		script.println("location.href='mvc_Login.jsp';");//특정 페이지 화면으로 이동
		script.println("</script>");
		script.close();
	}
	
	
	
%>
</head>
<body>
<h1>메인페이지</h1>
	<form action="" method="post">
		<table border="1">
			<tr>
				<td></td>
				<td></td>
			</tr>
		
			<tr>
				<td><input type="submit" value="글쓰기"></td>
			</tr>
		</table>
	</form>
</body>
</html>