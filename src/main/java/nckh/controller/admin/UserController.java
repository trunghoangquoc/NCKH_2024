package nckh.controller.admin;

import nckh.constant.SystemConstant;
import nckh.converter.UserConverter;
import nckh.dto.UserDTO;
import nckh.service.IRoleService;
import nckh.service.IUserService;
import nckh.util.MessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller(value = "UserControllerOfAdmin")
@PreAuthorize("hasAuthority('ADMIN_USER')")
public class UserController {
    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private MessageUtil messageUtil;

    @Autowired
    private UserConverter userConverter;

    @RequestMapping(value = "/admin/user/listActive", method = RequestMethod.GET)
    public ModelAndView userListActive(
            @RequestParam(name = "status", required = false) Integer status,
            @RequestParam("page") int page,
            @RequestParam("limit") int limit,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
            HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("admin/user/userList");
        // truyền vào page và limit

        UserDTO model = new UserDTO();
        model.setPage(page);
        model.setLimit(limit);

        // xử lý offset và limit
        List<UserDTO> userDtoLst = userService.findUserByStatus(page, limit, SystemConstant.ACTIVE_STATUS);
        model.setListResult(userDtoLst);
        model.setTotalItem(userService.getTotalUserByStatus(SystemConstant.ACTIVE_STATUS));
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;

    }

    @RequestMapping(value = "/admin/user/listDelete", method = RequestMethod.GET)
    public ModelAndView userListDelete(
            @RequestParam(name = "status", required = false) Integer status,
            @RequestParam("page") int page,
            @RequestParam("limit") int limit,
            @RequestParam(name = "sort", required = false, defaultValue = "ASC") String sort,
            HttpServletRequest request) {

        ModelAndView mav = new ModelAndView("admin/user/userListDelete");
        // truyền vào page và limit
        UserDTO model = new UserDTO();
        model.setPage(page);
        model.setLimit(limit);
		// xử lý offset và limit
		List<UserDTO> userDtoLst = userService.findUserByStatus(page, limit, SystemConstant.INACTIVE_STATUS);
		model.setListResult(userDtoLst);
		model.setTotalItem(userService.getTotalUserByStatus(SystemConstant.INACTIVE_STATUS));
        model.setTotalPage((int) Math.ceil((double) model.getTotalItem() / model.getLimit()));
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("model", model);
        return mav;

    }

    //
    @RequestMapping(value = "/admin/user/edit", method = RequestMethod.GET)
    public ModelAndView productEdit(@RequestParam(value = "id", required = false) Long id, HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("admin/user/userEdit");
        UserDTO model = new UserDTO();
        if (id != null) {
            model = userService.findById(id);

        }
        // xử lý message
        if (request.getParameter("message") != null) {
            Map<String, String> message = messageUtil.getMessage(request.getParameter("message"));
            mav.addObject("message", message.get("message"));
            mav.addObject("alert", message.get("alert"));
        }
        mav.addObject("roles", roleService.findAll());
        mav.addObject("model", model);

        return mav;
    }

}
