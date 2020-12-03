<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Inquiry</title>
<link href="css/mainstyles.css" rel="stylesheet" type="text/css">
    <link href="css/style_login.css" rel="stylesheet" type="text/css">
    <link href="css/style_cat.css" rel="stylesheet" type="text/css">

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
					<li><a href = "javascript:popup()">알림</a></li>
                    
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

	<!-- 문의 남기기 -->
	
	<h1>문의</h1>
	<div class="container">
		<div class="row">
			<form method="post" action="">
				<table class="table">
					<thead>
						<tr>
							<th colspan="2"
								style="background-color: #c0c0c0;  color: white; text-align: center;">문의
								남기기</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="text" class="form-control" placeholder="제목"
								maxlength="50"></td>
						</tr>
						<tr>
							<td><textarea class="form-control" placeholder="글 내용"
									maxlength="2048" style="height: 350px;"></textarea></td>
						</tr>
					</tbody>
				</table>
				<div class="form_btn_box">
					<input class="form_btn" type="submit" value="문의 남기기" />
				</div>
			</form>
		</div>
	</div>


</body>
</html>