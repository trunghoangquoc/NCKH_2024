package nckh.controller.web;

import nckh.dto.MyUser;
import nckh.util.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value ="AccountControllerOfWeb")
public class AccountController {
   

    @RequestMapping(value = "/account", method = RequestMethod.GET)
	public ModelAndView loginPage() {
		ModelAndView mav = new ModelAndView("web/inforPersonal");
		MyUser myUser = SecurityUtils.getPrincipal();
		mav.addObject("userInfo", myUser);
		return mav;
	}
	
}
