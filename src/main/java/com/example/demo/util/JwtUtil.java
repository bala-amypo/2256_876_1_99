// package com.example.demo.util;

// import io.jsonwebtoken.*;
// import io.jsonwebtoken.security.Keys;
// import org.springframework.stereotype.Component;

// import javax.crypto.SecretKey;
// import java.util.*;

// @Component
// public class JwtUtil {

//     // 🔐 MUST be at least 256 bits (32+ chars)
//     private static final String SECRET =
//             "ThisIsASecure256BitJwtSecretKeyForDemoApplication";

//     private static final long expirationMs = 3600000; // 1 hour

//     // Generate secure key once
//     private final SecretKey key = Keys.hmacShaKeyFor(SECRET.getBytes());

//     // Generate token
//     public String generateToken(String email, Long userId, Set<String> roles) {
//         Map<String, Object> claims = new HashMap<>();
//         claims.put("email", email);
//         claims.put("userId", userId);
//         claims.put("roles", roles);

//         return Jwts.builder()
//                 .setClaims(claims)
//                 .setSubject(email)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
//                 .signWith(key, SignatureAlgorithm.HS256) // ✅ CORRECT & SECURE
//                 .compact();
//     }

//     // Extract all claims
//     public Claims extractAllClaims(String token) throws ExpiredJwtException {
//         return Jwts.parserBuilder()
//                 .setSigningKey(key)
//                 .build()
//                 .parseClaimsJws(token)
//                 .getBody();
//     }

//     // Backward compatibility for portal/testcases
//     public Claims getClaims(String token) throws ExpiredJwtException {
//         return extractAllClaims(token);
//     }

//     // Validate token against email
//     public boolean validateToken(String token, String email) {
//         final String tokenEmail = extractAllClaims(token).get("email", String.class);
//         return (tokenEmail.equals(email) && !isTokenExpired(token));
//     }

//     // Validate token only (for portal/testcases)
//     public boolean validateToken(String token) {
//         try {
//             Jwts.parserBuilder()
//                     .setSigningKey(key)
//                     .build()
//                     .parseClaimsJws(token);
//             return true;
//         } catch (JwtException | IllegalArgumentException e) {
//             return false;
//         }
//     }

//     private boolean isTokenExpired(String token) {
//         return extractAllClaims(token).getExpiration().before(new Date());
//     }

//     public String extractEmail(String token) {
//         return extractAllClaims(token).get("email", String.class);
//     }

//     public Long extractUserId(String token) {
//         return extractAllClaims(token).get("userId", Long.class);
//     }

//     @SuppressWarnings("unchecked")
//     public Set<String> extractRoles(String token) {
//         Object roles = extractAllClaims(token).get("roles");
//         if (roles instanceof Collection<?>) {
//             Set<String> roleSet = new HashSet<>();
//             for (Object r : (Collection<?>) roles) {
//                 roleSet.add(String.valueOf(r));
//             }
//             return roleSet;
//         }
//         return Collections.emptySet();
//     }
// }
