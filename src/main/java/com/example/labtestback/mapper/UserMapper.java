package com.example.labtestback.mapper;



import com.example.labtestback.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component

public class UserMapper {
    private final ModelMapper modelMapper;
    public UserMapper(BCryptPasswordEncoder passwordEncoder) {
        this.modelMapper = new ModelMapper();
    }
    public UserDetails toUserDetails(UserEntity userEntity){
        return modelMapper.map(userEntity,UserDetails.class);
    }


}
