package hanium.opo.dto;

public class UserDTO {
	private String userId;
	private String userPw;
	private String userName;
	private String email;
	private String addr;
	private String phone;
	private int auth;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPw() {
		return userPw;
	}
	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getAuth() {
		return auth;
	}
	public void setAuth(int auth) {
		this.auth = auth;
	}
	@Override
	public String toString() {
		return "UserDTO [userId=" + userId + ", userPw=" + userPw + ", userName=" + userName + ", email=" + email
				+ ", addr=" + addr + ", phone=" + phone + ", auth=" + auth + "]";
	}
	
	
}
