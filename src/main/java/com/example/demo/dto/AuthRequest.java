// package com.example.demo.dto;

// import jakarta.validation.constraints.NotBlank;

// public class AuthRequest {

//     @NotBlank
//     private String email;

//     @NotBlank
//     private String password;

//     // Required by Jackson
//     public AuthRequest() {
//     }

//     // Required by tests (all-args constructor)
//     public AuthRequest(String email, String password) {
//         this.email = email;
//         this.password = password;
//     }


//     public String getEmail() {
//         return email;
//     }

//     public void setEmail(String email) {
//         this.email = email;
//     }

//     public String getPassword() {
//         return password;
//     }

//     public void setPassword(String password) {
//         this.password = password;
//     }

//     // Helpful for test debugging / logging
//     @Override
//     public String toString() {
//         return "AuthRequest{" +
//                 "email='" + email + '\'' +
//                 ", password='[PROTECTED]'" +
//                 '}';
//     }
// }
