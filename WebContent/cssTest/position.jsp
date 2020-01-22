<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{font-size: 12px;}
div{
	width:400px; 
	height:400px; 
	border:1px solid blue;
}
div.a{
	position:fixed; 
	right:50px; 
	bottom:50px; 
	background-color: red; 
	font-size: 2em; 
	z-index: 1
}
div.b{font-size: 4em; padding: 100px; margin: 100px; border:10px solid; z-index: 3}
</style>
</head>
<body>
<div class="a b">a</div>
<div class="b">b</div>
<div>c</div>
</body>
</html>