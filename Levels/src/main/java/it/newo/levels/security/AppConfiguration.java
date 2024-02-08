package it.newo.levels.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.server.ResponseStatusException;

import it.newo.levels.repository.UserRepository;

import lombok.RequiredArgsConstructor;

//this class is to verify informations got from token

@Configuration
@RequiredArgsConstructor
public class AppConfiguration {

	private final UserRepository store;
	
	//method to get user from db where email= :username
	@Bean
	public UserDetailsService getUserDetailsService() {
		return username -> store.findByUsername(username)
				.orElseThrow(()->new ResponseStatusException(HttpStatus.FORBIDDEN));
	}
	//method to cryptograph and verify users passwords (does this password exist in my db?)
	@Bean
	public PasswordEncoder getEncoder() {
		//uses BCrypt encryption algorithm
		return new BCryptPasswordEncoder();
	}
	
	
	//authentication manager is required to handle authentication in spring security
	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		//'configuration' let you use preconfigured Authentication Manager from Spring Security
		return configuration.getAuthenticationManager();
	}	
		
	//this bean handles authentication getting user email through UserDetailsService and verify password through PasswordEncoder
	@Bean
	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
		authProvider.setUserDetailsService(getUserDetailsService());
		authProvider.setPasswordEncoder(getEncoder());
		//return the configured instance of authentication provider (with UserDetailsService and PasswordEncoder both set). 
		//This bean will be used from Spring Security
		//this DaoAuthProvider will work when a user will try to authenticate
		return authProvider;
	}
}
