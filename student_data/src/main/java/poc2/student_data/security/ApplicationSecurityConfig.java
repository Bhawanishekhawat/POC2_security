package poc2.student_data.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import static poc2.student_data.security.ApplicationUserRole.*;
import static poc2.student_data.security.ApplicationUserPermission.*;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	private final PasswordEncoder passwordEncoder;

	@Autowired
	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
		this.passwordEncoder = passwordEncoder;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/", "index", "/css/*", "/js/*").permitAll()
				.antMatchers(HttpMethod.GET, "/api/**").hasAuthority(STUDENT_READ.getPermission())
				.antMatchers(HttpMethod.POST, "/api/**")
				.hasAnyAuthority(STUDENT_READ.getPermission(), STUDENT_WRITE.getPermission()).anyRequest()
				.authenticated().and().httpBasic();
	}

	@Override
	@Bean
	protected UserDetailsService userDetailsService() {
		UserDetails studentUser = User.builder().username("Student").password(passwordEncoder.encode("password"))
				.authorities(STUDENT.getGrantedAuthorities()).build();

		UserDetails adminUser = User.builder().username("Admin").password(passwordEncoder.encode("password123"))
				.authorities(ADMIN.getGrantedAuthorities()).build();

		return new InMemoryUserDetailsManager(studentUser, adminUser);

	}
}