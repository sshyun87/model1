package co.yedam.appboardAjax;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.common.Command;
import co.yedam.appboard.BoardDAO;
import co.yedam.appboard.BoardDTO;
import net.sf.json.JSONArray;

public class AjaxBoardList implements Command{

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
			BoardDAO dao = new BoardDAO();
			List<BoardDTO> list = dao.selectList();
			//자바객체 -> JSON string
			String result = JSONArray.fromObject(list).toString();
			return "ajax:" +result;
	}

}
