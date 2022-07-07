import java.util.Objects;

public class Customer{
    private int userNo;//회원번호
	private String userId;//회원아이디
	private String userPwd;//회원비밀번호
	private String userName;//회원이름
	private String userEmail;//회원 이메일 
	public Customer() {}

	public Customer(int userNo, String userId, String userPwd, String userName, String userEmail) {
		this.userNo = userNo;
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		this.userEmail = userEmail;
	}
	@Override
	public int hashCode() {
		return Objects.hash(userNo);
	}
	public boolean equals(Object obj) {
		if(this == obj){
	        return true;
	    }
		if (obj == null){
	        return false;
	    }
		if (getClass() != obj.getClass()){
	        return false;
	    }
		Customer other = (Customer) obj;
		return Objects.equals(userNo,other.userNo);
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

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}	
	
}

