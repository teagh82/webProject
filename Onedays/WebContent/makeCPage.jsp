<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>My Page</title>
    <link href="css/mainstyles.css" rel="stylesheet" type="text/css">
    <link href="css/style_mypage.css" rel="stylesheet" type="text/css">
</head>

<body>
    <!-- 상단  -->
    <header>
        <h1>
            <a href="index.jspl" style="color: #8EBCBB" style="text-decoration:none">One Days</a>
        </h1>
        <div class="navbar">
            <div class="search">
                <input type="text" placeholder="검색어를 입력해주세요.">
                <button>검색</button>

            </div>
            <div class="dropdown">
                <ul>
                    <li>알림</li>
                    <%
					if(session.getAttribute("mid") == null) {
					%>
						<li><a href="login.jsp" style="color: #8EBCBB" style="text-decoration:none">로그인</a>
	                    </li>
					<%
					} else{
					%>
					<li><%= session.getAttribute("mid") %>님
                        <ul>
                            <li><a href="myPage.jsp">마이페이지</a>
                                <li><a href="logout.jsp">로그아웃</a>
                        </ul>
                    </li>
 					<%
					}
					%>

                </ul>

            </div>
        </div>

    </header>

    <!-- 메뉴  -->
    <input type="checkbox" id="menuicon">
    <label for="menuicon"> <span></span> <span></span> <span></span>
	</label>
    <div class="sidebar">
        <h1 class="category">카테고리</h1>
        <ul class="item">
            <li><a href="craftsCat.jsp">공예</a></li>
            <li><a href="cookCat.jsp">요리</a></li>
            <li><a href="instCat.jsp">악기</a></li>
            <li><a href="itCat.jsp">IT</a></li>
            <li><a href="activityCat.jsp">액티비티</a></li>
        </ul>
    </div>

    <!-- 마이페이지 메뉴  -->
    <div class=mypage>
        <a href="myPage.jsp">마이페이지</a>
    </div>
    <div class="mypage_menu">
        <a href="myPage.jsp">개인 정보</a> <a href="apply.jsp">신청 현황</a> <a href="#">관심
			등록</a> <a href="makeClass.jsp">클래스 만들기</a>
    </div>

    <!-- 개인정보 수정 -->
    <div class="mypage_wrap">
        <h2 style="color: #8EBCBB; min-width: 1500px;">새로운 클래스 만들기</h2>
        <br />
        <form method="post" action="#" style="min-width: 1500px;">
            <div class=mypage_box>
                <h5>클래스 이름</h5>
                <input type="text" name="mid" />
            </div>
            <div class="mypage_box">
                <h5>난이도</h5>
                <input type="text" name="난이도" />
            </div>
            <div class=mypage_box>
                <h5>준비물</h5>
                <input type="text" name="준비물" />
            </div>
            <div class=mypage_box>
                <h5>수강일수</h5>
                <input type="text" name="수강일수" />
            </div>
            <div class=mypage_box>
                <h5>날짜</h5>
                <input type="date" name="날짜" />
            </div>
            <div class=mypage_box>
                <h5>작가 소개</h5>
                <input type="text" name="자기 소개" />
            </div>
            <div class=mypage_box>
                <h5>클래스 사진 넣기</h5>
                <input type="text" name="사진 넣기" />
            </div>
            <div class=region>
                <h5>지역</h5>
            </div>
            <div class=region_select>
                <select name="region">
					<option value="">지역 선택</option>
					<option value="">서울</option>
					<option value="">경기</option>
					<option value="">충청도</option>
					<option value="">전라도</option>
					<option value="">경상도</option>
				</select>
            </div>
            <div class=btn_box>
                <input class=btn type="submit" value="클래스 만들기" />
            </div>
        </form>

    </div>


</body>

</html>