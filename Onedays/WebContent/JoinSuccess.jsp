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
	<!-- 상단  -->
	<header>
		<h1>
			<a href="index.jsp" style="color: #8EBCBB"
				style="text-decoration:none">One Days</a>
		</h1>
		<div class="navbar">
			<div class="search">
			<form name="serach" method ="post" action="search.jsp">
                <input type="text" name="keyWord" placeholder="검색어를 입력해주세요.">
				<input type="submit" value="검색" onclick="searchCheck(form)" />
            </form>
            </div>
			<div class="dropdown">
				<ul>
					<li><a href="javascript:popup()">알림</a></li>

					<%
						if (session.getAttribute("mid") == null) {
					%>
					<li><a href="login.jsp" style="color: #8EBCBB"
						style="text-decoration:none">로그인</a></li>
					<%
						} else {
					%>
					<li><%=session.getAttribute("mid")%>님
						<ul>
							<li><a href="myPage.jsp">마이페이지</a>
							<li><a href="logout.jsp">로그아웃</a>
						</ul></li>
					<%
						}
					%>

				</ul>
			</div>
			<div style="clear: both;"></div>
		</div>


	</header>
	<!-- 메뉴  -->
	<input type="checkbox" id="menuicon">
	<label for="menuicon"> <span></span> <span></span> <span></span>
	</label>
	<div class="sidebar">
		<h1 class="category">카테고리</h1>
		<hr>
		<ul class="item">
			<li><a href="craftsCat.jsp">공예</a></li>
			<li><a href="cookCat.jsp">요리</a></li>
			<li><a href="instCat.jsp">악기</a></li>
			<li><a href="itCat.jsp">IT</a></li>
			<li><a href="activityCat.jsp">액티비티</a></li>
		</ul>

	</div>
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