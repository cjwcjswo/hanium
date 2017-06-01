<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>한이음 오더하기일</title>
<style>
html, body {
	margin: 0;
	height: 100%
}

#visual {
	height: 100%;
	text-align: center;
}

#video-bg, #visual-content {
	position: absolute;
	top: 50%;
	left: 50%;
	webkit-transform: translateX(-50%) translateY(-50%);
	transform: translateX(-50%) translateY(-50%);
	width: 100%;
}

#video-bg {
	height: 100%;
	background: #000; /* 배경 이미지로 대체 가능 */
	background-size: cover;
	z-index: -100;
}

#video-bg iframe {
	border: none;
	width: 100%;
	height: 100%;
}

#visual-content {
	z-index: 100;
}

h1 {
	font-size: 60px;
	font-weight: bold;
	color: #fff;
	margin-bottom: 60px;
}

#visual-btn {
	margin: auto;
	width: 100px;
	color: #fff;
	font-size: 20px;
	border: 2px solid #fff;
	padding: 12px 24px;
	border-radius: 5px;
	cursor: pointer;
	transition: transform 1s ease;
}

#visual-btn:hover {
	transition: transform 1s ease;
	transform: scale(1.5, 1.5);
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
$(function(){
	$("#visual-btn").click(function(){
		location.href="main";
	});
})
</script>
</head>
<body>
	<div id="visual">
		<div id="video-bg">
			<iframe
				src="https://youtube.com/embed/QtFUJ_Bg9e8?autoplay=1&controls=0&showinfo=0&wmode=opaque&autohide=1&loop=1&playlist=QtFUJ_Bg9e8">
			</iframe>
		</div>
		<div id="visual-content">
			<h1>
				한이음 오더하기일<br> 홈페이지
			</h1>
			<div id="visual-btn">
				입장하기</span>
			</div>
		</div>
</body>
</html>