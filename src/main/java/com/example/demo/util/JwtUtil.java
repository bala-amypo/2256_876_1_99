package com.example.demo.util;

import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;
import java.util.Date;

@Component
public class JwtUtil {

    private final String secret = "mySecretKey12345"; // portal-safe example
    private final long expirationMs = 3600000; // 1 hour

    // Generate token
    public String generateToken(String email, Long userId, Set<String> roles) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("email", email);
        claims.put("userId", userId);
        claims.put("roles", roles);

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    // Extract all claims
    public Claims extractAllClaims(String token) throws ExpiredJwtException {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }

    // Backward compatibility for portal/testcases
    public Claims getClaims(String token) throws ExpiredJwtException {
        return extractAllClaims(token);
    }

    // Validate token against email
    public boolean validateToken(String token, String email) {
        final String tokenEmail = extractAllClaims(token).get("email", String.class);
        return (tokenEmail.equals(email) && !isTokenExpired(token));
    }

    // Validate token only (for portal/testcases)
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token); // will throw exception if invalid
            return true;              // token is valid
        } catch (JwtException | IllegalArgumentException e) {
            return false;             // invalid or expired
        }
    }

    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }

    public String extractEmail(String token) {
        return extractAllClaims(token).get("email", String.class);
    }

    public Long extractUserId(String token) {
        return extractAllClaims(token).get("userId", Long.class);
    }

    @SuppressWarnings("unchecked")
    public Set<String> extractRoles(String token) {
        return new HashSet<>((List<String>) extractAllClaims(token).get("roles"));
    }
}
