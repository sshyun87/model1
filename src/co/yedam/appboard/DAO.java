/**
 * 
 */
package co.yedam.appboard;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * @author 석시현
 * 작성일자 : 2019-11-07
 * 상위 dao 객체
 * 
 */
public class DAO {
	Connection conn;
	PreparedStatement psmt;
	ResultSet rs;
	DataSource ds; //커넥션 pool 사용을 위한 데이터 연결 생성 객체
	
	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:xe";
	private String user = "hr";
	private String password = "hr";
	
	public DAO() {
		try {
			Class.forName(driver);  //DataSource 객체로 대체
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
					}
	}
//		
//		try {
//			Context initContext = new InitialContext();
//			Context envContext  = (Context)initContext.lookup("java:/comp/env");
//			ds = (DataSource)envContext.lookup("jdbc/myoracle");
//			conn = ds.getConnection();
//		} catch (NamingException | SQLException e) {
//			e.printStackTrace();
//		}
//		
//	}
	
	public void close() {
		try {
			if(rs != null) rs.close();
			if(psmt != null) psmt.close();
			if(conn != null) conn.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}
