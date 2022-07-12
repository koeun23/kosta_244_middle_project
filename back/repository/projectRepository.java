package com.my.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.my.dto.Project;
import com.my.exception.FindException;
import com.my.sql.MyConnection;

public class projectRepository {
	public void insert() throws FindException   {
		List<Project> projects = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectprojectSQL = "Select * from project_tb";
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectprojectSQL);
			pstmt.setString(1, "sq_tb_no.textval");
		}catch(SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			
		}
	}
	
	public List<Project> selectAll() throws FindException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectprojectSQL = "SELECT * FROM project_tb";
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectprojectSQL);
			rs = pstmt.executeQuery();
			List<Project> list = new ArrayList<>();
			while(rs.next()) {
				int p_no = rs.getInt("p_no");
				int userno = rs.getInt("userno");
				String p_title = rs.getString("p_title");
				String p_content = rs.getString("p_content");
				int p_views = rs.getInt("p_views");
				String p_createday = rs.getString("p_createday");
				String p_updateday = rs.getString("p_updateday");
				String p_deadlineday = rs.getString("p_deadlineday");
				String p_deleteday = rs.getString("p_deleteday");
				Project p = new Project(p_no, userno, p_title, p_content, p_views, p_createday, p_updateday, p_deadlineday, p_deleteday);
				list.add(p);
			}
			if(list.size()==0) {
				throw new FindException("~~`없습니다");
			}
			return list;
		}catch(SQLException e) {
			e.printStackTrace();
			throw new FindException(e.getMessage());
		} finally {
			MyConnection.close(rs, pstmt, con);
		}
	}
  }
