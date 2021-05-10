package ufps.web.professionacare.backend.auth.service;

import java.io.IOException;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import io.jsonwebtoken.Claims;

public interface JWTService {

	public String create(Authentication auth) throws IOException;

	public Claims getClaims(String token);

	public String getUserName(String token);

	public String revolve(String token);
	
	public List<GrantedAuthority> getRoles(String token) throws IOException;

	public boolean validate(String token);

}
