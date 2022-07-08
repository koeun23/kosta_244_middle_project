package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.boardRepository;
import exception.FindException;
import project.Project;
import project.projectRepository;

/**
 * Servlet implementation class projectWriteServlet
 */
@WebServlet("/projectWrite")
public class projectWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public projectWriteServlet() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		projectRepository repo = new projectRepository();
		List<Project> projects;
		
		try {
			projects = repo.selectAll();
		} catch (FindException e) {
			e.printStackTrace();
			projects = new ArrayList<>();
		}

		String result = "[";
		for(int i=0; i<projects.size(); i++) {
			if(i>0) {
				result += ",";
			}
			Project p = projects.get(i);

			result +="{";
			result +="\"postNo\":";    result +="\""+p.getPostNo()+"\"";    result +=",";
			result +="\"PTitle\":";  result +="\""+p.getP_title()+"\"";   result +=",";
			result +="\"pContetn\":"; result +=p.getP_content(); 
			result +="\"p_Createday\":"; result +=p.getP_createDay(); 
			result +="\"P_Deadlineday\":"; result +=p.getP_deadlineDay(); 
			result +="}"; //json문자열
		}
		
		
		result += "]";
		out.print(result);
		
	}
	

}
