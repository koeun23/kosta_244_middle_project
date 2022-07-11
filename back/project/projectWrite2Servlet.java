package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exception.FindException;

/**
 * Servlet implementation class projectWrite2Servlet
 */
@WebServlet("/projectWrite2")
public class projectWrite2Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public projectWrite2Servlet() {
        super();
    }

//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
// request 테스트 
//		 StringBuffer url = request.getRequestURL();
//	      String contextPath = request.getContextPath();
//	      String servletPath = request.getServletPath();
//	      System.out.println("url=" +url);  //http://localhost:8888/back/request
//	      System.out.println("contextPath=" + contextPath);  //back
//	      System.out.println("servletPath=" + servletPath);  //request
		
		
		response.setContentType("application/json; charset=utf-8");
//		HttpSession session = request.getSession();
		//로그인 되었는지 확인 해야되는데 일단 "A001" 데이터 넣어서 테스트함, 외래키 제약조건에 걸리므로 있는 데이터 써야함
				
		PrintWriter out = response.getWriter();
		projectRepository repo = new projectRepository();
//		Project p = new Project();
//		p.setuser_no(loginedId); //로그인정보로 userno 설정
//		List<pCategory> pcategory = new ArrayList<>();

		
		//로그인 된 사용자인가 확인하고 넘어가야함
		// null값이 들어가지 않게 확인필요
		
		out.print("start");
		try {
			//제목 내용 등 데이터를 받아서 project로 만들고 insert에 넘겨주기
			String userno = "A001";
			String title = request.getParameter("p_title");
			String content =  request.getParameter("p_content");
			String deadlineday = request.getParameter("deadlineDay");
			Project p = new Project(userno,title,content,deadlineday);
			
			int res = 0;
			res = repo.insert(p);
			if( res!=0) //insert에 성공하면 성공한 햏 횟수를 반환함
				out.print("성공");
			else
				out.print("실패");

		} catch (FindException | SQLException e) {
			e.printStackTrace();
		}


	}
}
