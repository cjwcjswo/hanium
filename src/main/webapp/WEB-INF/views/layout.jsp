<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<title>한이음 오더하기일</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function(){
	$("#logOk").click(function(){
		var id = $("#userId1").val().trim();
		var pw = $("#userPw1").val().trim();
		if(id == ""){
			alert("아이디를 입력하세요!");
			$("#userId1").focus();
			return;
		}
		if(pw == ""){
			alert("비밀번호를 입력하세요!");
			$("#userPw1").focus();
			return;
		}
		$.ajax({
			url: "${pageContext.request.contextPath}/login",
			type: "post",
			data: "userId1="+id+"&userPw1="+pw,
			dataType: "text",
			success:function(result){
				if(result == "OK"){
					location.reload();
				}
				$("#logResult").html("<h4>"+result+"</h4>");
			},
			error:function(err){
				alert(err);
			}
		})
	})
	$("#loginBtn").click(function(){
		document.getElementById('login').style.display='block';
	})
	$("#logoutBtn").click(function(){
		location.href= "${pageContext.request.contextPath}/logout";
	})
	$("#homeBtn").click(function(){
		location.href = "${pageContext.request.contextPath}/main";
	})
	$("#noticeBtn").click(function(){
		location.href = "${pageContext.request.contextPath}/notice/list";
	})
	$("#freeBtn").click(function(){
		location.href = "${pageContext.request.contextPath}/board/list";
	})
	$("#photoBtn").click(function(){
		location.href = "${pageContext.request.contextPath}/board/photo";
	})
	$("#signUp").click(function(){
		location.href = "${pageContext.request.contextPath}/signUp";
	})
})
</script>
<body>
	<div style="height:50px"></div>
	<!-- Navbar (sit on top) -->
	<div class="w3-top">
		<div class="w3-bar w3-white w3-wide w3-padding w3-card-2">
			<a id="homeBtn" class="w3-bar-item w3-button"><b>오더하기일</b></a>
			<!-- Float links to the right. Hide them on small screens -->
			<div class="w3-right w3-hide-small">
				<a id="noticeBtn" class="w3-bar-item w3-button">공지</a> <a
					id="freeBtn" class="w3-bar-item w3-button">자유게시판</a> <a
					id="photoBtn" class="w3-bar-item w3-button">사진게시판</a> <a
					id="signUp" class="w3-bar-item w3-button">회원가입</a> 
					<c:if test="${user == null}"><a id="loginBtn" class="w3-bar-item w3-button">로그인</a></c:if>
					<c:if test="${user != null}"><a id="logoutBtn" class="w3-bar-item w3-button">로그아웃</a></c:if>
					
			</div>
		</div>
	</div>


	<!-- Page content -->
	<tiles:insertAttribute name="content"/>

	<!-- 로그인 Modal창 -->
	<div id="login" class="w3-modal">
		<div class="w3-modal-content w3-card-4 w3-animate-zoom"
			style="padding: 32px; max-width: 600px">
			<div class="w3-container w3-white w3-center">
				<h1 class="w3-wide">LOG IN</h1>
				<form>
					<input class="w3-input w3-border" type="text" placeholder="아이디"
						name="userId1" id="userId1">
				</form>
				<p>
				<form>
					<input class="w3-input w3-border" type="password" placeholder="비밀번호"
						name="userPw1" id="userPw1">
				</form>
				</p>
				<div id="logResult"></div>
				<div class="w3-row">
					<div class="w3-half">
						<button
							type="button" class="w3-button w3-block w3-blue"
							id="logOk">로그인</button>
					</div>
					<div class="w3-half">
						<button
							onclick="document.getElementById('login').style.display='none'"
							type="button" class="w3-button w3-block w3-red">닫기</button>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>
