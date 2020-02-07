package co.yedam.appboardAjax;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.app.common.Command;
import co.yedam.appboard.BoardDAO;
import co.yedam.appboard.BoardDTO;
import net.sf.json.JSONObject;

public class AjaxBoard1 implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		//no 파라미터 받기
		int no = Integer.parseInt(request.getParameter("no"));
		//단건조회
		BoardDAO dao = new BoardDAO();
		BoardDTO dto = dao.selectOne(no);
		//json
		String result = JSONObject.fromObject(dto).toString();
		return "ajax" + result;
	}

}
