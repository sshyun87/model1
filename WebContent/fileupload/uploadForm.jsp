<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" enctype="multipart/form-data" action="../FileUpload.do">
 <!-- file이 하나라도 포함되면 form에 반드시 위에 내용 포함 되어야함 -->
	<input type="file" name="uploadfile">
	<input type="text" name="desc">
	<button>등록</button>
</form>
</body>
</html>