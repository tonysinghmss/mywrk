package mywrk.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.context.request.WebRequest;

import mywrk.dao.model.Users;
import mywrk.domain.User;
import mywrk.exception.EmailExistsException;
import mywrk.service.UserRegistration;

@Controller
@SessionAttributes("user")
public class RegistrationController {
	public static final String VIEW_REGISTER_USER = "register";
	public static final String VIEW_SUCCESS_REGISTER = "home";
	
	@Autowired private UserRegistration userRegistrationService;
	
	@RequestMapping(value="/user/registerform", method = RequestMethod.GET)
	public String showRegistrationForm(Model model) {
		model.addAttribute(new User());
		return RegistrationController.VIEW_REGISTER_USER;
	}
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String processRegistration(@Valid @ModelAttribute("user") User user, BindingResult result, WebRequest request, Errors error){
		Users registered = new Users();
		if(!result.hasErrors()){
			registered = createUserAccount(user, result);
		}				
		if (registered == null) {
	        result.rejectValue("email", "message.regError");
	    }
		if(result.hasErrors()){
			return RegistrationController.VIEW_REGISTER_USER;
		}
		else{
			return RegistrationController.VIEW_SUCCESS_REGISTER;
		}
	}
	
	private Users createUserAccount(User accountDto, BindingResult result) {
		Users registered = null;
	    try {
	        registered = userRegistrationService.registerNewUser(accountDto);
	    } catch (EmailExistsException e) {
	        return null;
	    }    
	    return registered;
	}
}
