package co.yedam.appboard;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import co.yedam.app.common.Command;

public class FileUpload implements Command {

	@Override
	public String excute(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		String uploadPath = request.getSession()  //session 기본객체
							.getServletContext()  //application 기본객체	
							.getRealPath("/imges"); // images는 url폴더의 실제 경로를 구해옴

		try {
			MultipartRequest multi = new MultipartRequest( // MultipartRequest 인스턴스 생성(cos.jar의 라이브러리)
					request, 
					uploadPath, // 파일을 저장할 디렉토리 지정
					10 * 1024 * 1024, // 첨부파일 최대 용량 설정(bite) / 10KB / 용량 초과 시 예외 발생
					"utf-8", // 인코딩 방식 지정
					new DefaultFileRenamePolicy() // 중복 파일 처리(동일한 파일명이 업로드되면 뒤에 숫자 등을 붙여 중복 회피)
			);

			String desc = multi.getParameter("desc");
			
			/* form의 <input type="file"> name값을 모를 경우 name을 구할때 사용
			Enumeration files=multi.getFileNames(); // form의 type="file" name을 구함
			String file1 =(String)files.nextElement(); // 첫번째 type="file"의 name 저장
			String file2 =(String)files.nextElement(); // 두번째 type="file"의 name 저장
			*/

			String fileName1 = multi.getFilesystemName("uploadfile"); //name
			String orgfileName1 = multi.getOriginalFileName("uploadfile");
			
			response.getWriter().append("desc:" + desc +"<br>");
			response.getWriter().append("fileName1:" + fileName1 +"<br>");
			response.getWriter().append("orgfileName1:" + orgfileName1 +"<br>");
			response.getWriter().append("uploadPath:" + uploadPath +"<br>");
			
			//dao insert
			
		} catch (Exception e) {
			e.getStackTrace();
		} // 업로드 종료
		
		return null;
	}

}
