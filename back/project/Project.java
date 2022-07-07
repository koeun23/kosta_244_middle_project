package project;

import java.sql.Date;
import java.util.Objects;

public class Project {
	
	private int p_no;
	private int userNo;
	private String p_title;
	private String p_content;
	private int p_like;
	private int p_views;
	private java.sql.Date p_createDay;
	private java.sql.Date p_deadlineDay;
	private java.sql.Date p_updateDay;
	private java.sql.Date p_deleteDay;

	public Project() {
	}
	public Project(int p_no, int userNo, String p_title, String p_content,Date p_createDay, Date p_deadlineDay) {
		this.p_no = p_no;
		this.userNo = userNo;
		this.p_title = p_title;
		this.p_content = p_content;
		this.p_createDay = p_createDay;
		this.p_deadlineDay = p_deadlineDay;
	
	}

	public int getPostNo() {
		return p_no;
	}

	public void setPostNo(int postNo) {
		this.p_no = postNo;
	}

	public int getUserNo() {
		return userNo;
	}

	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}

	public String getP_title() {
		return p_title;
	}

	public void setP_title(String p_title) {
		this.p_title = p_title;
	}

	public String getP_content() {
		return p_content;
	}

	public void setP_content(String p_content) {
		this.p_content = p_content;
	}

	public int getP_like() {
		return p_like;
	}

	public void setP_like(int p_like) {
		this.p_like = p_like;
	}

	public int getP_views() {
		return p_views;
	}

	public void setP_views(int p_views) {
		this.p_views = p_views;
	}

	public java.sql.Date getP_createDay() {
		return p_createDay;
	}

	public void setP_createDay(java.sql.Date p_createDay) {
		this.p_createDay = p_createDay;
	}

	public java.sql.Date getP_deadlineDay() {
		return p_deadlineDay;
	}

	public void setP_deadlineDay(java.sql.Date p_deadlineDay) {
		this.p_deadlineDay = p_deadlineDay;
	}

	public java.sql.Date getP_updateDay() {
		return p_updateDay;
	}

	public void setP_updateDay(java.sql.Date p_updateDay) {
		this.p_updateDay = p_updateDay;
	}

	public java.sql.Date getP_deleteDay() {
		return p_deleteDay;
	}

	public void setP_deleteDay(java.sql.Date p_deleteDay) {
		this.p_deleteDay = p_deleteDay;
	}


}
