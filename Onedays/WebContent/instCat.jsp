<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.ClassVO"
	import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>inst</title>
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

    <jsp:include page="header.jsp" />

    <h2>악기 클래스</h2>
	<h3 class="cr">지역</h3>
	<form action="instCatR.jsp">

    <div class="cat_region">
    <select name="region" id="region" onchange="this.form.submit();">
        <option value="-1" selected>지역 선택</option>
        <option value="1">서울</option>
        <option value="2">경기</option>
        <option value="3">충청도</option>
        <option value="4">전라도</option>
        <option value="5">경상도</option>
    </select>
    </div>
    
    </form>

	<jsp:useBean id="dao" class="model.ClassDAO" />
	<%
		ArrayList<ClassVO> list = dao.getCategorylist(3);
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
				<li class="list" style="width:350px;"><a
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
			<%if (cnt<4) {
     		for(;cnt<4;cnt++) {%>
     		<td style="padding:10px;">
            		<li class="list" style="width: 350px;" >
                		
            		</li> 	
			</td>
			 <%}} %>
		</tr>
		<%
			}
		%>
	</table>

	<div style="clear: both;"></div>
	<br>
	<br>
	<br>
	</div>


	<div style="clear: both;"></div>
	<br>
	<br>
	<br>

	<jsp:include page="footer.jsp" />
</body>

</html>