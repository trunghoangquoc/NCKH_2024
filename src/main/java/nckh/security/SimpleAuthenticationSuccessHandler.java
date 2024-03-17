package nckh.security;


import nckh.util.SecurityUtils;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Component(value = "authenticationSuccessHandler")
public class SimpleAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		
		String targetUrl = determineTargetUrl(authentication);
		if (response.isCommitted()) {
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}

	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}
	
	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	private String determineTargetUrl(Authentication authentication) {
		String url = "";
		
		//SecurityUtils.getAuthorities() get cái code để phân quyền
		List<String> roles = SecurityUtils.getAuthorities();
		if (isAdmin(roles)) {
			url = "/admin/home";
		} 
		else if (isAdminProduct(roles)) {
			url = "/admin/home";
		}
		else if (isAdminOrder(roles)) {
			url = "/admin/home";
		}
		else if (isAdminUser(roles)) {
			url = "/admin/home";
		}
		else if (isUser(roles)) {
			url = "/trang-chu";
		}
		return url;
	}
	
	private boolean isAdminProduct(List<String> roles) {
		if (roles.contains("ADMIN_PRODUCT")) {
			return true;
		}
		return false;
	}
	private boolean isAdmin(List<String> roles) {
		if (roles.contains("ADMIN")) {
			return true;
		}
		return false;
	}
	private boolean isAdminOrder(List<String> roles) {
		if (roles.contains("ADMIN_ORDER")) {
			return true;
		}
		return false;
	}
	private boolean isAdminUser(List<String> roles) {
		if (roles.contains("ADMIN_USER")) {
			return true;
		}
		return false;
	}
	
	private boolean isUser(List<String> roles) {
		if (roles.contains("USER")) {
			return true;
		}
		return false;
	
	}


}
