package ufps.web.professionacare.backend.auth.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import ufps.web.professionacare.backend.auth.ConstantsAuth;

@Component
public class JWTServiceImpl implements JWTService {

	private Logger LOG = LoggerFactory.getLogger(JWTServiceImpl.class);

	@Override
	public String create(Authentication auth) throws IOException {

		String username = auth.getName();

		Date inicio = new Date();
		Date fin = new Date(inicio.getTime() + ConstantsAuth.TOKEN_EXPIRATION_TIME);

		@SuppressWarnings("unchecked")
		Map<String, Object> data = (Map<String, Object>) auth.getDetails();

		Claims claims = Jwts.claims();

		claims.put("nit", data.get("nit"));
		claims.put("role", data.get("role"));

		String token = Jwts.builder().setClaims(claims).setSubject(username).setIssuedAt(inicio).setExpiration(fin)
				.signWith(ConstantsAuth.SECRET_KEY).compact();

		return token;
	}

	@Override
	public Claims getClaims(String token) {

		try {
			Jws<Claims> c = Jwts.parser().setSigningKey(ConstantsAuth.SECRET_KEY).parseClaimsJws(revolve(token));
			return c.getBody();
		} catch (JwtException e) {
			LOG.error(e.getMessage());
		}
		return null;
	}

	@Override
	public String getUserName(String token) {
		Claims claims = getClaims(token);
		if (claims != null) {
			return claims.getSubject();
		}
		return null;
	}

	@Override
	public List<GrantedAuthority> getRoles(String token) throws IOException {
		Object roles = getClaims(token).get("role");

		List<GrantedAuthority> authorities = new ArrayList<>();

		authorities.add(new SimpleGrantedAuthority(roles.toString()));

		return authorities;
	}

	@Override
	public String revolve(String token) {
		if (token != null && token.startsWith(ConstantsAuth.TOKEN_BEARER_PREFIX)) {
			return token.replace(ConstantsAuth.TOKEN_BEARER_PREFIX, "");
		}
		return token;

	}

	@Override
	public boolean validate(String token) {
		return getClaims(token) != null;
	}

}
