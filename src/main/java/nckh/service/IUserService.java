package nckh.service;

import nckh.dto.UserDTO;
import nckh.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IUserService {
   UserDTO save (UserDTO dto);
   UserDTO registerUser (UserDTO userDto);
   int getTotalItem();
   
   Page<UserEntity> findByStatus(Integer status , Pageable page);
   UserDTO findById(long id);
   void deleteUserActive(long[] ids);
   void deleteUserNoActive(long[] ids);
   List<UserDTO> findUserByStatus(Integer page, Integer limit ,Integer status);
   int getTotalUserByStatus(Integer status);
}
