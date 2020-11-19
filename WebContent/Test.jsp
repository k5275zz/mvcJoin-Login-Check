<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%
	Connection con =null;
	try{
		Context init = new InitialContext();
		DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/mysql");
		con = ds.getConnection();
		out.println("<h3>연결되었습니다.</h3>");
	}catch(Exception e){
		out.println("<h3>연결실패하였습니다.</h3>");
		e.printStackTrace();
	}

%>
</head>
<body>

</body>
</html>