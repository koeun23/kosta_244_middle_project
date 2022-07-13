package hye.myPage;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MyPageWebServlet
 */
@WebServlet("/myPostView")
public class MyPagePostViewWebServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MyPagePostViewWebServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("get방식으로 html 페이지를 호출한다.");
		
		String html = "";
		
		//목록에서 일반인지, 임시인지 
		String type = request.getParameter("type").toString();
		System.out.println(type);
		
		if("T".equals(type)) {
			html = "postTempView.html";
		}else{
			html = "myPostView.html";			
		}

		System.out.println(html);		
		
		//html파일 경로
		request.getRequestDispatcher("/WEB-INF/front/"+html).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// TODO Auto-generated method stub
		doGet(request, response);

	}

}
