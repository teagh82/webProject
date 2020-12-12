<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>My Page</title>
    <link href="css/mainstyles.css" rel="stylesheet" type="text/css">
    <link href="css/style_mypage.css" rel="stylesheet" type="text/css">
    
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
    <%
		if (session.getAttribute("mid") == null || session.isNew()) {
		out.println("<script>alert('로그인 후 이용해주세요.'); location.replace(\"login.jsp\"); </script>");
		return;
	}
	%>

    <!-- 마이페이지 메뉴  -->
    <div class=mypage>
        <a href="myPage.jsp">마이페이지</a>
    </div>
    <div class="mypage_menu">
        <a href="myPage.jsp">개인 정보</a> <a href="apply.jsp">신청 현황</a> <a href="#">관심
         등록</a> <a href="makeClass.jsp">클래스 만들기</a>
    </div>

   <!-- 클래스 만들기 -->
    <div class="mypage_wrap">
        <h2 style="color: #8EBCBB; min-width: 1500px;">새로운 클래스 만들기</h2>
        <br />
        <form method="post" action="RegistClass" style="min-width: 1500px;" enctype="multipart/form-data">
            <div class=mypage_box>
                <h5>클래스 이름</h5>
                <input type="text" name="name" />
            </div>
            <div class=region>
                <h5>카테고리</h5>
            </div>
            <div class=region_select>
                <select name="categoryIdx">
               <option value="">카테고리 선택</option>
               <option value="1">공예</option>
               <option value="2">요리</option>
               <option value="3">악기</option>
               <option value="4">IT</option>
               <option value="5">액티비티</option>
            </select>
            </div>
            <div class="mypage_box">
                <h5>장소</h5>
                <input type="text" name="place" />
            </div>
            <div class=mypage_box>
                <h5>날짜</h5>
                <input type="date" name="date" />
            </div>
            <div class=mypage_box>
                <h5>시간</h5>
                <input type="time" name="time" />
            </div>
            <div class=mypage_box>
                <h5>정원</h5>
                <input type="text" name="people" placeholder="숫자만 입력해주세요." />
            </div>
            <div class=region>
                <h5>난이도</h5>
            </div>
            <div class=region_select>
                <select name="level">
               <option value="">난이도 선택</option>
               <option value="초급">초급</option>
               <option value="중급">중급</option>
               <option value="고급">고급</option>
            </select>
            </div>
            <div class=mypage_box>
                <h5>클래스 소개</h5>
                <input type="text" name="content" />
            </div>
            <div class=mypage_box>
                <h5>작가 소개</h5>
                <input type="text" name="teacherInfo" />
            </div>
            <div class=mypage_box>
                <h5>가격</h5>
                <input type="text" name="price" />
            </div>
            <div class=mypage_box>
                <h5>클래스 사진</h5>
                <input type="file" name="image" />
            </div>
            <div class=region>
                <h5>지역</h5>
            </div>
            <div class=region_select>
                <select name="RegionIdx">
               <option value="">지역 선택</option>
               <option value="1">서울</option>
               <option value="2">경기</option>
               <option value="3">충청도</option>
               <option value="4">전라도</option>
               <option value="5">경상도</option>
            </select>
            </div>
            <div class=btn_box>
                <input class=btn type="submit" value="클래스 만들기" onclick="dropdown_check();"/>
            </div>
          
        </form>

    </div>
    
   

</body>

</html>