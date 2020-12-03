<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
	<div class="sidebar" style="overflow:auto;" >
        <h1 class="category">카테고리</h1>
        <ul class="item">
            <li><a href="craftsCat.jsp">공예</a></li>
            <li><a href="cookCat.jsp">요리</a></li>
            <li><a href="instCat.jsp">악기</a></li>
            <li><a href="itCat.jsp">IT</a></li>
            <li><a href="activityCat.jsp">액티비티</a></li>
            <li><a href="artCat.jsp">미술</a></li>
            <li><a href="designCat.jsp">디자인</a></li>
            <li><a href="beautyCat.jsp">뷰티</a></li>
            <li><a href="petCat.jsp">반려동물</a></li>
            <li><a href="flowerCat.jsp">플라워</a></li>
        </ul>
		<label for="menuicon"></label>
	</div>
	<br>

</body>
</html>