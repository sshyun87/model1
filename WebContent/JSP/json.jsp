<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	//json 객체
	let boardDTO = { no:1, poster:"홍길동", subject:"첫번째글"}
	
	//스트링배열
	let atrArr = ["딸기","키위","애플망고"];
	
	//객체배열
	let boardArr = [{no:1, poster:"홍길동", subject:"첫번째글"},
					{no:2, poster:"김길동", subject:"두번째글"},
					{no:3, poster:"나기자", subject:"세번째글"}];
	
	//boardDTO의 작성자 출력
	document.write(boardDTO.poster + "<br>");
	//strArr 두번째 과일 출력
	document.write(atrArr[1]+"<br>");
	//boardArr 의 세번째 게시글의 제목 출력. 
	document.write(boardArr[2].subject);
</script>
</head>
<body>

</body>
</html>