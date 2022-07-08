package board;

import java.sql.Date;
import java.util.Objects;

public class board {
	private int userNo;
	private String userId;
	private int boardNo;
	private String b_Content;
	private java.sql.Date b_createDay;
	private java.sql.Date b_reviseDay;
	private java.sql.Date b_deleteDay;

	public board() {
	}

	public board(int userNo, String userId, int boardNo, String b_Content, Date b_createDay) {
		this.userNo = userNo;
		this.userId = userId;
		this.boardNo = boardNo;
		this.b_Content = b_Content;
		this.b_createDay = b_createDay;
	}
	public board(int userNo, String userId, int boardNo, String b_Content, Date b_createDay, Date b_reviseDay, Date b_deleteDay){
		this.userId = userId;
		this.boardNo = boardNo;
		this.b_Content = b_Content;
		this.b_createDay = b_createDay;
		this.b_reviseDay = b_reviseDay;
		this.b_deleteDay = b_deleteDay;
	}

	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		board other = (board) obj;
		return Objects.equals(boardNo, other.boardNo);
	}

	public int getUserNum() {
		return userNo;
	}

	public void setUserNum(int userNo) {
		this.userNo = userNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getBoardNum() {
		return boardNo;
	}

	public void setBoardNum(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardContents() {
		return b_Content;
	}

	public void setBoardContents(String b_Content) {
		this.b_Content = b_Content;
	}

	public Date getCreateDate() {
		return b_createDay;
	}

	public void setCreateDate(Date b_createDay) {
		this.b_createDay = b_createDay;
	}

	public Date getReviseDate() {
		return b_reviseDay;
	}

	public void setReviseDate(Date b_reviseDay) {
		this.b_reviseDay = b_reviseDay;
	}

	public Date getDeleteDate() {
		return b_deleteDay;
	}

	public void setDeleteDate(Date b_deleteDay) {
		this.b_deleteDay = b_deleteDay;
	}

}
