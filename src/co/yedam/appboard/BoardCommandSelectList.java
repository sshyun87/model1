package co.yedam.appboard;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.common.Command;

public class BoardCommandSelectList implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		BoardDAO dao = new BoardDAO();
		List<BoardDTO> list = dao.selectList();
		request.setAttribute("list", list);
		return "board/list.jsp";
	}
	

}
