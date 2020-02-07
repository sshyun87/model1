package co.yedam.app.common;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.codec.binary.Base64;

import co.yedam.appboard.BoardDAO;
import co.yedam.appboard.BoardDTO;

public class imageCommand implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		BoardDAO dao = new BoardDAO();
		List<BoardDTO> list = dao.selectList();
		
		Object dto;
		byte[] fileArray;
		
		request.setAttribute("list", list);
		return "imageTest.jsp";
		
		String imageString = new String( Base64.encodeBase64( fileArray ));
		Object changeString = "data:image/" + fileExtName + ";base64, "+ imageString;
		
		return null;
	}

}
