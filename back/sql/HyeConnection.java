package sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// hyeconnection으로 usernname과 pwd 바꿨습니다.
public class HyeConnection {
	static {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {

		Connection con = null; // 초기화
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String password = "hr";

		con = DriverManager.getConnection(url, hr, hr);
		return con;
	}

	public static void close(ResultSet rs, Statement stmt, Connection con) {
//		DB연결 해제 : rs, stmt, con 연결해제
		if (rs != null) { // rs기 null면 종료할필요없음
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
	public static void close(Statement stmt, Connection con) {
		close(null,stmt,con);
	}
}
