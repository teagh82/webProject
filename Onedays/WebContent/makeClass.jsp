<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="model.ClassVO, java.util.ArrayList, javax.servlet.http.HttpSession"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>My Page</title>
    <link href="css/mainstyles.css" rel="stylesheet" type="text/css">
    <link href="css/style_mypage.css" rel="stylesheet" type="text/css">
    <link href="css/style_makeclass.css" rel="stylesheet" type="text/css">
	
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

</head>

<body>
    <jsp:include page="header.jsp" />

    <!-- 마이페이지 메뉴  -->
	<div class=mypage>
		<a href="myPage.jsp">마이페이지</a>
	</div>
	<div class="mypage_menu">
		<a href="myPage.jsp">개인 정보</a> <a href="apply.jsp">신청 현황</a> <a
			href="favorite.jsp">관심 등록</a> <a href="makeClass.jsp">클래스 만들기</a>
	</div>

	<div class=apply_item1>
		<h2>내가 만든 클래스</h2>
	</div>

	<jsp:useBean id="dao" class="model.MyPageDAO" />
	<%
		int userIdx = Integer.parseInt(session.getAttribute("user_idx").toString());
	ArrayList<ClassVO> list = dao.getMyRegistClass(userIdx);
	%>

	<!--클래스 목록-->
	<table class="pro_body">
		<%
			int cnt = 0;
		for (int i = 0; i <= (list.size() / 4); i++) {
		%>
		<tr>
			<%
				int lim;
			if (list.size() - cnt <= 4)
				lim = list.size() - cnt;
			else
				lim = 4;

			for (int j = 0; j < lim; j++) {
				int idx = (i * 4) + j;
				ClassVO vo = list.get(idx);
				cnt++;
			%>
			<td style="padding: 10px;">
				<li class="list"><a
					href="detail.jsp?classIdx=<%=vo.getClassIdx()%>" class="lista">
						<img
						src="${pageContext.request.contextPath}/uploadImg/<%=vo.getImage() %>"
						alt="" class="img">
						<h3><%=vo.getName()%>
							클래스
						</h3>
						<p><%=vo.getPrice()%>원
						</p> <%
 	switch (vo.getClassRegionIdx()) {
 case 1:
 %>
						<h4 style="padding: 0 5px 5px;">서울</h4> <%
 	break;
 	case 2:
 %>
						<h4 style="padding: 0 5px 5px;">경기</h4> <%
 	break;
 		case 3:
 %>
						<h4 style="padding: 0 5px 5px;">충청도</h4> <%
 	break;
 		case 4:
 %>
						<h4 style="padding: 0 5px 5px;">전라도</h4> <%
 	break;
 		case 5:
 %>
						<h4 style="padding: 0 5px 5px;">경상도</h4> <%
 	break;
 		}
 %>

				</a></li>
			</td>
			<%
				}
			%>
		</tr>
		<%
			}
		%>
	</table>


	<div class="make_class">
		<a href="makeCPage.jsp">새로운 클래스를 만들러 가기</a>
	</div>

</body>

</html>