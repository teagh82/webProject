<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="model.ClassDAO, model.ReviewDAO, model.ReviewVO, java.sql.*, javax.servlet.http.HttpSession, java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>OOO Class</title>
<link href="css/mainstyles.css" rel="stylesheet" type="text/css">
<link href="css/style_detail.css" rel="stylesheet" type="text/css">

<script>
   var cnt = 1;
   
   function popup() {
      var url = "notice.jsp";
      var name = "popup test";
      var option = "width = 500, height = 100, top = 100, left = 800, location = no"
      window.open(url, name, option);
   }
   
   function change() {
        var xyz = document.getElementById("xyz");
        
        if(cnt%2==1) {
           xyz.src="imgs/heart.png";
        }
        else{
           xyz.src = "imgs/heart2.png";
        }
        cnt++;
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

	<%
      request.setCharacterEncoding("euc-kr");
   %>

	<jsp:include page="header.jsp" />


	<!-- 자바빈 액션태그 사용 -->
	<jsp:useBean id="classVO" class="model.ClassVO" />
	<jsp:setProperty name="classVO" property="*" />

	<%
      request.setCharacterEncoding("euc-kr");
   int classIdx = Integer.parseInt(request.getParameter("classIdx"));
   ServletContext sc = getServletContext(); 
   Connection con = (Connection)sc.getAttribute("DBconnection"); 
   HttpSession session1 = request.getSession();
   
   ArrayList<ReviewVO> list = ReviewDAO.getReview(con, classIdx);
   classVO = ClassDAO.getClassByIdx(con, classIdx); 
   ResultSet rs = ClassDAO.getClassLike(con, classIdx, Integer.parseInt(session.getAttribute("user_idx").toString()));
   
   String heartFile = null;
   int flag = 0;
   
   if(rs==null) heartFile = "heart2";
   else {
      flag = 1;
      heartFile = "heart";
   }
   %>

	<!-- 클래스 설명 -->
	<div class="left">
		<div class="detail_menu">
			<a href="#explain">상세설명</a>
		</div>
		<div class="detail_menu">
			<a href="#intro">작가소개</a>
		</div>
		<div class="detail_menu">
			<a href="#review">한줄평</a>
		</div>
		<div class="detail_menu">
			<a href="#inquiry">문의하기</a>
		</div>
		<div class="detail_img">
			<img
				src="${pageContext.request.contextPath}/uploadImg/<%=classVO.getImage() %>"
				width="300" height="300">
		</div>

		<div class="detail">
			<h1 id="explain">상세설명</h1>
			<p><%=classVO.getContent()%></p>
		</div>

		<div class="detail">
			<h1 id="intro">작가소개</h1>
			<p><%=classVO.getTeacherInfo()%></p>
		</div>

		<div class="detail">
			<h1 id="review">한줄평</h1>
			<div style="float: right">
				<a href="review.jsp?classIdx=<%=classIdx %>" target="_blank">리뷰
					남기기</a>
			</div>
			<div style="clear: both"></div>
			<hr>

			<table style="width: 100%;">
				<Tr style="padding: 10px;">
					<th>ID</th>
					<th>COMENT</th>
				</Tr>

				<%
					int cnt = 0;
					for (int i = 0; i < list.size(); i++) {
				%>

				<tr>
					<%
						ReviewVO review = list.get(i);
					%>
					<td><%= review.getUserName()%></td>
					<td><%= review.getContent()%></td>
				</tr>
				<%
					}
				%>
			</table>

			<hr>
			<br> <br> <br>
		</div>


		<!--  리뷰 테이블 변환 전 원본
		
		<div class="detail">
			<h1 id="review">한줄평</h1>
			<div style="float: right">
				<a href="review.jsp?classIdx=<%=classIdx %>" target="_blank">리뷰
					남기기<h/a>
			</div>
			<p>리뷰------</p>
			<details>
				<summary>-더보기-</summary>
				<P>리뷰 블라블라</P>
			</details>
		</div>
		
		-->

		<!--
      <div class="detail">
         <h1 id="inquiry">문의하기</h1>
         <div style="float: right">
            <a href="inquiry.jsp?classIdx=<%=classIdx %>" target="_blank">문의 남기기</a>
         </div>
         <p>문의-------</p>
         <details>
            <summary>-더보기-</summary>
            <P>문의 블라블라</P>

         </details>
      </div>
      -->
	</div>

	<!-- 신청 부분 -->
	<div class="right">
		<h2>
			지역 :
			<%=ClassDAO.getRegionByIdx(con, classVO.getClassRegionIdx())%>
			/ 클래스 카테고리 :
			<%=ClassDAO.getCategoryByIdx(con, classVO.getCategoryIdx())%></h2>
		<div class="classname">
			<h1><%=classVO.getName()%></h1>
			<h2>
				￦<%=classVO.getPrice()%></h2>
		</div>
		<h2>
			신청인원수
			<%=classVO.getApplyPeople()%>
			/ 총 인원수
			<%=classVO.getPeople()%></h2>

		<div class="selectWrap">
			<div class="option">
				<h5>
					난이도 :
					<%=classVO.getLevel()%></h5>
			</div>
			<div class="detail_select"></div>
		</div>

		<div class="selectWrap">
			<div class="option">
				<h5>
					장소 :
					<%=classVO.getPlace()%></h5>
			</div>
			<div class="detail_select"></div>
		</div>

		<div class="selectWrap">
			<div class="option">
				<h5>
					날짜 :
					<%=classVO.getDate()%></h5>
			</div>
			<div class="detail_select"></div>
		</div>

		<div class="selectWrap">
			<div class="option">
				<h5>
					시간 :
					<%=classVO.getTime()%></h5>
			</div>
			<div class="detail_select"></div>
		</div>
		<div class=btn_box>
			<form method="post" action="RegistLike">
				<input type="hidden" name="flag" id="flag" value="<%=flag%>" /> <input
					type="hidden" name="classIdx" id="classIdx"
					value="<%=request.getParameter("classIdx")%>" /> <input
					type="image" src="imgs/<%=heartFile%>.png" name="Submit"
					value=Submit class="img_s" align="absmiddle" id="xyz" width="40px"
					height="40px" />
			</form>
			<form method="post" action="ApplicationClass">
				<input type="hidden" name="classIdx" id="classIdx"
					value="<%=request.getParameter("classIdx")%>" /> <input
					class="btn" type="submit" value="신청하기" />
			</form>
		</div>

	</div>

	<div style="clear: both;"></div>
	<br>
	<br>
	<br>

	<jsp:include page="footer.jsp" />
</body>
</html>