<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to OneDays</title>
<link href="css/mainstyles.css" rel="stylesheet" type="text/css">
<link href="css/style.css" rel="stylesheet" type="text/css">
<link href="css/style_worldcup.css" rel="stylesheet" type="text/css">
<link href="css/style_login.css" rel="stylesheet" type="text/css">

<script>
	function popup() {
		var url = "notice.jsp";
		var name = "popup test";
		var option = "width = 500, height = 100, top = 100, left = 800, location = no"
		window.open(url, name, option);
	}
	
	function searchCheck(frm){
        //검색
        if(frm.keyWord.value ==""){
            alert("검색 단어를 입력하세요.");
            frm.keyWord.focus();
            return;
        }
        frm.submit();   
        location.href = "search.jsp";
    }
</script>
<style>
.btn2 {
	background-color: #8EBCBB;
	border: 5px solid #8EBCBB;
	border-radius: 3em;
	font-size: 30px;
	color: white;
	text-align: center;
}
</style>
</head>
<body>
	<jsp:include page="header.jsp" />
	<br>

	<div class="logo_div">
		<img src="imgs/joinS.png" class="logo">
	</div>
	<br>
	<br>
	<br>
	<br>
	<h1
		style="color: #8EBCBB; text-align: center; min-width: 1500px; max-width: 100%; font-size: 50px;">Welcome
		to OneDays !</h1>
	<br>
	<br>
	<br>
	<br>
	<h2 style="text-align: center; min-width: 1500px; max-width: 100%;">
		회원가입을 정상적으로 완료하였습니다.</h2>
	<br>
	<br>
	<br>
	<a href="login.jsp" style="padding-left: 200px;">
		<div style="padding-left: 300px; padding-right: 300px;">
			<div class="btn2">로그인하러 가기</div>
		</div>
	</a>

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

<div style="clear: both;"></div>
	<br>
	<br>
	<br>
	<br>
	<br>
	<jsp:include page="footer.jsp" />


</body>
</html>