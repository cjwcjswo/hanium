<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
* {
	text-align: center;
}

#main, #back {
	width: 150px;
}

table {
	margin: auto;
	border: red 3px double;
}
</style>


</head>
<body>
	<h1>${message} ${exception.message }</h1>
	<table>
		<tr>
			<td><a href="${pageContext.request.contextPath}/main"
				class="w3-button w3-block w3-blue" id="main">메인으로!</a></td>
			<td><button class="w3-button w3-block w3-green" id="back"
					onclick="history.back()">뒤로가기</button></td>
		</tr>
	</table>


</body>
</html>