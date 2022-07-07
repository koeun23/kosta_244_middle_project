import java.util.Objects;

public class Introduce {
	private int introNo;//자기소개글번호
	private int userNo;//회원번호
	private String title;//자기소개서 제목
	private int age;//나이
	private String major;//전공
	private String context;//자기소개 내용
	
	public Introduce() {}
	public Introduce(int introNo,int userNo ,String title ,int age ,String major, String context) {
		this.introNo=introNo;
		this.userNo=userNo;
		this.title=title;
		this.age=age;
		this.major=major;
		this.context=context;
	}
	@Override
	public int hashCode() {
		return Objects.hash(introNo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Introduce other = (Introduce) obj;
		return Objects.equals(introNo, other.introNo);//prodNo.equals(other.prodNo)..
	}
	public int getIntroNo() {
		return introNo;
	}
	public void setIntroNo(int introNo) {
		this.introNo = introNo;
	}
	public int getUserNo() {
		return userNo;
	}
	public void setUserNo(int userNo) {
		this.userNo = userNo;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
}