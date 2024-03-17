package nckh.util;

import nckh.dto.UserDTO;
import nckh.repository.UserRepository;
import nckh.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserValidator implements Validator {

	@Autowired
	private IUserService userService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		
		return UserDTO.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		UserDTO userDto = (UserDTO) target;
		
		ValidationUtils.rejectIfEmpty(errors, "fullName", "error.fullName", "Họ tên không được bỏ trống");
		ValidationUtils.rejectIfEmpty(errors, "userName", "error.userName", " Tên Nguoi dung không được bỏ trống");
		ValidationUtils.rejectIfEmpty(errors, "phoneNumber", "error.phoneNumber", "Số điện thoại không được bỏ trống");
		ValidationUtils.rejectIfEmpty(errors, "address", "error.address", "Địa chỉ không được bỏ trống");
		ValidationUtils.rejectIfEmpty(errors, "email", "error.email", "Email không được trống");
	
		// check địa chi email đã được dùng chưa
				if (userRepository.findByEmail(userDto.getEmail()) != null) {
					errors.rejectValue("email", "error.email", "Địa chỉ email đã được sử dụng");
				}
             //check username dc su dung chua?
				if(userRepository.findByUserName(userDto.getUserName()) != null) {
					errors.rejectValue("userName", "error.userName", "UserName  đã được sử dụng");
				}
				// check password trống hay không
				ValidationUtils.rejectIfEmptyOrWhitespace(errors, "passWord", "error.passWord", "Password không được bỏ trống");

				// check độ dài password (8-32)
				if (userDto.getPassWord().length() < 6 || userDto.getPassWord().length() > 32) {
					errors.rejectValue("passWord", "error.passWord", "Mật khẩu phải dài 6-32 ký tự");
				}
	}

}
