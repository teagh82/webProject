<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Page</title>
<link href="css/mainstyles.css" rel="stylesheet" type="text/css">
<link href="css/style_mypage.css" rel="stylesheet" type="text/css">

<script>
        function popup(){
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
</head>
<body>
	<jsp:include page="header.jsp" />

	<!-- 마이페이지 메뉴  -->
	<div class=mypage>
		<a href="myPage.jsp">마이페이지</a>
	</div>
	<div class="mypage_menu">
		<a href="myPage.jsp">개인 정보</a> <a href="apply.jsp">신청 현황</a> <a
			href="favorite.jsp">관심 등록</a> <a href="makeClass.jsp">나의 클래스</a>
	</div>

	<!-- 개인정보 수정 -->
	<div class="mypage_wrap">
		<h2>개인 정보</h2>
		<br />
		<form method="post" action="UpdateUserInfo">
			<div class=mypage_box>
				<h5>아이디</h5>
				<input type="text" name="mid" required/>
			</div>
			<div class="mypage_box">
				<h5>비밀 번호</h5>
				<input type="password" name="passwd" required/>
			</div>
			<div class=mypage_box>
				<h5>이름</h5>
				<input type="text" name="userName" required/>
			</div>
			<div class=mypage_box>
				<h5>전화 번호</h5>
				<input type="tel" name="phone" required/>
			</div>
			<div class=mypage_box>
				<h5>이메일</h5>
				<input type="email" name="email" required/>
			</div>
			<div class=region>
				<h5>지역</h5>
			</div>
			<div class=region_select>
				<select name="region">
					<option value="0">지역 선택</option>
					<option value="1">서울</option>
					<option value="2">경기</option>
					<option value="3">충청도</option>
					<option value="4">전라도</option>
					<option value="5">경상도</option>
				</select>
			</div>
			<div class=btn_box>
				<input class=btn type="submit" value="수정하기" />
			</div>
		</form>

	</div>
</body>
</html>