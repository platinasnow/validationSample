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
	 * CASE 1 : Don't have Validator
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/join1", method = RequestMethod.GET)
	public String join5(Model model) {
		model.addAttribute("color", "info");
		model.addAttribute("title", "Don't Use Validator");
		return "join_nonvalidation";
	}

	@RequestMapping(value = "/join1", method = RequestMethod.POST)
	public String joinSubmit5(Model model, @ModelAttribute User user) {
		model.addAttribute("color", "info");
		model.addAttribute("title", "Don't Use Validator");
		return "redirect:/";
	}
	
	
	
	
	/**
	 * CASE 2 : Spring Sources Normal
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/join2", method = RequestMethod.GET)
	public String join4(Model model) {
		model.addAttribute("color", "danger");
		model.addAttribute("title", "Basic Validator");
		return "join_basic";
	}

	@RequestMapping(value = "/join2", method = RequestMethod.POST)
	public String joinSubmit4(Model model, @ModelAttribute User user) {
		model.addAttribute("color", "danger");
		model.addAttribute("title", "Basic Validator");
		String returnUrl = "join_basic";
		
		if(user.getName() == null || "".equals(user.getName())){
			model.addAttribute("errorMsg", "아이디를 입력하세요.");
		}else if(user.getName() == null || "".equals(user.getName())){
			model.addAttribute("errorMsg", "이름을 입력하세요.");
		}else if(user.getName() == null || "".equals(user.getName())){
			model.addAttribute("errorMsg", "비밀번호를 입력하세요.");
		}else if(user.getName() == null || "".equals(user.getName())){
			model.addAttribute("errorMsg", "비밀번호 확인을 입력하세요.");
		}else if(user.getName() == null || "".equals(user.getName())){
			model.addAttribute("errorMsg", "이메일을 입력하세요.");
		}else if (user.getUserId().length() < 6 || user.getUserId().length() > 10) {
			model.addAttribute("errorMsg", "아이디는 6~10 글자 사이로 만들어주세요.");
		}else if (user.getPassword().length() < 8 || user.getPassword().length() > 16) {
			model.addAttribute("errorMsg", "비밀번호는 8~16 글자 사이로 만들어주세요.");
		}else if (!user.getPassword().equals(user.getPwConfirm())) {
			model.addAttribute("errorMsg", "비밀번호가 일치하지 않습니다.");
		} else if (!StringUtil.isValidEmail(user.getEmail())) {
			model.addAttribute("emailMatch", "이메일 형식이 올바르지 않습니다.");
		}else{
			return "redirect:/";
		}
		return returnUrl;
		
	}
	
	

	
	/**
	 * CASE 3 : Spring Validator  
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/join3", method = RequestMethod.GET)
	public String join(Model model) {
		model.addAttribute("color", "success");
		model.addAttribute("title", "Spring Validator");
		return "join";
	}

	@RequestMapping(value = "/join3", method = RequestMethod.POST)
	public String joinSubmit(Model model, @ModelAttribute User user, BindingResult bindingResult) {
		model.addAttribute("color", "success");
		model.addAttribute("title", "Spring Validator");
		new UserValidation().validate(user, bindingResult);
		if (bindingResult.hasErrors()) {
			return "join";
		} else {
			return "redirect:/";
		}
	}
	
	
	
	
	/**
	 * CASE 4 : Spring Sources like Spring Validator
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/join4", method = RequestMethod.GET)
	public String join3(Model model) {
		model.addAttribute("color", "warning");
		model.addAttribute("title", "Spring Validator?");
		return "join_basic";
	}

	@RequestMapping(value = "/join4", method = RequestMethod.POST)
	public String joinSubmit3(Model model, @ModelAttribute User user) {
		model.addAttribute("color", "warning");
		model.addAttribute("title", "Spring Validator?");
		if(BasicUserValidator.hasError(user, model)){
			return "join_basic";
		}else{
			return "redirect:/";
		}
	}
	
	
	

	/**
	 * CASE 5 : Hibernate Validator
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/join5", method = RequestMethod.GET)
	public String join2(Model model) {
		model.addAttribute("color", "primary");
		model.addAttribute("title", "Hibernate Validator");
		return "join";
	}

	@RequestMapping(value = "/join5", method = RequestMethod.POST)
	public String joinSubmit2(Model model, @ModelAttribute("user") @Valid User2 user, BindingResult bindingResult) {
		model.addAttribute("color", "primary");
		model.addAttribute("title", "Hibernate Validator");
		if (bindingResult.hasErrors()) {
			return "join";
		} else {
			return "redirect:/";
		}
	}

	
	
	
	
	
	
	
}
