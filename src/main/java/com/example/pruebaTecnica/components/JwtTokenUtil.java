package com.example.pruebaTecnica.components;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component("JwtToken")
public class JwtTokenUtil {

	private String secret = "secret";

	public String generateToken() {

		return Jwts.builder().setExpiration(new Date(System.currentTimeMillis() + 120000))
				.signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	public boolean validateToken(String token) {	
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
			return true;
		} catch (Exception e) {
			e.printStackTrace(System.out);
			return false;
		}
		

	}

}
