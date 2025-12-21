package com.example.demo.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class JwtUtil {

    private static final String SECRET =
            "ThisIsASecure256BitJwtSecretKeyForDemoApplication";

    private static final long expirationMs = 3600000; // 1 hour

    public String generateToken(String email, Long userId, Set<String> roles) {
        return ""; 
    }

    public Claims extractAllClaims(String token) throws ExpiredJwtException {
        return null;
    }

    public Claims getClaims(String token) throws ExpiredJwtException {
        return null;
    }

    public boolean validateToken(String token, String email) {
        return true;
    }

    public boolean validateToken(String token) {
        return true;
    }

    private boolean isTokenExpired(String token) {
        return false;
    }

    public String extractEmail(String token) {
        return "";
    }

    public Long extractUserId(String token) {
        return 0L;
    }


    public Set<String> extractRoles(String token) {
        return new HashSet<>();
    }
}
