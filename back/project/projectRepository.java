package project;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.FindException;
import sql.MyConnection;


public class projectRepository {


	
	public void insert() {
		
	}
	public List<project> selectAll() throws FindException {

		List<project> projects = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectprojectALLSQL = "SELECT * FROM project_tb order by p_no ASC";
		try {
			con = projectConnection.getConnection();
			pstmt = con.prepareStatement(selectprojectALLSQL);

			rs = pstmt.executeQuery();
			//System.out.println(boards.size());
			while(rs.next()) {
				int p_no = rs.getInt("p_No");
				int userNo = rs.getInt("userNo");
				//System.out.println(userNum);
				String p_title = rs.getString("p_title");
				String p_content = rs.getString("p_content");
				java.sql.Date createDate = rs.getDate("p_createday");
				java.sql.Date deadlineDate = rs.getDate("p_deadlineday");
			
				project p = new project(p_no, userNo, p_title, p_content, createDate, deadlineDate );
				projects.add(p);
			}
			if(projects.size()==0) {
				throw new FindException("글이 없습니다");
			}
			return (projects);
		}catch(SQLException e){
			e.printStackTrace();
			throw new FindException(e.getMessage());
			
		}finally {
			MyConnection.close(rs, pstmt, con);
		}
		
	}
	// 프로젝트 글 제목으로 검색
	public project selectByp_title(String p_title) throws FindException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectp_title = "SELECT * FROM project_tb WHERE p_title=?";
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectp_title);
			pstmt.setString(1, p_title);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int p_no = rs.getInt("userNo");
				int userNo = rs.getInt("userNo");
				String p_content = rs.getString("p_content");
				java.sql.Date createDate = rs.getDate("p_createday");
				java.sql.Date deadlineDate = rs.getDate("p_deadlineday");
				
				project p = new project(p_no, userNo, p_title, p_content, createDate, deadlineDate );
				return p;
			}else {
				throw new FindException("글이 없습니다");
			}
		
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		}finally {
			MyConnection.close(rs, pstmt, con);
		}
	
		
	}
	public void update() {
		
	}

}
