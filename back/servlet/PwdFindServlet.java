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
import javax.servlet.http.HttpSession;

import com.my.sql.MyConnection;


@WebServlet("/pwdfind")
public class PwdFindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see 비밀번호 찾기 버튼 눌렀을 떄
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");//ISO_88859_1
		PrintWriter out=response.getWriter();//응답출력스트림 얻기
		HttpSession session=request.getSession();
		
		
		String name=request.getParameter("name");
		String id=request.getParameter("id");
		String email=request.getParameter("email");
		System.out.println("name="+name+" id="+id+" email="+email);
		//DB와의 연결
		Connection con=null;
		//SQL송신
		PreparedStatement pstmt=null;
		//응답결과
		ResultSet rs=null;
		String result=null;
		
		
		try {
			con=MyConnection.getConnection();
			String selectIdNPwdSQL="SELECT * FROM customer WHERE userName=? AND userId=? AND userEmail=?";
			pstmt=con.prepareStatement(selectIdNPwdSQL);
			pstmt.setString(1, name);
			pstmt.setString(2, id);
			pstmt.setString(3, email);
			rs=pstmt.executeQuery();
			if(rs.next()) {//입력한 정보와 일치하는 회원정보가 있으면 로그인 된 상태로 만들자 
				result="{\"status\":1}";
				session.setAttribute("loginInfo", id);
				//그리고 redirect를 이용해서 비밀번호 변경하는 페이지로 이동하자
				response.sendRedirect("http://localhost:8888/front/project_html/pwdUpdate.html");
			}else {//입력한 정보와 일치하는 회원정보가 없다면
				result="{\"status\":0}";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			MyConnection.close(rs,pstmt,con);
		}
		
		out.print(result);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
