package mywrk.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import mywrk.domain.User;

@Controller
@RequestMapping( "/register")
public class RegistrationController {
	public static final String VIEW_REGISTER_USER = "register";
	
	@RequestMapping(method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute(new User());
		return RegistrationController.VIEW_REGISTER_USER;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(){
		return "redirect:home";
	}
}
