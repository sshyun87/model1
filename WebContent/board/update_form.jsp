<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page import="java.sql.*" %>

<html>
<head><title>�Խ���</title></head>

<body>
<%
	Connection myConn=null;
	Statement stmt=null;
	try {
		String dbdriver = "oracle.jdbc.OracleDriver";    
		String dburl = "jdbc:oracle:thin:@localhost:1521:ORCL";

		Class.forName(dbdriver);
		myConn = DriverManager.getConnection(dburl, "scott", "tiger");
		stmt = myConn.createStatement();	
	} catch(SQLException ex) {
		System.err.println("SQLException: " + ex.getMessage());
	}
	                
	int no, views;
	String subject="", contents="", poster="";
	Date lastpost=null;

	int c_no = Integer.parseInt(request.getParameter("c_no"));  

	String mySQL = " select no, subject, contents, poster, lastpost,  views " +
                " from board " +
                " where no=" + c_no;

	ResultSet myResultSet = stmt.executeQuery(mySQL);
		
	if (myResultSet.next()) {
		no = myResultSet.getInt("no");
		subject = myResultSet.getString("subject");
		contents = myResultSet.getString("contents");
		poster = myResultSet.getString("poster");
		lastpost = myResultSet.getDate("lastpost");
		views = myResultSet.getInt("views");
	}	
	stmt.close();  
	myConn.close();			
%>

<form method="post" action="update_verify.jsp">
<input type="hidden" name="c_no" size="30" value="<%=c_no%>">
<table width="80%" align="center" border=1 cellspacing=0>
  <tr height=35>
    <td align="center" width=80 bgcolor="#FFFF99">�۾���</td> 
    <td><%=poster %></td></tr>
  <tr height=35>
    <td align="center" bgcolor="#FFFF99">����</td>  
    <td><input type="text" name="c_subject" size="70" value="<%=subject%>"> 
        </td></tr>
  <tr height=170> 
    <td bgcolor="#FFFF99" align="center">����</td>  
    <td><textarea name=c_contents rows="10" cols="70"><%= contents %>           
        </textarea></td> </tr>	  
</table>

<table width="75%" align="center">
  <tr align="center" >
    <td><input type="submit" value="����"></td>
    <td><a href="list.jsp">�������</a></td> 
  </tr>
</table>

</form>
</body>
</html>