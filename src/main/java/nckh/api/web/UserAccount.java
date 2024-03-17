package nckh.api.web;

import nckh.dto.UserDTO;
import nckh.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "newApiOfWeb")
public class UserAccount {
	@Autowired
	private IUserService userService;
	
	@PostMapping ("/api/registerAccount")
		public UserDTO registerAccount (@RequestBody UserDTO userDTO) {
		
		return userService.registerUser(userDTO);
	}
}
