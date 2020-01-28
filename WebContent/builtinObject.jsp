<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.onload = init;
	
	function init(){
		let btn = document.getElementById("btnCheck")
		//btn.onclick = funciotn(){}
		btn.addEventListener("click", function(){
			//document.getElementById("result").innerHTML="이벤트발생";
			//입력값 길이 출력
			var txtBigo = document.getElementById("bigo") ;
			var divResult = document.getElementById("result") ;
			divResult.innerHTML= txtBigo.value.length;
			// http://yedam/model
			divResult.innerHTML +="<br> 마지막경로/위치 " + txtBigo.value.lastIndexOf("/");
			divResult.innerHTML +="<br> 마지막경로명 " + txtBigo.value.substring(txtBigo.value.lastIndexOf("/")+1);
			//split 키워드 : 모델,객체,스트링
			var arr = txtBigo.value.split(",");
			divResult.innerHTML += "<br> 키워드 객수" + arr.length;
			//search, pattern -정규표현식
			divResult.innerHTML += "<br> 이메일체크"+ isEmail(txtBigo.value);
			//replace : 공백제거
			txtBigo.value = txtBigo.value.replace(\/s\g,"");
		})
	}
	// 이메일 체크 정규식
		function isEmail(asValue) {
	var regExp = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;
	return regExp.test(asValue); // 형식에 맞는 경우 true 리턴	
}
</script>
</head>
<body>
<form>
	<input name="bigo" id="bigo"/>
	<button type="button" id="btnCheck">입력값확인</button>
	<div id="result">결과확인</div>
</form>
</body>
</html>