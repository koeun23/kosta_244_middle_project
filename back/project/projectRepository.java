package project;


import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.FindException;
import sql.MyConnection;


public class projectRepository {


	
	public int insert(Project p) throws FindException, SQLException {
		Connection con = null;
		int res = 0;
		try {
			con = MyConnection.getConnection();
			res = insertproject(con, p);
//			insertpCategory(con, p.getP_category());
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnection.close(null, con);
		}
		return res;
	}										
	private int insertpCategory(Connection con, List<pCategory> pCate) throws SQLException {
		// 카테고리 코드가 입력된 만큰 테이블에 추가
		int res = 0;
		for(pCategory pCategorys : pCate) {
			PreparedStatement pstmt = null;
			String insertpCategorySQL = 
					"INSERT INTO p_category VALUES (?, ?)";
			pstmt = con.prepareStatement(insertpCategorySQL);
			
			int p_no = pCategorys.getP_no();
			int p_catecode = pCategorys.getCatecode();
			pstmt.setInt(1, p_no );
			pstmt.setInt(2, p_catecode);
			res = pstmt.executeUpdate(); //1이면 입력 성공
		}
		return res;
		
		
	}
	private int insertproject(Connection con, Project p) throws SQLException {
		int res = 0;
		PreparedStatement pstmt = null;
		String insertInfoSQL = 
				"INSERT INTO project_tb (p_no,user_no,p_title,p_content,p_createday,p_deadlineday) "
				+ "VALUES (sq_tb_no.nextval, ?, ?, ? ,SYSDATE, ?)";
		pstmt = con.prepareStatement(insertInfoSQL);
//		pstmt.setString(1, p.getuser_no());
		pstmt.setString(1, p.getuser_no());
		pstmt.setString(2, p.getP_title());
		pstmt.setString(3, p.getP_content());
		pstmt.setString(4, p.getP_deadlineday());
		res = pstmt.executeUpdate();
		return res;
	}
	public List<Project> selectAll() throws FindException {

		List<Project> projects = new ArrayList<>();
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
				String user_no = rs.getString("user_no");
				//System.out.println(userNum);
				String p_title = rs.getString("p_title");
				String p_content = rs.getString("p_content");
//				String createDate = rs.getDate("p_createday");
//				String deadlineDate = rs.getDate("p_deadlineday");
				String deadlineDate = rs.getString("p_deadlineday");
				Project p = new Project(user_no, p_title, p_content, deadlineDate );
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
//	public Project selectByp_title(String p_title) throws FindException {
//		Connection con = null;
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		String select_title = "SELECT * FROM project_tb WHERE p_title=?";
//		try {
//			con = MyConnection.getConnection();
//			pstmt = con.prepareStatement(select_title);
//			pstmt.setString(1, p_title);
//			rs = pstmt.executeQuery();
//			if(rs.next()) {
////				int p_no = rs.getInt("p_no");
//				String userNo = rs.getString("user_no");
//				String p_content = rs.getString("p_content");
////				Date createDate = rs.getDate("p_createday");
//				Date deadlineDate = rs.getDate("p_deadlineday");
//				
//				Project p = new Project(userNo, p_title, p_content, deadlineDate );
//				return p;
//			}else {
//				throw new FindException("글이 없습니다");
//			}
//		
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw new FindException(e.getMessage());
//		}finally {
//			MyConnection.close(rs, pstmt, con);
//		}
//	
//		
//	}
	public void update() {
		
	}

}
