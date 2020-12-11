<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>알림</title>

 <link href="css/mainstyles.css" rel="stylesheet" type="text/css">
 <link href="css/style.css" rel="stylesheet" type="text/css">
 
</head>
<body>
<% if(session.getAttribute("mid")==null || session.isNew()){
	   out.println("<script>alert('로그인 후 이용해주세요.'); location.replace(\"login.jsp\"); </script>");
	   return;
   }
	else{ 
	String check = session.getAttribute("apply_check").toString();
	if(check.equals("ok")){
		session.setAttribute("apply_check", "no");
	%>
		클래스 신청이 완료되었습니다.	
	<%} else{%>
		알림이 없습니다.
	<%}} %>
	


</body>
</html>