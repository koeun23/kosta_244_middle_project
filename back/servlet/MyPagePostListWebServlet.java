package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class MyPageWebServlet
 */

//내가 정의한 URL을 입력하면
//request.getRequestDispatcher 여기에 정의한 html로 이동시켜준다.
@WebServlet("/myPagePostList")
public class MyPagePostListWebServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public MyPagePostListWebServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("1. get방식으로 myPagePostList.html 페이지를 호출한다.");
		
		MyPagePostRepository repository =new MyPagePostRepository();

		//임시저장글 목록을 조회한다.
		List<MyPagePostDTO> list = repository.tempProjectList();
		
		System.out.println("3. 데이터베이스 결과 목록 list : "+list);
		
		request.setAttribute("tempProjectList", list);
		
		//jsp파일 경로
		request.getRequestDispatcher("/WEB-INF/front/myPagePostList.html").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//요청전달데이터 얻기
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		doGet(request, response);
	}

}
