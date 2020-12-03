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
	<jsp:include page="header.jsp" />

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