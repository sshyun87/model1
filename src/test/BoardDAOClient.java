package test;

import co.yedam.appboard.BoardDAO;
import co.yedam.appboard.BoardDTO;

public class BoardDAOClient {
	public static void main(String[] args) {
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = new BoardDTO();
		dto.setPoster("홍길도");
		dto.setSubject("dao test");
		dto.setContents("dat test입니다.");
		dao.insert(dto);
	}

}
