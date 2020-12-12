<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>Join Here</title>
<link href="css/mainstyles.css" rel="stylesheet" type="text/css">
<link href="css/style_join.css" rel="stylesheet" type="text/css">

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

	<!-- 회원가입 form -->
	<div class="join">
		<h2 class="h2p">회원 가입</h2>
		<br />
		<div class="join_wrap">
			<form method="post" action="doJoin">
				<div class=join_box>
					<h5>아이디</h5>
					<input type="text" placeholder="영문 소문자 /숫자, 4-16자" name="memid"
						required />
				</div>
				<br> <br>
				<div class="join_box">
					<h5>비밀 번호</h5>
					<input type="password" id="pw" onChange="doubleCheck()"
						placeholder="영문 대소문자/숫자/특수문자 중 2가지 이상, 6-16자" name="passwd"
						required />
				</div>
				<br> <br>
				<div class="join_box">
					<h5>비밀 번호 확인</h5>
					<input type="password" id="pw2" onChange="doubleCheck()"
						name="passwd2" required /><span id="check"></span>
				</div>
				<br> <br>
				<div class=join_box>
					<h5>이름</h5>
					<input type="text" name="name" required />
				</div>
				<br> <br>
				<div class=join_box>
					<h5>전화 번호</h5>
					<input type="text" name="phone" />
				</div>
				<br> <br>
				<div class=join_box>
					<h5>이메일</h5>
					<input type="text" name="email" />
				</div>
				<br> <br>
				<h5 style="color: #c0c0c0">지역</h5>
				<select name="region" class="region" id="region" onChange="search()">
					<option value="0">지역 선택</option>
					<option value="1">서울</option>
					<option value="2">경기</option>
					<option value="3">충청도</option>
					<option value="4">전라도</option>
					<option value="5">경상도</option>
				</select> <br /> <br /> <input class="btn" type="submit" value="가입하기"
					onSubmit="search()" /> <br /> <br />
			</form>
		</div>
	</div>
	<script>
		function doubleCheck() {

			var pw = document.getElementById('pw').value;
			
			if (document.getElementById('pw').value != ''
					&& document.getElementById('pw2').value != '') {
				if (document.getElementById('pw').value == document
						.getElementById('pw2').value) {
					document.getElementById('check').innerHTML = '비밀번호가 일치합니다.'
					document.getElementById('check').style.color = 'blue';
				} else {
					document.getElementById('check').innerHTML = '비밀번호가 일치하지 않습니다.';
					document.getElementById('check').style.color = 'red';
				}
			}
		}
	</script>
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