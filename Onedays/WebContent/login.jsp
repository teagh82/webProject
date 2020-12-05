<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.ClassDAO"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
<link href="css/mainstyles.css" rel="stylesheet" type="text/css">
<link href="css/style_login.css" rel="stylesheet" type="text/css">

<script>
        function popup(){
            var url = "notice.jsp";
            var name = "popup test";
            var option = "width = 500, height = 100, top = 100, left = 800, location = no"
            window.open(url, name, option);
        }
    </script>
</head>
<body>

	<jsp:include page="header.jsp" />
	
	<% ClassDAO.closeClass(); %>
		
		<!-- 로그인  -->
		<div class="left">
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<h2>로그인</h2>
			<br />
			<div class="login">
				<form method="post" action="doLogin">
				<div class="login_box">
					<input type="text" placeholder="User Id" name="mid" />
				</div>
				<div class="login_box">
					<input type="password" placeholder="PassWord" name="passwd" />
				</div>
				<input class="btn" type="submit" value="LOGIN" /> <br /> <br /> <a
					href="join.jsp" style="color: #808080" style="text-decoration:none">회원가입
				</a> <br />
	</form>
	</div>
	</div>

	<!-- 이미지 삽입  -->
	<div class="right">
		<div class="img">
			<img src="imgs/flower.png" width="650px" height=auto text-align=right>
		</div>
	</div>
	
	<div style="clear: both;"></div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<jsp:include page="footer.jsp" />

</body>
</html>