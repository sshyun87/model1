<%@ page contentType="text/html; charset=EUC-KR" %>
<html>
<head><title>�Խ���</title></head>
<body>

<form method="post" action="insert_verify.jsp">
<table width="80%" align="center" border=1 cellspacing=0 >
	<tr height=30>
		<td align="center" bgcolor="#FFFF99" width=64>�۾���</td> 
		<td>&nbsp<input type="text" name="s_poster" size="20"></td></tr>
	<tr height=30>
		<td align="center" bgcolor="#FFFF99">����</td>  
		<td>&nbsp<input type="text" name="s_subject" size="70"></td></tr>
	<tr> 
		<td align="center" bgcolor="#FFFF99">����</td>  
		<td>&nbsp<textarea name=s_contents rows="10" cols="70"></textarea></td></tr>	   
	<tr>
		<td align="center" colspan="2"><input type="submit" value="����"></td></tr>
</table>
</form>
</body>
</html>