package com.example.labtestback.service.impl;

import com.example.labtestback.entity.UserEntity;
import com.example.labtestback.repository.UserRepository;
import com.example.labtestback.service.JwtUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class JwtUserDetailsServiceImpl implements JwtUserDetailsService {

    private final UserRepository userRepository;
    @Override
    public UserEntity loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findUserByUsername(username);
        if (userEntity == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return userEntity;
    }
    @Override
    public UserEntity getCurrentUser() {
        return userRepository
                .findUserByUsername((String) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
    }
}


