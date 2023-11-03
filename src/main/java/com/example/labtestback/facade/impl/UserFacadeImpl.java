package com.example.labtestback.facade.impl;

import com.example.labtestback.entity.UserEntity;
import com.example.labtestback.facade.UserFacade;
import com.example.labtestback.mapper.UserMapper;
import com.example.labtestback.service.JwtUserDetailsService;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserFacadeImpl implements UserFacade {
    private final JwtUserDetailsService userService;
    private final UserMapper userMapper;
    @Override
    public UserDetails loadUserByUsername(String username) {
        UserEntity userEntity =  userService.loadUserByUsername(username);
        return userMapper.toUserDetails(userEntity);
    }

}
