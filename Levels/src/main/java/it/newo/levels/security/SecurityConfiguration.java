package it.newo.levels.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import it.newo.levels.model.enums.Role;

import org.springframework.security.authentication.AuthenticationProvider;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

	private final JWTAuthenticationFilter filter;
	
	private final AuthenticationProvider provider;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
		
		http
		//disable csrf protection
		.csrf(h -> h.disable())
		
		.authenticationProvider(provider)
		//disabilita il blocco della composizione delle chiamate
		.headers(c->c.frameOptions(HeadersConfigurer.FrameOptionsConfig::disable))
		//disable cors support
		.cors(h -> h.disable())
		//you dont want to handle authentication through session so set it to stateless
		.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
		//set permissions on endpoints
		.authorizeHttpRequests(path -> path
				.requestMatchers("all").hasAnyRole(Role.USER.toString(), Role.ADMIN.toString(), Role.SUPER_ADMIN.toString())
				.requestMatchers("admin").hasAnyRole(Role.ADMIN.toString(), Role.SUPER_ADMIN.toString())
				.requestMatchers("super_admin").hasRole(Role.SUPER_ADMIN.toString())
				.anyRequest().permitAll()
				)
		//add jwt token filter
		.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class);
	return http.build();
		
	}
}
