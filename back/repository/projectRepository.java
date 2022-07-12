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

	/*
	 * public void insert() throws FindException, SQLException { List<Project>
	 * projects = new ArrayList<>(); Connection con = null; PreparedStatement pstmt
	 * = null; ResultSet rs = null; String insertprojectSQL =
	 * "INSERT INTO PROJECT_TB VALUES(?,?,?,?,?)"; try { con =
	 * MyConnection.getConnection(); pstmt = con.prepareStatement(insertprojectSQL);
	 * pstmt.setString(0, "sq_tb_no.nextval");
	 * 
	 * }finally {
	 * 
	 * }
	 * 
	 * 
	 * 
	 * pstmt = con.prepareStatement("UPDATE SAMPLE_TABLE SET NAME=? WHERE ID = ?");
	 * pstmt.setString(1, "Park"); pstmt.setInt(2, 100); int ret =
	 * pstmt.executeUpdate(); System.out.println("Return : " + ret ); }
	 * 
	 * public List<Project> selectAll() throws FindException {
	 * 
	 * List<Project> projects = new ArrayList<>(); Connection con = null;
	 * PreparedStatement pstmt = null; ResultSet rs = null; String
	 * selectprojectALLSQL = "SELECT * FROM project_tb order by p_no ASC"; try { con
	 * = projectConnection.getConnection(); pstmt =
	 * con.prepareStatement(selectprojectALLSQL);
	 * 
	 * rs = pstmt.executeQuery(); //System.out.println(boards.size());
	 * while(rs.next()) { int p_no = rs.getInt("p_No"); int user_no =
	 * rs.getInt("user_no"); //System.out.println(userNum); String p_title =
	 * rs.getString("p_title"); String p_content = rs.getString("p_content");
	 * java.sql.Date createDate = rs.getDate("p_createday"); java.sql.Date
	 * deadlineDate = rs.getDate("p_deadlineday"); Project p = new Project(user_no,
	 * p_title, p_content, createDate, deadlineDate ); projects.add(p); }
	 * if(projects.size()==0) { throw new FindException("글이 없습니다"); } return
	 * (projects); }catch(SQLException e){ e.printStackTrace(); throw new
	 * FindException(e.getMessage());
	 * 
	 * }finally { MyConnection.close(rs, pstmt, con); }
	 * 
	 * } // 프로젝트 글 제목으로 검색 public Project selectByp_title(String p_title) throws
	 * FindException { Connection con = null; PreparedStatement pstmt = null;
	 * ResultSet rs = null; String select_title =
	 * "SELECT * FROM project_tb WHERE p_title=?"; try { con =
	 * MyConnection.getConnect(); pstmt = con.prepareStatement(select_title);
	 * pstmt.setString(1, p_title); rs = pstmt.executeQuery(); if(rs.next()) { //
	 * int p_no = rs.getInt("userNo"); int userNo = rs.getInt("user_no"); String
	 * p_content = rs.getString("p_content"); java.sql.Date createDate =
	 * rs.getDate("p_createday"); java.sql.Date deadlineDate =
	 * rs.getDate("p_deadlineday");
	 * 
	 * Project p = new Project(userNo, p_title, p_content, createDate, deadlineDate
	 * ); return p; }else { throw new FindException("글이 없습니다"); }
	 * 
	 * 
	 * } catch (SQLException e) { e.printStackTrace(); throw new
	 * FindException(e.getMessage()); }finally { MyConnection.close(rs, pstmt, con);
	 * }
	 * 
	 * 
	 * } public void update() {
	 * 
	 * }
	 * 
	 */}
