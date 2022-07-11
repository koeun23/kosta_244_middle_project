package hye.myPage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MyPagePostRepository {

	Connection con = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    /*나의 임시글 목록 조회 호출*/
	public List<MyPagePostDTO> tempProjectList() {

		List<MyPagePostDTO> list = new ArrayList<MyPagePostDTO>();
		 
		try {
			
            con = DBConnection.getConnect();
            String query = "SELECT T_P_NO, USER_NO, T_P_TITLE, T_P_CONTENT, T_P_CREATEDAY, T_P_DEADLINEDAY, T_P_UPDATEDAY, T_P_DELETEDAY FROM TEMP_PROJECT_TB";
			System.out.println(query);
			
			pstmt = con.prepareStatement(query);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {

				int tTNo = 				rs.getInt("T_P_NO");			//게시판번호
				String userNo = 		rs.getString("USER_NO");		//사용자 번호
				String tPTitle = 		rs.getString("T_P_TITLE");		//제목
				String tPContent = 		rs.getString("T_P_CONTENT");		//내용
				String tPCreateday = 	rs.getString("T_P_CREATEDAY");		//생성일
				String tPDeadlineday = 	rs.getString("T_P_DEADLINEDAY");		//종료일
				String tPUpdateday = 	rs.getString("T_P_UPDATEDAY");		//수정일
				String tPDeleteday	=	rs.getString("T_P_DELETEDAY");		//삭제일
				
				MyPagePostDTO dto = new MyPagePostDTO();
				
				dto.settTNo(tTNo);
				dto.setUserNo(userNo);
				dto.settPTitle(tPTitle);
				dto.settPContent(tPContent);
				dto.settPCreateday(tPCreateday);
				dto.settPDeadlineday(tPDeadlineday);
				dto.settPUpdateday(tPUpdateday);
				dto.settPDeleteday(tPDeleteday);

				list.add(dto);
				
			}
			
			rs.close();
			pstmt.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
		
	}
	
    /*게시판 등록 쿼리 호출*/
	public int boardInsert(MyPagePostDTO myProjectDTO) throws Exception {

		int result = 0;
		
		//Q. 쿼리는 에러가 날 수 밖에 없다. 게시판번호 컬럼에 값을 넣어주는 부분이 없기 때문
		final String query = "INSERT INTO BBOARD(BOARDNUM, BOARDWRITER, BOARDTITLE, BOARDCONTENT) VALUES(?, ?, ?, ?)";
		
		try {
			
			//con = DBConnection.getConnect();
			//pstmt = con.prepareStatement(query);
			
			//pstmt.setString(1, myProjectDTO.getBoardWriter());
			//pstmt.setString(2, myProjectDTO.getBoardTitle());
			//pstmt.setString(3, myProjectDTO.getBoardWriter());

			//insert 성공하면 1 int 값 리턴
			result  = pstmt.executeUpdate();
			
		} catch(Exception e) {
			throw e;
		} finally {
			try {
				if(con != null) con.close();
				if(pstmt != null) pstmt.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}

}
