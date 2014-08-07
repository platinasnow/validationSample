package org.smaple.vali;

import org.springframework.ui.Model;

public class BasicUserValidator {
	
	public static boolean hasError(User user, Model model){
		boolean hasError = false;
		if(user.getName() == null || "".equals(user.getName())){
			model.addAttribute("nameEmpty", "�̸��� �Է��ϼ���.");
			hasError = true;
		}
		if(user.getName() == null || "".equals(user.getName())){
			model.addAttribute("userIdEmpty", "���̵� �Է��ϼ���.");
			hasError = true;
		}
		if(user.getName() == null || "".equals(user.getName())){
			model.addAttribute("passwordEmpty", "��й�ȣ�� �Է��ϼ���.");
			hasError = true;
		}
		if(user.getName() == null || "".equals(user.getName())){
			model.addAttribute("pwConfirmEmpty", "��й�ȣ Ȯ���� �Է��ϼ���.");
			hasError = true;
		}
		if(user.getName() == null || "".equals(user.getName())){
			model.addAttribute("emailEmpty", "�̸����� �Է��ϼ���.");
			hasError = true;
		}
		if (user.getUserId().length() < 6 || user.getUserId().length() > 10) {
			model.addAttribute("userIdSize", "���̵�� 6~10 ���� ���̷� ������ּ���.");
			hasError = true;
		}
		if (user.getPassword().length() < 8 || user.getPassword().length() > 16) {
			model.addAttribute("passwordSize", "��й�ȣ�� 8~16 ���� ���̷� ������ּ���.");
			hasError = true;
		}
		if (!user.getPassword().equals(user.getPwConfirm())) {
			model.addAttribute("pwConfirmEqual", "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
			hasError = true;
		}
		if (!StringUtil.isValidEmail(user.getEmail())) {
			model.addAttribute("emailMatch", "�̸��� ������ �ùٸ��� �ʽ��ϴ�.");
			hasError = true;
		}
		return hasError;
	}
	

}
