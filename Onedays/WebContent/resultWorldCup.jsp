<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Result of WorldCup</title>
	<link href="css/mainstyles.css" rel="stylesheet" type="text/css">
	<link href="css/style_login.css" rel="stylesheet" type="text/css">
	<link href="css/style_worldcup.css" rel="stylesheet" type="text/css">
	
	<style>
		.wa {border: 2px solid #8EBCBB;  background-color:#8EBCBB; padding: 10px; font-color: white; font-size: 22px;}
		a:hover {color: white;}
		a:link {color: white;}
		a:visited {color: white;}
		p { font-size: 40px; }
		
	</style>
	
</head>
<body>
	<jsp:include page="header.jsp" />
	
	<div class="logo_div">
		<h1 style="text-align: center; padding: 5px; color: #808080;">클래스
			월드컵</h1> 
	</div>
	
	<div style="min-width:1500px; width:100%;">
	
	<%String name = request.getParameter("name");
	String n = name.substring(12, name.length()-4); 
	%>
	
	<%int[] catNum = {3,3,9,10,2,2,8,5,6,7,4,5,6,1,1,4}; 
	int cat_n = catNum[Integer.parseInt(n)-1];%>
	
	<%String[] cat = {"공예", "요리", "악기", "IT", "액티비티", "미술", "디자인", "뷰티", "반려동물", "플라워"};%>
	
	<p class="rs" style="
    width: 100%;text-align:center; padding-top: 150px;"><font color='red'><%= cat[cat_n-1]%> 클래스</font>를 제일 좋아하시는 군요!</p>
    
   
   <div style="clear:both;"></div>
   <br><br><br><br><br><br>
   
    <div style="width:100%; text-align: center; ">
    
    <%String jspcat[] = {"craftsCat.jsp", "cookCat.jsp","instCat.jsp","itCat.jsp","activityCat.jsp","artCat.jsp","designCat.jsp","beautyCat.jsp","petCat.jsp","flowerCat.jsp"}; %>
    
    <a href="<%=jspcat[cat_n-1] %>" class="wa">관련 클래스 둘러보기!</a>
    </div>
    
    <br><br><br><br>
    
    <div style="width:100%; text-align: center; ">
    <a href="index.jsp" class="wa">메인으로 돌아가기</a>
    </div>
    </div>

</body>
</html>