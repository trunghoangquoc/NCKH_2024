package nckh.util;

import nckh.dto.MyUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class SecurityUtils {
	
	public static MyUser getPrincipal() {
		Object object = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		MyUser myUser = (MyUser) object;
        return myUser;
    }
	
	@SuppressWarnings("unchecked")
	public static List<String> getAuthorities() {
		//put cái role-code vào thằng result để xử lý Authorization
		List<String> results = new ArrayList<>();
		List<GrantedAuthority> authorities = (List<GrantedAuthority>)(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        for (GrantedAuthority authority : authorities) {
            results.add(authority.getAuthority());
        }
		return results;
	}
}
