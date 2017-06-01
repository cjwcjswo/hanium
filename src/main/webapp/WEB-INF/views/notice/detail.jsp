<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	#replyTable th{
		text-align:center;
	}
	#replyTable th:nth-child(1){
		width:12%;
	}
	#replyTable th:nth-child(2){
		width:12%;
	}
	#replyTable th:nth-child(3){
		width:56%;
	}
	#replyTable th:nth-child(4){
		width:20%;
	}
	#replyTable th:nth-child(5){
		width:10%;
	}
</style>
</head>
<body>
	<br>
	<br>
	<form name="f" method="post" action="${pageContext.request.contextPath}/notice/insertReply">
		<input type="hidden" value="${board.boardNum}" name="boardNum"/>
		<div class="container">
			<div class="row">
				<div class="col-sm-9 col-md-10">
					<button type="button" class="btn btn-default" data-toggle="tooltip"
						title="Back to inbox"
						onClick="location.href=
				'${pageContext.request.contextPath}/notice/list'">
						<span class="glyphicon glyphicon-arrow-left"></span> 게시판으로 돌아가기
					</button>

					<!-- Single button -->

					<div class="pull-right">
						<span class="text-muted"><b>현재 글번호(${board.boardNum})</b></span>

					</div>
				</div>
			</div>
			<hr />
			<div class="row" id="rowFrame">

				<div class="container-fluid">
					<div class="msg-wrap">
						<p class="thread-title">
						<h3 align="center">제목: ${board.subject}</h3>
						</p>
						<hr>
						<div class="msg odd">
							<div class="col-md-3 author" style="border: 2px gray solid">
								<h5 class="media-heading">
									<h4>${board.userId}(${board.userName})</h4>
									<small class="text-muted"> </small>
								</h5>
								<small class="text-muted"> <i class="fa fa-clock-o"></i>
									${board.writeDay}
								</small>
							</div>
							<!-- 게시글 부분 -->
							<div class="col-md-9">${board.content}</div>
							<div class="clearfix"></div>
						</div>
						<hr>
					</div>
				</div>
				<table class="table table-striped table-bordered table-hover" id="replyTable">
					<tr>
						<th>아이디</th>
						<th>이름</th>
						<th>내용</th>
						<th>작성일</th>
						<th></th>
					</tr>
					<c:forEach items="${replyList}" var="reply">
						<tr>
							<th>${reply.userId}</th>
							<th>${reply.userName}</th>
							<th>${reply.content}</th>
							<th>${reply.writeDay}</th>
							<th><a href="${pageContext.request.contextPath}/notice/reply/delete/${reply.userId}/${board.boardNum}/${reply.replyNum}"
							class ="w3-button w3-block w3-blue">삭제</a></th>
						</tr>
					</c:forEach>
					<tr>
						<th colspan="5"><table>
							<tr>
								<th colspan="2" width="20%"><input type="text"
									value="${sessionScope.user.userId}" name="userId"
									readonly="readonly" style="text-align:center"></th>
								<th colspan="3" width="70%"><input type="text" value="" name="content" size="100"></th>
								<th width="10%" style="text-align:center"><input type="submit" value="등록"></th>

							</tr>
						</table></th>
					</tr>
				</table>
			</div>
		</div>
	</form>
</body>
</html>