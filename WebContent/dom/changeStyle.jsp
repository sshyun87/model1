<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.addEventListener("load", init);
	
	function init(){
		btn.addEventListener("click", function(){
			result.style.display="none";
			//div 숨기기: display= "none"
		});
		btn.addEventListener("mouseout", function(){
			result.style.display="";
		});
		//img1.addEventListener("error", function(){
			//이미지의 src 변경
			//img1.src="../imges/Hydrangeas.jpg";
			//consloe.log("aaa");
		//})
	}
</script>
</head>
<body>
	<button type="button" id="btn">숨기기</button>
	<div id="result">남산의 부장들 소개</div>
	<img src="../imges/Koal.jpg" id="img1"
		 onerror >
</body>
</html>