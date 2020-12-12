<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="model.ClassVO"
	import="java.util.ArrayList" import="java.util.*"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>search</title>
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
    <h2>검색 결과</h2>

	<jsp:useBean id="dao" class="model.ClassDAO" />
	<%
    String keyWord = new String(request.getParameter("keyWord").getBytes("ISO-8859-1"), "UTF-8");
    ArrayList<ClassVO> list = dao.getSearchlist(keyWord);
    %>
	<!--클래스 목록-->
	<%
     if(list.size() == 0){
    	 %>
	<div style="clear: both; margin: 150px;"></div>
	<h2 style="text-align: center;">해당 클래스가 없습니다.</h2>
	<div style="clear: both; margin: 150px;"></div>
	<%
     }
     else{
     %>

	<table class="pro_body">
		<%
		int cnt = 0;
    	for(int i = 0; i <= (list.size() / 4); i++){
    	%>
		<tr>
			<%
			int lim;
			if(list.size() - cnt <= 4)
				lim = list.size() - cnt;
			else
				lim = 4;
			
			for(int j = 0; j < lim; j++){
				int idx = (i*4)+j;
	    		ClassVO vo = list.get(idx);
	    		cnt++;
	    	%>
			<td style="padding: 10px;">
				<li class="list" style="width:350px;">
					<a href="detail.jsp?classIdx=<%=vo.getClassIdx()%>" class="lista">
					
					<%String imgsrc = vo.getImage();
					if(imgsrc.length()>15){
						if(imgsrc.substring(0,15).equals("https://onedays")){ %>
                  			<img src="<%=vo.getImage() %>" alt="" class="img">
                         <%
                         }
						else {%>
          				<img src="${pageContext.request.contextPath}/uploadImg/<%=vo.getImage() %>" alt="" class="img">
                    <%}
					}
                    else {%>
          				<img src="${pageContext.request.contextPath}/uploadImg/<%=vo.getImage() %>" alt="" class="img">
                    <%} %>
                    
						<h3><%=vo.getName() %>
							클래스
						</h3>
						<p><%=vo.getPrice() %>원
						</p> <%
                   		switch(vo.getClassRegionIdx()){
                   		case 1: %>
						<h4 style="padding: 0 5px 5px;">서울</h4> <% 
                   			break;
                   		case 2:%>
						<h4 style="padding: 0 5px 5px;">경기</h4> <%
                   			break;
                   		case 3:%>
						<h4 style="padding: 0 5px 5px;">충청도</h4> <%
                   			break;
                   		case 4:%>
						<h4 style="padding: 0 5px 5px;">전라도</h4> <%
                   			break;
                   		case 5:%>
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
	   <%} %>

	<br>
	<div style="clear: both;"></div>
	<br>
	<br>
	<br>

	<jsp:include page="footer.jsp" />

</body>

</html>