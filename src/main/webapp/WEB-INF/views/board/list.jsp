<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<title>한이음 오더하기일</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
	$(function(){
		$(document).on("click", "button[data-title='Edit']", function(){
			$("#editVal").val($(this).attr("num"));
			$("#editId").val($(this).attr("id"));
			$("#upTitle").val("");
			$("#upContent").val("");
			
		})
		$(document).on("click", "button[data-title='Delete']", function(){
			$("#delVal").val($(this).attr("num"));
			$("#delId").val($(this).attr("id"));
			
			
		})
		$("#delOk").click(function(){
			location.href="delete/"+$("#delId").val()+"/"+$("#delVal").val();
		})
		$("#editOk").click(function(){
			if($("#upTitle").val().trim() == ""){
				alert("제목을 입력하세요!");
				return;
			}
			if($("#upContent").val().trim() == ""){
				alert("내용을 입력하세요!");
				return;
			}
			location.href="update/"+$("#editId").val()+"/"+$("#editVal").val()
			+"?subject="+$("#upTitle").val()+"&content="+$("#upContent").val();
		})
	})
</script>
<style>
</style>
<body>

	<!-- 게시판 -->
	<div class="container-fluid">
		<div class="row">


			<div class="col-md-12" id="noticeBoard">
				<h4>
					<font size="14px" color="gray"> 자유게시판 </font>
				</h4>
				<br>
				<div class="table-responsive">
					<hr>
					<br>
					<table id="mytable" class="table table-bordred table-striped">

						<thead>
							<th>글번호</th>
							<th>아이디</th>
							<th>이름</th>
							<th>제목</th>
							<th>작성일</th>
							<th>조회수</th>
						</thead>
						<tbody>
							<c:choose>
								<c:when test="${list.size() == 0}">
									<tr>
										<th colspan="6" align="center">게시물이 없습니다</th>
									</tr>
								</c:when>
								<c:otherwise>
									<c:forEach items="${list}" var="board">
										<tr>
											<th>${board.boardNum}</th>
											<td>${board.userId}</td>
											<td>${board.userName}</td>
											<td><a href="read/${board.boardNum}">${board.subject}
													[${board.reply.size()}]</a></td>
											<td>${board.writeDay}</td>
											<td>${board.readNum}</td>
											<td><p data-placement="top" data-toggle="tooltip"
													title="Edit">
													<button class="btn btn-primary btn-xs" data-title="Edit"
														data-toggle="modal" data-target="#edit"
														id="${board.userId}" num="${board.boardNum}">
														<span class="glyphicon glyphicon-pencil"></span>
													</button>
												</p></td>
											<td><p data-placement="top" data-toggle="tooltip"
													title="Delete">
													<button class="btn btn-danger btn-xs" data-title="Delete"
														data-toggle="modal" data-target="#delete"
														num="${board.boardNum}" id="${board.userId}">
														<span class="glyphicon glyphicon-trash"></span>
													</button>
												</p></td>
										</tr>
									</c:forEach>
								</c:otherwise>
							</c:choose>


						</tbody>

					</table>
					<div style="text-align: right">
						<br> <a href="write" class="btn btn-primary" id="write">글쓰기</a>
					</div>
					<div class="clearfix"></div>

				</div>

			</div>
		</div>
		<div style="text-align: center">
			<ul class="pagination">
				<c:if test="${pm.previous}">
					<li><a
						href="${pageContext.request.contextPath}/board/list?page=${pm.lastPage - 10}"><span
							class="glyphicon glyphicon-chevron-left"></span></a></li>
				</c:if>
				<c:forEach begin="${pm.startPage}" end="${pm.lastPage}"
					varStatus="state">
					<c:if test="${pm.currentPage == state.count}">
						<li class="active"><a
							href='${pageContext.request.contextPath}/board/list?page=${pm.startPage + state.count-1}'>${pm.startPage + state.count-1}</a>
						</li>
					</c:if>
					<c:if test="${pm.currentPage != state.count}">
						<li><a
							href='${pageContext.request.contextPath}/board/list?page=${pm.startPage + state.count-1}'>${pm.startPage + state.count-1}</a>
						</li>
					</c:if>
				</c:forEach>
				<c:if test="${pm.next}">
					<li><a
						href="${pageContext.request.contextPath}/board/list?page=${pm.lastPage + 1}"><span
							class="glyphicon glyphicon-chevron-right"></span></a></li>
				</c:if>

			</ul>
		</div>
		<br> <br>
		<!-- 드랍다운 검색하기 버튼 -->
		<div class="col-xs-8 col-xs-offset-2">
			<div class="input-group">

				<div class="input-group-btn search-panel">

					<button type="button" class="btn btn-default dropdown-toggle"
						data-toggle="dropdown">
						<span id="search_concept">카테고리</span> <span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a href="#titleSearch">제목</a></li>
						<li><a href="#writerSearch">ID</a></li>
						<li><a href="#contentSearch">내용</a></li>



					</ul>
				</div>
				<input type="hidden" name="search_param" value="all"
					id="search_param"> <input type="text" class="form-control"
					name="x" placeholder="Search"> <span
					class="input-group-btn">
					<button class="btn btn-default" id="searchBtn" type="button"
						style="height: 34px">
						<span class="glyphicon glyphicon-search"></span>
					</button>
				</span>

			</div>

		</div>

		<div class="modal fade" id="edit" tabindex="-1" role="dialog"
			aria-labelledby="edit" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
						</button>
						<h4 class="modal-title custom_align" id="Heading">수정</h4>
					</div>
					<div class="modal-body">
						<div class="form-group">

							<input class="form-control " type="text" placeholder="제목"
								id="upTitle">
						</div>
						<div class="form-group">
							<textarea rows="5" class="form-control" placeholder="게시물"
								id="upContent"></textarea>
							<input type="hidden" id="editVal" value="" /> <input
								type="hidden" id="editId" value="" />
						</div>
					</div>
					<div class="modal-footer ">
						<input type="hidden" id="editNum"> <input type="hidden"
							id="editVal">
						<button type="button" class="btn btn-warning btn-lg" id="editOk"
							style="width: 100%;">
							<span class="glyphicon glyphicon-ok-sign"></span> 업데이트
						</button>
					</div>
				</div>
				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->
		</div>



		<div class="modal fade" tabindex="-1" role="dialog"
			aria-labelledby="edit" aria-hidden="true" id="delete">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">
							<span class="glyphicon glyphicon-remove" aria-hidden="true"></span>
						</button>
						<h4 class="modal-title custom_align" id="Heading">해당 게시물 삭제하기</h4>
					</div>
					<div class="modal-body">

						<div class="alert alert-danger">
							<span class="glyphicon glyphicon-warning-sign"></span> 정말로
							삭제하겠습니까?
						</div>
						<input type="hidden" id="delVal" value="" /> <input type="hidden"
							id="delId" value="" />
					</div>
					<div class="modal-footer ">
						<input type="hidden" id="deleteNum">
						<button type="button" class="btn btn-success" id="delOk">
							<span class="glyphicon glyphicon-ok-sign"></span> 네
						</button>
						<button type="button" class="btn btn-default" data-dismiss="modal">
							<span class="glyphicon glyphicon-remove"></span> 아니요
						</button>

					</div>
				</div>

				<!-- /.modal-content -->
			</div>
			<!-- /.modal-dialog -->

		</div>
	</div>

</body>
</html>
