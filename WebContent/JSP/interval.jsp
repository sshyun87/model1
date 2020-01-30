<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	//타이머연습
	
	//반복 실행할 함수 만들기
	function printTime(){
		result.innerHTML = (new Date()).getSeconds();
	}
	window.addEventListener("load", function(){
		window.setInterval(printTime, 1000);
		//이미지 변경 타이머 지정(2초마다)
	});
	
	//이미지 배열
	var imgs = [ "../imges/Jellyfish.jpg",
		"../imges/Koala.jpg",
		"../imges/Lighthouse.jpg"]
	
	//2초마다 이미지가 변경되도록 작성.
</script>
</head>
<body>
<div id="result"></div>
<img src="../imges/Hydrangeas.jpg"/>
</body>
</html>