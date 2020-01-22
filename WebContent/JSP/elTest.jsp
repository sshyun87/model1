<%@page import="java.util.List"%>
<%@page import="co.yedam.appboard.BoardDTO"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
속성읽기<br>
session의 name 속성<br>
표현식: <%=session.getAttribute("name") %><br>
EL:${sessionScope.name} <br>

<hr>
application의 name속성<br>
표현식: <%=application.getAttribute("name") %><br>
EL: ${applicationScope.name}<br>
<hr>
map: userInfo의 dept키의 값<br>
표현식: <%=((Map<String,Object>)request.getAttribute("userInfo")).get("dept") %><br>
EL: ${requestScope.userInfo.dept} <br>
<hr>
DTO: board의 제목<hr>
표현식:<%=((BoardDTO)request.getAttribute("board")).getSubject() %><br>
EL:${board.subject}
<hr>
boardList 첫번째 게시글의 작성자<hr>
표현식: <%=((List<BoardDTO>)request.getAttribute("boardList")).get(0).getPoster() %><br>
EL: ${boardList[0].poster}
<hr>
쿠키정보 <br>
표현식 : <% Cookie[] cookies = request.getCookies(); %>
EL: ${cookie.openYn.value}
파라미터(배열)<br>
표현식: <%=request.getParameterValues("hobby")[0] %><br>
EL: ${paramValues.hobby[0]}<br>
<hr>
헤더정보<br>
표현식: <%=request.getHeader("User-Agent") %><br>
EL:${header["User-Agent"]}<br>
<hr>
request<br>
표현식:<%=request.getContextPath() %> <br>
EL : ${pageContext.request.contextPath }
</body>
</html>