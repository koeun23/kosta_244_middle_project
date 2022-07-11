package project;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		projectRepository repo = new projectRepository();
		List<Project> projects;
		
		String feild=request.getParameter("field");
		//
//		repo.insert();
//		Product p = new()
		
		
		try {
			projects = repo.selectAll();
		} catch (FindException e) {
			e.printStackTrace();
			projects = new ArrayList<>();
		}

//		String result = "[";
//		for(int i=0; i<projects.size(); i++) {
//			if(i>0) {
//				result += ",";
//			}
//			Project p = projects.get(i);
//
//			result +="{";
//			result +="\"p_no\":";    result +="\""+p.getp_no()+"\"";    result +=",";
//			result +="\"p_title\":";  result +="\""+p.getP_title()+"\"";   result +=",";
//			result +="\"p_content\":"; result +=p.getP_content(); 
//			result +="\"p_createday\":"; result +=p.getP_createday(); 
//			result +="\"P_deadlineday\":"; result +=p.getP_deadlineday(); 
//			result +="}"; //json문자열
//		}
//		
//		
//		result += "]";
//		out.print(result);
		
	}
}
