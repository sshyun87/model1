<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	img { width: 200px;}
</style>
<script>
	window.onload = function(){
		//모든 이미지의 alt 속성만 div에 출력
		var imgArr = document.getElementsByTagName("img");
		var text = "";
		console.log(imgArr);
		for(i=0; i<imgArr.length; i++){
			text += imgArr[i].alt + "<br>";
		}
		document.getElementById("result").innerHTML = text;
	}
</script>
</head>
<body>
<img src="../imges/Chrysanthemum.jpg" alt="국화">
<img src="../imges/Jellyfish.jpg" alt="해파리">
<img src="../imges/Tulips.jpg" alt="튤립">
<div id="result"> </div>

</body>
</html>