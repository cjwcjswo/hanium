<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script>
	function checkValid() {
		if(document.f.subject.value.trim() == "") {
			alert("������ �Է��ϼ���!");
			return false;
		}
		if(document.f.content.value.trim() == ""){
			alert("������ �Է��ϼ���!");
			return false;
		}
		return true;
	}
</script>
</head>
<body>
	<div style="width: 500px; margin: auto">
		<form action="insert" method="post" name="f" onsubmit="return checkValid()">
			<h3>
				<font size="12px" color="gray">���ο� �� ����</font>
			</h3>
			<br>
			<div class="form-group">
				<div class="row">
					<div class="col-xs-8">
						<label class="control-label">����</label> <input type="text"
							class="form-control" name="subject" id="subject" />
					</div>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label">�Խñ�</label>
				<textarea class="form-control" name="content" rows="8" id="content"></textarea>
			</div>
			<button type="submit" class="btn btn-default" id="write">�ۼ��Ϸ�</button>
		</form>
	</div>

</body>
</html>