<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function(){
	$("#userId").keyup(function(){
		$.ajax({
			url:"checkId",
			type:"post",
			data:"userId="+$(this).val(),
			dataType:"text",
			success:function(result){
				console.log(result);
				$("#span").html(result);
			},
			error:function(err){
				alert(err);
			}
		})
	});
});
function checkValid(){
	var f = document.joinForm;
	if(f.userId.value.trim() == ""){
		alert("아이디를 입력하세요");
		f.userId.focus();
		return false;
	}
	if(document.getElementById("span").innerHTML != "사용 할 수 있습니다"){
		alert("아이디를 확인해주세요");
		f.userId.focus();
		return false;
	}
	if(f.userPw.value.trim() == ""){
		alert("비밀번호를 입력하세요");
		f.userPw.focus();
		return false;
	}
	if(f.repwd.value.trim() == ""){
		alert("비밀번호 확인을 입력하세요");
		f.repwd.focus();
		return false;
	}
	if(f.pwd.value.trim() != f.repwd.value.trim()){
		alert("비밀번호가 서로 다릅니다");
		f.repwd.focus();
		return false;
	}
	if(f.userName.value.trim() == ""){
		alert("이름을 입력하세요");
		f.userName.focus();
		return false;
	}
	if(f.email.value.trim() == ""){
		alert("이메일을 입력하세요");
		f.email.focus();
		return false;
	}
	if(f.addr.value.trim() == ""){
		alert("주소를 입력하세요");
		f.addr.focus();
		return false;
	}
	if(f.phone.value.trim() == ""){
		alert("핸드폰번호를 입력하세요");
		f.phone.focus();
		return false;
	}
	
	return true;
}
function jusoPopup(){
	// 주소검색을 수행할 팝업 페이지를 호출합니다.
	// 호출된 페이지(jusopopup.jsp)에서 실제 주소검색URL(http://www.juso.go.kr/addrlink/addrLinkUrl.do)를 호출하게 됩니다.
	var pop = window.open("juso","pop","width=570,height=420, scrollbars=yes, resizable=yes"); 
}

function jusoCallBack(roadFullAddr,roadAddrPart1,addrDetail,roadAddrPart2,engAddr, jibunAddr, zipNo, admCd, rnMgtSn, bdMgtSn,detBdNmList,bdNm,bdKdcd,siNm,sggNm,emdNm,liNm,rn,udrtYn,buldMnnm,buldSlno,mtYn,lnbrMnnm,lnbrSlno,emdNo){
// 팝업페이지에서 주소입력한 정보를 받아서, 현 페이지에 정보를 등록합니다.
document.joinForm.addr.value = roadFullAddr;
}


</script>
</head>
<body>
	<article class="container">
		<div class="page-header">
			<h1>
				회원가입 <small></small>
			</h1>
		</div>
		<div class="col-md-6 col-md-offset-3">
			<form role="form" name="joinForm" method="post" action="join"
				onSubmit="return checkValid()">
				<div class="form-group">
					<span id="span">중복결과여부</span><br> <label for="userId">ID</label> <input
						type="text" class="form-control" name="userId" id="userId"
						placeholder="ID">

				</div>
				<div class="form-group">
					<label for="userPw">비밀번호</label> <input type="password"
						class="form-control" name="userPw" id="userPw placeholder="비밀번호">
				</div>
				<div class="form-group">
					<label for="repwd">비밀번호 확인</label> <input type="password"
						class="form-control" id="repwd" name="repwd" placeholder="비밀번호 확인">
					<p class="help-block">비밀번호 확인을 위해 다시한번 입력 해 주세요</p>
				</div>
				<div class="form-group">
					<label for="userName">이름</label> <input type="text"
						class="form-control" id="userName" name="userName"
						placeholder="이름을 입력해 주세요">
				</div>
				<div class="form-group">
					<label for="email">이메일</label> <input type="email"
						class="form-control" id="email" name="email" placeholder="Email">
				</div>
				<div class="form-group">
					<label for="addr">주소</label> <input type="Addr"
						class="form-control" id="addr" name="addr"
						placeholder="주소를 입력해 주세요">
					<button type="button" class="btn btn-info" onClick="jusoPopup()">
						주소검색<i class="fa fa-check spaceLeft"></i>
					</button>
				</div>
				<div class="form-group">
					<label for="phone">휴대폰 번호</label>
					<div class="input-group">
						<input type="text" class="form-control" id="phone" name="phone"
							placeholder="- 없이 입력해 주세요">
					</div>
				</div>
				<div class="form-group">
					<div data-toggle="buttons"></div>
				</div>
				<div class="form-group text-center">
					<button type="submit" id="joinBtn" class="btn btn-info">
						회원가입<i class="fa fa-check spaceLeft"></i>
					</button>
					<button type="button" class="btn btn-warning">
						가입취소<i class="fa fa-times spaceLeft"></i>
					</button>
				</div>
			</form>
		</div>

	</article>
</body>
</html>