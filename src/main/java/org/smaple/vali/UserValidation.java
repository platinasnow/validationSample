package org.smaple.vali;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class UserValidation  implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User)target;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "�̸��� �Է��ϼ���.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "userId.empty", "���̵� �Է��ϼ���.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "��й�ȣ�� �Է��ϼ���.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwConfirm", "pwConfirm.empty", "��й�ȣ Ȯ���� �Է��ϼ���.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty", "�̸����� �Է��ϼ���.");
		
		if(user.getUserId().length() < 6 || user.getUserId().length() > 10){errors.rejectValue("userId", "userId.size", "���̵�� 6~10 ���� ���̷� ������ּ���.");}
		if(user.getPassword().length() < 8 || user.getPassword().length() > 16){ errors.rejectValue("password", "password.size", "��й�ȣ�� 8~16 ���� ���̷� ������ּ���.");}
		if(!user.getPassword().equals(user.getPwConfirm()) ){ errors.rejectValue("pwConfirm", "pwConfirm.equal", "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");}
		if(!StringUtil.isValidEmail(user.getEmail())){errors.rejectValue("email", "email.match", "�̸��� ������ �ùٸ��� �ʽ��ϴ�.");}
	}
}
