<%@page import="co.yedam.appboard.BoardDTO"%>
<%@page import="java.util.List"%>
<%@page import="co.yedam.appboard.BoardDAO"%>
<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page import="java.sql.*"  %>
<%@ taglib prefix="my" tagdir="/WEB-INF/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>


<html> 
<head> <title>�Խ���</title> </head>

<body>
<my:page></my:page>
<my:boardType></my:boardType>
<table width="80%" border=0 > 
     <tr><td align="center" > JDBC �Խ��� </td></tr>
</table><br>

<table width="80%" border=1 cellspacing=0 >
	<tr height=30 bgcolor="#FFFF99" >
	  <th>��ȣ</th><th>����</th><th>�۾���</th><th>�����</th><th>��ȸ</th>
	</tr>


<%--
	List<BoardDTO> list = (List<BoardDTO>)request.getAttribute("list");
	for (BoardDTO dto : list){
			
--%>
<c:forEach items="${list}" var="dto">
<tr>
<td>${dto.getNo()}</td>
<td><a href="view.jsp?c_no=${dto.getNo()}">${dto.getSubject()}</a></td>
<td>${dto.getPoster()}</td>
<td>${dto.getLastpost()}</td>
<td>${dto.getViews()}</td>
</tr>
</c:forEach>
<c:if test="${empty list }">
	<tr><td colspan="5">no data</td></tr>
  </c:if>
</table>



<table width="80%" border=0 >
	<tr><td align="right"><a href="boardCreatForm">�۾���</a> </td> </tr>
</table>

<%=application.getRealPath("/") %>
<%= request.getHeader("User-Agent") %>

<img src="<%=request.getContextPath()%>/img/a.jpg"/>
</body>
</html>