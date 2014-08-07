package org.smaple.vali;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class User2 {

	@NotEmpty(message = "���̵� �Է��Ͽ��� �մϴ�.")
	@Size(min = 6, max = 10, message = "���̴� {2}���� {1} ���̷� �ؾ��մϴ�.")
	private String userId;
	@NotEmpty(message = "�̸��� �Է��Ͽ��� �մϴ�.")
	private String name;
	@NotEmpty(message = "��й�ȣ�� �Է��Ͽ��� �մϴ�.")
	@Size(min = 8, max = 16, message = "���̴� {2}���� {1} ���̷� �ؾ��մϴ�.")
	private String password;
	@NotEmpty(message = "��й�ȣ Ȯ���� �Է��Ͽ��� �մϴ�.")
	private String pwConfirm;
	@NotEmpty(message = "�̸����� �Է��Ͽ��� �մϴ�.")
	@Pattern(regexp="^[_a-z0-9-]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$", message = "�̸��� ������ Ʋ���ϴ�.")
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
