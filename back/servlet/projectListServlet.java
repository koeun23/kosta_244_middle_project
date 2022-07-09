package com.my.testproject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.my.sql.MyConnection;

/**
 * Servlet implementation class projectList
 */
public class projectList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public projectList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		//From Here, we get the pageNumber data from sql!!
		String p_no = request.getParameter("p_no");
		//DB Connection
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String result = null;
		System.out.println("p_no");
		
		try {
			con=MyConnection.getConnection();
			String selectBoardSQL="SELECT * FROM project_tb";
			pstmt = con.prepareStatement(selectBoardSQL);
			//How to show is not decided
			pstmt.setString(1, null);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				response.sendRedirect("http/...");
				out.print(false);
			} else {
				result="{\"status\":0}";
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnection.close(rs, pstmt, con);
		}
	}

}
