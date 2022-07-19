package project;

import java.io.IOException;
import java.io.PrintWriter;
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
 * Servlet implementation class projectViewServlet
 */
@WebServlet("/projectView")
public class projectViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public projectViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=utf-8");
		PrintWriter out = response.getWriter();
		projectRepository repo = new projectRepository();
		Project p = null;
		String result;
		ObjectMapper mapper =  new ObjectMapper();
		Map<String, Object> map = new HashMap<>();
//		objectmmapper로 json 문자열 만듬
		try {
			String P_no= request.getParameter("p_no");
			int p_no=Integer.parseInt(P_no);
			p = repo.selectByprojectNumber(p_no);
			map.put("status", 1);
			map.put("project", p);
		}catch(FindException e){
			e.printStackTrace();
			map.put("status", 0);
			map.put("msg", e.getMessage());
			
		}
//		//:
//		String result = mapper.writeValueAsString(map);
//		String result ="{";
//			result +="\"p_no\":";  result +="\""+p.getp_no()+"\"";   result +=",";
//			result +="\"p_title\":";    result +="\""+p.getP_title()+"\"";    result +=",";
//			result +="\"p_content\":";  result +="\""+p.getP_content()+"\"";   result +=",";
//			result +="\"p_userno\":";  result +="\""+p.getuser_no()+"\"";   result +=",";
//			result +="\"p_createday\":";  result +="\""+p.getP_createday()+"\"";   result +=",";
//			result +="\"p_view\":";  result +="\""+p.getP_view()+"\"";
//			result +="\"p_deadlineday\":"; result +=p.getP_deadlineday(); //숫자는 \" 필요없음
//			result +="}"; //json문자열
//		
		
		
//		result += "]";

		result = mapper.writeValueAsString(map);
		out.print(result);
	}
	



}
