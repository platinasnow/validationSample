package org.smaple.vali;

public class User {

	private String userId;
	private String name;
	private String password;
	private String pwConfirm;
	private String phoneNum;
	private String email;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPwConfirm() {
		return pwConfirm;
	}

	public void setPwConfirm(String pwConfirm) {
		this.pwConfirm = pwConfirm;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
