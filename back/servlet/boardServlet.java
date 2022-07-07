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

import board.board;
import board.boardRepository;
import exception.FindException;

/**
 * Servlet implementation class boardServlet
 */
@WebServlet("/board")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public boardServlet() {
        super();
    }
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		boardRepository repo = new boardRepository();
		List<Board> boards;
		
		try {
			boards = repo.selectAll();
		} catch (FindException e) {
			e.printStackTrace();
			boards = new ArrayList<>();
		}

		String result = "[";
		for(int i=0; i<boards.size(); i++) {
			if(i>0) {
				result += ",";
			}
			Board b = boards.get(i);

			result +="{";
			result +="\"userNum\":";    result +="\""+b.getUserNo()+"\"";    result +=",";
			result +="\"userId\":";  result +="\""+b.getUserId()+"\"";   result +=",";
			result +="\"boardNum\":"; result +=b.getBoardNo(); 
			result +="\"boardContents\":"; result +=b.getContext(); 
			result +="\"createDate\":"; result +=b.getWriteDate(); 
			result +="}"; //json문자열
		}
		
		
		result += "]";
		out.print(result);
		
	}
	

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
