package mywrk.web;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import mywrk.domain.User;
import mywrk.utils.Ctrlr;

@Controller
@RequestMapping( "/register")
@SessionAttributes("user")
public class RegistrationController {
	public static final String VIEW_REGISTER_USER = "register";
	
	@RequestMapping(method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute(new User());
		return RegistrationController.VIEW_REGISTER_USER;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@Valid @ModelAttribute("user") User user, BindingResult result){
		if(result.hasErrors()){
			return RegistrationController.VIEW_REGISTER_USER;
		}
		return Ctrlr.createRedirectPath("home");
	}
}
