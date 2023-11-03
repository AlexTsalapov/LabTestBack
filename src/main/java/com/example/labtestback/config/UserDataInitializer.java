package com.example.labtestback.config;

import com.example.labtestback.entity.Role;
import com.example.labtestback.entity.Type;
import com.example.labtestback.entity.Unit;
import com.example.labtestback.entity.UserEntity;
import com.example.labtestback.repository.TypeRepository;
import com.example.labtestback.repository.UnitRepository;
import com.example.labtestback.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Collections;

@Component
public class UserDataInitializer {

    private final UserRepository userRepository;
    private final TypeRepository typeRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final UnitRepository unitRepository;

    public UserDataInitializer(UserRepository userRepository, TypeRepository typeRepository, BCryptPasswordEncoder passwordEncoder, UnitRepository unitRepository) {
        this.userRepository = userRepository;
        this.typeRepository = typeRepository;
        this.passwordEncoder = passwordEncoder;
        this.unitRepository = unitRepository;
    }

    public void findType(String type) {
        Type pressure = new Type();
        pressure.setName(type);
        typeRepository.save(pressure);
    }

    public void findUnit(String unit) {
        Unit bar = new Unit();
        bar.setName(unit);
        unitRepository.save(bar);
    }

    @PostConstruct
    public void init() {
        if (typeRepository.findByName("Pressure") == null) {
            findType("Pressure");
        }
        if (typeRepository.findByName("Voltage") == null) {
            findType("Voltage");
        }
        if (typeRepository.findByName("Temperature") == null) {
            findType("Temperature");
        }
        if (typeRepository.findByName("Humidity") == null) {
            findType("Humidity");
        }

        if (unitRepository.findByName("bar") == null) {
            findUnit("bar");
        }
        if (unitRepository.findByName("voltage") == null) {
            findUnit("voltage");
        }
        if (unitRepository.findByName("Celsium") == null) {
            findUnit("Celsium");
        }
        if (unitRepository.findByName("%") == null) {
            findUnit("%");
        }
        if (userRepository.count() == 0) {
            // Пользователь с ролью ADMINISTRATOR
            UserEntity adminUser = new UserEntity();
            adminUser.setUsername("admin");
            adminUser.setPassword(passwordEncoder.encode("admin"));
            adminUser.setRoles(Collections.singleton(Role.ADMINISTRATOR));
            userRepository.save(adminUser);

            // Пользователь с ролью VIEWER
            UserEntity viewerUser = new UserEntity();
            viewerUser.setUsername("user");
            viewerUser.setPassword(passwordEncoder.encode("user"));
            viewerUser.setRoles(Collections.singleton(Role.VIEWER));
            userRepository.save(viewerUser);
        }
    }
}

