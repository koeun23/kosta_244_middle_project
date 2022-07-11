package dto;

public class MyPagePostDTO {
	
	
	/*Table TEMP_PROJECT_TB */
	
	private int tTNo;		//임시테이블 게시판번호
	private String userNo;		//유저 번호
	private String tPTitle;		//제목
	private String tPContent;		//내용
	private String tPCreateday;		//생성일		> regDate
	private String tPDeadlineday;	//종료일		시작일 > stDate stDt		종료일 edDt endDate	
	private String tPUpdateday;		//수정일		> modDate
	private String tPDeleteday;		//수정일
	
	public int gettTNo() {
		return tTNo;
	}
	public void settTNo(int tTNo) {
		this.tTNo = tTNo;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String gettPTitle() {
		return tPTitle;
	}
	public void settPTitle(String tPTitle) {
		this.tPTitle = tPTitle;
	}
	public String gettPContent() {
		return tPContent;
	}
	public void settPContent(String tPContent) {
		this.tPContent = tPContent;
	}
	public String gettPCreateday() {
		return tPCreateday;
	}
	public void settPCreateday(String tPCreateday) {
		this.tPCreateday = tPCreateday;
	}
	public String gettPDeadlineday() {
		return tPDeadlineday;
	}
	public void settPDeadlineday(String tPDeadlineday) {
		this.tPDeadlineday = tPDeadlineday;
	}
	public String gettPUpdateday() {
		return tPUpdateday;
	}
	public void settPUpdateday(String tPUpdateday) {
		this.tPUpdateday = tPUpdateday;
	}
	public String gettPDeleteday() {
		return tPDeleteday;
	}
	public void settPDeleteday(String tPDeleteday) {
		this.tPDeleteday = tPDeleteday;
	}

	@Override
	public String toString() {
		return "MyPagePostDTO [tTNo=" + tTNo + ", userNo=" + userNo + ", tPTitle=" + tPTitle + ", tPContent="
				+ tPContent + ", tPCreateday=" + tPCreateday + ", tPDeadlineday=" + tPDeadlineday + ", tPUpdateday="
				+ tPUpdateday + ", tPDeleteday=" + tPDeleteday + "]";
	}
	
	

}
