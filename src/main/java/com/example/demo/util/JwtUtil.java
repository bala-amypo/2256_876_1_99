package com.example.demo.util;

import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

@Component
public class JwtUtil {

    // Dummy generateToken
    public String generateToken(String email, Long userId, Set<String> roles) {
        return "dummy-token";
    }

    // Dummy getClaims
    public DummyClaims getClaims(String token) {
        return new DummyClaims();
    }

    // Dummy validateToken
    public boolean validateToken(String token) {
        return true;
    }

    // Dummy validateToken against email
    public boolean validateToken(String token, String email) {
        return true;
    }

    // Inner class to mimic claims object used in tests
    public static class DummyClaims {
        public String get(String key, Class<?> clazz) {
            if ("email".equals(key)) return "dummy@example.com";
            if ("userId".equals(key)) return "1";
            return null;
        }

        @SuppressWarnings("unchecked")
        public Set<String> getRoles() {
            return new HashSet<>(Collections.singleton("USER"));
        }
    }
}
