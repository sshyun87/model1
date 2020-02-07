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

import co.yedam.app.ajax.GetDeptCnt;
import co.yedam.app.users.command.DeleteUsers;
import co.yedam.app.users.command.GetUsers;
import co.yedam.app.users.command.GetUsersList;
import co.yedam.app.users.command.InsertUsers;
import co.yedam.app.users.command.ManageUsers;
import co.yedam.app.users.command.UpdateUsers;
import co.yedam.appboard.BoardCommandSelectList;
import co.yedam.appboard.FileUpload;
import co.yedam.appboardAjax.AjaxBoardList;


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
		
		//ajax
		cont.put("/ajaxBoardList.do", new AjaxBoardList());
		cont.put("/ajaxBoard1.do", new AjaxBoardList());
		
		cont.put("/ManageUsers.do",    new ManageUsers()); //사용자 관리페이지
		cont.put("/ajax/InsertUsers.do", new InsertUsers()); //사용자 등록 ajax
		cont.put("/ajax/UpdateUsers.do", new UpdateUsers()); //사용자 수정 ajax
		cont.put("/ajax/DeleteUsers.do", new DeleteUsers()); //사용자 삭제 ajax
		cont.put("/ajax/GetUsers.do", new GetUsers());  	 //사용자 조회 ajax
		cont.put("/ajax/GetUsersList.do", new GetUsersList());	//사용자 전체 조회 ajax	
		
		cont.put("/FileUpload.do", new FileUpload());	
		cont.put("/imageCommand.do", new imageCommand());
		//차트 데이터
		cont.put("/ajax/GetDeptCnt.do", new GetDeptCnt());
		
		
	}

	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//실행할 class객체를 찾아주는 부분. get()(get method)로 적어준다.
		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();
		String context = request.getContextPath();
		String path = uri.substring(context.length());
		
		System.out.println("path=" +path);
		
		Command commandImpl = cont.get(path); //실행 클래스를 선택한다.
		String page = null;
		response.setContentType("text/html; charset=UTF-8");
		
		if(commandImpl != null) {
			page =commandImpl.excute(request, response);
			if(page != null && !page.isEmpty()) {
				if(page.startsWith("redirect:")) {
					String view = page.substring(9);
					response.sendRedirect(view);
				}else if(page.startsWith("ajax:")) {
					response.getWriter().append(page.substring(5));
				}else if(page.startsWith("script:")) {
					response.getWriter().append("<script>")
									    .append(page.substring(7))
									    .append("</script>");
				}else {
					request.getRequestDispatcher(page)
						   .forward(request, response);
				}
			}
		}else {
			response.getWriter().append("잘못된요청");
		}
				
	}
}
	


