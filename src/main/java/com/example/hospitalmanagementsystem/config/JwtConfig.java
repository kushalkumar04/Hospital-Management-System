package com.example.hospitalmanagementsystem.config;

/*
 * JWT Service
 * Handles token generation and validation
 */


import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;

@Service
public class JwtService {

    private final String SECRET = "this_is_a_very_long_secret_key_for_jwt";

    private Key getSignKey() {
        return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    // GENERATE TOKEN
    public String generateToken(String email) {
        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 86400000)) // 1 day
                .signWith(getSignKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    // EXTRACT EMAIL
    public String extractEmail(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // VALIDATE TOKEN
    public boolean isTokenValid(String token, String email) {
        return extractEmail(token).equals(email);
    }
}