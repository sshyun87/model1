<%@ page contentType="text/html; charset=EUC-KR" %>
<%@ page import="java.sql.*" %>

<%
	Connection myConn=null;
	Statement stmt=null;
	String mySQL="";
	
	try {
		String dbdriver = "oracle.jdbc.OracleDriver";    
		String dburl = "jdbc:oracle:thin:@localhost:1521:ORCL";

		Class.forName(dbdriver);
		myConn = DriverManager.getConnection(dburl, "scott", "tiger");
	} catch(SQLException ex) {
		System.err.println("SQLException: " + ex.getMessage());
	}

	stmt = myConn.createStatement();

	request.setCharacterEncoding("euc-kr");
	int c_no = Integer.parseInt(request.getParameter("c_no"));

	mySQL = "delete board " +
            " where no =" + c_no ;

    stmt.executeQuery(mySQL);

	stmt.close();   
	myConn.close(); 
%>

<script>
	alert("삭제되었습니다.");
	location.href="list.jsp";
</script>

