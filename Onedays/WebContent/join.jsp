<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Join Here</title>
    <link href="css/mainstyles.css" rel="stylesheet" type="text/css">
    <link href="css/style_join.css" rel="stylesheet" type="text/css">
</head>

<body>
    <!-- 상단  -->
    <header>
        <h1>
            <a href="index.jsp" style="color: #8EBCBB">One Days</a>
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
    <!-- 회원가입 form -->
    <div class="join">
        <h2 class="h2p">회원 가입</h2>
        <br/>
        <div class="join_wrap">
            <form method="post" action="doJoin">
                <div class=join_box>
                    <h5>아이디</h5>
                    <input type="text" placeholder="영문 소문자 /숫자, 4-16자" name="memid" required />
                </div>
                <br><br>
                <div class="join_box">
                    <h5>비밀 번호</h5>
                    <input type="password" placeholder="영문 대소문자/숫자/특수문자 중 2가지 이상, 8-16자" name="passwd" required />
                </div>
                <br><br>
                <div class="join_box">
                    <h5>비밀 번호 확인</h5>
                    <input type="password" name="passwd" required" />
                </div>
                <br><br>
                <div class=join_box>
                    <h5>이름</h5>
                    <input type="text" name="name" required />
                </div>
                <br><br>
                <div class=join_box>
                    <h5>전화 번호</h5>
                    <input type="text" name="phone" />
                </div>
                <br><br>
                <div class=join_box>
                    <h5>이메일</h5>
                    <input type="text" name="email" />
                </div>
                <br><br>
                <h5 style="color: #c0c0c0">지역</h5>
                <select name="region" class="region">
					<option value="">지역 선택</option>
					<option value="">서울</option>
					<option value="">경기</option>
					<option value="">충청도</option>
					<option value="">전라도</option>
					<option value="">경상도</option>
				</select> <br /> <br /> <input class="btn" type="submit" value="가입하기" /> <br />
                <br />
            </form>
        </div>
    </div>

</body>
</html>