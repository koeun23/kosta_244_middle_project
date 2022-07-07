import java.util.Date;
import java.util.Objects;

public class Notice {
	private int boardNo;//공지사항 글번보
	String adminId;//관리자아이디
	String title;//공지사항 제목
    String Context;//공지사항 글내용
	int viewCount;//공지사항 조회수
	Date writeDate;//작성일자
	Date updateDate;//수정일자
	Date deleteDate;//삭제일자
	
	public Notice(){}
	public Notice(int boardNo,String adminId,String title,Date writeDate) {
		this.boardNo=boardNo;
		this.adminId=adminId;
		this.title=title;
		this.writeDate=writeDate;
	}
	public Notice(int boardNo,String adminId,String title,Date writeDate,Date updateDate) {
		this.boardNo=boardNo;
		this.adminId=adminId;
		this.title=title;
		this.writeDate=writeDate;
		this.updateDate=updateDate;
	}
	@Override
	public int hashCode() {
		return Objects.hash(boardNo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Notice other = (Notice) obj;
		return Objects.equals(boardNo, other.boardNo);//prodNo.equals(other.prodNo)..
	}
	public int getBoardNo() {
		return boardNo;
	}
	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}
	public String getAdminId() {
		return adminId;
	}
	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getViewCount() {
		return viewCount;
	}
	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}
	public Date getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}
	public Date getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}
	public Date getDeleteDate() {
		return deleteDate;
	}
	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}
	
}

