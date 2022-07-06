package board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import exception.FindException;
import sql.MyConnection;

public class boardRepository  {
	//자유게시판 저장소
	//
	
	public void insert() {
		
	}
	public List<board> selectAll() throws FindException {

		List<board> boards = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectboardALLSQL = "SELECT * FROM board_tb order by boardNo ASC";
		try {
			con = boardConnection.getConnection();
			pstmt = con.prepareStatement(selectboardALLSQL);

			rs = pstmt.executeQuery();
			//System.out.println(boards.size());
			while(rs.next()) {
				int userNum = rs.getInt("userNo");
				//System.out.println(userNum);
				String userId = rs.getString("userId");
				int boardNum = rs.getInt("boardNo");
				String boardContents = rs.getString("b_content");
				java.sql.Date createDate = rs.getDate("b_createday");
			
				board b = new board(userNum, userId, boardNum, boardContents, createDate);
				boards.add(b);
			}
			if(boards.size()==0) {
				throw new FindException("글이 없습니다");
			}
			return (boards);
		}catch(SQLException e){
			e.printStackTrace();
			throw new FindException(e.getMessage());
			
		}finally {
			MyConnection.close(rs, pstmt, con);
		}
		
	}
	public board selectByboardNum(int boardNo) throws FindException {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectboardNumSQL = "SELECT * FROM board_tb WHERE boardNo=?";
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectboardNumSQL);
			pstmt.setLong(1, boardNo);
			rs = pstmt.executeQuery();
			if(rs.next()) {
				int userNum = rs.getInt("userNo");
				String userId = rs.getString("userId");
				String boardContents = rs.getString("b_contents");
				java.sql.Date createDate = rs.getDate("b_createday");
				
				board b = new board(userNum, userId, boardNo, boardContents, createDate);
				return b;
			}else {
				throw new FindException("상품이 없습니다");
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
