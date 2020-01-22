package co.yedam.appboard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

/**
 * Servlet implementation class ELServlet
 */
@WebServlet("/ELServlet")
public class ELServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ELServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("name", "request-hong");
		HttpSession session = request.getSession();
		session.setAttribute("name", "session-hong");
		//application
		this.getServletContext()
			.setAttribute("name", "application-hong");
		//list
		List<BoardDTO> list = new ArrayList<>();
		list.add(new BoardDTO(1,"홍길동","첫번째"));
		list.add(new BoardDTO(1,"김유신","두번째"));
		request.setAttribute("boardList", list);
		//map
		Map<String, Object> map = new HashMap<>();
		map.put("name", "이순신");
		map.put("age", 25);
		map.put("dept", "개발");
		request.setAttribute("userInfo", map);
		
		//dto
		request.setAttribute("board", new BoardDTO(3,"최","세번째"));
		
		
		
		request.getRequestDispatcher("jsp/elTest.jsp")
				.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
