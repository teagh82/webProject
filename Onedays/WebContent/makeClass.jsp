<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>My Page</title>
    <link href="css/mainstyles.css" rel="stylesheet" type="text/css">
    <link href="css/style_mypage.css" rel="stylesheet" type="text/css">
    <link href="css/style_makeclass.css" rel="stylesheet" type="text/css">
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

    <h2 class="class_list">내가 만든 클래스 목록</h2>

    <div class="pro_body" style="padding-top: 5px;">
        <br>
        <ul class="list">
            <li>
                <a href="#a" class="lista">
                    <img src="classimg/test3.png" alt="" class="img">
                    <h3>클래스 이름</h3>
                    <p>0,000원</p>
                    <h4 style="padding: 0 5px 5px;">서울</h4>
                </a>
            </li>

            <li>
                <a href="#a" class="lista">
                    <img src="classimg/test3.png" alt="" class="img">
                    <h3>클래스 이름</h3>
                    <p>0,000원</p>
                    <h4 style="padding: 0 5px 5px;">서울</h4>
                </a>
            </li>

            <li>
                <a href="#a" class="lista">
                    <img src="classimg/test3.png" alt="" class="img">
                    <h3>클래스 이름</h3>
                    <p>0,000원</p>
                    <h4 style="padding: 0 5px 5px;">서울</h4>
                </a>
                <div class="mark">
                    <div>HOT</div>
                </div>
            </li>
            <li>
                <a href="#a" class="lista">
                    <img src="classimg/test3.png" alt="" class="img">
                    <h3>클래스 이름</h3>
                    <p>0,000원</p>
                    <h4 style="padding: 0 5px 5px;">서울</h4>
                </a>
                <div class="mark">
                    <div>HOT</div>
                </div>
            </li>
        </ul>
        <div style="clear: both;"></div>
        <br><br><br>
    </div>


    <div class="make_class"><a href="makeCPage.jsp">새로운 클래스를 만들러 가기</a></div>

</body>

</html>