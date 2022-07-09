
import java.sql.Date;
import java.util.Objects;

public class Project {
	
	private int p_no;
	private int user_no;
	private String p_title;
	private String p_content;
	private int p_view;
	private java.sql.Date p_createday;
	private java.sql.Date p_deadlineday;
	private java.sql.Date p_updateday;
	private java.sql.Date p_deleteday;

	public Project() {
	}
	//모든 데이터가 들어가는 생성자
	public Project(int p_no, int user_no, String p_title, String p_content, int p_view, 
			Date p_createday, Date p_deadlineday, Date p_updateday, Date p_deleteday) {
		this.p_no = p_no;
		this.user_no = user_no;
		this.p_title = p_title;
		this.p_content = p_content;
		this.p_view = p_view;
		this.p_createday = p_createday;
		this.p_deadlineday = p_deadlineday;
		this.p_updateday = p_updateday;;
		this.p_deleteday = p_deleteday;
	}
	//not null 값만 들어가는 생성자 (모집글 작성기준)
	public Project(int user_no, String p_title, String p_content,Date p_createday, Date p_deadlineday) {
		this.user_no = user_no;
		this.p_title = p_title;
		this.p_content = p_content;
		this.p_createday = p_createday;
		this.p_deadlineday = p_deadlineday;
	}

	public int getp_no() {
		return p_no;
	}

	public void setp_no(int postNo) {
		this.p_no = postNo;
	}

	public int getuser_no() {
		return user_no;
	}

	public void setuser_no(int user_no) {
		this.user_no = user_no;
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

	public int getP_view() {
		return p_view;
	}

	public void setP_view(int p_views) {
		this.p_view = p_views;
	}

	public java.sql.Date getP_createday() {
		return p_createday;
	}

	public void setP_createday(java.sql.Date p_createday) {
		this.p_createday = p_createday;
	}

	public java.sql.Date getP_deadlineday() {
		return p_deadlineday;
	}

	public void setP_deadlineday(java.sql.Date p_deadlineday) {
		this.p_deadlineday = p_deadlineday;
	}

	public java.sql.Date getP_updateday() {
		return p_updateday;
	}

	public void setP_updateday(java.sql.Date p_updateday) {
		this.p_updateday = p_updateday;
	}

	public java.sql.Date getP_deleteday() {
		return p_deleteday;
	}

	public void setP_deleteday(java.sql.Date p_deleteday) {
		this.p_deleteday = p_deleteday;
	}



}
