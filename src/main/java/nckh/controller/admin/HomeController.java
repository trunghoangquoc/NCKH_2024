package nckh.controller.admin;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller(value = "homeControllerOfAdmin")
//@PreAuthorize("hasRole('ROLE_role1') and hasRole('ROLE_role2')") Nếu muốn làm một cái gì đó như truy cập phương thức
//Vai trò 1 và Vai trò 2 thì  sẽ phải sử dụng @PreAuthorize
@PreAuthorize("hasAuthority('ADMIN')")
public class HomeController {


    @RequestMapping(value = "/admin/home", method = RequestMethod.GET)
    public ModelAndView homePage() {
        ModelAndView mav = new ModelAndView("/admin/home");
        return mav;
    }

}
