package board;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class boardConnection {
	private static Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	static {
		// 2. jdbc driver 클래스로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {

		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "webtest";
		String password = "1234";

		con = DriverManager.getConnection(url, user, password);
		System.out.println("오라클 연결 성공");
		return con;
	}


	
	public String getDate() {
		String SQL = "SELECT NOW()";
		try {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getString(1);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public int getNext() {
		String SQL = "SELECT * from board_tb order by boardNo";
		try {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1)+1;
			}
			return 1;//첫번쨰 게시글
		}catch(Exception e) {
			e.printStackTrace();
		}
		return -1; //데이터베이스 오류
	}
	
//	public int write() {
//		String SQL = "INSERT INTO BOARD_TB VALUES(?,?,?,?,?)";
//		try {
//			PreparedStatement pstmt = con.prepareStatement(SQL);
//			pstmt.setInt(1, getNext());
//			pstmt.setString(2, userId);
//			pstmt.setInt(3, boardNum);
//			pstmt.setString(4, boardContents);
//			pstmt.setStringInt(5, getDate);
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
//				return rs.getInt(1)+1;
//			}
//			return 1;//첫번쨰 게시글
//		}catch(Exception e) {
//			e.printStackTrace();
//		}
//		return -1; //데이터베이스 오류
//	}
}
