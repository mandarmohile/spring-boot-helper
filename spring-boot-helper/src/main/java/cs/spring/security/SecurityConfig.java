package cs.spring.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;


@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	private UserDetailsService userDetailsService;
	
	public SecurityConfig(@Autowired @Qualifier("JavaBrainsUserDetailsServiceImpl") UserDetailsServiceImpl pUserDetailsService) {
		this.userDetailsService = pUserDetailsService;
	}
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests()
		.antMatchers("/**")
		.hasAuthority("PERM_1")
		.and().formLogin();
		 
	}
	
	// Java Brains
	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		/* PART 1
		 * auth .inMemoryAuthentication()
		 * .withUser("user").password("pass").roles("USER").authorities("PERM_1") .and()
		 * .withUser("foo").password("pass").roles("USER").authorities("PERM_1");
		 */
		
		// Part 2 when fetching users from database
		auth.userDetailsService(userDetailsService);
	
    }
}
