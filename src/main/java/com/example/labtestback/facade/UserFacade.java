package com.example.labtestback.facade;

import org.springframework.security.core.userdetails.UserDetails;


public interface UserFacade {
    UserDetails loadUserByUsername(String username);

}
