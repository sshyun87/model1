package co.yedam.appboard;

import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAO extends DAO{
	public int insert(BoardDTO dto) {
		int r = 0;
		try {
			String sql = "insert into board(no, poster,subject, contents, lastpost, view)" 
					+ "values((select max(no)+1 from board ), ?,?,?, sysdate, 1)";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getPoster());
			psmt.setString(2, dto.getSubject());
			psmt.setString(3, dto.getContents());
			r= psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return r;
	}
//수정
	public int update(BoardDTO dto) {
		int r = 0;
		try {
			String sql = "update board set subject=?, contents=?" + "where no = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setString(1, dto.getSubject());
			psmt.setString(2, dto.getContents());
			psmt.setInt(3, dto.getNo());
			r= psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return r;
	}
	
//삭제
	public int delete(BoardDTO dto) {
		int r = 0;
		try {
			String sql = "delete board"+" where no = ?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, dto.getNo());
			r= psmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return r;
	}
//단건조회
	public BoardDTO selectOne(int no) {
		BoardDTO dto = new BoardDTO();
		try {
			String sql = "select * from sys.test_a where code=?";
			psmt = conn.prepareStatement(sql);
			psmt.setInt(1, no);
			rs = psmt.executeQuery();
			if(rs.next()) {
			
				Blob blob = rs.getBlob("BLOBDATA");
				dto.setFile(blob.getBytes(1,(int) blob.length()));
				System.out.println("====="+blob.length());
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close();
		}
		return dto;
		
		
	}
//목록
	public List<BoardDTO> selectList(){
		List<BoardDTO> list = new ArrayList<BoardDTO>();
		//1.DB연결
		
		
		try {
			//2.쿼리실행
			String sql = "select * from board order by no desc";
			psmt = conn.prepareStatement(sql);
			rs = psmt.executeQuery(sql);
			//3.결과저장
			while(rs.next()) {
				BoardDTO dto = new BoardDTO();
				dto.setNo(rs.getInt("no"));
				//dto.setLastpost(rs.getDate("Lastpost"));
				dto.setContents(rs.getString("Contents"));
				dto.setPoster(rs.getString("Poster"));
				dto.setViews(rs.getInt("views"));
				dto.setSubject(rs.getString("Subject"));
				list.add(dto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			//4.연결해제
			close();
		}
		return list;
	}
	
	}


