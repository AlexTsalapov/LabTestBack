package com.example.labtestback.service;


import com.example.labtestback.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface JwtUserDetailsService extends UserDetailsService {
    UserEntity loadUserByUsername(String username);
    UserEntity getCurrentUser();
}
