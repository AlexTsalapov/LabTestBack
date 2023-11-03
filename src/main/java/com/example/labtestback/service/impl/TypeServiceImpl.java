package com.example.labtestback.service.impl;

import com.example.labtestback.entity.Type;
import com.example.labtestback.repository.TypeRepository;
import com.example.labtestback.service.TypeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TypeServiceImpl implements TypeService {
    private TypeRepository typeRepository;
    @Override
    public Type findTypeByName(String name) {
        return typeRepository.findByName(name);
    }

    @Override
    public List<Type> getAllTypes() {
        return typeRepository.findAll();
    }
}
