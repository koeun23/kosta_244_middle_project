import java.util.Date;
import java.util.Objects;

public class Board {
	private int userNo;
	private String userId;
	private int boardNo;
	private String context;
	private Date writeDate;
	private Date updateDate;
	private Date deleteDate;

	public Board() {
	}

	public Board(int userNo, String userId, int boardNo, String context, Date writeDate) {
		this.userNo = userNo;
		this.userId = userId;
		this.boardNo = boardNo;
		this.context = context;
		this.writeDate = writeDate;
	}
	public Board(int userNo, String userId, int boardNo, String context, Date writeDate, Date updateDate, Date deleteDate){
        this.userNo = userNo;
		this.userId = userId;
		this.boardNo = boardNo;
		this.context = context;
		this.writeDate = writeDate;
		this.updateDate = updateDate;
		this.deleteDate = deleteDate;
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
		Board other = (Board) obj;
		return Objects.equals(boardNo, other.boardNo);//prodNo.equals(other.prodNo)..
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getContext() {
		return context;
	}

	public void setContext(String context) {
		this.context = context;
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