package it.newo.levels.security;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.Optional;

import javax.crypto.SecretKey;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import it.newo.levels.model.User;
import it.newo.levels.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;


//this class is for handling incoming and outgoing tokens

@Service
@RequiredArgsConstructor
public class JWTHandler {
	
	//to call methods to extract user from the token
	private final UserRepository store;
	
	//application secret key to decode signature
	private static final String SECRET_KEY = "zRd1O0bSHzEh6dQsuXt1bRzItniJnVE9iAKZYKl44zNJoxUmAK2pRRQgh4wWA56U";

	//method to decode signature
	private SecretKey getSigninKey() {
		//cryptographic authentication technique that uses a hash function and a secret key
		return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
	}

	//method to build my decoder based on signature key to extract the payload
	private JwtParser getDecoder() {
		return Jwts
				//parse the token
				.parser()
				//verify it's valid with the signature key
				.verifyWith(getSigninKey())
				//build it
				.build();
	}

	public User extractUser(String token) {
		//save claims extracted using decoder
		Claims claims = getDecoder().parseSignedClaims(token).getPayload();
		//extract subject from the token
		String username = claims.getSubject();
		//extract user from subject using email
		Optional<User> u = store.findByUsername(username);
		//if user is stored in my db return it, otherwise throw forbidden status
		return u.orElseThrow(()->new ResponseStatusException(HttpStatus.FORBIDDEN));
	}
	
	//method to extract anything from payload
	public <T> T extractParameters(String token, String parameterName, Class<T> parameterClass) {
		Claims claims = getDecoder().parseSignedClaims(token).getPayload();
		return claims.get(parameterName, parameterClass);
	}
	
	//method to extract token expiration date from payload
	public LocalDateTime getExpirationDate(String token) {
		Claims claims = getDecoder().parseSignedClaims(token).getPayload();
		Date date = claims.getExpiration();
		return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();			
	}
	
	public String buildToken(User u) {
		//define token expiration time
		long tokenLife = 1000L*60*60*24*30*6;
		
		String token = Jwts
				//call the builder from jwt services
				.builder()
				//define claims
				.claims()
					.add("role", u.getRole())
					.add("name", u.getName())
					.add("surname", u.getSurname())
					//define subject based on user's email
					.subject(u.getUsername())
					//define creation date
					.issuedAt(new Date(System.currentTimeMillis()))
					//define expiration date
					.expiration(new Date(System.currentTimeMillis()+tokenLife))
				//close the claims part
				.and()
				//sign the token
				.signWith(getSigninKey())
				//compact all
				.compact();
		//get the token
		return token;
	}
}
