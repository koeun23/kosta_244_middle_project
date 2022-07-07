package project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class projectConnection {
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
		String SQL = "SELECT * from post_tb order by postNo";
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
//	
//	public int write(int userno, String p_title, String p_content, Date deadlineDay) {
//		String SQL = "insert into post_tb values"
//				+ "(?,?,?,?,?,?,?,?,?,?);";
//		try {
//			PreparedStatement pstmt = con.prepareStatement(SQL);
//			pstmt.setInt(1, getNext()); //게시물번호
//			pstmt.setInt(2, userno); //회원번호 -> 회원아이디로 표시해야될거같음?
//			pstmt.setString(3, p_title); //글 제목
//			pstmt.setString(4, p_content); //글 내용
////			pstmt.setInt(5,  );
////			pstmt.setInt(6, );
////			pstmt.Date(7, getDate);// 작성날짜
////			pstmt.Date(8, getDate);// 작성날짜
////			pstmt.Date(9, getDate);// 작성날짜
////			pstmt.Date(10, getDate);// 작성날짜
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
