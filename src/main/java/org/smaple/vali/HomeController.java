package org.smaple.vali;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {

		return "index";
	}

	/**
	 * CASE 1 : Spring Validator  
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("color", "success");
		return "join";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinSubmit(Model model, @ModelAttribute User user, BindingResult bindingResult) {
		model.addAttribute("color", "success");
		new UserValidation().validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			return "join";
		} else {
			return "redirect:/";
		}
	}

	/**
	 * CASE 2 : Hibernate Validator
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/join2", method = RequestMethod.GET)
	public String join2(Model model) {
		model.addAttribute("color", "primary");
		return "join";
	}

	@RequestMapping(value = "/join2", method = RequestMethod.POST)
	public String joinSubmit2(Model model, @ModelAttribute("user") @Valid User2 user, BindingResult bindingResult) {
		model.addAttribute("color", "primary");
		if (bindingResult.hasErrors()) {
			return "join";
		} else {
			return "redirect:/";
		}
	}

	
	/**
	 * CASE 3 : Spring Sources like Spring Validator
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/join3", method = RequestMethod.GET)
	public String join3(Model model) {
		model.addAttribute("color", "warning");
		return "join2";
	}

	@RequestMapping(value = "/join3", method = RequestMethod.POST)
	public String joinSubmit3(Model model, @ModelAttribute User user) {
		model.addAttribute("color", "warning");
		if(BasicUserValidator.hasError(user, model)){
			return "join2";
		}else{
			return "redirect:/";
		}
	}
	
	/**
	 * CASE 4 : Spring Sources Normal
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/join4", method = RequestMethod.GET)
	public String join4(Model model) {
		model.addAttribute("color", "danger");
		return "join2";
	}

	@RequestMapping(value = "/join4", method = RequestMethod.POST)
	public String joinSubmit4(Model model, @ModelAttribute User user) {
		model.addAttribute("color", "danger");
		String returnUrl = "join2";
		
		if(user.getName() == null || "".equals(user.getName())){
			model.addAttribute("errorMsg", "���̵� �Է��ϼ���.");
		}else if(user.getName() == null || "".equals(user.getName())){
			model.addAttribute("errorMsg", "�̸��� �Է��ϼ���.");
		}else if(user.getName() == null || "".equals(user.getName())){
			model.addAttribute("errorMsg", "��й�ȣ�� �Է��ϼ���.");
		}else if(user.getName() == null || "".equals(user.getName())){
			model.addAttribute("errorMsg", "��й�ȣ Ȯ���� �Է��ϼ���.");
		}else if(user.getName() == null || "".equals(user.getName())){
			model.addAttribute("errorMsg", "�̸����� �Է��ϼ���.");
		}else if (user.getUserId().length() < 6 || user.getUserId().length() > 10) {
			model.addAttribute("errorMsg", "���̵�� 6~10 ���� ���̷� ������ּ���.");
		}else if (user.getPassword().length() < 8 || user.getPassword().length() > 16) {
			model.addAttribute("errorMsg", "��й�ȣ�� 8~16 ���� ���̷� ������ּ���.");
		}else if (!user.getPassword().equals(user.getPwConfirm())) {
			model.addAttribute("errorMsg", "��й�ȣ�� ��ġ���� �ʽ��ϴ�.");
		} else if (!StringUtil.isValidEmail(user.getEmail())) {
			model.addAttribute("emailMatch", "�̸��� ������ �ùٸ��� �ʽ��ϴ�.");
		}else{
			return "redirect:/";
		}
		return returnUrl;
		
	}
	
	/**
	 * CASE 5 : Don't have Validator
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/join5", method = RequestMethod.GET)
	public String join5(Model model) {
		model.addAttribute("color", "info");
		return "join3";
	}

	@RequestMapping(value = "/join5", method = RequestMethod.POST)
	public String joinSubmit5(Model model, @ModelAttribute User user) {
		model.addAttribute("color", "info");
		
		return "redirect:/";
	}
	
}
