package nckh.service.impl;

import nckh.constant.SystemConstant;
import nckh.converter.UserConverter;
import nckh.dto.UserDTO;
import nckh.entity.RoleEntity;
import nckh.entity.UserEntity;
import nckh.repository.RoleRepository;
import nckh.repository.UserRepository;
import nckh.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private SystemConstant constant;

    @Override
    @Transactional
    public UserDTO registerUser(UserDTO dto) {
        UserEntity userEntity = new UserEntity();
        UserDTO userDTO = new UserDTO();
        if ((!dto.getEmail().isEmpty()) && (!dto.getUserName().isEmpty()) && (!dto.getPassWord().isEmpty())) {
            UserEntity user = userRepository.findByUserName(dto.getUserName());
            UserEntity user1 = userRepository.findByEmail(dto.getEmail());
            if (user == null && user1 == null) {
                userEntity = userConverter.toEntity(dto);
                List<RoleEntity> roles = new ArrayList<>();
                roles.add(roleRepository.findOneByCode("USER"));
                userEntity.setRoles(roles);
                userEntity.setStatus(1);
                userDTO = userConverter.toDto(userRepository.save(userEntity));
                return userDTO;
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    // = ( findAll Status =1 + findAll Status = 0 )
    @Override
    public Page<UserEntity> findByStatus(Integer status, Pageable page) {

        return userRepository.findByStatus(status, page);
    }

    @Override
    public int getTotalItem() {

        return (int) userRepository.count();
    }

    @Override
    public UserDTO findById(long id) {
        Optional<UserEntity> entity = userRepository.findById(id);
        UserEntity userEntity = new UserEntity();
        userEntity = userConverter.entityToEntity(entity);
        userEntity.setRoles(entity.get().getRoles());

        return userConverter.toDto(userEntity);
    }

    // instes + update
    @Override
    @Transactional
    public UserDTO save(UserDTO dto) {
        UserEntity userEntity = new UserEntity();
        Optional<UserEntity> oldUserEntity;
//		userEntity = userConverter.toEntity(dto);
        if (dto.getId() != null) {
            oldUserEntity = userRepository.findById(dto.getId());
            userEntity = userConverter.entityToEntity(oldUserEntity);
            userEntity.setFullName(dto.getFullName());
            userEntity.setStatus(dto.getStatus());
            userEntity.setUserName(dto.getUserName());
            userEntity.setEmail(dto.getEmail());
            userEntity.setAddress(dto.getAddress());
            userEntity.setPhoneNumber(dto.getPhoneNumber());
        } else {
            userEntity = userConverter.toEntity(dto);
        }

        List<RoleEntity> roles = new ArrayList<>();
        roles.add(roleRepository.findOneByCode(dto.getRoleCode()));
        userEntity.setRoles(roles);
        return userConverter.toDto(userRepository.save(userEntity));
    }

    @Override
    @Transactional
    public void deleteUserActive(long[] ids) {

        Optional<UserEntity> user;
        UserEntity userEntity = new UserEntity();
        for (long id : ids) {
            user = userRepository.findById(id);
            userEntity = userConverter.entityToEntity(user);
            userEntity.setStatus(0);

            userRepository.save(userEntity);
        }
    }

    @Override
    @Transactional
    public void deleteUserNoActive(long[] ids) {

        for (long id : ids) {
            userRepository.deleteById(id);
        }
    }

    @Override
    public List<UserDTO> findUserByStatus(Integer page, Integer limit, Integer status) {
        List<UserEntity> userEntities = userRepository.findUserEntityByStatus(status);
        List<UserDTO> userDTOS = userEntities.stream()
                .skip((page - 1) * limit)
                .limit(limit)
                .map(n -> userConverter.toDto(n))
                .collect(Collectors.toList());
        return userDTOS;
    }

    @Override
    public int getTotalUserByStatus(Integer status) {
        return userRepository.countUserByStatus(status);
    }


}
