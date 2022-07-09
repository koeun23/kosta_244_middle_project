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

import com.my.dto.Customer; 
import com.my.sql.MyConnection;


public class EmailChkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Product sample = (Product)request.getAttribute("test");
		System.out.println(sample);
		
		String id = request.getParameter("email");
		String result = "{\"status\":0, \"msg\": \"이미 사용중인 이메일입니다\"}";
		
		//DB연결
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String selectemailChkSQL = "SELECT * FROM customer WHERE email = ?";
		try {
		    con = MyConnection.getConnection();
		    pstmt = con.prepareStatement(selectemailChkSQL);
		    pstmt.setString(1,  id);
		    rs = pstmt.executeQuery();
		    if(!rs.next()) {
		    	result = "{\"status\":1, \"msg\": \"사용가능한 이메일입니다\"}";
		    }	
		} catch(SQLException e) {
			e.printStackTrace();
			String msg = e.getMessage();
			result = "{\"status\":0, \"+ msg\"" + msg +"\"}";	
		} finally {
			MyConnection.close(rs,  pstmt, con);
		}
		
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(result);
	}

}