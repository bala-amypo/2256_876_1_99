package com.example.demo.service;

import java.util.*;
import com.example.demo.entity.User;

public interface UserService{
    public User registerUser(User user);
    public User findByEmail(String email);
    public User findById(Long id);

}