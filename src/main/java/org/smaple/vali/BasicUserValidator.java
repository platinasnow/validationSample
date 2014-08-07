package org.smaple.vali;

import org.springframework.ui.Model;

public class BasicUserValidator {
	
	public static boolean hasError(User user, Model model){
		boolean hasError = false;
		if(user.getName() == null || "".equals(user.getName())){
			model.addAttribute("nameEmpty", "이름을 입력하세요.");
			hasError = true;
		}
		if(user.getName() == null || "".equals(user.getName())){
			model.addAttribute("userIdEmpty", "아이디를 입력하세요.");
			hasError = true;
		}
		if(user.getName() == null || "".equals(user.getName())){
			model.addAttribute("passwordEmpty", "비밀번호를 입력하세요.");
			hasError = true;
		}
		if(user.getName() == null || "".equals(user.getName())){
			model.addAttribute("pwConfirmEmpty", "비밀번호 확인을 입력하세요.");
			hasError = true;
		}
		if(user.getName() == null || "".equals(user.getName())){
			model.addAttribute("emailEmpty", "이메일을 입력하세요.");
			hasError = true;
		}
		if (user.getUserId().length() < 6 || user.getUserId().length() > 10) {
			model.addAttribute("userIdSize", "아이디는 6~10 글자 사이로 만들어주세요.");
			hasError = true;
		}
		if (user.getPassword().length() < 8 || user.getPassword().length() > 16) {
			model.addAttribute("passwordSize", "비밀번호는 8~16 글자 사이로 만들어주세요.");
			hasError = true;
		}
		if (!user.getPassword().equals(user.getPwConfirm())) {
			model.addAttribute("pwConfirmEqual", "비밀번호가 일치하지 않습니다.");
			hasError = true;
		}
		if (!StringUtil.isValidEmail(user.getEmail())) {
			model.addAttribute("emailMatch", "이메일 형식이 올바르지 않습니다.");
			hasError = true;
		}
		return hasError;
	}
	

}
