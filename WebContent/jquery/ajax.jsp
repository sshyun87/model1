<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script>
$(function(){     // ready == window.load
	result.innerHTML = "로딩중";
	$.ajax("./server/getName.jsp",
			{ async:ture //비동기 NO = 동기, ture가 디폴트이므로 생략가능. 
			,beforeSend: function(){}
			,cache : false
			,data :$("#frm").serialize()   //파라미터
			,dataType : "json"   //디폴트는 html
			})
	 .done(function(data){ result.innerHTML = data;})
	 .fail(function(){})
	 .always(function(){});
	 console.log("ajax end");
});
	
</script>
</head>
<body>
<form id="frm" name="frm">
	<input name="no" value="1">
	<input name="name" value="hong">
</form>
<div id="result"></div>
</body>
</html>