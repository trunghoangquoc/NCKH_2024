package nckh.service.impl;

import nckh.constant.SystemConstant;
import nckh.dto.MyUser;
import nckh.entity.RoleEntity;
import nckh.entity.UserEntity;
import nckh.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

//tất cả thao tác login rồi ktra thì sẽ nhảy vào file confix security.xml
//rồi mới gọi đến class CustomUserDetailsService
@Service
@Transactional
public class UserDetailsServiceIml implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = new UserEntity();
        userEntity = userRepository.findOneByUserNameAndStatus(username, SystemConstant.ACTIVE_STATUS);

        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found");
        }
        //put thông tin vào security duy tri thông tin  khi user login vào
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleEntity role : userEntity.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getCode()));
            //thêm cái code của role vào List<GrantedAuthority>
        }

        MyUser myUser = new MyUser(userEntity.getUserName(), userEntity.getPassword(),
                true, true, true, true, authorities);
        myUser.setFullName(userEntity.getFullName());
        myUser.setEmail(userEntity.getEmail());
        myUser.setStatus(userEntity.getStatus());
        myUser.setAddress(userEntity.getAddress());
        myUser.setPhoneNumber(userEntity.getPhoneNumber());
        return myUser;
    }


}
