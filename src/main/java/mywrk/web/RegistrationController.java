package mywrk.web;

import javax.validation.Valid;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import mywrk.domain.User;
import mywrk.utils.Ctrlr;

@Controller
@SessionAttributes("user")
public class RegistrationController {
	public static final String VIEW_REGISTER_USER = "register";
	public static final String VIEW_HOME = "home";
	
	@RequestMapping(value="/registerform", method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute(new User());
		return RegistrationController.VIEW_REGISTER_USER;
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String processRegistration(@Valid @ModelAttribute("user") User user, BindingResult result){
		if(result.hasErrors()){
			return RegistrationController.VIEW_REGISTER_USER;
		}
		return RegistrationController.VIEW_HOME;
	}
}
