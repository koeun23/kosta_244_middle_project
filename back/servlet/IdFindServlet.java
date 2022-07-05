package com.my.projectServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.my.sql.MyConnection;


@WebServlet("/Idfind")
public class IdFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see 아이디 찾기 버튼 눌렀을 때
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");//ISO_88859_1
		PrintWriter out=response.getWriter();//응답출력스트림 얻기
		
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		//DB와의 연결
		Connection con=null;
		//SQL송신
		PreparedStatement pstmt=null;
		//응답결과
		ResultSet rs=null;
		String result="{\"status\":0}";
		
		try {
			con=MyConnection.getConnection();
			String selectIdNPwdSQL="SELECT * FROM customer WHERE name=? AND id=?";
			pstmt=con.prepareStatement(selectIdNPwdSQL);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			rs=pstmt.executeQuery();
			if(rs.next()) {//입력한 정보와 일치하는 회원정보가 있으면 id값을 알려주자
				String customerId = rs.getString("id");//DB에 저장되어 있는 회원 아이디를 찾고
				out.print(customerId);//클라이언트에게 아이디 출력
				result="{\"status\":1}";//성공했다는 의미
			}else {
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MyConnection.close(rs,pstmt,con);
		}
		
		
		out.print(result);
	}

}
