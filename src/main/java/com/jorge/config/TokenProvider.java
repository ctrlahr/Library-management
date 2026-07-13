package com.jorge.config;

import io.jsonwebtoken.Jwt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class TokenProvider {

    @Value("${jwt.expiration}")
    private long expirationTime;

    @Value("${jwt.key}")
    private String key;


//    Generate Token
    public String generateToken(Authentication authentication) {
        UserDetails user = (UserDetails) authentication.getPrincipal();
        return buildToken(user.getUsername());
    }

    private String buildToken(UserDetails username) {

    }

//    Validate token


//    Extract information about the token

}
