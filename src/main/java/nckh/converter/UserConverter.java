package nckh.converter;

import nckh.dto.UserDTO;
import nckh.entity.RoleEntity;
import nckh.entity.UserEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class UserConverter {
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	
	public UserDTO toDto(UserEntity entity) {
		UserDTO result = new UserDTO();
		result.setId(entity.getId());
		result.setFullName(entity.getFullName());
		result.setPassWord(entity.getPassword());
		result.setUserName(entity.getUserName());
		result.setStatus(entity.getStatus());
		result.setEmail(entity.getEmail());
		result.setAddress(entity.getAddress());
		result.setPhoneNumber(entity.getPhoneNumber());
		List<RoleEntity> roles = entity.getRoles();
		String roleNames = "";
		for (RoleEntity roleEntity : roles) {
			roleNames += roleEntity.getCode()+"  ,";
		}
		if(StringUtils.isNotBlank(roleNames)){
			roleNames = roleNames.substring(0, roleNames.length()-3);
		}else {
			roleNames = "";
		}
		result.setRoleCode(roleNames);
		return result;
	}
	
	public UserEntity toEntity(UserDTO dto) {
		 UserEntity userEntity = new UserEntity();
		 
		 userEntity.setFullName(dto.getFullName());
		 userEntity.setPassword(bCryptPasswordEncoder.encode(dto.getPassWord()));
		 userEntity.setStatus(dto.getStatus());
		 userEntity.setUserName(dto.getUserName());
		 userEntity.setEmail(dto.getEmail());
		 userEntity.setAddress(dto.getAddress());
		 userEntity.setPhoneNumber(dto.getPhoneNumber());
		return userEntity;
	}
	
	public UserEntity entityToEntity(Optional<UserEntity> entity) {
		 UserEntity userEntity = new UserEntity();
		 
		    userEntity.setId(entity.get().getId());
			userEntity.setAddress(entity.get().getAddress());
			userEntity.setEmail(entity.get().getEmail());
			userEntity.setFullName(entity.get().getFullName());
			userEntity.setUserName(entity.get().getUserName());
			userEntity.setRoles(entity.get().getRoles());
			userEntity.setPhoneNumber(entity.get().getPhoneNumber());
			userEntity.setPassword(entity.get().getPassword());
			userEntity.setStatus(entity.get().getStatus());
			userEntity.setCreatedBy(entity.get().getCreatedBy());
			userEntity.setCreatedDate(entity.get().getCreatedDate());
			userEntity.setModifiedBy(entity.get().getModifiedBy());
			userEntity.setModifiedDate(entity.get().getModifiedDate());
			
		return userEntity;
	}
	
}
