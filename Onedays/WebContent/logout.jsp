<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<%
	if(session!=null) session.invalidate();
	response.sendRedirect("login.jsp");
%>
</body>
</html>