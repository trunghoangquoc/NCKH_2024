package nckh.config;

import nckh.service.impl.UserDetailsServiceIml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.transaction.annotation.Transactional;


@Configuration
@EnableWebSecurity /*(debug = true)*/
@Transactional
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsServiceIml userDetailsService;

    @Autowired
    private AppConfig appConfig;

	@Autowired
	@Qualifier ("authenticationSuccessHandler")
	private AuthenticationSuccessHandler successHandler;
	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    
        auth.userDetailsService(userDetailsService).passwordEncoder(appConfig.passwordEncoder());
    }

    @Bean
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManager();
	}
    

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.csrf().disable();

        // Các trang không yêu cầu login
        http.authorizeRequests().antMatchers("/trang-chu", "/dang-ky", "/dang-nhap","/" ).permitAll();
      
        // Trang chỉ dành cho ADMIN
        http.authorizeRequests().antMatchers("/admin/home").authenticated();  
        http.authorizeRequests().antMatchers("/admin/product/*").authenticated();
        http.authorizeRequests().antMatchers("/admin/user/*").authenticated();
       
        //trang bat phải đăng nhập quyền.
//        http.authorizeRequests().antMatchers("/contact").access("hasRole('USER')");
        
       //Nếu cần vô những trang yêu cầu quyền mà chưa đăng nhập thì sẽ vào thăng "/accessDenied"
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/accessDenied");

        // Cấu hình cho Login Form.
        http.authorizeRequests().and().formLogin()//
                // Submit URL của trang login
                .loginProcessingUrl("/j_spring_security_check") // Submit URL
                .loginPage("/dang-nhap")//
//                .defaultSuccessUrl("/customSuccessHandler",true)
                .successHandler(successHandler)
                .failureUrl("/dang-nhap?incorrectAccount")//nhap sai thi phai nhap lai
                .usernameParameter("j_username")//
                .passwordParameter("j_password")
                
                // Cấu hình cho Logout Page.
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");
               
        // Cấu hình Remember Me.
        http.authorizeRequests().and() //
                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
                .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h

    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        return memory;
    }
}
