<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<img id="imgSample" src="imges/Penguins.jpg" style="width:100px">
<button type="button" id="btnSize">그림크게</button>
<script>
	let imgSample = document.getElementById("imgSample");
	let btnSize = document.getElementById("btnSize");
	btnSize.addEventListener("click", function(){
		//이미지의 크기(width) 확인
		var w = imgSample.style.width;
		//크기를 +100
		imgSample.style.width = parseInt(w) + 100 + "px";
	
	})
	
</script>
</body>
</html>