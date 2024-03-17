package nckh.api.admin;

import nckh.dto.UserDTO;
import nckh.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController(value = "userAPIOfAdmin")
public class UserAPI {

	@Autowired
	private IUserService userService;
	
	@PostMapping("/api/user") 
	public UserDTO createUser(@RequestBody UserDTO dto) {
		return userService.save(dto);
	}
	
	@PutMapping("/api/user") 
	public UserDTO updateUser(@RequestBody UserDTO dto) {
		return userService.save(dto);
	}
	
	@DeleteMapping("/api/user")
	public void deleteUserActive(@RequestBody long[] ids) {
		userService.deleteUserActive(ids);
		
	}
	@DeleteMapping("/api/user/noActive")
	public void deleteUserNoActive(@RequestBody long[] ids) {
		userService.deleteUserNoActive(ids);
		
	}
}
