package com.my.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.my.dto.Project;
import com.my.sql.MyConnection;


/**
 * Servlet implementation class projectWrite2Servlet
 */
@WebServlet("/projectWrite2")
public class ProjectListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ProjectListServlet() {
        super();
    }
//
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
//	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");//ISO_88859_1
		PrintWriter out=response.getWriter();//응답출력스트림 얻기

        //String p_no=request.getParameter("p_no");

        //DB와의 연결
		Connection con=null;
		//SQL송신
		PreparedStatement pstmt=null;
		//응답결과
		ResultSet rs=null;
		String result=null;
		
		try {
			con=MyConnection.getConnection();
			String selectBoardSQL="SELECT * FROM project_tb";
			pstmt=con.prepareStatement(selectBoardSQL);
			rs=pstmt.executeQuery();
			if(rs.next()) {//전달받은 글번호와 일치하는 DB 데이터가 있을 경우에는
				String p_no= rs.getString("p_no");
				String user_no = rs.getString("user_no");
	               String p_title=rs.getString("p_title");
	               String p_content=rs.getString("p_content");
	               int p_views = rs.getInt("p_views");
	               String p_createday = rs.getString("p_createday");
	               System.out.println(p_no);
	               System.out.println(p_title);
	               System.out.println(p_content);
	               
	               ObjectMapper mapper = new ObjectMapper();
	               Map<String, Object>map = new HashMap<>();
	               map.put("p_no", p_no);
	               map.put("p_content", p_content);
	               map.put("p_title", p_title);
	               result = mapper.writeValueAsString(map);
	            
		    }else {//입력한 정보와 일치하는 게시글이 없으면
				result="{\"status\":0}";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MyConnection.close(rs,pstmt,con);
		}
		
		out.print(result);
	}
}
