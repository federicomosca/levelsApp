package it.newo.levels.security;

import java.io.IOException;
import java.time.LocalDateTime;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import it.newo.levels.security.JWTHandler;
import it.newo.levels.model.User;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JWTAuthenticationFilter extends OncePerRequestFilter{
	
	private final JWTHandler handler;
	
	@Override
	protected void doFilterInternal(
				HttpServletRequest request,
				HttpServletResponse response,
				FilterChain filterChain
			) 
			throws ServletException, IOException {
			//getting all authorization from header
			final String authHeader = request.getHeader("Authorization");
			//variable to save token in
			final String jwtToken;
			//if header is null or doesn't start with "Bearer "
			if (authHeader == null || !authHeader.startsWith("Bearer ")) {
				//request keep going
				filterChain.doFilter(request, response);
				return;
			}
			
			//getting my token through header, taking off the 'bearer part'
			jwtToken = authHeader.substring(7);

			//in this condition security already set a user
			boolean alreadyChecked = SecurityContextHolder.getContext().getAuthentication()!=null;
			
			//if security didnt set a user or token is expired
			if(!alreadyChecked && handler.getExpirationDate(jwtToken).isAfter(LocalDateTime.now())) {
				
				//extract user from token
				User user = handler.extractUser(jwtToken);
				//object with logged user and his authorities
				UsernamePasswordAuthenticationToken upat = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
				//link the object to the request
				upat.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				//set user in the security context
				SecurityContextHolder.getContext().setAuthentication(upat);
			}
			filterChain.doFilter(request, response);		
	}
	
}
