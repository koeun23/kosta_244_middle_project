package dto;
import java.util.Date;
import java.util.Objects;

public class TempProject {
	private int t_p_no;
	private int user_no;
	private String t_p_title;
	private String t_p_content;
	private Date t_p_createday;
	private Date t_p_deadlineday;
	private Date t_p_updateday;
	private Date t_p_deleteday;
	
	@Override
	public int hashCode() {
		return Objects.hash(t_p_no);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TempProject other = (TempProject) obj;
		return Objects.equals(t_p_no, other.t_p_no);
	}
	
	public int getT_p_no() {
		return t_p_no;
	}
	public void setT_p_no(int t_p_no) {
		this.t_p_no = t_p_no;
	}
	public int getUser_no() {
		return user_no;
	}
	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}
	public String getT_p_title() {
		return t_p_title;
	}
	public void setT_p_title(String t_p_title) {
		this.t_p_title = t_p_title;
	}
	public String getT_p_content() {
		return t_p_content;
	}
	public void setT_p_content(String t_p_content) {
		this.t_p_content = t_p_content;
	}
	public Date getT_p_createday() {
		return t_p_createday;
	}
	public void setT_p_createday(Date t_p_createday) {
		this.t_p_createday = t_p_createday;
	}
	public Date getT_p_deadlineday() {
		return t_p_deadlineday;
	}
	public void setT_p_deadlineday(Date t_p_deadlineday) {
		this.t_p_deadlineday = t_p_deadlineday;
	}
	public Date getT_p_updateday() {
		return t_p_updateday;
	}
	public void setT_p_updateday(Date t_p_updateday) {
		this.t_p_updateday = t_p_updateday;
	}
	public Date getT_p_deleteday() {
		return t_p_deleteday;
	}
	public void setT_p_deleteday(Date t_p_deleteday) {
		this.t_p_deleteday = t_p_deleteday;
	}

		
	}
	
	
