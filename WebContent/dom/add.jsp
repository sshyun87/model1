+<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.back {background-color:cyan;}
.back {background-color:red;}
</style>
<script>
//태그추가
window.addEventListener("load", function(){
	btn.addEventListener("click", function(){
		//div input 태그 추가
		var newInput = document.createElement("input");
		//태그의 속성지정
		//입력값(value)에 "홍길동"
		newInput.value = "홍길동";
		//클래스 지정
		newInput.classList.add('back');//<input class="back">
		//배경색을 pink로 지정
		//newInput.style.backgroundColor = "pink";
		//event mouseover시에 배경색을 blue
		//newInput.addEventListener("mouseover", function(){
		//	newInput.stlye.backgroundColor = "blue";
		})
		result.appendChild(newInput); 
	});
})
</script>
</head>
<body>
<button type="button" id="btn">추가</button>
<div id="result">
</div>
</body>
</html>