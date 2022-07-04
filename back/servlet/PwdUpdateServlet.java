package com.my.control;

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


public class PwdReviseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//요청전달데이터열기
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out=response.getWriter();

        //사용자가 입력한 변경할 비밀번호 값을 받아오자 
		String pwd=request.getParameter("pwd");
		//DB와의 연결
		Connection con=null;
		//SQL송신
		PreparedStatement pstmt=null;
		//응답결과
		ResultSet rs=null;
        //디폴트 값으로 result 0.. 
		String result="{\"status\":0}";
		
		//세션얻기(클라이언트별)
		HttpSession session=request.getSession();
        // 1) 비밀번호 변경 레이아웃에서 id값을 입력 받아서 
        //  비밀번호 변경할 때 아이디값을 가져와서 WHERE 절에 해당 아이디 값인 회원정보를 찾아 비밀번호를 UPDATE구문을 이용해 변경
        // 2) 해당 페이지에선 상태는 이미 로그인된 상태이다 그러므로 로그인정보를 이용해서 비밀번호 변경해줄 회원정보를 특정하고
        //  UPDATE문을 이용해서 비밀번호를 변경해준다.
		try {
			con=MyConnection.getConnection();
			String selectIdNPwdSQL="UPDATE customer_info SET pw=? WHERE";//where 절에 넣어주세요
			pstmt=con.prepareStatement(selectIdNPwdSQL);
			pstmt.setString(1, pwd);
			rs=pstmt.executeUpdate();
			if(rs.next()) {
                //비밀번호 변경이 성공적일 경우 status 1 값을 front로 전달 
				result="{\"status\":1}";
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
