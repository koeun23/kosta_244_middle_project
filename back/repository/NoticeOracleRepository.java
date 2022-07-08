import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.my.exception.AddException;
import com.my.exception.FindException;
import com.my.projectdto.Board;
import com.my.projectdto.Notice;
import com.my.sql.MyConnection;

public class NoticeOracleRepository implements NoticeRepository{
	@Override
	public void insert(Notice notice) throws AddException {
		Connection con = null;
		try {
			con = MyConnection.getConnection();
			insertInfo(con, notice);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			MyConnection.close(null, con);
		}
	}
	private void insertInfo(Connection con, Notice notice) throws SQLException{
		PreparedStatement pstmt = null;
		String insertInfoSQL = 
				"INSERT INTO notice(admin_id,board_no,title,b_content,b_createday) VALUES (admin,board_no.NEXTVAL, ? , ? ,SYSDATE)";
		pstmt = con.prepareStatement(insertInfoSQL);
		pstmt.setString(1, notice.getTitle());
		pstmt.setString(2, notice.getB_content());
		pstmt.executeUpdate();
	}
		
	public List<Notice> selectAll() throws FindException {

		List<Notice> notices = new ArrayList<>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String selectboardALLSQL = "SELECT * FROM notice order by board_no ASC";
		try {
			con = MyConnection.getConnection();
			pstmt = con.prepareStatement(selectboardALLSQL);

			rs = pstmt.executeQuery();
			//System.out.println(boards.size());
			while(rs.next()) {
				int boardNo = rs.getInt("board_no");
				String adminId = rs.getString("admin_id");
				String title = rs.getString("title");
				String content = rs.getString("b_content");
				Date createDay = rs.getDate("b_createday");
			
				Notice b = new Notice(boardNo,adminId,title,content,createDay);
				notices.add(b);
			}
			if(notices.size()==0) {
				throw new FindException("글이 없습니다");
			}
			return (notices);
		}catch(SQLException e){
			e.printStackTrace();
			throw new FindException(e.getMessage());
			
		}finally {
			MyConnection.close(rs, pstmt, con);
		}
		
	}
	public Notice selectByboardNo(int boardNo) throws FindException {
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
				String adminId = rs.getString("userId");
				String title = rs.getString("title");
				String content = rs.getString("b_contents");
				java.sql.Date createDay = rs.getDate("b_createday");
				
				Notice b = new Notice(boardNo,adminId,title,content,createDay);
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
	
	
	
	
 	@Override
	public List<Notice> selectByBoardNo(int boardNo) throws FindException {
		//최근 주문 내역 상품번호순으로 
 		PreparedStatement pstmt=null;
 		Connection con=null;
 		String selectLineSQL="";
 		
 		try {
			con = MyConnection.getConnection();
			pstmt=con.prepareStatement(selectLineSQL);
			pstmt.execute();
		} catch (SQLException e) {
			
		}
		return null;
	}
}