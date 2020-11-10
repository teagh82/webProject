<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>원데이즈 기능</title>
</head>
<body>
	<h1 align="center">기능</h1>
	<p> User selected state : <% out.print((String) request.getAttribute("state")); %>
	<p>
		<%
		List styles = (List) request.getAttribute("next");
		Iterator it = styles.iterator();
		while (it.hasNext()) {
			out.print("<br>try: " + it.next());
		}
		%>
	
</body>
</html>