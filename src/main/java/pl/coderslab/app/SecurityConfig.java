package pl.coderslab.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import pl.coderslab.repository.UserRepository;

@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


	@Qualifier("myUserDetailsService")
	@Autowired(required = true)
	public UserDetailsService userDetailsService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

	    http.authorizeRequests().antMatchers("/admin/**")
		.access("hasRole('ROLE_ADMIN')")
		.and().formLogin()
		.and().csrf().disable();
//		.loginPage("/login").failureUrl("/login?error")
//		.usernameParameter("username")
//		.passwordParameter("password")
//		.and().logout().logoutSuccessUrl("/login?logout")
//		.and().csrf()
//		.and().exceptionHandling().accessDeniedPage("/403");
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}
	
}
