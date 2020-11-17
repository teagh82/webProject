<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*" import="model.DBUtil" %>
<%
String mid = request.getParameter("mid");
String passwd = request.getParameter("passwd");

ServletContext sc = getServletContext();
Connection conn = (Connection) sc.getAttribute("DBconnection");

ResultSet rs = DBUtil.login(conn, mid);

if (rs != null) {
	try {
		if (rs.next()) { // existing user
			String checkpw = rs.getString(1);
			if (checkpw.equals(passwd)) { // valid user and password
				session.setAttribute("mid",mid);
				session.setAttribute("passwd",passwd);
				response.sendRedirect("index.jsp"); 
	
			} else { // wrong password
				System.out.println("Wrong Passwd!!");
				out.println("<script>alert('비밀번호가 틀렸습니다.'); history.back(); </script>");
			}
		} else { // invalid user
			out.println("<script>alert('존재하지 않는 사용자입니다.'); history.back(); </script>");
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
%>