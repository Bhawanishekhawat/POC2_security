package security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("Student").password("password").roles("STUDENT");
	}

//	private final PasswordEncoder passwordEncoder ;
//	
//	@Autowired
//	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
//		this .passwordEncoder = passwordEncoder;
//	}
	
	@Override 
	protected void configure(HttpSecurity http) throws Exception{
		http.csrf().disable();
		http.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}
//	@Override
//	@Bean
//	protected UserDetailsService userDetailsService() {
//		UserDetails StudentUser =  User.builder()
//		.username("Student")
//		.password(passwordEncoder.encode("password"))
//		.roles("STUDENT").build();
//		
//		return new InMemoryUserDetailsManager(
//				StudentUser
//				);
//	}
	

	
	
	
	
}
