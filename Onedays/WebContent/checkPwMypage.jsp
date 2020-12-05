<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyPage</title>
<link href="css/mainstyles.css" rel="stylesheet" type="text/css">
<link href="css/style_mypage.css" rel="stylesheet" type="text/css">

<script>
	function popup() {
		var url = "notice.jsp";
		var name = "popup test";
		var option = "width = 500, height = 100, top = 100, left = 800, location = no"
		window.open(url, name, option);
	}

	function searchCheck(frm) {
		//검색
		if (frm.keyWord.value == "") {
			alert("검색 단어를 입력하세요.");
			frm.keyWord.focus();
			return;
		}
		frm.submit();
		location.href = "search.jsp";
	}
</script>
</head>
<body>
		<jsp:include page="header.jsp" />

	<!-- 마이페이지 메뉴  -->
	<div class=mypage>
		<a href="checkPwMypage.jsp">마이페이지</a>
	</div>
	<div class="mypage_menu">
		<a href="checkPwMypage.jsp">개인 정보</a> <a href="apply.jsp">신청 현황</a> <a
			href="favorite.jsp">관심 등록</a> <a href="makeClass.jsp">나의 클래스</a>
	</div>
	<!-- 개인정보 수정 전 본인확인 -->
	<div class="mypage_wrap">
		<h2>개인 정보</h2>
		<br>
		<h3 style="text-align: center">비밀번호를 다시 한 번 입력하세요!</h3>
		<br>
		<form method="post" action="CheckPasswd">
			<div class="login_box">
				<input type="password" placeholder="PassWord" name="passwd"
					style="margin-left: 45%" />
			</div>
			<input class="btn" type="submit" value="확인"
				style="margin-left: 40%" /> <br /> <br />
		</form>


	</div>

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