package com.example.demo.util;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Component
public class JwtUtil {

    private static final String SECRET ="ThisIsASecure256BitJwtSecretKeyForDemoApplication";

    private static final long EXPIRATION_MS = 3600000; // 1 hour

    
    private final SecretKey key =Keys.hmacShaKeyFor(SECRET.getBytes(StandardCharsets.UTF_8));

    
    public String generateToken(String email, Long userId, Set<String> roles) {

        Map<String, Object> claims = new HashMap<>();
        claims.put("email", email);
        claims.put("userId", userId);
        claims.put("roles", roles);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)               // IMPORTANT for Spring Security
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_MS))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    
    public Claims getClaims(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (JwtException | IllegalArgumentException e) {
            return null; // IMPORTANT: tests expect no exception
        }
    }

    
    public boolean validateToken(String token) {
        try {
            Claims claims = getClaims(token);
            return claims != null && !isTokenExpired(claims);
        } catch (Exception e) {
            return false;
        }
    }

    
    public String extractUsername(String token) {
        Claims claims = getClaims(token);
        return claims != null ? claims.getSubject() : null;
    }

    public String extractEmail(String token) {
        Claims claims = getClaims(token);
        return claims != null ? claims.get("email", String.class) : null;
    }

    public Long extractUserId(String token) {
        Claims claims = getClaims(token);
        return claims != null
                ? Long.valueOf(claims.get("userId").toString())
                : null;
    }

    @SuppressWarnings("unchecked")
    public Set<String> extractRoles(String token) {
        Claims claims = getClaims(token);
        if (claims == null) return Collections.emptySet();

        Object roles = claims.get("roles");
        Set<String> roleSet = new HashSet<>();

        if (roles instanceof Collection<?>) {
            for (Object r : (Collection<?>) roles) {
                roleSet.add(String.valueOf(r));
            }
        }
        return roleSet;
    }

    private boolean isTokenExpired(Claims claims) {
        return claims.getExpiration().before(new Date());
    }
}
