package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import exception.FindException;

/**
 * Servlet implementation class projectUpdateServlet
 */
@WebServlet("/projectUpdate")
public class projectUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public projectUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		projectRepository repo = new projectRepository();
	
		String user_no = "A001";
		String pNo = request.getParameter("p_no");
		int p_no = Integer.parseInt(pNo);
		String title = request.getParameter("p_title");
		String content =  request.getParameter("p_content");
		String deadlineday = request.getParameter("deadlineDay");
		Project p = new Project(p_no,user_no,title,content,deadlineday);
		System.out.println(title);
		int res = 0;
		
		try {
			res = repo.update(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// 모집글에 데이터 입력
		if( res!=0) //insert에 성공하면 성공한 햏 횟수를 반환함
			out.print("성공");
		else
			out.print("실패");

// 수정하기 버튼 눌렀을때 입력페이지랑 같은 형식을 보여주고
// 내용이 들어있어야함. 거기서 수정완료 버튼을 눌렀을때 글번호를 받아서 업데이트 해야함
		out.print(res);
	}


}
