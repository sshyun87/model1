package co.yedam.app.common;

import java.io.IOException;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import co.yedam.appboard.BoardCommandSelectList;


@WebServlet("*.do")
public class NewFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    HashMap<String, Command> cont = new HashMap<String, Command>();
    
    public NewFrontController() {
        super();
    }
	
	public void init(ServletConfig config) throws ServletException {
		//해쉬맵 구조를 put()(put method)로 적어준다.
		//cont.put("/index.do", new IndexCommand()); // 홈페이지(index)호출
		//board
		//등록
		//수정
		//삭제
		//상세보기
		//목록
		cont.put("/boardList", new BoardCommandSelectList());
		//수정폼
		cont.put("/boardCreatForm", new BoardCommandCreateForm());
		//등록폼
		//member
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//실행할 class객체를 찾아주는 부분. get()(get method)로 적어준다.
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String path = uri.substring(context.length());
		
		Command commandImpl = cont.get(path); //실행 클래스를 선택한다.
		
		String page = null;
		response.setContentType("text/html; charset=UTF-8");
		if(commandImpl != null) {
			page =commandImpl.excute(request, response);
			request.getRequestDispatcher(page)
				.forward(request, response);
		}else {
			response.getWriter().append("잘못된요청");
		}
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(page);
		dispatcher.forward(request, response);
				
	}
}
	


