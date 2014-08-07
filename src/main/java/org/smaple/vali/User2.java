package org.smaple.vali;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class User2 {

	@NotEmpty(message = "아이디를 입력하여야 합니다.")
	@Size(min = 6, max = 10, message = "길이는 {2}에서 {1} 사이로 해야합니다.")
	private String userId;
	@NotEmpty(message = "이름을 입력하여야 합니다.")
	private String name;
	@NotEmpty(message = "비밀번호를 입력하여야 합니다.")
	@Size(min = 8, max = 16, message = "길이는 {2}에서 {1} 사이로 해야합니다.")
	private String password;
	@NotEmpty(message = "비밀번호 확인을 입력하여야 합니다.")
	private String pwConfirm;
	@NotEmpty(message = "이메일을 입력하여야 합니다.")
	@Pattern(regexp="^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$", message = "이메일 형식이 틀립니다.")
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
