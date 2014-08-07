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
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.empty", "이름을 입력하세요.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "userId.empty", "아이디를 입력하세요.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.empty", "비밀번호를 입력하세요.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "pwConfirm", "pwConfirm.empty", "비밀번호 확인을 입력하세요.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "email.empty", "이메일을 입력하세요.");
		
		if(user.getUserId().length() < 6 || user.getUserId().length() > 10){errors.rejectValue("userId", "userId.size", "아이디는 6~10 글자 사이로 만들어주세요.");}
		if(user.getPassword().length() < 8 || user.getPassword().length() > 16){ errors.rejectValue("password", "password.size", "비밀번호는 8~16 글자 사이로 만들어주세요.");}
		if(!user.getPassword().equals(user.getPwConfirm()) ){ errors.rejectValue("pwConfirm", "pwConfirm.equal", "비밀번호가 일치하지 않습니다.");}
		if(!StringUtil.isValidEmail(user.getEmail())){errors.rejectValue("email", "email.match", "이메일 형식이 올바르지 않습니다.");}
	}
}
