<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	window.addEventListener("click", function(){
		//btnR버튼 이벤트
		btnR.addEventListener("click", function(){
			//selectedIndex
			if(subject.selectedIndex > -1){
			//선택항목 오른쪽에 추가
			var opt = document.createElement("option");
			opt.text = subject.options[subject.selectedIndex].text;
			
			choose.add(opt);
			//선택항목 삭제
			subject.remove(subject.selectedIndex);
			}
		});
		btnL.addEventListener("click", function(){
			if(choose.selectedIndex > -1){
			var opt1 = document.createElement("option");
			opt1.text = choose.options[choose.selectedIndex].text;
			
			subject.add(opt1);
			choose.remove(choose.selectedIndex);
		}
		});
		
		//btnAll버튼 이벤트 
		btnAll.addEventListener("click", function(){
			var len = subject.length;
			for(i=len-1; i>=0; i--){
				//선택항목 오른쪽에 추가
				var opt = document.createElement("option");
				opt.text = subject.options[i].text;
				choose.add(opt);
				//선택항목 삭제
				subject.remove(i);
			};
	})
	})
</script>
</head>
<body>
<select id="subject" multiple="multiple">
	<option value="java">자바
	<option value="jsp">JSP
	<option value="spring">스프링
</select>
<select id="choose" multiple="multiple" size="5"></select>
<button type="button" id="btnR">▶</button>
<button type="button" id="btnL">◀</button>
<button type="button" id="btnAll">전체이동</button>


</body>
</html>