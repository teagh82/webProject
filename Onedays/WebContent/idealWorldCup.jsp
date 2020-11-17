<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link href="css/mainstyles.css" rel="stylesheet" type="text/css">
    <link href="css/style_login.css" rel="stylesheet" type="text/css">
    <link href="css/style_worldcup.css" rel="stylesheet" type="text/css">
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

    <br style="clear: both;">


    <div class="logo_div"><img src="imgs/wdclogo.png" class="logo"></div>

    <div style="margin: 30px; font-size: 35px">
        <p class="round">64&nbsp</p>
        <p>강</p>
    </div>

    <br style="clear: both;">

    <div style="min-width: 1500px; width: 100%;" class="width">
        <div style="float: left;">
            <input type="image" name="button" src="imgs/flower.png" width="500px" height="600px" lass="img">
            <!-- <ig src="imgs/flower.png" width="500px" height="600px" class="img">  -->
            <h3 style="text-align: center;">00 클래스</h3>
        </div>
        <div style="float: left;">
            <p style="font-size: 40px; padding-top: 250px;" width="20px" height="600px">VS</p>
        </div>
        <div style="float: left;">
            <input type="image" name="button" src="imgs/flower.png" width="500px" height="600px" lass="img">
            <h3 style="text-align: center;">00 클래스</h3>
        </div>
    </div>

    <br style="clear: both;">

    <br style="margin-top: 100px;">

</body>

</html>