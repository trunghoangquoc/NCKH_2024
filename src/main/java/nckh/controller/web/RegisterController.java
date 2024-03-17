package nckh.controller.web;

import nckh.dto.UserDTO;
import nckh.service.IUserService;
import nckh.util.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller(value ="RegisterControllerOfWeb")
public class RegisterController {
   
	@Autowired
	private IUserService userService;
	
	@Autowired
	private UserValidator userValidator;
	
	@GetMapping("/dang-ky")
	public String registerPage(Model model) {
		
		model.addAttribute("newUser", new UserDTO());
		
		return "web/register";
	}
	
	@PostMapping("/shop/dang-ky")
	public String registerProcess(@ModelAttribute("newUser") @Valid UserDTO userDto, BindingResult bindingResult, Model model) {
	    
		userValidator.validate(userDto, bindingResult);
		
        if (bindingResult.hasErrors()) {
            return "web/register";
        }else {
        	if( userService.registerUser(userDto) != null) {
        		return "web/login";
        	}
        	 
            return "web/register";
        }

	}
}
